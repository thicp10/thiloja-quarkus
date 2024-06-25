package org.acme.controller;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CustomerDTO;
import org.acme.service.CustomerService;

import java.awt.*;
import java.util.List;

@Path("/api/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)// Retorna para o front end o formato Json
    public List<CustomerDTO> findAllCustomers(){
        return customerService.findAllCustomer();
    }
    @POST
    // faz o gerenciamento de dados que vão ser salvos no banco de dados
    @Transactional
    public Response saveCustomer(CustomerDTO customerDTO){
        try{
         customerService.createNewCustomer(customerDTO);
         return Response.ok().build();
        }catch(Exception e ){
         e.printStackTrace();
         return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeCustomer(@PathParam("id")Long id,CustomerDTO customerDTO){

        try {
            customerService.changeCustomer(id,customerDTO);
            return Response.accepted().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional // serve para informar que teve alteração no banco de Dados
    public Response deleteCustomer(@PathParam("id")Long id,CustomerDTO customerDTO){
        try {
            customerService.deleteCustomer(id);
            return Response.accepted().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }

    }

}
