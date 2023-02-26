package fr.herozofzespring.adapter.rest;

import fr.herozofzespring.adapter.entity.HeroEntity;
import fr.herozofzespring.port.in.hero.HeroDeleteService;
import fr.herozofzespring.port.in.hero.HeroFindService;
import fr.herozofzespring.port.in.hero.HeroSaveService;
import fr.herozofzespring.port.in.hero.HeroUpdateService;
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
    private final HeroDeleteService heroDeleteService;
    private final HeroUpdateService heroUpdateService;

    public HeroController(HeroSaveService heroSaveService, HeroFindService heroFindService, HeroDeleteService heroDeleteService, HeroUpdateService heroUpdateService) {
        this.heroSaveService = heroSaveService;
        this.heroFindService = heroFindService;
        this.heroDeleteService = heroDeleteService;
        this.heroUpdateService = heroUpdateService;
    }

    @GetMapping
    public ResponseEntity<List<HeroEntity>> findAll(){
        return ResponseEntity.ok(heroFindService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroEntity> findById(@PathVariable Integer id){
        HeroEntity heroEntity = heroFindService.findById(id);
        if (heroEntity == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(heroEntity);
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
            return ResponseEntity.badRequest().body(errorBody);

        try{
            return ResponseEntity.ok(heroSaveService.save(name, speciality, rarity));
        }catch (IllegalArgumentException e){
            errorBody.put("internalError", e.getMessage());
            return ResponseEntity.badRequest().body(errorBody);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(heroDeleteService.deleteById(id));
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody Map<String, Object> body) {

        Map<String, String> errorBody = new HashMap<>();

        String name = (String) body.get("name");
        String speciality = (String) body.get("speciality");
        String rarity = (String) body.get("rarity");

        if (name == null && speciality == null && rarity == null){
            errorBody.put("error", "no data to update, invalid Request");
            return ResponseEntity.badRequest().body(errorBody);
        }

        try{
            heroUpdateService.updateById(id, name, speciality, rarity);
        }catch (IllegalArgumentException e){
            errorBody.put("internalError", e.getMessage());
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }
}
