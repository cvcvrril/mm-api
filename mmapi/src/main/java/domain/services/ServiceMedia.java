package domain.services;

import dao.DaoMedia;
import dao.data.StaticLists;
import dao.model.Media;
import domain.exceptions.BadArgumentException;
import domain.exceptions.BaseCaidaException;
import io.vavr.control.Either;
import jakarta.excepciones.ApiError;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Random;

@Log4j2
public class ServiceMedia {

    private final DaoMedia daoMedia;

    @Inject
    public ServiceMedia(DaoMedia daoMedia) {
        this.daoMedia = daoMedia;
    }

    public Either<ApiError, List<Media>> getAll() {
        return daoMedia.getAll();
    }

    public Either<ApiError, Media> getById(String idParam) {
        try {
            Integer id = Integer.parseInt(idParam);
            return daoMedia.getById(id);
        } catch (NumberFormatException e) {
            log.error(e.getMessage(),e);
            throw new BadArgumentException("Format error -> The id you introduced is not valid");
        }
    }

    public Either<ApiError, Media> getByName(String name){
        return daoMedia.getByName(name);
    }

    public Either<ApiError, List<Media>> getByYear(String yearParam) {
        try {
            Integer year = Integer.parseInt(yearParam);
            return daoMedia.getByYear(year);
        } catch (NumberFormatException e) {
            log.error(e.getMessage(),e);
            throw new BadArgumentException("Format error -> The year you introduced is not valid");
        }
    }

    public Either<ApiError, Media> getRandom(){
        try {
            int randomIndex = new Random().nextInt(StaticLists.media.size());
            Media randomMedia = StaticLists.media.get(randomIndex);
            return Either.right(randomMedia);
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseCaidaException("Failed to get a random Media");
        }
    }
}
