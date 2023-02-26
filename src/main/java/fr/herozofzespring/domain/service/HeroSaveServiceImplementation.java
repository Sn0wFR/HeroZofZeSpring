package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.domain.enumerator.Rarity;
import fr.herozofzespring.domain.enumerator.Speciality;
import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.out.HeroSaveRepository;
import fr.herozofzespring.port.out.HeroSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroSaveServiceImplementation implements HeroSaveService {

    @Autowired
    private HeroSaveRepository heroSaveRepository;

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
            return null;

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
