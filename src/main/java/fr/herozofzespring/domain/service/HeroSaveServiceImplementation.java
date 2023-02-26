package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.domain.enumerator.Rarity;
import fr.herozofzespring.domain.enumerator.Speciality;
import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.in.HeroFindRepository;
import fr.herozofzespring.port.in.HeroFindService;
import fr.herozofzespring.port.out.HeroSaveRepository;
import fr.herozofzespring.port.out.HeroSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroSaveServiceImplementation implements HeroSaveService {

    @Autowired
    private HeroSaveRepository heroSaveRepository;

    @Autowired
    private HeroFindRepository heroFindRepository;

    @Override
    public HeroEntity save(String name, String speciality, String rarity) {
        Speciality affectedSpeciality = null;
        for (Speciality s : Speciality.values()) {
            if(s.name().equals(speciality.toUpperCase())){
                affectedSpeciality = s;
            }
        }

        Rarity affectedRarity = null;
        for (Rarity r : Rarity.values()) {
            if(r.name().equals(rarity.toUpperCase())){
                affectedRarity = r;
            }
        }

        if (name == null || affectedSpeciality == null || affectedRarity == null)
            throw new IllegalArgumentException("Hero not valid");

        this.heroFindRepository.findAll().forEach(heroEntity -> {
            if (heroEntity.getName().equals(name) && heroEntity.getSpeciality().equals(name) && heroEntity.getRarity().equals(name))
                throw new IllegalArgumentException("Hero already exists");
        });

        HeroEntity heroEntity = new HeroEntity(
                new Hero(
                        name,
                        affectedSpeciality,
                        affectedRarity
                )
        );

        return heroSaveRepository.save(heroEntity);

    }

}
