package fr.herozofzespring.domain.service.card;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.domain.enumerator.Speciality;
import fr.herozofzespring.port.in.card.CardUpdateService;
import fr.herozofzespring.port.out.card.CardUpdateRepository;
import fr.herozofzespring.port.out.hero.HeroFindRepository;
import fr.herozofzespring.port.out.player.PlayerFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardUpdateServiceImplementation implements CardUpdateService {

    @Autowired
    private CardUpdateRepository cardUpdateRepository;

    @Autowired
    private HeroFindRepository heroFindRepository;

    @Autowired
    private PlayerFindRepository playerFindRepository;

    @Override
    public void updateById(Integer cardId, Integer heroId, Integer playerId) {

        HeroEntity heroEntity = heroFindRepository.findById(heroId);

        PlayerEntity playerEntity = playerFindRepository.findById(playerId);

        if (heroEntity == null && playerEntity == null)
            throw new IllegalArgumentException("Hero and Player not found");

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
                playerEntity,
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
