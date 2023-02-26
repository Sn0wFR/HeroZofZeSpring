package fr.herozofzespring.adapter.rest;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.port.in.HeroFindService;
import fr.herozofzespring.port.out.HeroSaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroController {


    private final HeroSaveService heroSaveService;
    private final HeroFindService heroFindService;

    public HeroController(HeroSaveService heroSaveService, HeroFindService heroFindService) {
        this.heroSaveService = heroSaveService;
        this.heroFindService = heroFindService;
    }

    @GetMapping
    public ResponseEntity<List<HeroEntity>> findAll(){
        return new ResponseEntity<>(heroFindService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Map<String, Object> body){

        Map<String, String> errorBody = new HashMap<>();

        String name = (String) body.get("name");
        if (name == null)
            errorBody.put("errorName", "name is null !");

        String speciality = (String) body.get("speciality");
        if (speciality == null)
            errorBody.put("errorSpeciality", "speciality is null !");
        else{
            switch (speciality.toUpperCase()) {
                case "TANK" -> speciality = "TANK";
                case "ASSASSIN" -> speciality = "ASSASSIN";
                case "MAGE" -> speciality = "MAGE";
                default -> errorBody.put("errorSpeciality", "the chosen speciality is unknown");
            }
        }

        String rarity = (String) body.get("rarity");
        if (rarity == null)
            errorBody.put("errorRarity", "rarity is null !");
        else{
            switch (rarity.toUpperCase()) {
                case "COMMON" -> rarity = "COMMON";
                case "RARE" -> rarity = "RARE";
                case "LEGENDARY" -> rarity = "LEGENDARY";
                default -> errorBody.put("errorRarity", "the chosen rarity is unknown");
            }
        }

        if (!errorBody.isEmpty())
            return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);

        try{
            HeroEntity heroSaved = heroSaveService.save(name, speciality, rarity);
            return new ResponseEntity<>(heroSaved, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            errorBody.put("internalError", e.getMessage());
            return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
        }

    }
}
