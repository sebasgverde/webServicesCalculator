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
import javax.servlet.jsp.tagext.TryCatchFinally;
/**
 *
 * @author sebastian
 */
public class WsCalcClient {
    String uri = "http://localhost:8080/AppServer1/wscalc1";
    
    Wscalc1 calc1 = null;
    
    
    Wscalc1_Service calc1Serv = null;
    
    public WsCalcClient()
    {
        try {
            calc1Serv = new Wscalc1_Service(new URL(uri));
            calc1 = calc1Serv.getWscalc1Port();
        } catch (MalformedURLException ex) {  
            Logger.getLogger(WsCalcClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int sumar(int a, int b) {
        return calc1.sumar(a, b);
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return calc1.multiplicar(a, b);
    }

    public int dividir(int a, int b) {
        return a / b;
    }    
    
    
}
