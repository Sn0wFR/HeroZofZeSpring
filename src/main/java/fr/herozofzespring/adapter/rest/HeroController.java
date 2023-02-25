package fr.herozofzespring.adapter.rest;

import fr.herozofzespring.domain.model.Hero;
import fr.herozofzespring.port.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public ResponseEntity<List<Hero>> getProducts() {
        return new ResponseEntity<>(heroService.getHeros(), HttpStatus.OK);
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<Hero> getProductById(@PathVariable Integer heroId) {
        return new ResponseEntity<>(heroService.getHeroById(heroId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hero> addProduct(@RequestBody Hero hero) {
        System.out.println(hero.getHeroId());
        System.out.println(this.getClass().getName());
        return new ResponseEntity<>(heroService.addHero(hero), HttpStatus.CREATED);
    }

    @DeleteMapping("/{heroId}")
    public ResponseEntity<Hero> removeProduct(@PathVariable Integer heroId) {
        return new ResponseEntity<>(heroService.removeHero(heroId), HttpStatus.OK);
    }
}
