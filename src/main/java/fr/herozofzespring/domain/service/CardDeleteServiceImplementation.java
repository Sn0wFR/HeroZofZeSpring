package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.port.in.CardDeleteService;
import fr.herozofzespring.port.out.CardDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardDeleteServiceImplementation implements CardDeleteService {

    @Autowired
    private CardDeleteRepository cardDeleteRepository;

    @Override
    public CardEntity deleteById(Integer id) {

        CardEntity cardEntity = cardDeleteRepository.deleteById(id);

        if (cardEntity == null) {
            throw new IllegalArgumentException("Card not found");
        }

        return cardEntity;
    }

}
