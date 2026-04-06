package BonkData.repositorio;

import BonkData.model.Tomos;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TomosRepository extends JpaRepository<Tomos, Long>{}
