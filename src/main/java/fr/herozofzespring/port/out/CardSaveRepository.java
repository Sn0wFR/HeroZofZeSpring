package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardSaveRepository {

        CardEntity save(CardEntity card);
}
