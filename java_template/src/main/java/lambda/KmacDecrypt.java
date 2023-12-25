package lambda;

import java.util.Arrays;
import java.util.HashMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import saaf.Inspector;
import saaf.Response;

public class KmacDecrypt implements RequestHandler<Request, HashMap<String, Object>> {
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
        final String cryptogram = request.getData();
        final String passphrase = request.getName();
        byte[] decryption = KMAC.decrypt(ByteStringUtil.hexToBytes(cryptogram), passphrase);
        // removes the last bit because it just encodes whether t = t'
        byte t_equals_t_prime = decryption[decryption.length - 1];
        decryption = Arrays.copyOf(decryption, decryption.length - 1);

        // accept if and only if t = t'
        if (t_equals_t_prime == 1) {
            inspector.addAttribute("accept", 1);
        } else {
            inspector.addAttribute("accept", 0);
        }

        inspector.addAttribute("decipheredText", new String(decryption));

        //Create and populate a separate response object for function output. (OPTIONAL)
        // final Response response = new Response();
        // response.setValue("Hello! This is from a response object!");
        
        //****************END FUNCTION IMPLEMENTATION***************************
        
        //Collect final information such as total runtime and cpu deltas.
        inspector.inspectAllDeltas();
        return inspector.finish();
    }
}