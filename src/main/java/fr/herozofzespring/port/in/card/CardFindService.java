package fr.herozofzespring.port.in.card;

import fr.herozofzespring.adapter.entity.CardEntity;

import java.util.List;

public interface CardFindService {

        List<CardEntity> findAll();

        CardEntity findById(Integer id);
}
