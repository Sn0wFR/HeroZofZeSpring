package fr.herozofzespring.port.in;

import fr.herozofzespring.adapter.entity.CardEntity;

public interface CardDeleteService {

        CardEntity deleteById(Integer id);
}
