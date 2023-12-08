package dao.imp;

import dao.DaoCharacter;
import dao.data.StaticLists;
import dao.model.Character;
import dao.model.Media;
import domain.exceptions.BaseCaidaException;
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
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseCaidaException("The list is empty");
        }
        return res;
    }

    @Override
    public Either<ApiError, Character> getById(int id) {
        Either<ApiError, Character> res;
        try {
            Character character = StaticLists.characters.stream().filter(character1 -> character1.getId() == id).findFirst().orElse(null);
            res = Either.right(character);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BaseCaidaException("There's no object with that id");
        }
        return res;
    }

    @Override
    public Either<ApiError, Character> getByName(String name) {
        Either<ApiError, Character> res;
        try {
            Character character = StaticLists.characters.stream().filter(character1 -> character1.getName().equals(name)).findFirst().orElse(null);
            res = Either.right(character);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BaseCaidaException("There's no object with that name");
        }
        return res;
    }

    @Override
    public Either<ApiError, List<Character>> getByState(boolean state) {
        return null;
    }


}
