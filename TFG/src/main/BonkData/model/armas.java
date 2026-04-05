package BonkData.model;

import org.springframework.data.mongodb.core.mapping.Document;
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
    private String tipo;
    private String obtencion;

    public Armas() {}

    public Armas(String nombre, String descripcion, String obtencion, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.obtencion = obtencion;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObtencion() {
        return obtencion;
    }
    public void setObtencion(String obtencion) {
        this.obtencion = obtencion;
    }
}