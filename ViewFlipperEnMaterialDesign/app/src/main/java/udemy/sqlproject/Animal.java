package udemy.sqlproject;

/**
 * Created by daniel on 8/03/2017.
 */

public class Animal {

    private String nombre;
    private String ubicacion;

    public Animal(String nombre,String ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
