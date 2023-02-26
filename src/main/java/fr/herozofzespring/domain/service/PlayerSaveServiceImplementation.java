package fr.herozofzespring.domain.service;

import fr.herozofzespring.domain.model.Player;
import fr.herozofzespring.port.in.PlayerSaveService;
import fr.herozofzespring.port.out.PlayerSaveRepository;

public class PlayerSaveServiceImplementation implements PlayerSaveService {

    PlayerSaveRepository playerSaveRepository;


    @Override
    public Player create() {
        return null;
    }
}
