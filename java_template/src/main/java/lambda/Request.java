package lambda;

/**
 *
 * @author Wes Lloyd
 */
public class Request {

    private String data;
    private String name;

    public Request(final String name, final String data) {
        this.name = name;
        this.data = data;
    }

    public Request() {
        
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}
