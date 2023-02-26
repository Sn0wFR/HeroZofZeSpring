package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.domain.enumerator.Speciality;
import fr.herozofzespring.port.in.CardSaveService;
import fr.herozofzespring.port.out.CardSaveRepository;
import fr.herozofzespring.port.out.HeroFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardSaveServiceImplementation implements CardSaveService {

    @Autowired
    private CardSaveRepository cardSaveRepository;

    @Autowired
    private HeroFindRepository heroFindRepository;

    @Override
    public CardEntity save(Integer heroId) {

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
                    heroEntity,
                    armor,
                    0,
                    hp,
                    power,
                    1
            );

            return cardSaveRepository.save(cardEntity);
    }
}
