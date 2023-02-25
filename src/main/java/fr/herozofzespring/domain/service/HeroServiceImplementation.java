package fr.herozofzespring.domain.service;

import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.HeroRepository;
import fr.herozofzespring.port.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImplementation implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public List<Hero> getHeros() {
        return (List<Hero>) heroRepository.findAll();
    }

    @Override
    public Optional<Hero> getHeroById(Integer heroId) {
        return heroRepository.findById(heroId);
    }

    @Override
    public Hero addHero(Hero hero) {
        System.out.println(this.getClass().getName());
        return heroRepository.save(hero);
    }

    @Override
    public void removeHero(Integer heroId) {
        heroRepository.deleteById(heroId);
    }
}
