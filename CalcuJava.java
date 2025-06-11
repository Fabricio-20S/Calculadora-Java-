import java.util.InputMismatchException; 
import java.util.Scanner;

public class CalculadoraTrigronometrica { 
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal; 
        boolean continuarPrincipal = true;

        do {
            mostrarMenuPrincipal(); 
            try {
                opcionPrincipal = scanner.nextInt();

                switch (opcionPrincipal) {
                    case 1:
                        ejecutarOperacionesDirectas(scanner); 
                        break;
                    case 2:
                        ejecutarOperacionesInversas(scanner);
                        break;
                    case 3:
                        continuarPrincipal = false;
                        System.out.println("Saliendo de la calculadora. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Selecciona una opción del 1 al 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.next(); 
                opcionPrincipal = 0; 
            }
            System.out.println(); 
        } while (continuarPrincipal);

        scanner.close();
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("=== CALCULADORA TRIGONOMÉTRICA ===");
        System.out.println("1. Operaciones Trigonométricas Directas (sen, cos, tan)");
        System.out.println("2. Operaciones Trigonométricas Inversas (arcsin, arccos, arctan)");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void ejecutarOperacionesDirectas(Scanner scanner) {
        int opcionDirecta;
        boolean continuarDirectas = true;

        while (continuarDirectas) {
            System.out.println("\n--- Operaciones Trigonométricas Directas ---");
            System.out.println("1. Calcular Seno");
            System.out.println("2. Calcular Coseno");
            System.out.println("3. Calcular Tangente");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcionDirecta = scanner.nextInt();
                switch (opcionDirecta) {
                    case 1:
                        calcularSeno(scanner);
                        break;
                    case 2:
                        calcularCoseno(scanner);
                        break;
                    case 3:
                        calcularTangente(scanner);
                        break;
                    case 4:
                        continuarDirectas = false;
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); 
                opcionDirecta = 0; 
            }
            System.out.println();
        }
    }

    public static void ejecutarOperacionesInversas(Scanner scanner) {
        int opcionInversa;
        boolean continuarInversas = true;

        System.out.println("\n=== CALCULADORA TRIGONOMÉTRICA INVERSA ===");
        System.out.println("Operaciones Disponibles:");
        System.out.println("1. arcsin(a) = Arco seno");
        System.out.println("2. arccos(a) = Arco coseno");
        System.out.println("3. arctan(a) = Arco tangente");
        System.out.println("4. Volver al menú principal");
        System.out.println();

        while (continuarInversas) {
            System.out.print("Seleccione la opción a solicitar (1-4):");
            try {
                opcionInversa = scanner.nextInt();

                switch(opcionInversa) { 
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
                        continuarInversas = false; 
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción inválida. Selecciona una opción del 1 al 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.next(); 
                opcionInversa = 0; 
            }

            if (continuarInversas) {
                System.out.println();
            }
        }
    }

    public static void calcularSeno(Scanner scanner) {
        System.out.print("Ingrese el ángulo en grados para el seno: ");
        try {
            double anguloGrados = scanner.nextDouble();
            double anguloRadianes = Math.toRadians(anguloGrados); 
            double resultado = Math.sin(anguloRadianes);
            System.out.printf("El seno de %.2f grados es: %.4f%n", anguloGrados, resultado);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número para el ángulo.");
            scanner.next(); 
        }
    }

    public static void calcularCoseno(Scanner scanner) {
        System.out.print("Ingrese el ángulo en grados para el coseno: ");
        try {
            double anguloGrados = scanner.nextDouble();
            double anguloRadianes = Math.toRadians(anguloGrados); 
            double resultado = Math.cos(anguloRadianes);
            System.out.printf("El coseno de %.2f grados es: %.4f%n", anguloGrados, resultado);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número para el ángulo.");
            scanner.next(); 
        }
    }

    public static void calcularTangente(Scanner scanner) {
        System.out.print("Ingrese el ángulo en grados para la tangente: ");
        try {
            double anguloGrados = scanner.nextDouble();
            double anguloNormalizado = anguloGrados % 360;
            if (anguloNormalizado < 0) {
                anguloNormalizado += 360;
            }

            if (Math.abs(anguloNormalizado - 90) < 0.0001 || Math.abs(anguloNormalizado - 270) < 0.0001) {
                System.out.println("La tangente de " + anguloGrados + " grados es indefinida.");
            } else {
                double anguloRadianes = Math.toRadians(anguloGrados);
                double resultado = Math.tan(anguloRadianes);
                System.out.printf("La tangente de %.2f grados es: %.4f%n", anguloGrados, resultado);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número para el ángulo.");
            scanner.next(); 
        }
    }


    private static void calcularArcSeno(Scanner scanner) {
        System.out.print("Ingresa el valor de α para arcsin(α): ");
        double alpha = scanner.nextDouble();

        if (alpha < -1 || alpha > 1) {
            System.out.println("Error: El valor debe estar entre -1 y 1 para arcsin(α)"); 
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

        double resultado = Math.atan(alpha);
        double resultadoGrados = Math.toDegrees(resultado);

        System.out.printf("arctan(%.4f) = %.4f radianes\n", alpha, resultado);
        System.out.printf("arctan(%.4f) = %.4f grados\n", alpha, resultadoGrados);
    }
}
