package portfolio1;

/**
 * Represents and xml element
 */
public class XMLElement {
    private String name;

    public XMLElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
