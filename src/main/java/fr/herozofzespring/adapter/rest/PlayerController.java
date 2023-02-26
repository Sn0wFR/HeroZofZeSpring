/*
package fr.herozofzespring.adapter.rest;

import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.port.in.PlayerSaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class PlayerController {

    private final PlayerSaveService playerSaveService;

    public PlayerController(PlayerSaveService playerSaveService) {
        this.playerSaveService = playerSaveService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Map<String, Object> body){

        Map<String, String> errorBody = new HashMap<>();

        String name = (String) body.get("name");
        if (name == null)
            errorBody.put("errorName", "name is null !");


        if (!errorBody.isEmpty())
            return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);

        try{
            HeroEntity heroSaved = heroSaveService.save(name);
            return new ResponseEntity<>(heroSaved, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            errorBody.put("internalError", e.getMessage());
            return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
        }

    }
}
*/