import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Libro extends ItemBiblioteca implements Catalogable{
    private String titulo;
    private String autor;
    private int numeroDePaginas;

    private LocalDate fechaPrestamo;
    private boolean prestado;

    public Libro() {
    }

    public Libro(String titulo, String autor, int numeroDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
        this.fechaPrestamo = null;
        this.prestado = false;
    }

    public  String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    @Override
    public void prestar() {
        if (prestado == false) {
            fechaPrestamo = LocalDate.now();
            prestado = true;
            System.out.println("Libro prestado.");
        } else {
            System.out.println("No hay mas ejemplares disponibles para prestar.");
        }
    }

    @Override
    public void devolver() {
        if (prestado == true) {
            fechaPrestamo = null;
            prestado = false;
            System.out.println("Libro devuelto.");
        } else {
            System.out.println("El libro no esta prestado.");
        }
    }
    @Override
    public double calcularMultas(int diasAtraso) {
        if (fechaPrestamo == null) {
            System.out.println("No se ha registrado un prestamo para este libro.");
            return 0;
        }
        double multaporDia = 2.0;
        LocalDate DiaDevolucion = LocalDate.now();
        long diasPrestamo = ChronoUnit.DAYS.between(fechaPrestamo,DiaDevolucion);

        double multaTotal = (diasPrestamo - diasAtraso) * multaporDia;

        return multaTotal > 0 ? multaTotal : 0;
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Titulo del libro: " +titulo);
        System.out.println("Autor del Libro: " +autor);
        System.out.println("Cantidad de Paginas: " +numeroDePaginas);
        System.out.println("Fue Prestado: " +(prestado == true ? "Si fue prestado" : "No fue prestado"));
        System.out.println("Fecha de Prestamo: " +(fechaPrestamo !=null ? fechaPrestamo : "No prestada"));
    }
}
