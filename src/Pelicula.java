import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pelicula extends ItemBiblioteca implements Catalogable{
    private String titulo;
    private String director;
    private String genero;
    private LocalDate fechaPrestamo;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaPrestamo = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    @Override
    public void prestar() {
        if (fechaPrestamo == null) {
            fechaPrestamo = LocalDate.now();
            System.out.println("Pelicula prestada el dia " +fechaPrestamo);
        } else {
            System.out.println("La prelicula ya esta prestada. ");
        }
    }

    @Override
    public void devolver() {
        if (fechaPrestamo != null) {
            fechaPrestamo = null;
            System.out.println("Pelicula devuelta.");
        } else {
            System.out.println("La pelicula no esta prestada.");
        }
    }

    @Override
    public double calcularMultas(int diasAtraso) {
        if (fechaPrestamo == null) {
            System.out.println("No se ha registrado un prestamo para esta pelicula.");
            return 0;
        }

        LocalDate fechaDevolucion = LocalDate.now();
        long diasPrestamo = ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);

        double multaPorDia = 4.5;
        double multaTotal = (diasPrestamo - diasAtraso) * multaPorDia;

        return multaTotal > 0 ? multaTotal : 0;
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Titulo de la Pelicula: " +titulo);
        System.out.println("Director: " +director);
        System.out.println("Genero: " +genero);
        System.out.println("Fecha de prestamo: " +(fechaPrestamo != null ? fechaPrestamo : "No prestada." ));
    }
}
