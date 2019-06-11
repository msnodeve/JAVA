import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class SOAPParser {
    private Element rootNode;
    private ArrayList<DataObject> objectList;

    public void soapMessageParser(InputStream in) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.parse(in);
        rootNode = doc.getDocumentElement();

        Node returnNode = this.getNode("return");

        objectList = new ArrayList<>();
        while (returnNode != null) {
            if (returnNode.getNodeType() == Node.ELEMENT_NODE) {
                objectList.add(new DataObject(returnNode));
            }
            returnNode = returnNode.getNextSibling();
        }
    }

    private Node getNode(String nodeName) {
        Node node = rootNode;
        while ((node = getFirstChildNodeTypeNode(node)) != null) {
            if (node.getNodeName().equals(nodeName))
                return node;
        }
        return null;
    }

    private Node getFirstChildNodeTypeNode(Node node) {
        if (node.getChildNodes().getLength() < 1)
            return null;
        node = node.getFirstChild();
        while (node.getNodeType() != Node.ELEMENT_NODE)
            node = node.getNextSibling();
        return node;
    }

    public ArrayList<DataObject> getData() {
        return objectList;
    }
}