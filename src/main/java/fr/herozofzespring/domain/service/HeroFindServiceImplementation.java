package fr.herozofzespring.domain.service;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.port.out.HeroFindRepository;
import fr.herozofzespring.port.in.HeroFindService;
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

    @Override
    public HeroEntity findById(Integer heroId) {
        return heroFindRepository.findById(heroId);
    }

}
