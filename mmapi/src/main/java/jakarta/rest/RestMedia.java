package jakarta.rest;

import dao.model.Media;
import domain.services.ServiceMedia;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Path("/media")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestMedia {

    private final ServiceMedia serviceMedia;

    @Inject
    public RestMedia(ServiceMedia serviceMedia) {
        this.serviceMedia = serviceMedia;
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/media*/

    @GET
    public List<Media> getAllMedia(){
        return serviceMedia.getAll().get();
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/media/1*/

    @GET
    @Path("/{id}")
    public Media getById(@PathParam("id") String idParam){
        return serviceMedia.getById(idParam).get();
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/media/byName?name=Death%20Stranding*/

    @GET
    @Path("/byName")
    public Media getByName(@QueryParam("name") String name){
        return serviceMedia.getByName(name).get();
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/media/byYear?year=2016*/

    @GET
    @Path("/byYear")
    public List<Media> getByYear(@QueryParam("year") String yearParam){
        return serviceMedia.getByYear(yearParam).get();
    }

    /*http://localhost:8080/mmapi-1.0-SNAPSHOT/api/media/random*/

    @GET
    @Path("/random")
    public Media getRandom(){
        return serviceMedia.getRandom().get();
    }

}
