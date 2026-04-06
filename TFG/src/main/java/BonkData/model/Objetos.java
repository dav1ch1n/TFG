package BonkData.model;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.*;

@Entity
@Table(name = "objetos")
public class Objetos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_objeto")
    private Integer id;
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Column(name = "estadisticas_subir")
    private Boolean estadisticasSubir;
    private String obtencion;
    private String categoria;

    public Objetos() {}

    public Objetos(String categoria, Boolean estadisticasSubir, String descripcion, String obtencion, String nombre) {
        this.categoria = categoria;
        this.estadisticasSubir = estadisticasSubir;
        this.descripcion = descripcion;
        this.obtencion = obtencion;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstadisticasSubir() {
        return estadisticasSubir;
    }
    public void setEstadisticasSubir(Boolean estadisticasSubir) {
        this.estadisticasSubir = estadisticasSubir;
    }

    public String getObtencion() {
        return obtencion;
    }
    public void setObtencion(String obtencion) {
        this.obtencion = obtencion;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}