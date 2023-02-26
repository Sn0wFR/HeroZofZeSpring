package fr.herozofzespring.port.out.card;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardUpdateRepository {

        int updateById(CardEntity cardEntity);
}
