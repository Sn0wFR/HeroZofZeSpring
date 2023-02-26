package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardSaveService {

        CardEntity save(Integer heroId);
}
