import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Revista extends ItemBiblioteca implements Catalogable{
    private int nroEdicion;
    private int cantidadEjemplares;
    private String nombreRevista;
    private LocalDate fechaPrestamo;

    public Revista() {

    }

    public Revista(int nroEdicion, int cantidadEjemplares, String nombreRevista, LocalDate fechaPrestamo) {
        this.nroEdicion = nroEdicion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.nombreRevista = nombreRevista;
        this.fechaPrestamo = null;
    }

    public int getNroEdicion() {
        return nroEdicion;
    }

    public void setNroEdicion(int nroEdicion) {
        this.nroEdicion = nroEdicion;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public LocalDate getDiasAtraso() {
        return fechaPrestamo;
    }

    @Override
    public void prestar() {
        if (cantidadEjemplares > 0 ) {
            cantidadEjemplares--;
            fechaPrestamo = LocalDate.now();
            System.out.println("Revista prestada. Ejemplares restantes: " +cantidadEjemplares);
        } else {
            System.out.println("No hay mas ejemplares disponibles para prestar.");
        }
    }

    @Override
    public void devolver() {
        cantidadEjemplares++;
        System.out.println("Revista devuelta. Ejemplares ahora disponibles: " +cantidadEjemplares);
    }

    @Override
    public double calcularMultas(int diasAtraso) {
        if (fechaPrestamo == null) {
            System.out.println("No se ha registrado un prestamo para esta revista.");
            return 0;
        }

        double multaPorDia = 1.0;
        LocalDate DiaDevolucion = LocalDate.now();
        long diasPrestamo = ChronoUnit.DAYS.between(fechaPrestamo,DiaDevolucion);

        double multaTotal = (diasPrestamo - diasAtraso) * multaPorDia;

        return multaTotal > 0 ? multaTotal:0;
    }

    public int diasAtraso() {
        return cantidadEjemplares;
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Nombre de la Revista: " +nombreRevista);
        System.out.println("Numero de Edicion: " +nroEdicion);
        System.out.println("Cantidad de Ejemplares: " +cantidadEjemplares);
        System.out.println("Fecha de prestamo: " +(fechaPrestamo != null ? fechaPrestamo : "No prestada"));
    }


}
