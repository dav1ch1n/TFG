package BonkData.model;

import jakarta.persistence.*;

@Entity
@Table(name = "armas")
public class Armas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arma")
    private Long id;
    private String nombre;
    private String descripcion;
    private String obtencion;

    public Armas() {}

    public Armas(String nombre, String descripcion, String obtencion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.obtencion = obtencion;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getObtencion() {
        return obtencion;
    }
    public void setObtencion(String obtencion) {
        this.obtencion = obtencion;
    }
}