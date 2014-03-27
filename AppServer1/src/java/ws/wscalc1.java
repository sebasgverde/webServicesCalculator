/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import Logica.Calculadora;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sebastian
 */
@WebService(serviceName = "wscalc1")
public class wscalc1 {

 Calculadora calc = new Calculadora();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "sumar")
    public int sumar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return calc.sumar(a, b);
    }
    
        @WebMethod(operationName = "restar")
    public int restar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return calc.restar(a, b);
    }
    
        @WebMethod(operationName = "multiplicar")
    public int multiplicar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return calc.multiplicar(a, b);
    }
    
        @WebMethod(operationName = "dividir")
    public int dividir(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return calc.dividir(a, b);
    }
}
