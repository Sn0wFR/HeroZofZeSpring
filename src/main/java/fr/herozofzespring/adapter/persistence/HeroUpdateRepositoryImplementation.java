package fr.herozofzespring.adapter.persistence;

import fr.herozofzespring.adapter.HeroEntity;
import fr.herozofzespring.port.out.HeroUpdateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class HeroUpdateRepositoryImplementation implements HeroUpdateRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public int updateById(HeroEntity hero) {

        String sql = "UPDATE hero_entity SET ";
        String data = "";

        if (hero.getName() != null) {
            data += "name = '" + hero.getName() + "' ";
        }

        if (hero.getSpeciality() != null) {
            if (!data.equals("")) {
                data += ", ";
            }
            data += "speciality = '" + hero.getSpeciality() + "' ";
        }

        if (hero.getRarity() != null) {
            if (!data.equals("")) {
                data += ", ";
            }
            data += "rarity = '" + hero.getRarity() + "' ";
        }

        sql += data + "WHERE hero_id = " + hero.getHeroId();

        System.out.println(sql);

        return entityManager.createNativeQuery(sql).executeUpdate();
    }
}
