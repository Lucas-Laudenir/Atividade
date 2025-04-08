package com.example.Avitidade.Model;

public class PersonagemEntity {
    private long idPersonagem;
    private String namePersonagem;
    private String NomeAventureiro;
    private String classe;
    private int level;
    private String LIstaitemMagico; //lista
    private int forcaPersonagem;
    private int defPersonagem;

    public PersonagemEntity(int defPersonagem, int forcaPersonagem, String LIstaitemMagico, int level, String classe, String nomeAventureiro, String namePersonagem) {
        this.defPersonagem = defPersonagem;
        this.forcaPersonagem = forcaPersonagem;
        this.LIstaitemMagico = LIstaitemMagico;
        this.level = level;
        this.classe = classe;
        NomeAventureiro = nomeAventureiro;
        this.namePersonagem = namePersonagem;
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
        return NomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        NomeAventureiro = nomeAventureiro;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLIstaitemMagico() {
        return LIstaitemMagico;
    }

    public void setLIstaitemMagico(String LIstaitemMagico) {
        this.LIstaitemMagico = LIstaitemMagico;
    }

    public int getForcaPersonagem() {
        return forcaPersonagem;
    }

    public void setForcaPersonagem(int forcaPersonagem) {
        this.forcaPersonagem = forcaPersonagem;
    }

    public int getDefPersonagem() {
        return defPersonagem;
    }

    public void setDefPersonagem(int defPersonagem) {
        this.defPersonagem = defPersonagem;
    }
}



