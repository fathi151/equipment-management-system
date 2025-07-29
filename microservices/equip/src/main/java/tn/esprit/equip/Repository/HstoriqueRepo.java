package tn.esprit.equip.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.equip.Entity.Historique;

public interface HstoriqueRepo extends JpaRepository<Historique, Integer> {

    @Override
    Page<Historique> findAll(Pageable pageable);
}
