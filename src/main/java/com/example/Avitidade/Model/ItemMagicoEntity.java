package com.example.Avitidade.Model;

public class ItemMagicoEntity {
    private long id ;
    private String nameItem;
    private String itenTipo;
    private int forcaItem;
    private int defIten;

    public ItemMagicoEntity(String nameItem, String itenTipo, int forcaItem, int defIten) {
        this.nameItem = nameItem;
        this.itenTipo = itenTipo;
        this.forcaItem = forcaItem;
        this.defIten = defIten;
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

    public String getItenTipo() {
        return itenTipo;
    }

    public void setItenTipo(String itenTipo) {
        this.itenTipo = itenTipo;
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
}
