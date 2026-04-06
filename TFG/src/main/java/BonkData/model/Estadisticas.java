package BonkData.model;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.*;
import java.math.Decimal;

@Entity
@Table(name = "estadisticas")
public class Estadisticas {

    @Id
    private Long id; // Este ID será el mismo que el del Personaje

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_personajeFK")
    private Personaje personaje;

    private Integer maxHp;
    private Integer regeneracionHp;
    private Integer supercura;
    private Integer escudo;

    private Decimal armadura;
    private Decimal esquivar;
    private Decimal robo_de_vida;
    private Integer espinas;

    private Decimal danyo;
    private Decimal probabilidad_critico;
    private Decimal velocidad_ataque;
    private Decimal danyo_critico;

    private Integer cantidad_proyectiles;
    private Integer rebote_proyectiles;
    private Decimal tamanyo;
    private Decimal velocidad_proyectil;
    private Decimal duracion;
    private Decimal danyo_elites;
    private Decimal retroceso;

    private Decimal velocidad_movimiento;
    private Integer salto_extra;
    private Integer altura_salto;

    private Decimal suerte;
    private Decimal dificultad;
    private Integer rango_recogida;
    private Decimal aumento_XP;
    private Decimal aumento_Oro;
    private Decimal incremento_plata;
    private Decimal aparicion_elites;
    private Decimal multiplicador_potenciadores;
    private Decimal caida_potenciador;

    public Estadisticas() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public Integer getRegeneracionHp() {
        return regeneracionHp;
    }

    public void setRegeneracionHp(Integer regeneracionHp) {
        this.regeneracionHp = regeneracionHp;
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

    public Decimal getArmadura() {
        return armadura;
    }

    public void setArmadura(Decimal armadura) {
        this.armadura = armadura;
    }

    public Decimal getEsquivar() {
        return esquivar;
    }

    public void setEsquivar(Decimal esquivar) {
        this.esquivar = esquivar;
    }

    public Decimal getRobo_de_vida() {
        return robo_de_vida;
    }

    public void setRobo_de_vida(Decimal robo_de_vida) {
        this.robo_de_vida = robo_de_vida;
    }

    public Integer getEspinas() {
        return espinas;
    }

    public void setEspinas(Integer espinas) {
        this.espinas = espinas;
    }

    public Decimal getDanyo() {
        return danyo;
    }

    public void setDanyo(Decimal danyo) {
        this.danyo = danyo;
    }

    public Decimal getProbabilidad_critico() {
        return probabilidad_critico;
    }

    public void setProbabilidad_critico(Decimal probabilidad_critico) {
        this.probabilidad_critico = probabilidad_critico;
    }

    public Decimal getVelocidad_ataque() {
        return velocidad_ataque;
    }

    public void setVelocidad_ataque(Decimal velocidad_ataque) {
        this.velocidad_ataque = velocidad_ataque;
    }

    public Decimal getDanyo_critico() {
        return danyo_critico;
    }

    public void setDanyo_critico(Decimal danyo_critico) {
        this.danyo_critico = danyo_critico;
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

    public Decimal getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(Decimal tamanyo) {
        this.tamanyo = tamanyo;
    }

    public Decimal getVelocidad_proyectil() {
        return velocidad_proyectil;
    }

    public void setVelocidad_proyectil(Decimal velocidad_proyectil) {
        this.velocidad_proyectil = velocidad_proyectil;
    }

    public Decimal getDanyo_elites() {
        return danyo_elites;
    }

    public void setDanyo_elites(Decimal danyo_elites) {
        this.danyo_elites = danyo_elites;
    }

    public Decimal getDuracion() {
        return duracion;
    }

    public void setDuracion(Decimal duracion) {
        this.duracion = duracion;
    }

    public Decimal getRetroceso() {
        return retroceso;
    }

    public void setRetroceso(Decimal retroceso) {
        this.retroceso = retroceso;
    }

    public Decimal getVelocidad_movimiento() {
        return velocidad_movimiento;
    }

    public void setVelocidad_movimiento(Decimal velocidad_movimiento) {
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

    public Decimal getSuerte() {
        return suerte;
    }

    public void setSuerte(Decimal suerte) {
        this.suerte = suerte;
    }

    public Decimal getDificultad() {
        return dificultad;
    }

    public void setDificultad(Decimal dificultad) {
        this.dificultad = dificultad;
    }

    public Integer getRango_recogida() {
        return rango_recogida;
    }

    public void setRango_recogida(Integer rango_recogida) {
        this.rango_recogida = rango_recogida;
    }

    public Decimal getAumento_XP() {
        return aumento_XP;
    }

    public void setAumento_XP(Decimal aumento_XP) {
        this.aumento_XP = aumento_XP;
    }

    public Decimal getAumento_Oro() {
        return aumento_Oro;
    }

    public void setAumento_Oro(Decimal aumento_Oro) {
        this.aumento_Oro = aumento_Oro;
    }

    public Decimal getIncremento_plata() {
        return incremento_plata;
    }

    public void setIncremento_plata(Decimal incremento_plata) {
        this.incremento_plata = incremento_plata;
    }

    public Decimal getMultiplicador_potenciadores() {
        return multiplicador_potenciadores;
    }

    public void setMultiplicador_potenciadores(Decimal multiplicador_potenciadores) {
        this.multiplicador_potenciadores = multiplicador_potenciadores;
    }

    public Decimal getAparicion_elites() {
        return aparicion_elites;
    }

    public void setAparicion_elites(Decimal aparicion_elites) {
        this.aparicion_elites = aparicion_elites;
    }

    public Decimal getCaida_potenciador() {
        return caida_potenciador;
    }

    public void setCaida_potenciador(Decimal caida_potenciador) {
        this.caida_potenciador = caida_potenciador;
    }
}