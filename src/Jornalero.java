public class Jornalero extends Empleado {

    private double numHorasExtra;

    public Jornalero(String nombre, double numHorasTrabajadas, double numHorasExtra) {
        super(nombre, numHorasTrabajadas);
        this.numHorasExtra = numHorasExtra;
    }

    public double getnumHorasExtra(double numHorasExtra){
        return this.numHorasExtra;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNúmero de horas extra " + this.numHorasExtra;
    }
 
    public double calcularSalario(int numHorasTrabajadas, double tarifa) {
        return super.calcularSalario(numHorasTrabajadas + ((int)this.numHorasExtra * 2), tarifa);
    }
    
}
