package tn.esprit.equip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.equip.Entity.Marque;

@Repository
public interface MarqueRepo extends JpaRepository <Marque, Integer> {
}
