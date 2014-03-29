/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robotcalc;

import web.CalcProxy;
import web.XmlParser;

/**
 *
 * @author sebastian
 */
public class RobotCalc {

    public static String[] ComunicarseWs(String [] operaciones, String [] urls)
    {
        CalcProxy calcProxy = new CalcProxy(urls);
        
        String op;
        String a;
        String b;
        String result = "0";
        String [] resultados = new String[operaciones.length];
        
        for(int i = 0; i < operaciones.length; i++)
        {
            String [] operacion = operaciones[i].split("&");
            
            op = operacion[0];
            a = operacion[1];
            b = operacion[2];
            if (op.equals("restar")) {
                result = calcProxy.restar(a, b);
            } else if (op.equals("multiplicar")) {
                result = calcProxy.multiplicar(a, b);
            } else if (op.equals("dividir")) {
                result = calcProxy.dividir(a, b);
            } else if (op.equals("sumar")){
                result = calcProxy.sumar(a, b);
            }
            System.out.println(a+ " "+op+" " + b + " = "+  result);   
            resultados[i] = result;          
        }  
        return resultados;
    }
    
    public static void main(String[] args) {

        XmlParseroperaciones parsOper = new XmlParseroperaciones();
        String [] operaciones = parsOper.parsearOperaciones();
        
        XmlParser parser = new XmlParser();
        String [] urls = parser.leerUrls();  
        
        String [] resultados = ComunicarseWs(operaciones, urls);
        
        parsOper.setResultado(resultados);
        
    }
}
