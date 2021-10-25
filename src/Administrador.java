public class Administrador extends Empleado {
    private double porcentajeCompensacion;

    public Administrador(String nombre, double numHorasTrabajadas) {
        super(nombre, numHorasTrabajadas);
        if(super.getNumHorasTrabajadas() >= 80){
            this.porcentajeCompensacion = .3;
        } else{
            this.porcentajeCompensacion = .2;
        }
    }

    public double getporcentajeCompensacion(double porcentajeCompensacion){
        return this.porcentajeCompensacion;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPorcentaje " + this.porcentajeCompensacion;
    }
 
    public double calcularSalario(int numHorasTrabajadas, double tarifa) {
        return super.calcularSalario(numHorasTrabajadas, tarifa * (1 + this.porcentajeCompensacion));
    }

}
