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
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public Hero save(String name, Integer hp, Integer xp, Integer power, Integer armor, Integer level) {
        System.out.println("service !");
        System.out.println(name);
        return heroRepository.save(new Hero(name, hp, xp, power, armor, level));
    }
}
