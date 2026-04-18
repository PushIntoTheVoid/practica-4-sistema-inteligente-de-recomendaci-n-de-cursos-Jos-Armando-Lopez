import java.util.*;

public class Main {
    public static void main(String[] args) {
         
        SistemaRecomendacion sistema = new SistemaRecomendacion();

         Curso c1 = new Curso("Programación en Java");
         c1.agregarTema("programacion");

         Curso c2 = new Curso("Introduccion a IA");
         c2.agregarTema("ia");

         Curso c3 = new Curso("Bases de Datos");
         c3.agregarTema("datos");
         sistema.agregarCurso(c1);
         sistema.agregarCurso(c2);
         sistema.agregarCurso(c3);
         Scanner scanner = new Scanner(System.in);
         System.out.print("¿Cuántos estudiantes deseas registrar? ");
         int cantidad = Integer.parseInt(scanner.nextLine());
         for (int i = 0; i < cantidad; i++) {
            System.out.println("Nombre del estudiante: ");
            String nombre = scanner.nextLine();
            Estudiante est = new Estudiante(nombre);

            System.out.print("¿Cuántos intereses tiene " + nombre + "? ");
            int numIntereses = Integer.parseInt(scanner.nextLine());
            
            for (int j = 0; j < numIntereses; j++) {
                System.out.print("Interes " + (j + 1) + ": ");
                est.agregarIntereses(scanner.nextLine());
            }  
            sistema.agregarEstudiante(est);
         }
         for(Estudiante est : sistema.getEstudiantes()) {
            System.out.println("Recomendaciones para: " + est.getNombre() );
            HashMap<Curso, Integer> scores = sistema.reconmedarConScore(est);

            List<Map.Entry<Curso, Integer>> lista = new ArrayList<>(scores.entrySet());
            lista.sort((a,b) -> b.getValue() - a.getValue());
            boolean hayRecomendaciones = false;
            for (Map.Entry<Curso, Integer> entry : lista) {
                if (entry.getValue() > 0) {
                    System.out.println("-" + entry.getKey().getNombre()+ " (score:"+ entry.getValue() + ")");
                    hayRecomendaciones = true;
                }
            }
            if (!hayRecomendaciones) {
                System.out.println("No hay cursos que coincidan con sus intereses.");
            }
         }
    }
}