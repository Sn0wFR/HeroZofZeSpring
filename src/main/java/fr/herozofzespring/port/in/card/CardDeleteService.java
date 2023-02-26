package fr.herozofzespring.port.in.card;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardDeleteService {

        CardEntity deleteById(Integer id);
}
