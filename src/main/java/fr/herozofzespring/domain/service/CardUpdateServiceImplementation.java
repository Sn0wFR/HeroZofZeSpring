package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.domain.enumerator.Speciality;
import fr.herozofzespring.port.in.CardUpdateService;
import fr.herozofzespring.port.out.CardUpdateRepository;
import fr.herozofzespring.port.out.HeroFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardUpdateServiceImplementation implements CardUpdateService {

    @Autowired
    private CardUpdateRepository cardUpdateRepository;

    @Autowired
    private HeroFindRepository heroFindRepository;

    @Override
    public void updateById(Integer cardId, Integer heroId) {

        HeroEntity heroEntity = heroFindRepository.findById(heroId);

        if (heroEntity == null)
            throw new IllegalArgumentException("Hero not found");

        Integer hp = null;
        Integer armor = null;
        Integer power = null;

        for (Speciality s : Speciality.values()) {
            if (s.name().equals(heroEntity.getSpeciality())) {
                hp = s.getHp();
                armor = s.getArmor();
                power = s.getPower();
            }
        }

        CardEntity cardEntity = new CardEntity(
                cardId,
                heroEntity,
                armor,
                0,
                hp,
                power,
                1
        );

        if (cardUpdateRepository.updateById(cardEntity) == 0)
            throw new IllegalArgumentException("Card not found");


    }
}
