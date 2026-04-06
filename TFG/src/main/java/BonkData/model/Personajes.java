package BonkData.model;

import jakarta.persistence.*;

@Entity
@Table(name="personajes")
public class Personajes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idPersonajes")
    private Long idPersonajes;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "Arma_inicialFK") // El nombre exacto de la FK
    private Armas Arma_inicialFK;
    private String habilidad;
    private String descripcion;
    private String obtencion;

    public Personajes(){}

    public Personajes( String nombre, Armas Arma_inicialFK, String habilidad, String descripcion, String obtencion) {
        this.nombre = nombre;
        this.Arma_inicialFK = Arma_inicialFK;
        this.habilidad = habilidad;
        this.descripcion = descripcion;
        this.obtencion = obtencion;
    }
    public Long getidPersonajes() {
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

    public Armas getArma_inicialFK() {
        return Arma_inicialFK;
    }
    public void setArma_inicialFK(Armas Arma_inicialFK) {
        this.Arma_inicialFK = Arma_inicialFK;
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