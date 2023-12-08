package jakarta.rest;

import dao.model.Character;
import domain.services.ServiceCharacters;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Path("/characters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestCharacters {

    private final ServiceCharacters serviceCharacters;

    @Inject
    public RestCharacters(ServiceCharacters serviceCharacters) {
        this.serviceCharacters = serviceCharacters;
    }

    @GET
    public List<Character> getAllCharacters(){
        return serviceCharacters.getAll().get();
    }

    @GET
    @Path("/{id}")
    public Character getById(@PathParam("id") String idParam){
        return serviceCharacters.getById(idParam).get();
    }

    @GET
    @Path("/byName")
    public Character getByName(@QueryParam("name") String name){
        return serviceCharacters.getByName(name).get();
    }

}
