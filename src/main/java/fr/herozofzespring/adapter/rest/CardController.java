package fr.herozofzespring.adapter.rest;

import fr.herozofzespring.port.in.card.CardDeleteService;
import fr.herozofzespring.port.in.card.CardFindService;
import fr.herozofzespring.port.in.card.CardSaveService;
import fr.herozofzespring.port.in.card.CardUpdateService;
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
        Integer playerId = (Integer) body.get("playerId");

        if (heroId == null)
            return ResponseEntity.badRequest().body(Map.of("errorHeroId", "heroId is null !"));

        if (playerId == null)
            return ResponseEntity.badRequest().body(Map.of("errorPlayerId", "playerId is null !"));

        try{

            return ResponseEntity.ok(cardSaveService.save(heroId, playerId));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
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

        Integer playerId = (Integer) body.get("playerId");

        if (heroId == null && playerId == null)
            return ResponseEntity.badRequest().body(Map.of("error", "heroId and playerId are null !"));


        try{
            cardUpdateService.updateById(id, heroId, playerId);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }


}
