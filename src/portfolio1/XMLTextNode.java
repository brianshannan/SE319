package portfolio1;

/**
 * Represents and xml text node
 */
public class XMLTextNode {
    private String value;

    public XMLTextNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
