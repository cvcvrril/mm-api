package dao;

import dao.model.Character;
import io.vavr.control.Either;
import jakarta.excepciones.ApiError;

import java.util.List;

public interface DaoCharacter {

    Either<ApiError, List<Character>> getAll();
    Either<ApiError, Character> get(int id);

}
