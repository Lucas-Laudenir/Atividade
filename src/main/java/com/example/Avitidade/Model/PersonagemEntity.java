package com.example.Avitidade.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class PersonagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersonagem;
    private String namePersonagem;
    private String nomeAventureiro;
    @Enumerated(EnumType.STRING)
    private ClassePersonagem classe;
    private int level;
    private int forcaPersonagem;
    private int defPersonagem;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "personagem_id") // cria a FK em ItemMagicoEntity
    private List<ItemMagicoEntity> itensMagicos = new ArrayList<>();


    public PersonagemEntity() {
    }

    public PersonagemEntity(String namePersonagem, String nomeAventureiro, ClassePersonagem classe, int level, int forcaPersonagem, int defPersonagem) {
        this.namePersonagem = namePersonagem;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.forcaPersonagem = forcaPersonagem;
        this.defPersonagem = defPersonagem;
    }

    public enum ClassePersonagem {
        GUERREIRO, MAGO, ARQUEIRO, LADINO, BARDO
    }

    public int getForcaTotal() {
        return forcaPersonagem + itensMagicos.stream().mapToInt(ItemMagicoEntity::getForcaItem).sum();
    }

    public int getDefesaTotal() {
        return defPersonagem + itensMagicos.stream().mapToInt(ItemMagicoEntity::getDefIten).sum();
    }

    public void adicionarItem(ItemMagicoEntity item) {
        if (item.getTipo() == ItemMagicoEntity.TipoItem.AMULETO &&
                itensMagicos.stream().anyMatch(i -> i.getTipo() == ItemMagicoEntity.TipoItem.AMULETO)) {
            throw new IllegalArgumentException("O personagem já possui um amuleto. Remova o amuleto existente antes de adicionar outro.");
        }
        this.itensMagicos.add(item);
    }

    public List<ItemMagicoEntity> getItensMagicos() {
        return Collections.unmodifiableList(itensMagicos);
    }

    public long getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(long idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public String getNamePersonagem() {
        return namePersonagem;
    }

    public void setNamePersonagem(String namePersonagem) {
        this.namePersonagem = namePersonagem;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public ClassePersonagem getClasse() {
        return classe;
    }

    public void setClasse(ClassePersonagem classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setForcaPersonagem(int forcaPersonagem) {
        this.forcaPersonagem = forcaPersonagem;
    }

    public void setDefPersonagem(int defPersonagem) {
        this.defPersonagem = defPersonagem;
    }

    public void setItensMagicos(List<ItemMagicoEntity> itensMagicos) {
        this.itensMagicos = itensMagicos;
    }

    public int getForcaPersonagem() {
        return forcaPersonagem;
    }

    public int getDefPersonagem() {
        return defPersonagem;
    }

}