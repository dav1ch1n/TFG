package BonkData.repositorio;

import BonnkData.model.Estadisticas;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstadisticasRepository extends JpaRepository<Estadisticas, Long>{}
