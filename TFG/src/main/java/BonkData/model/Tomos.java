package BonkData.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tomos")
public class Tomos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tomo")
    private Integer id;
    private String nombre;
    private String descripcion;
    @Column(name = "estadistica_subir")
    private String estadisticaSubir;
    private String obtencion;

    public Tomos() {}

    public Tomos(String obtencion, String nombre, String descripcion, String estadisticaSubir) {
        this.obtencion = obtencion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadisticaSubir = estadisticaSubir;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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

    public String getEstadisticaSubir() {
        return estadisticaSubir;
    }
    public void setEstadisticaSubir(String estadisticaSubir) {
        this.estadisticaSubir = estadisticaSubir;
    }

    public String getObtencion() {
        return obtencion;
    }
    public void setObtencion(String obtencion) {
        this.obtencion = obtencion;
    }
}