import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String apellido;
    private ArrayList<Libro> librosPrestados;

    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }

    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados por " +nombre+ " " +apellido+ " : ");
        if (librosPrestados.isEmpty()) {
            System.out.println("No tiene libros prestados.");
        } else {
            for (Libro libro : librosPrestados) {
                libro.obtenerInformacion();
            }
        }
    }
}
