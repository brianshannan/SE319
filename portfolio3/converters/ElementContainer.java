package converters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementContainer {

    private Map<String, Object> container;

    public ElementContainer() {
        container = new HashMap<String, Object>();
    }

    public void addAttr(String name, String val) {
        container.put("@" + name, val);
    }

    public void addText(String val) {
        List<String> textList;

        // If exists in container already, get it, otherwise create
        if(container.get("_text") != null) {
            textList = (List<String>) container.get("_text");
        } else {
            textList = new ArrayList<String>();
            container.put("name", textList);
        }
        textList.add(val);
    }

    public void addElem(String name, ElementContainer ec) {
        List<ElementContainer> ecList;

        if(container.get(name) != null) {
            ecList = (List<ElementContainer>) container.get("name");
        } else {
            ecList = new ArrayList<ElementContainer>();
            container.put(name, ecList);
        }
        ecList.add(ec);
    }

    @Override
    public String toString() {
        StringBuilder accum = new StringBuilder();

        boolean first = true;
        for(String key : container.keySet()) {
            String toAppend = "";
            if(!first) {
                toAppend = ", ";
            }
            first = false;

            Object val = container.get(key);
            if(val instanceof String) {
                accum.append(toAppend + key + ": " + val);
            } else if(val instanceof List) {
                List<?> list = (List<?>) val;
                boolean listFirst = true;
                StringBuilder listAccum = new StringBuilder();
                listAccum.append("[");
                
                for(Object obj : list) {
                    String listToAppend = "";
                    if(!listFirst) {
                        listToAppend = ", ";
                    }
                    listFirst = false;
                    listAccum.append(listToAppend + obj.toString());
                }
                listAccum.append("]");
                accum.append(toAppend + key + ": " + listAccum.toString());
            } else if(val instanceof ElementContainer) {
                ElementContainer ec = (ElementContainer) val;
                accum.append(toAppend + key + ": " + ec.toString());
            }
        }

        return accum.toString();
    }
}
