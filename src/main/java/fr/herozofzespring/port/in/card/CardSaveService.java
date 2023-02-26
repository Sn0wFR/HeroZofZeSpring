package fr.herozofzespring.port.in.card;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardSaveService {

        CardEntity save(Integer heroId, Integer playerId);
}
