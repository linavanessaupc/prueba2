/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitecturas.prueba2.services;

/**
 *
 * @author lina_
 */

import co.edu.unipiloto.arquitecturas.prueba2.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Produces;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juan Pablo
 */

@Path("/service")
public class Service {
    private static Map<Integer, Persona> Persons=new HashMap<Integer, Persona>();
    static {
        int count=0;
        for (int i = 0; i < 10; i++) {
            Persona person = new Persona();
            int id = i + 1;
            count++;
            person.setId(id);
            person.setFullName("My wonderful Person " + id);
            person.setAge(new Random().nextInt(40) + 1);
            Persons.put(id, person);
        }
    }
    
    @GET
    @Path("/GetAllPersons")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> GetAllPersons(){
        return new ArrayList<Persona>(Persons.values());
    }
    @POST
    @Path("/addPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
     public List<Persona> addPersons(List<Persona> pr){
         for (Persona persona:pr) {
             Persons.put(persona.getId(), persona);
         }
         return new ArrayList<Persona>(Persons.values());
     }   
    
}
