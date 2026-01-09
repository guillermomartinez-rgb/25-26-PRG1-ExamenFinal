import java.util.Scanner;

class RegistroEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[5];
        double[] notas = new double[5];
        int[] edades = new int[5];
        String[] cursos = new String[5];
        int numEstudiantes = 0;

        System.out.println("Sistema de Gestion Academica - Registro de Estudiantes");

        while (true) {
            System.out.println("1. Anadir estudiante");
            System.out.println("2. Ver estudiantes");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Calcular estadisticas");
            System.out.println("5. Modificar nota");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            if (opcion == 1) {
                if (numEstudiantes < 5) {
                    System.out.print("Nombre: ");
                    nombres[numEstudiantes] = sc.nextLine();
                    System.out.print("Edad: ");
                    edades[numEstudiantes] = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Curso: ");
                    cursos[numEstudiantes] = sc.nextLine();
                    System.out.print("Nota (0-10): ");
                    notas[numEstudiantes] = sc.nextDouble();
                    sc.nextLine(); 
                    numEstudiantes++;
                    System.out.println("Estudiante anadido correctamente.");
                } else {
                    System.out.println("No se pueden anadir mas estudiantes.");
                }
            } else if (opcion == 2) {
                System.out.println("LISTA DE ESTUDIANTES");
                if (numEstudiantes == 0) {
                    System.out.println("(No hay estudiantes registrados)");
                } else {
                    for (int i = 0; i < numEstudiantes; i++) {
                        System.out.println((i + 1) + ". " + nombres[i] +
                                         " | Edad: " + edades[i] +
                                         " | Curso: " + cursos[i] +
                                         " | Nota: " + notas[i] +
                                         " | Estado: " + (notas[i] >= 5 ? "APROBADO" : "SUSPENSO"));
                    }
                }
            } else if (opcion == 3) {
                System.out.print("Nombre a buscar: ");
                String buscar = sc.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < numEstudiantes; i++) {
                    if (nombres[i].equalsIgnoreCase(buscar)) {
                        System.out.println("Encontrado:");
                        System.out.println("Nombre: " + nombres[i] + ", Edad: " + edades[i] + ", Curso: " + cursos[i] + ", Nota: " + notas[i]);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Estudiante no encontrado.");
                }
            } else if (opcion == 4) {
                if (numEstudiantes > 0) {
                    double sumaNotas = 0;
                    int aprobadosCount = 0;
                    double notaMax = notas[0];
                    double notaMin = notas[0];
                    int edadTotal = 0;
                    for (int i = 0; i < numEstudiantes; i++) {
                        sumaNotas += notas[i];
                        if (notas[i] >= 5) {
                            aprobadosCount++;
                        }
                        if (notas[i] > notaMax) {
                            notaMax = notas[i];
                        }
                        if (notas[i] < notaMin) {
                            notaMin = notas[i];
                        }
                        edadTotal += edades[i];
                    }
                    System.out.println("ESTADISTICAS");
                    System.out.println("Nota media: " + (sumaNotas / numEstudiantes));
                    System.out.println("Nota maxima: " + notaMax);
                    System.out.println("Nota minima: " + notaMin);
                    System.out.println("Porcentaje de aprobados: " + ((aprobadosCount * 100.0) / numEstudiantes) + "%");
                    System.out.println("Edad media: " + ((double) edadTotal / numEstudiantes));
                } else {
                    System.out.println("No hay estudiantes para calcular estadisticas.");
                }
            } else if (opcion == 5) {
                System.out.print("Numero de estudiante a modificar (1-" + numEstudiantes + "): ");
                int num = sc.nextInt();
                if (num >= 1 && num <= numEstudiantes) {
                    System.out.print("Nueva nota (0-10): ");
                    double nuevaNota = sc.nextDouble();
                    notas[num - 1] = nuevaNota;
                    System.out.println("Nota actualizada.");
                } else {
                    System.out.println("Numero de estudiante invalido.");
                }
            } else if (opcion == 6) {
                System.out.println("Saliendo del sistema.");
                break;
            } else {
                System.out.println("Opcion no valida.");
            }
        }
        sc.close();
    }
}
