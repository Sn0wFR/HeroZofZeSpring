package fr.herozofzespring.adapter.rest;

import fr.herozofzespring.port.in.CardDeleteService;
import fr.herozofzespring.port.in.CardFindService;
import fr.herozofzespring.port.in.CardSaveService;
import fr.herozofzespring.port.in.CardUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/card")
public class CardController {

    private final CardSaveService cardSaveService;
    private final CardFindService cardFindService;
    private final CardDeleteService cardDeleteService;
    private final CardUpdateService cardUpdateService;

    public CardController(CardSaveService cardSaveService, CardFindService cardFindService, CardDeleteService cardDeleteService, CardUpdateService cardUpdateService) {
        this.cardSaveService = cardSaveService;
        this.cardFindService = cardFindService;
        this.cardDeleteService = cardDeleteService;
        this.cardUpdateService = cardUpdateService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Map<String, Object> body){
        Integer heroId = (Integer) body.get("heroId");

        if (heroId == null)
            return ResponseEntity.badRequest().body(Map.of("errorHeroId", "heroId is null !"));

        try{

            return ResponseEntity.ok(cardSaveService.save(heroId));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("errorHeroId", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(cardFindService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        try{
            return ResponseEntity.ok(cardFindService.findById(id));
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){

        try{
            return ResponseEntity.ok(cardDeleteService.deleteById(id));
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody Map<String, Object> body){
        Integer heroId = (Integer) body.get("heroId");

        if (heroId == null)
            return ResponseEntity.badRequest().body(Map.of("errorHeroId", "heroId is null !"));

        try{
            cardUpdateService.updateById(id, heroId);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }


}
