package BonkData.repositorio

import BonnkData.model.Personajes;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonajesRepository extends JpaRepository<Personajes, Long>{}
