package com.example.restwsdemo.rest;


import com.example.restwsdemo.domain.Producent;
import com.example.restwsdemo.service.ProducentManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("producent")
@Stateless
public class ProducentREST {

    @Inject
    private ProducentManager producentManager;

    @GET
    @Path("/{producentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producent getProducent(@PathParam("producentId") Long id) {
        Producent c = producentManager.getProducent(id);
        return c;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducent(Producent producent) {
        producentManager.addProducent(producent);
        return Response.status(201).entity("Producent").build();
    }

    @DELETE
    @Path("/del/{id}")
    public void deleteBike(@PathParam("id") Long id) {
        producentManager.deleteProducent(producentManager.getProducent(id));
    }


}
