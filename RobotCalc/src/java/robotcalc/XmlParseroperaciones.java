
package robotcalc;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 


public class XmlParseroperaciones{

    private static int numeroSensores;
    
    public void parsearOperaciones(){
    try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("../calc.xml"));
            

            // normalize text representation
            doc.getDocumentElement ().normalize ();
            
            NodeList listaSensores = doc.getElementsByTagName("sensor");
            numeroSensores = listaSensores.getLength();
            System.out.println("Total no of sensors : " + numeroSensores);

            for(int s=0; s<listaSensores.getLength() ; s++){


                Node sensorNodo = listaSensores.item(s);
                if(sensorNodo.getNodeType() == Node.ELEMENT_NODE){


                    Element elementoSensor = (Element)sensorNodo;

                    //-------
                    NodeList listaNombre = elementoSensor.getElementsByTagName("nombre");
                    Element elementNombre = (Element)listaNombre.item(0);

                    NodeList textoNombre = elementNombre.getChildNodes();
                    String nombre = ((Node)textoNombre.item(0)).getNodeValue().trim();
                    System.out.println("nombre sensor : " + 
                    		nombre);

                    //-------
                    NodeList listaPosArreglo = elementoSensor.getElementsByTagName("posArreglo");
                    Element elementPosArreg = (Element)listaPosArreglo.item(0);

                    NodeList textoPosArreg = elementPosArreg.getChildNodes();
                    int pos = Integer.parseInt(((Node)textoPosArreg.item(0)).getNodeValue().trim());
                    System.out.println("pos en arreglo : " + 
                    		pos);
                    

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


    }//end of main
}