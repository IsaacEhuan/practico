import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    static ArrayList<Empleado> empleado =  new ArrayList<Empleado>();
    static Scanner entrada = new Scanner(System.in);
    static int numHrsJor = 0;
    static int numHrsAdmin = 0;
    static int numHrsTotales = 0;
    static double nomTotal = 0;
    static double nomJor = 0;
    static double nomAdmin =0;

    public static void main(String[] args) throws Exception {
        llenarEmpleados();
        mostrarResultado();

    }

    public static void llenarEmpleados(){
        char respuesta;
        int opcion,contadorJor = 0 ,ContadorAdmin = 0;
        do{
            do{
                System.out.print("\nDigite el tipo de empleado \n1 : Administrador \n2 : Jornalero\n");
                opcion = entrada.nextInt();
            }while(opcion < 1 || opcion > 2);
            switch(opcion){
                case 1:
                    llenarAdministrador();
                    ContadorAdmin = ContadorAdmin +1;
                    break;
                case 2:
                    llenarJornalero();
                    contadorJor = contadorJor +1;
                    break;
            }
            System.out.print("\n¿Desea introducir otro empleado? (s/n)");
            respuesta = entrada.next().charAt(0);
        }while(respuesta == 's' || respuesta == 'S');
        System.out.println("Número de Administradores: ");
        System.out.println(ContadorAdmin);
        System.out.println("Número de jornaleros: ");
        System.out.println(contadorJor);
    }

    public static void llenarJornalero(){
        String nombre, a;
        double numHorasTrabajadas, numHorasExtra;
        a = entrada.nextLine();
        System.out.print("\nIntroduzca el nombre del empleado: ");
        nombre = entrada.nextLine();
        System.out.print("\nIntroduzca el número de horas trabajadas a la quincena: ");
        numHorasTrabajadas = entrada.nextDouble();
        System.out.print("\nIntroduzca el número de horas extra: ");
        numHorasExtra = entrada.nextDouble();
        
        numHrsJor = numHrsJor + (int) (numHorasExtra + numHorasTrabajadas);
        Jornalero jornalero = new Jornalero(nombre, numHorasTrabajadas, numHorasExtra);
        jornalero.calcularSalario((int)numHorasTrabajadas, 15);
        nomJor = nomJor + jornalero.calcularSalario((int)numHorasTrabajadas, 15);

        empleado.add(jornalero);
    }

    public static void llenarAdministrador(){
        String nombre, a;
        double numHorasTrabajadas;
        a = entrada.nextLine();
        System.out.print("\nIntroduzca el nombre del empleado: ");
        nombre = entrada.nextLine();
        System.out.print("\nIntroduzca el número de horas trabajadas: ");
        numHorasTrabajadas = entrada.nextDouble();

        numHrsAdmin = numHrsAdmin + (int)(numHorasTrabajadas);
        Administrador aministrador = new Administrador(nombre, numHorasTrabajadas);
        aministrador.calcularSalario((int)numHorasTrabajadas, 15);
        nomAdmin = nomAdmin + aministrador.calcularSalario((int)numHorasTrabajadas, 15);

        empleado.add(aministrador);
    }

    public static void mostrarResultado(){
        System.out.println("LISTA DE EMPLEADOS");
        for(Empleado empl : empleado){
            System.out.println("-------------------------------------------");
            System.out.println(empl.toString());
            System.out.println("-------------------------------------------");
        }
        nomTotal = nomAdmin + nomJor;
        numHrsTotales = numHrsAdmin + numHrsJor;
        System.out.println("\nNómina total de la quincena: ");
        System.out.println(nomTotal);
        System.out.println("\nNómina total de los administradores: ");
        System.out.println(nomAdmin);
        System.out.println("\nNómina total de los jornaleros: ");
        System.out.println(nomJor);
        System.out.println("Número de horas de todos los empleados: ");
        System.out.println(numHrsTotales);
        System.out.println("Número de horas de los Administradores: ");
        System.out.println(numHrsAdmin);
        System.out.println("Número de horas de los Jornaleros: ");
        System.out.println(numHrsJor);


    }
}