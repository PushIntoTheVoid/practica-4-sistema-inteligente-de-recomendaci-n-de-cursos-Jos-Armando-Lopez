import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private ArrayList<String> intereses;
    
    public Estudiante(String nombre){
        this.nombre = nombre;
        this.intereses = new ArrayList<>();
    
    }
    public void agregarIntereses(String interes){
        intereses.add(interes.toLowerCase());
    }

    public String getNombre(){
        return nombre;
    
    }
    public ArrayList<String>getIntereses(){
        return intereses;
    }
}
