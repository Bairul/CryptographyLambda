package lambda;

import java.util.HashMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import saaf.Inspector;
import saaf.Response;

public class KmacEncrypt implements RequestHandler<Request, HashMap<String, Object>> {
    /**
     * Lambda Function Handler
     * 
     * @param request Request POJO with defined variables from Request.java
     * @param context 
     * @return HashMap that Lambda will automatically convert into JSON.
     */
    public HashMap<String, Object> handleRequest(final Request request, final Context context) {
        
        //Collect inital data.
        final Inspector inspector = new Inspector();
        // inspector.inspectAll();
        
        //****************START FUNCTION IMPLEMENTATION*************************
        final byte[] plaintext = request.getData().getBytes();
        final String passphrase = request.getName();
        String cyptogram = ByteStringUtil.bytesToHex(KMAC.encrypt(plaintext, passphrase));
        inspector.addAttribute("cryptogram", cyptogram);

        //Create and populate a separate response object for function output. (OPTIONAL)
        // final Response response = new Response();
        // response.setValue("Hello! This is from a response object!");
        
        //****************END FUNCTION IMPLEMENTATION***************************
        
        //Collect final information such as total runtime and cpu deltas.
        inspector.inspectAllDeltas();
        return inspector.finish();
    }
}