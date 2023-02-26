package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.port.out.HeroDeleteRepository;
import fr.herozofzespring.port.in.HeroDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroDeleteServiceImplementation implements HeroDeleteService {

    @Autowired
    private HeroDeleteRepository heroDeleteRepository;

    @Override
    public HeroEntity deleteById(Integer heroId) {
        HeroEntity heroEntity = heroDeleteRepository.deleteById(heroId);
        if (heroEntity == null) {
            throw new IllegalArgumentException("Hero not found");
        }
        return heroEntity;
    }
}
