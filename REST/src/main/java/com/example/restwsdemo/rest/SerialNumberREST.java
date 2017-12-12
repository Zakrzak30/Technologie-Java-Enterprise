package com.example.restwsdemo.rest;

import com.example.restwsdemo.domain.SerialNumber;
import com.example.restwsdemo.service.SerialNumberManeger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("serial")
@Stateless
public class SerialNumberREST {

    @Inject
    private SerialNumberManeger serialNumberManager;

    @GET
    @Path("/{producentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public SerialNumber getSerialNumber(@PathParam("producentId") Long id) {
        SerialNumber c = serialNumberManager.getSerialNumber(id);
        return c;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSerialNumber(SerialNumber serial) {
        serialNumberManager.addSerialNumber(serial);
        return Response.status(201).entity("SerialNumber").build();
    }

    @DELETE
    @Path("/del/{id}")
    public void deleteBike(@PathParam("id") Long id) {
        serialNumberManager.deleteSerialNumber(serialNumberManager.getSerialNumber(id));
    }


}
