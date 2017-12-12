package com.example.restwsdemo.rest;

import com.example.restwsdemo.domain.Bike;
import com.example.restwsdemo.domain.Person;
import com.example.restwsdemo.service.BikeManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("bike")
@Stateless
public class BikeRESTService {


    @Inject
    private BikeManager bikeManager;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testRelation() {
        Person person1 = new Person("Adam", "Nowak");
        Person person2 = new Person("Jan", "Kowalski");

        Bike bike1 = new Bike("Bike a", 22.0);
        Bike bike2 = new Bike("Bike b", 21.5);

        bikeManager.addBike(bike1);

        List<Person> users = new ArrayList<>();
        users.add(person1);
        users.add(person2);


        bike1.addUsers(users);

        bikeManager.updateBike(bike1);
        bikeManager.updateBike(bike2);
        return "ManytoMany";
    }

     
    @GET
    @Path("/{bikeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bike getBike(@PathParam("bikeId") Long id) {
        Bike b = bikeManager.getBike(id);
        return b;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBike(Bike bike) {
        bikeManager.addBike(bike);

        return Response.status(201).entity("Bike").build();
    }

    @DELETE
    @Path("/del/{id}")
    public void deleteBike(@PathParam("id") Long id) {
    	bikeManager.deleteBike(bikeManager.getBike(id));

    }

    @DELETE
    public Response clearBooks() {
    	bikeManager.deletAll();
        return Response.status(200).build();
    }

    @GET
    @Path("/bikesUser/{FirstName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesUser(@PathParam("FirstName") String firstName) {

        List<Object[]> rawUsers = bikeManager.getBikeOfUserByUserName(firstName);
        JsonArrayBuilder users = Json.createArrayBuilder();

        for (Object[] rawUser : rawUsers) {
            String fName = (String) rawUser[0];
            String lName = (String) rawUser[1];
            String name = (String) rawUser[2];

            users.add(Json.createObjectBuilder()
                    .add("firstName", fName)
                    .add("lastName", lName)
                    .add("bike_name", name));

        }
        JsonObject json = Json.createObjectBuilder().add("result", users).build();
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }


}
