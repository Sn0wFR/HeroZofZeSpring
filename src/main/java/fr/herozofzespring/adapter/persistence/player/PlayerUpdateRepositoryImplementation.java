package fr.herozofzespring.adapter.persistence.player;

import fr.herozofzespring.adapter.entity.PlayerEntity;
import fr.herozofzespring.port.out.player.PlayerUpdateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerUpdateRepositoryImplementation implements PlayerUpdateRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public int update(PlayerEntity playerEntity) {
        String sql = "UPDATE player_entity SET ";
        String data = "";

        if (playerEntity.getName() != null) {
            data += "name = '" + playerEntity.getName() + "' ";
        }

        if (playerEntity.getJeton() != null) {
            if (!data.equals("")) {
                data += ", ";
            }
            data += "jeton = '" + playerEntity.getJeton() + "' ";
        }

        sql += data + "WHERE player_id = " + playerEntity.getPlayerId();

        System.out.println(sql);

        return entityManager.createNativeQuery(sql).executeUpdate();
    }
}
