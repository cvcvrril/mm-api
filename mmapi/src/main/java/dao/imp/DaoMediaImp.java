package dao.imp;

import dao.DaoMedia;
import dao.data.StaticLists;
import dao.model.Media;
import domain.exceptions.BaseCaidaException;
import io.vavr.control.Either;
import jakarta.excepciones.ApiError;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
public class DaoMediaImp implements DaoMedia {
    @Override
    public Either<ApiError, List<Media>> getAll() {
        Either<ApiError, List<Media>> res;
        try {
            List<Media> media = StaticLists.media;
            res = Either.right(media);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BaseCaidaException("The list is empty");
        }
        return res;
    }

    @Override
    public Either<ApiError, Media> getById(int id) {
        Either<ApiError, Media> res;
        try {
            Media media = StaticLists.media.stream().filter(media1 -> media1.getId() == id).findFirst().orElse(null);
            res = Either.right(media);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BaseCaidaException("There's no object with that id");
        }
        return res;
    }

    @Override
    public Either<ApiError, Media> getByName(String name) {
        Either<ApiError, Media> res;
        try {
            Media media = StaticLists.media.stream().filter(media1 -> media1.getName().equals(name)).findFirst().orElse(null);
            res = Either.right(media);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BaseCaidaException("There's no object with that name");
        }
        return res;
    }

    @Override
    public Either<ApiError, List<Media>> getByYear(int year) {
        Either<ApiError, List<Media>> res;
        try {
            List<Media> media = StaticLists.media.stream().filter(media1 -> media1.getYear() == year).toList();
            res = Either.right(media);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BaseCaidaException("There's no object with that id");
        }
        return res;
    }
}
