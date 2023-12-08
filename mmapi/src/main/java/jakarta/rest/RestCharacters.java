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

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/characters*/

    @GET
    public List<Character> getAllCharacters(){
        return serviceCharacters.getAll().get();
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/characters/4*/

    @GET
    @Path("/{id}")
    public Character getById(@PathParam("id") String idParam){
        return serviceCharacters.getById(idParam).get();
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/characters/byName?name=Cliff%20Unger*/

    @GET
    @Path("/byName")
    public Character getByName(@QueryParam("name") String name){
        return serviceCharacters.getByName(name).get();
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/characters/byState?state=true*/

    @GET
    @Path("/byState")
    public List<Character> getByState(@QueryParam("state") String stateParam){
        return serviceCharacters.getByState(stateParam).get();
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/characters/byOcupation?ocupation=Father*/

    @GET
    @Path("/byOcupation")
    public List<Character> getByOcupation(@QueryParam("ocupation") String ocupation){
        return serviceCharacters.getByOcupation(ocupation).get();
    }
}
