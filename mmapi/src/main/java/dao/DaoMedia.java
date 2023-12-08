package dao;

import dao.model.Media;
import io.vavr.control.Either;
import jakarta.excepciones.ApiError;

import java.util.List;

public interface DaoMedia {

    Either<ApiError, List<Media>> getAll();
    Either<ApiError, Media> getById(int id);
    Either<ApiError, Media> getByName(String name);
    Either<ApiError, List<Media>> getByYear(int year);

}
