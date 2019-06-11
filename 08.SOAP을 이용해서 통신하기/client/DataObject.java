import java.util.HashMap;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DataObject {
    private HashMap<String, String> objects;
    private Element rootNode;

    public DataObject(Node rootNode){
        Node node = rootNode;
        if(rootNode.getChildNodes().getLength()>1){
            node = rootNode.getFirstChild();
            while(node.getNodeType()!=Node.ELEMENT_NODE)
                node=node.getNextSibling();
        }
        objects = new HashMap<>();
        while(node!=null){
            if(node.getNodeType()==Node.ELEMENT_NODE && node.getChildNodes().getLength()>0)
                objects.put(node.getNodeName(), node.getFirstChild().getNodeValue()); 
            node = node.getNextSibling();
        }
    }
    public String getValue(String key){
        return objects.get(key);
    }
}