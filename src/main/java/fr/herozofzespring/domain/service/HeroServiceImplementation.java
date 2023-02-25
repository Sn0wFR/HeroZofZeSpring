package fr.herozofzespring.domain.service;

import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.HeroRepository;
import fr.herozofzespring.port.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImplementation implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public List<Hero> getHeros() {
        return heroRepository.getHeros();
    }

    @Override
    public Hero getHeroById(Integer heroId) {
        return heroRepository.getHeroById(heroId);
    }

    @Override
    public Hero addHero(Hero hero) {
        System.out.println(this.getClass().getName());
        return heroRepository.addHero(hero);
    }

    @Override
    public Hero removeHero(Integer heroId) {
        return heroRepository.removeHero(heroId);
    }
}
