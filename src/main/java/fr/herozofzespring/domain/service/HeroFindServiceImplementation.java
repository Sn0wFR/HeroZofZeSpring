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
public class HeroFindServiceImplementation implements HeroFindService {

    @Autowired
    private HeroFindRepository heroFindRepository;

    @Override
    public List<HeroEntity> findAll() {
        return heroFindRepository.findAll();
    }
}
