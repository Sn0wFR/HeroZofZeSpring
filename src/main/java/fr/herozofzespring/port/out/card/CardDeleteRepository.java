package fr.herozofzespring.port.out.card;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardDeleteRepository {

        CardEntity deleteById(Integer id);
}
