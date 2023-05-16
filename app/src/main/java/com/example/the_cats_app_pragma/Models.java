package com.example.the_cats_app_pragma;


public class Models {
    private String breedname;

    private String oringin;

    private String afectionlevel;

    private String inteligencia;

    private String imageUrl;

    public Models(String breedname, String imageUrl, String afectionlevel, String oringin, String inteligencia) {
        this.breedname = breedname;
        this.imageUrl = imageUrl;
        this.oringin = oringin;
        this.afectionlevel = afectionlevel;
        this.inteligencia = inteligencia;
    }



    public String getNombre() {
        return breedname;
    }

    public void setNombre(String nombre) {
        this.breedname = nombre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAfectionlevel() {
        return afectionlevel;
    }

    public void setAfectionlevel(String raza) {
        this.afectionlevel = raza;
    }

    public String getOringin() {
        return oringin;
    }

    public void setOringin(String pais) {
        this.oringin = pais;
    }

    public String getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        this.inteligencia = inteligencia;
    }
}

