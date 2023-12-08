package dao;

import dao.model.Character;
import io.vavr.control.Either;
import jakarta.excepciones.ApiError;

import java.util.List;

public interface DaoCharacter {

    Either<ApiError, List<Character>> getAll();
    Either<ApiError, Character> getById(int id);
    Either<ApiError, Character> getByName(String name);
    Either<ApiError, List<Character>> getByState(boolean state);


}
