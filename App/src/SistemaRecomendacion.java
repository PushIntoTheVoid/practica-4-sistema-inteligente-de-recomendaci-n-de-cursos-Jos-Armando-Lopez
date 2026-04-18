import java.util.*;

public class SistemaRecomendacion {

    private ArrayList<Curso> cursos;
    private HashMap<String, ArrayList<Curso>> historial;
    private ArrayList<Estudiante> estudiantes;

    public SistemaRecomendacion(){
        cursos = new ArrayList<>();
        historial = new HashMap<>();
        estudiantes = new ArrayList<>();
    }
    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }
    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }

    public List<Curso> recomendar(Estudiante estudiante) {
        HashMap<Curso,Integer> puntuacion = new HashMap<>();
        for (Curso curso : cursos){
            int score = 0;
            for (String interes : estudiante.getIntereses()) {
                if (curso.getTemas().contains(interes)) {
                    score++;
                }
            }
            puntuacion.put(curso, score);
        }
        List<Map.Entry<Curso, Integer>> lista = new ArrayList<>(puntuacion.entrySet());
        lista.sort((a,b) -> b.getValue() - a.getValue());
        
        List<Curso> recomendados = new ArrayList<>();

        for (Map.Entry<Curso, Integer> entry : lista) {
            if(entry.getValue() > 0){
                recomendados.add(entry.getKey());
            }
        }

        historial.put(estudiante.getNombre(), new ArrayList<>(recomendados));
        return recomendados;
    }
    public HashMap<Curso, Integer> reconmedarConScore(Estudiante estudiante){
        HashMap<Curso, Integer> puntuacion = new HashMap<>();
        for(Curso curso : cursos){
            int score = 0;
            for (String interes : estudiante.getIntereses()){
                if (curso.getTemas().contains(interes)){
                    score++;
                }
            }
            puntuacion.put(curso, score);
        }
        historial.put(estudiante.getNombre(), new ArrayList<>(cursos));
        return puntuacion;
    }
    public ArrayList<Curso> getCursos(){
        return cursos;
    }
    public ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }
    public HashMap<String, ArrayList<Curso>> getHistorial(){
        return historial;
    }
}
