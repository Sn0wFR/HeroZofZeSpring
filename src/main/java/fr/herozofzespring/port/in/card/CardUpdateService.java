package fr.herozofzespring.port.in.card;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardUpdateService {

    void updateById(Integer cardId, Integer heroId, Integer playerId);

}
