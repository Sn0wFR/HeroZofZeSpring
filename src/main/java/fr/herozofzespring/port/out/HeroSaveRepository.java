package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.domain.model.Hero;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface HeroSaveRepository {

    HeroEntity save(HeroEntity hero);
}
