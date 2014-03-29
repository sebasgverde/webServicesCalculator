/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import cliente.Wscalc1;
import cliente.Wscalc1_Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sebastian
 */
public class WsCalcClient {
    String uri ;//= "http://localhost:8080/AppServer1/wscalc1";
    String uriRest;// = "http://localhost:8080/AppServer2/webresources/ws2calc2";
    
    Wscalc1 calc1 = null;
    Wscalc1_Service calc1Serv = null;
    CalcRestClient calc2 = null;
    
    public WsCalcClient(String [] urls)
    {
        uri = urls[0];
        uriRest = urls[1];
        try {
            calc1Serv = new Wscalc1_Service(new URL(uri));
            calc1 = calc1Serv.getWscalc1Port();
            
            calc2 = new CalcRestClient(uriRest);
        } catch (MalformedURLException ex) {  
            Logger.getLogger(WsCalcClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String sumar(String a, String b) {
        return Integer.toString(calc1.sumar(Integer.parseInt(a), Integer.parseInt(b)));
    }

    public String restar(String a, String b) {
        return calc2.getDatos("-", a, b);
    }

    public String multiplicar(String a, String b) {
        return Integer.toString(calc1.multiplicar(Integer.parseInt(a), Integer.parseInt(b)));
    }

    public String dividir(String a, String b) {
        return calc2.getDatos("/", a, b);
    }    
    
    
}
