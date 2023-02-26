package fr.herozofzespring.domain.service.card;

import fr.herozofzespring.adapter.entity.CardEntity;
import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.domain.enumerator.Speciality;
import fr.herozofzespring.port.in.card.CardSaveService;
import fr.herozofzespring.port.out.card.CardFindRepository;
import fr.herozofzespring.port.out.card.CardSaveRepository;
import fr.herozofzespring.port.out.hero.HeroFindRepository;
import fr.herozofzespring.port.out.player.PlayerFindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardSaveServiceImplementation implements CardSaveService {

    @Autowired
    private CardSaveRepository cardSaveRepository;

    @Autowired
    private HeroFindRepository heroFindRepository;

    @Autowired
    private PlayerFindRepository playerFindRepository;

    @Autowired
    private CardFindRepository cardFindRepository;

    @Override
    public CardEntity save(Integer heroId, Integer playerId) {

            HeroEntity heroEntity = heroFindRepository.findById(heroId);

            PlayerEntity playerEntity = playerFindRepository.findById(playerId);

            if (heroEntity == null)
                throw new IllegalArgumentException("Hero not found");

            if (playerEntity == null)
                throw new IllegalArgumentException("Player not found");

            for (CardEntity c : cardFindRepository.findAll())
                if (c.getHero().getHeroId().equals(heroId) && c.getPlayer().getPlayerId().equals(playerId))
                    throw new IllegalArgumentException("Card already exist");

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
                    playerEntity,
                    armor,
                    0,
                    hp,
                    power,
                    1
            );

            return cardSaveRepository.save(cardEntity);
    }
}
