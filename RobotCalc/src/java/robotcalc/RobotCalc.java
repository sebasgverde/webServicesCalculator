/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robotcalc;

import web.WsCalcClient;
import web.XmlParser;

/**
 *
 * @author sebastian
 */
public class RobotCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                XmlParser parser = new XmlParser();
        String [] urls = parser.leerUrls();
        
        WsCalcClient calcProxy = new WsCalcClient(urls);
        
        String op = "/";
        String a = "9";
        String b = "3";
        String result = "0";
        
        if (op.equals("-")) {
            result = calcProxy.restar(a, b);
        } else if (op.equals("*")) {
            result = calcProxy.multiplicar(a, b);
        } else if (op.equals("/")) {
            result = calcProxy.dividir(a, b);
        } else if (op.equals("+")){
            result = calcProxy.sumar(a, b);
        }
        System.out.println(a+ " "+op+" " + b + " = "+  result);
    }
}
