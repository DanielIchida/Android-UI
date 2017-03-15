package udemy.animacion;

/**
 * Created by daniel on 10/03/2017.
 */

public class Equipo {

    private String nombre;
    private String nom_estadio;
    private int logo;
    private int img_estadio;
    private String bg_color;
    private String tx_color;

    public Equipo(String nombre, String nom_estadio , int logo , int img_estadio , String bg_color , String tx_color){
        this.nombre = nombre;
        this.nom_estadio = nom_estadio;
        this.logo = logo;
        this.img_estadio = img_estadio;
        this.bg_color = bg_color;
        this.tx_color = tx_color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNom_estadio() {
        return nom_estadio;
    }

    public int getLogo() {
        return logo;
    }

    public int getImg_estadio() {
        return img_estadio;
    }

    public String getBg_color() {
        return bg_color;
    }

    public String getTx_color() {
        return tx_color;
    }
}
