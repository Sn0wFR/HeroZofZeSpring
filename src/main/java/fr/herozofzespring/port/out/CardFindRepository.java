package fr.herozofzespring.port.out;

import fr.herozofzespring.adapter.entity.CardEntity;

import java.util.List;

public interface CardFindRepository {

    List<CardEntity> findAll();

    CardEntity findById(Integer id);

}
