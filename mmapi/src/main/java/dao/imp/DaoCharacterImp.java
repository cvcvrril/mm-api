package dao.imp;

import dao.DaoCharacter;
import dao.data.StaticLists;
import dao.model.Character;
import io.vavr.control.Either;
import jakarta.excepciones.ApiError;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
public class DaoCharacterImp implements DaoCharacter {
    @Override
    public Either<ApiError, List<Character>> getAll() {
        Either<ApiError, List<Character>> res;
        try {
            List<Character> characters = StaticLists.characters;
            res = Either.right(characters);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            res = Either.left(new ApiError(e.getMessage(), LocalDateTime.now()));
        }
        return res;
    }

    @Override
    public Either<ApiError, Character> get(int id) {
        return null;
    }
}
