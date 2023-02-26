package fr.herozofzespring.domain.service.hero;

import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.port.out.hero.HeroFindRepository;
import fr.herozofzespring.port.out.hero.HeroSaveRepository;
import fr.herozofzespring.port.in.hero.HeroSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroSaveServiceImplementation implements HeroSaveService {

    @Autowired
    private HeroSaveRepository heroSaveRepository;

    @Autowired
    private HeroFindRepository heroFindRepository;

    @Override
    public HeroEntity save(String name, String speciality, String rarity) {

        this.heroFindRepository.findAll().forEach(heroEntity -> {
            System.out.println(heroEntity.getName() + " " + heroEntity.getSpeciality() + " " + heroEntity.getRarity());
            if (heroEntity.getName().equals(name) && heroEntity.getSpeciality().equals(speciality) && heroEntity.getRarity().equals(rarity))
                throw new IllegalArgumentException("Hero already exists");
        });

        HeroEntity heroEntity = new HeroEntity(
                        name,
                        speciality,
                        rarity
        );

        return heroSaveRepository.save(heroEntity);

    }

}
