package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.port.out.HeroDeleteRepository;
import fr.herozofzespring.port.in.HeroDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroDeleteServiceImplementation implements HeroDeleteService {

    @Autowired
    private HeroDeleteRepository heroDeleteRepository;

    @Autowired
    private CardFindServiceImplementation cardFindServiceImplementation;

    @Autowired
    private CardDeleteServiceImplementation cardDeleteServiceImplementation;

    @Override
    public HeroEntity deleteById(Integer heroId) {

        cardFindServiceImplementation.findAll().forEach(cardEntity -> {
            if (cardEntity.getHero().getHeroId().equals(heroId)) {
                cardDeleteServiceImplementation.deleteById(cardEntity.getId());
            }
        });


        HeroEntity heroEntity = heroDeleteRepository.deleteById(heroId);
        if (heroEntity == null) {
            throw new IllegalArgumentException("Hero not found");
        }
        return heroEntity;
    }
}
