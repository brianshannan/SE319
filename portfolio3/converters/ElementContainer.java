package converters;

import java.util.HashMap;
import java.util.Map;

public class ElementContainer {

    private Map<String, Object> container;

    public ElementContainer() {
        container = new HashMap<String, Object>();
    }

    public void addAttr(String name, String val) {
        container.put(name, val);
    }

    public void addElem() {
        //
    }

    @Override
    public String toString() {
        // TODO
        return null;
    }
}
