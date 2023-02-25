package fr.herozofzespring.adapter.rest;

import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.HeroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroController {


    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public ResponseEntity<List<Hero>> findAll(){
        return new ResponseEntity<>(heroService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hero> save(@RequestBody Map<String, Object> body){

        System.out.println(body);

        String name = (String) body.get("name");
        System.out.println(name);
        Integer hp = (Integer) body.get("hp");
        Integer xp = (Integer) body.get("xp");
        Integer power = (Integer) body.get("power");
        Integer armor = (Integer) body.get("armor");
        Integer level = (Integer) body.get("level");

        System.out.println("test");

        return new ResponseEntity<>(heroService.save(name, hp, xp, power, armor, level), HttpStatus.CREATED);
    }
}
