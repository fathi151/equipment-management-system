package tn.esprit.equip.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.equip.Entity.Equipement;

public interface EquipRepo extends JpaRepository<Equipement, Integer> {
    @Query("SELECT DISTINCT e FROM Equipement e  JOIN e.fournisseur f " +
            "WHERE LOWER(e.numSerie) LIKE %:keyword% " +
            "OR LOWER(e.model.nomModel) LIKE %:keyword% " +
            "OR LOWER(f.nomFournisseur) LIKE %:keyword%")

    Page<Equipement> searchEquipements(@Param("keyword") String keyword, Pageable pageable);

}
