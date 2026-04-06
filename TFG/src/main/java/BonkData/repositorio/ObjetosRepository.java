package BonkData.repositorio;

import BonnkData.model.Objetos;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ObjetosRepository extends JpaRepository<Objetos, Long>{}
