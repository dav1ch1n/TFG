package BonkData.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "estadisticas")
@JsonPropertyOrder({ "nombrePersonaje", "id" }) // Añade los campos que quieras priorizar
public class Estadisticas {
    @Id
    private Long id; // Este ID será el mismo que el del Personaje
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_personajeFK")
    @JsonIgnore
    private Personajes personaje;
    @JsonProperty("nombrePersonaje")
    public String getNombreDelPersonaje() {
        return (personaje != null) ? personaje.getNombre() : "Sin nombre";
    }

    private Integer maxhp;
    private Integer regeneracionhp;
    private Integer supercura;
    private Integer escudo;

    private BigDecimal armadura;
    private BigDecimal esquivar;
    private BigDecimal robo_de_vida;
    private Integer espinas;

    private BigDecimal daño;
    private BigDecimal probabilidad_critico;
    private BigDecimal velocidad_ataque;
    private BigDecimal daño_critico;

    private Integer cantidad_proyectiles;
    private Integer rebote_proyectiles;
    private BigDecimal tamaño;
    private BigDecimal velocidad_proyectil;
    private BigDecimal duracion;
    private BigDecimal daño_elites;
    private BigDecimal retroceso;

    private BigDecimal velocidad_movimiento;
    private Integer salto_extra;
    private Integer altura_salto;

    private BigDecimal suerte;
    private BigDecimal dificultad;
    private Integer rango_recogida;
    private BigDecimal aumento_XP;
    private BigDecimal aumento_Oro;
    private BigDecimal incremento_plata;
    private BigDecimal aparicion_elites;
    private BigDecimal multiplicador_potenciadores;
    private BigDecimal caida_potenciador;

    public Estadisticas() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personajes getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personajes personaje) {
        this.personaje = personaje;
    }

    public Integer getmaxhp() {
        return maxhp;
    }

    public void setmaxhp(Integer maxhp) {
        this.maxhp = maxhp;
    }

    public Integer getregeneracionhp() {
        return regeneracionhp;
    }

    public void setregeneracionhp(Integer regeneracionhp) {
        this.regeneracionhp = regeneracionhp;
    }

    public Integer getEscudo() {
        return escudo;
    }

    public void setEscudo(Integer escudo) {
        this.escudo = escudo;
    }

    public Integer getSupercura() {
        return supercura;
    }

    public void setSupercura(Integer supercura) {
        this.supercura = supercura;
    }

    public BigDecimal getArmadura() {
        return armadura;
    }

    public void setArmadura(BigDecimal armadura) {
        this.armadura = armadura;
    }

    public BigDecimal getEsquivar() {
        return esquivar;
    }

    public void setEsquivar(BigDecimal esquivar) {
        this.esquivar = esquivar;
    }

    public BigDecimal getRobo_de_vida() {
        return robo_de_vida;
    }

    public void setRobo_de_vida(BigDecimal robo_de_vida) {
        this.robo_de_vida = robo_de_vida;
    }

    public Integer getEspinas() {
        return espinas;
    }

    public void setEspinas(Integer espinas) {
        this.espinas = espinas;
    }

    public BigDecimal getdaño() {
        return daño;
    }

    public void setdaño(BigDecimal daño) {
        this.daño = daño;
    }

    public BigDecimal getProbabilidad_critico() {
        return probabilidad_critico;
    }

    public void setProbabilidad_critico(BigDecimal probabilidad_critico) {
        this.probabilidad_critico = probabilidad_critico;
    }

    public BigDecimal getVelocidad_ataque() {
        return velocidad_ataque;
    }

    public void setVelocidad_ataque(BigDecimal velocidad_ataque) {
        this.velocidad_ataque = velocidad_ataque;
    }

    public BigDecimal getdaño_critico() {
        return daño_critico;
    }

    public void setdaño_critico(BigDecimal daño_critico) {
        this.daño_critico = daño_critico;
    }

    public Integer getRebote_proyectiles() {
        return rebote_proyectiles;
    }

    public void setRebote_proyectiles(Integer rebote_proyectiles) {
        this.rebote_proyectiles = rebote_proyectiles;
    }

    public Integer getCantidad_proyectiles() {
        return cantidad_proyectiles;
    }

    public void setCantidad_proyectiles(Integer cantidad_proyectiles) {
        this.cantidad_proyectiles = cantidad_proyectiles;
    }

    public BigDecimal gettamaño() {
        return tamaño;
    }

    public void settamaño(BigDecimal tamaño) {
        this.tamaño = tamaño;
    }

    public BigDecimal getVelocidad_proyectil() {
        return velocidad_proyectil;
    }

    public void setVelocidad_proyectil(BigDecimal velocidad_proyectil) {
        this.velocidad_proyectil = velocidad_proyectil;
    }

    public BigDecimal getdaño_elites() {
        return daño_elites;
    }

    public void setdaño_elites(BigDecimal daño_elites) {
        this.daño_elites = daño_elites;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public BigDecimal getRetroceso() {
        return retroceso;
    }

    public void setRetroceso(BigDecimal retroceso) {
        this.retroceso = retroceso;
    }

    public BigDecimal getVelocidad_movimiento() {
        return velocidad_movimiento;
    }

    public void setVelocidad_movimiento(BigDecimal velocidad_movimiento) {
        this.velocidad_movimiento = velocidad_movimiento;
    }

    public Integer getSalto_extra() {
        return salto_extra;
    }

    public void setSalto_extra(Integer salto_extra) {
        this.salto_extra = salto_extra;
    }

    public Integer getAltura_salto() {
        return altura_salto;
    }

    public void setAltura_salto(Integer altura_salto) {
        this.altura_salto = altura_salto;
    }

    public BigDecimal getSuerte() {
        return suerte;
    }

    public void setSuerte(BigDecimal suerte) {
        this.suerte = suerte;
    }

    public BigDecimal getDificultad() {
        return dificultad;
    }

    public void setDificultad(BigDecimal dificultad) {
        this.dificultad = dificultad;
    }

    public Integer getRango_recogida() {
        return rango_recogida;
    }

    public void setRango_recogida(Integer rango_recogida) {
        this.rango_recogida = rango_recogida;
    }

    public BigDecimal getAumento_XP() {
        return aumento_XP;
    }

    public void setAumento_XP(BigDecimal aumento_XP) {
        this.aumento_XP = aumento_XP;
    }

    public BigDecimal getAumento_Oro() {
        return aumento_Oro;
    }

    public void setAumento_Oro(BigDecimal aumento_Oro) {
        this.aumento_Oro = aumento_Oro;
    }

    public BigDecimal getIncremento_plata() {
        return incremento_plata;
    }

    public void setIncremento_plata(BigDecimal incremento_plata) {
        this.incremento_plata = incremento_plata;
    }

    public BigDecimal getMultiplicador_potenciadores() {
        return multiplicador_potenciadores;
    }

    public void setMultiplicador_potenciadores(BigDecimal multiplicador_potenciadores) {
        this.multiplicador_potenciadores = multiplicador_potenciadores;
    }

    public BigDecimal getAparicion_elites() {
        return aparicion_elites;
    }

    public void setAparicion_elites(BigDecimal aparicion_elites) {
        this.aparicion_elites = aparicion_elites;
    }

    public BigDecimal getCaida_potenciador() {
        return caida_potenciador;
    }

    public void setCaida_potenciador(BigDecimal caida_potenciador) {
        this.caida_potenciador = caida_potenciador;
    }
}