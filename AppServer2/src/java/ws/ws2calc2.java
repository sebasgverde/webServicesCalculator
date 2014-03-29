/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import Logica.CalculadoraR;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author sebastian
 */
@Path("/ws2calc2")
public class ws2calc2 {

 @EJB
    private CalculadoraR calc;
    /**
     * Retrieves representation of an instance of helloworld.HelloWorldResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getDatos(@QueryParam("op") String op, @QueryParam("p1") int p1, @QueryParam("p2") int p2) {        

        //System.out.println(p1+ " "+op+" " + p2);
        //return p1+ " "+op+" " + p2 + " = "+  calc.operacion(p1, p2,op);
        return "{\"res\": " + calc.operacion(p1, p2,op) + "}";
    }
}
