package com.example.Avitidade.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemMagicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameItem;
    private int forcaItem;
    private int defIten;

    private TipoItem tipo;

    public ItemMagicoEntity() {

    }

    public enum TipoItem {
        ARMA, ARMADURA, AMULETO
    }

    public void validarDeforAtak() {
        if (forcaItem == 0 && defIten == 0) {
            throw new IllegalArgumentException("Item tem que ter FORÇA ou DEFESA");
        }
        if (tipo == TipoItem.ARMA && defIten != 0) {
            throw new IllegalArgumentException("Armas não tem DEFESA");
        }
        if (tipo == TipoItem.ARMADURA && forcaItem != 0) {
            throw new IllegalArgumentException("Armaduras não tem FORÇA.");
        }
    }

    public ItemMagicoEntity(String nameItem, int forcaItem, int defIten, TipoItem tipo) {
        this.nameItem = nameItem;
        this.forcaItem = forcaItem;
        this.defIten = defIten;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public int getForcaItem() {
        return forcaItem;
    }

    public void setForcaItem(int forcaItem) {
        this.forcaItem = forcaItem;
    }

    public int getDefIten() {
        return defIten;
    }

    public void setDefIten(int defIten) {
        this.defIten = defIten;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }
}