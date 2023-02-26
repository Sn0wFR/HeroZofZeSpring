package fr.herozofzespring.port.out.card;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardSaveRepository {

        CardEntity save(CardEntity card);
}
