package domain.services;

import dao.DaoCharacter;
import dao.model.Character;
import domain.exceptions.BadArgumentException;
import io.vavr.control.Either;
import jakarta.excepciones.ApiError;
import jakarta.inject.Inject;
import lombok.With;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ServiceCharacters {

    private final DaoCharacter daoCharacter;

    @Inject
    public ServiceCharacters(DaoCharacter daoCharacter) {
        this.daoCharacter = daoCharacter;
    }

    public Either<ApiError, List<Character>> getAll(){
        return daoCharacter.getAll();
    }

    public Either<ApiError, Character> getById(String idParam){
        try {
            Integer id = Integer.parseInt(idParam);
            return daoCharacter.getById(id);
        }catch (NumberFormatException e){
            log.error(e.getMessage(), e);
            throw new BadArgumentException("Format error -> The id you introduced is not valid");
        }
    }

    public Either<ApiError, Character> getByName(String name){
        return daoCharacter.getByName(name);
    }

    public Either<ApiError, List<Character>> getByState(String stateParam){
        try {
            Boolean state = Boolean.parseBoolean(stateParam);
            return daoCharacter.getByState(state);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BadArgumentException("Format error -> The state you introduced is not valid");
        }
    }

    public Either<ApiError,List<Character>> getByOcupation(String ocupation) {
        return daoCharacter.getByOcupation(ocupation);
    }
}
