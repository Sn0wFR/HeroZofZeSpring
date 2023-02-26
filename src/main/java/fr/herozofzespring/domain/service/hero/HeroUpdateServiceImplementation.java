package fr.herozofzespring.domain.service.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.port.in.hero.HeroUpdateService;
import fr.herozofzespring.port.out.hero.HeroUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroUpdateServiceImplementation implements HeroUpdateService {

    @Autowired
    private HeroUpdateRepository heroUpdateRepository;

    @Override
    public void updateById(Integer id, String name, String speciality, String rarity) {

        HeroEntity heroEntity = new HeroEntity(id, name, speciality, rarity);

        if(heroUpdateRepository.updateById(heroEntity) == 0){
            throw new IllegalArgumentException("Hero not found");
        }


    }
}
