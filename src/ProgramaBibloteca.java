import java.util.Scanner;

public class ProgramaBibloteca {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibro(new Libro("Crepusculo", "autor", 200));
        biblioteca.agregarLibro(new Libro("El Caballero Carmelo", "Abraham Valdelomar.", 200));

        Persona persona1 = new Persona("Juan", "Sanchez");
        biblioteca.registrarPersona(persona1);

        Persona persona2 = new Persona("Gabriela", "Milla");
        biblioteca.registrarPersona(persona2);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n- - - MENU BIBLIOTECA - - -");
            System.out.println("1. Mostrar catalogo de libros");
            System.out.println("2. Mostrar personas registradas");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> biblioteca.mostrarCatalogo();
                case 2 -> biblioteca.mostrarPersonas();
                case 3 -> {
                    System.out.println("Ingrese el nombre de la persona: ");
                    String nombrePersona = scanner.nextLine();
                    System.out.println("Ingrese el titulo del libro a prestar: ");
                    String tituloLIBROPrestar = scanner.nextLine();
                    Persona personaPrestamo = buscarPersona(biblioteca, nombrePersona);
                    if (personaPrestamo != null) {
                        biblioteca.prestarLibro(personaPrestamo, tituloLIBROPrestar);
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el nombre de la persona: ");
                    String nombrePersonaDevolver = scanner.nextLine();
                    System.out.println("Ingrese el titulo del libro a devolver: ");
                    String tituloLibroDevolver = scanner.nextLine();
                    Persona personaDevolucion = buscarPersona(biblioteca, nombrePersonaDevolver);
                    if (personaDevolucion != null) {
                        biblioteca.devolverLibro(personaDevolucion, tituloLibroDevolver);
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                }
                case 5 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }
        }
        scanner.close();
    }
    private static Persona buscarPersona(Biblioteca biblioteca, String nombre) {
        for (Persona persona : biblioteca.getPersonas()) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null;
    }
}
