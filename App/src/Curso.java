import java.util.ArrayList;

public class Curso {
    
    private String nombre;
    private ArrayList<String> temas;

    public Curso(String nombre){
        this.nombre = nombre;
        this.temas = new ArrayList<>();
    }
    public void agregarTema(String tema) {
        temas.add(tema.toLowerCase());
    }
    public String getNombre () {
        return nombre;
    }
    public ArrayList<String> getTemas(){
        return temas;
    }
}
