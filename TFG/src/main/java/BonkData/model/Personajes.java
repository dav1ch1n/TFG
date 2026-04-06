package BonkData.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name="personajes")
@JsonPropertyOrder({ "idPersonajes", "nombre", "nombreArma", "habilidad", "descripcion", "obtencion" })
public class Personajes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_personajes")
    private Long idPersonajes;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "arma_inicialfk") // El nombre exacto de la FK
    @JsonIgnore
    private Armas Arma_inicial;


    private String habilidad;
    private String descripcion;
    private String obtencion;

    public Personajes(){}

    public Personajes( String nombre, String habilidad, String descripcion, String obtencion) {
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.descripcion = descripcion;
        this.obtencion = obtencion;
    }
    public Long getIdPersonajes() {
        return idPersonajes;
    }
    public void setidPersonajes(Long idPersonajes) {
        this.idPersonajes = idPersonajes;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("nombreArma")
    public String getNombreDelArma() {
        return (Arma_inicial != null) ? Arma_inicial.getNombre() : "Sin arma";
    }
    public void setArma_inicial(Armas Arma_inicial) {
        this.Arma_inicial = Arma_inicial;
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