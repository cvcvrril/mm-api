package domain.services;

import dao.DaoCharacter;
import dao.model.Character;
import io.vavr.control.Either;
import jakarta.excepciones.ApiError;
import jakarta.inject.Inject;

import java.util.List;

public class ServiceCharacters {

    private final DaoCharacter daoCharacter;

    @Inject
    public ServiceCharacters(DaoCharacter daoCharacter) {
        this.daoCharacter = daoCharacter;
    }

    public Either<ApiError, List<Character>> getAll(){
        return daoCharacter.getAll();
    }

}
