import java.util.Scanner;

public class CalculadoraTrigronometrica {
  
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;

    System.out.println("=== CALCULADORA TRIGONOMÉTRICA INVERSA ===");
    System.out.println("Operaciones Disponibles:");
    System.out.println("1. arcsin(a) = Arco seno");
    System.out.println("2. arccos(a = Arco coseno)");
    System.out.println("3. arctan(a) = Arco tangente");
    System.out.println("4. Salir");
    System.out.println();

    while (continuar) {
      System.out.print("Seleccione la opción a solicitar(1-4):");
      int opcion = scanner.nextInt();

      swicht(opcion) {
        case 1:
          calcularArcSeno(scanner);
          break;

        case 2:
          calcularArcCoseno(scanner);
          break;

        case 3:
          calcularArcTangente(scanner);
          break;

        case 4: 
          continuar = False;
          System.out.println("Adios, hasta luego");
          break;
        default:
          System.out.println("Opcion inválida. Selecciona una opcion del 1 al 4");
      }

      if (continuar) {
          System.out.println();
      }
   }  

    scanner.close();
}

private static void calcularArcSeno(Scanner scanner) {
  System.out.print("Ingresa el valor de α para arcsin(α): ");
  double alpha = scanner.nextDouble();

  //Dominio
  if (alpha < -1 || alpha > 1) {
    System.out.println("Error: El valor debe estar entre -1 y 1 para arcsin(α)")
    return;
  }

  double resultado = Math.asin(alpha);
  double resultadoGrados = Math.toDegrees(resultado);

  System.out.printf("arcsin(%.4f) = %.4f radianes\n", alpha, resultado);
  System.out.printf("arcsin(%.4f) = %.4f grados\n", alpha, resultadoGrados);
}

 private static void calcularArcCoseno(Scanner scanner) {
        System.out.print("Ingresa el valor de α para arccos(α): ");
        double alpha = scanner.nextDouble();
        
        // Verificar que el valor esté en el dominio [-1, 1]
        if (alpha < -1 || alpha > 1) {
            System.out.println("Error: El valor debe estar entre -1 y 1 para arccos(α)");
            return;
        }
        
        double resultado = Math.acos(alpha);
        double resultadoGrados = Math.toDegrees(resultado);
        
        System.out.printf("arccos(%.4f) = %.4f radianes\n", alpha, resultado);
        System.out.printf("arccos(%.4f) = %.4f grados\n", alpha, resultadoGrados);
    }
    
    private static void calcularArcTangente(Scanner scanner) {
        System.out.print("Ingresa el valor de α para arctan(α): ");
        double alpha = scanner.nextDouble();
        
        // arctan acepta cualquier valor real
        double resultado = Math.atan(alpha);
        double resultadoGrados = Math.toDegrees(resultado);
        
        System.out.printf("arctan(%.4f) = %.4f radianes\n", alpha, resultado);
        System.out.printf("arctan(%.4f) = %.4f grados\n", alpha, resultadoGrados);
    }
}
