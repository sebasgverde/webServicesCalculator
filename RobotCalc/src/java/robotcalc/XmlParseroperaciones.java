
package robotcalc;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 


public class XmlParseroperaciones{

    private static int numeroWebServ;
    String operacion = "";
    String pathXml = "calc.xml";
    public String [] parsearOperaciones(){
    try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(pathXml));
            

            // normalize text representation
            doc.getDocumentElement ().normalize ();
            
            NodeList listaWebServices = doc.getElementsByTagName("webservice");
            numeroWebServ = listaWebServices.getLength();
            //System.out.println("Total no of ws : " + numeroWebServ);

            for(int s=0; s < numeroWebServ ; s++){


                Node wsNodo = listaWebServices.item(s);
                if(wsNodo.getNodeType() == Node.ELEMENT_NODE){

                    Element elementoMetodo = (Element)wsNodo;
                            
                    operacion += valorNodo("method", elementoMetodo) + "&";

                    //-------
                    NodeList listaParams = elementoMetodo.getElementsByTagName("params");
                    
                    Node paramsNodo = listaParams.item(0);
                    if(paramsNodo.getNodeType() == Node.ELEMENT_NODE)
                    {

                        Element elementoParam = (Element)paramsNodo;
                        operacion += valorNodo("p1", elementoParam)+ "&";
                        operacion += valorNodo("p2", elementoParam)+ "#";

                    }
                    
                }//end of if clause
            }//end of for loop with s var


        }catch (SAXParseException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        t.printStackTrace ();
        }

        return operacion.split("#");
    }//end of main
    
    public void setResultado(String [] results)
    {
    try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("calc.xml"));
            

            // normalize text representation
            doc.getDocumentElement ().normalize ();
            
            NodeList listaWebServices = doc.getElementsByTagName("webservice");
            numeroWebServ = listaWebServices.getLength();
            //System.out.println("Total no of ws : " + numeroWebServ);

            for(int s=0; s < numeroWebServ ; s++){


                Node wsNodo = listaWebServices.item(s);
                if(wsNodo.getNodeType() == Node.ELEMENT_NODE){

                    Element elementoMetodo = (Element)wsNodo;
                    setValorNodo("result", elementoMetodo, results[s]);            
                    
                }//end of if clause
            }//end of for loop with s var
            
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(pathXml));
            transformer.transform(source, result);

        }catch (SAXParseException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        t.printStackTrace ();
        }        
    }
    
    public String valorNodo(String tag, Element elemento)
    {
        //-------
        NodeList listaElem = elemento.getElementsByTagName(tag);
        Element element = (Element)listaElem.item(0);

        NodeList textoElem = element.getChildNodes();
        String nombre = ((Node)textoElem.item(0)).getNodeValue().trim();
        //System.out.println("nombre : " + nombre); 
        
        return nombre;
    }

    public void setValorNodo(String tag, Element elemento, String valor)
    {
        //-------
        NodeList listaElem = elemento.getElementsByTagName(tag);
        Element element = (Element)listaElem.item(0);

        NodeList textoElem = element.getChildNodes();
        ((Node)textoElem.item(0)).setNodeValue(valor);
        //System.out.println("nombre : " + nombre); 
    }
}