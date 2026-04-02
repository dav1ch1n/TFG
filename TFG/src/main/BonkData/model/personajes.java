package BonkData.model;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.*;

@Entity
@Table(name="personajes")
public class personajes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id_personajes;
    String nombre;
    Integrer arma_inicialFK;
    String habilidad;
    String descripcion;
    String obtencion;

    public personajes(){}

    public personajes(Long id_personajes, String nombre, Integrer arma_inicialFK, String habilidad, String descripcion, String obtencion) {
        this.id_personajes = id_personajes;
        this.nombre = nombre;
        this.arma_inicialFK = arma_inicialFK;
        this.habilidad = habilidad;
        this.descripcion = descripcion;
        this.obtencion = obtencion;
    }

    public Long getId_personajes() {
        return id_personajes;
    }
    public void setId_personajes(Long id_personajes) {
        this.id_personajes = id_personajes;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integrer getArma_inicialFK() {
        return arma_inicialFK;
    }
    public void setArma_inicialFK(Integrer arma_inicialFK) {
        this.arma_inicialFK = arma_inicialFK;
    }

    public String getHabilidad() {
        return habilidad;
    }
    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getObtencion() {
        return obtencion;
    }
    public void setObtencion(String obtencion) {
        this.obtencion = obtencion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}