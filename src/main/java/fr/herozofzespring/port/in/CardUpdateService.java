package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardUpdateService {

    void updateById(Integer cardId, Integer heroId);

}
