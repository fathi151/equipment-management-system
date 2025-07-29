package tn.esprit.equip.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.equip.Entity.Affectation;
import tn.esprit.equip.Entity.Equipement;

public interface AffectationRepo  extends JpaRepository<Affectation,Long> {
Affectation findByEquipementIdEqui(int idEqui);


    void deleteAllByEquipement(Equipement equipement);
}
