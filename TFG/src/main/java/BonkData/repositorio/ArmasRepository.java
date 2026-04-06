package BonkData.repositorio;

import BonkData.model.Armas;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArmasRepository extends JpaRepository<Armas, Long>{}
