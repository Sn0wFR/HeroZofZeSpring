
package fr.herozofzespring.adapter.rest;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.in.player.PlayerDeleteService;
import fr.herozofzespring.port.in.player.PlayerFindService;
import fr.herozofzespring.port.in.player.PlayerSaveService;
import fr.herozofzespring.port.in.player.PlayerUpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    private final PlayerSaveService playerSaveService;
    private final PlayerFindService playerFindService;
    private final PlayerDeleteService playerDeleteService;
    private final PlayerUpdateService playerUpdateService;

    public PlayerController(PlayerSaveService playerSaveService, PlayerFindService playerFindService, PlayerDeleteService playerDeleteService, PlayerUpdateService playerUpdateService) {
        this.playerSaveService = playerSaveService;
        this.playerFindService = playerFindService;
        this.playerDeleteService = playerDeleteService;
        this.playerUpdateService = playerUpdateService;
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
            PlayerEntity player = playerSaveService.save(name);
            return new ResponseEntity<>(player, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            errorBody.put("internalError", e.getMessage());
            return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(playerFindService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        PlayerEntity playerEntity = playerFindService.findById(id);
        if (playerEntity == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(playerEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(playerDeleteService.deleteById(id));
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody Map<String, Object> body){
        Map<String, String> errorBody = new HashMap<>();

        String name = (String) body.get("name");
        Integer jeton = (Integer) body.get("jeton");
        if (name == null && jeton == null)
            errorBody.put("error", "name and jeton are null !");

        if (!errorBody.isEmpty())
            return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);

        try{
            playerUpdateService.updateById(id, name, jeton);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }


}
