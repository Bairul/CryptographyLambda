package lambda;

/**
 *
 * @author Wes Lloyd
 */
public class Request {

    private String records;
    private String name;
    private String cryptogram;

    public Request(final String name, final String records) {
        this.records = records;
        this.name = name;
    }

    public Request(final String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public void setRecords(final String records) {
        this.records = records;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setCryptogram(final String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getRecords() {
        return records;
    }

    public String getName() {
        return name;
    }

    public String getCryptogram() {
        return cryptogram;
    }
}
