package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardUpdateRepository {

        int updateById(CardEntity cardEntity);
}
