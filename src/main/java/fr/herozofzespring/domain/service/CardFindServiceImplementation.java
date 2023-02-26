package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.port.in.CardFindService;
import fr.herozofzespring.port.out.CardFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardFindServiceImplementation implements CardFindService {

    @Autowired
    private CardFindRepository cardFindRepository;

    @Override
    public List<CardEntity> findAll() {
        return cardFindRepository.findAll();
    }

    @Override
    public CardEntity findById(Integer id) {

        CardEntity cardEntity = cardFindRepository.findById(id);

        if (cardEntity == null) {
            throw new IllegalArgumentException("Card not found");
        }

        return cardEntity;
    }
}
