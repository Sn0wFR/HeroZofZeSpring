package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardDeleteRepository {

        CardEntity deleteById(Integer id);
}
