import java.util.Scanner;

class CalculadoraGeometria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] hist_f = new String[20];
        double[] hist_a = new double[20];
        double[] hist_p = new double[20];
        int hist_idx = 0;
        
        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        while(true) {
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int x = sc.nextInt();

            if (x == 5) {
                System.out.println("Historial de Calculos");
                double total_a = 0;
                for (int i = 0; i < hist_idx; i++) {
                    System.out.println((i+1) + ". " + hist_f[i] + " -> Area: " + hist_a[i] + ", Perimetro/Volumen: " + hist_p[i]);
                    total_a += hist_a[i];
                }
                System.out.println("Area total acumulada: " + total_a);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            double y = 0;
            double z = 0;
            boolean f = false;

            if (x == 1) {
                System.out.print("Radio: ");
                y = sc.nextDouble();
                if (y > 0) {
                    z = 3.14159 * y * y;
                    double p = 2 * 3.14159 * y;
                    System.out.println("Area: " + z);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(hist_idx < 20) {
                        hist_f[hist_idx] = "Circulo";
                        hist_a[hist_idx] = z;
                        hist_p[hist_idx] = p;
                        hist_idx++;
                    }
                } else {
                    System.out.println("Radio invalido");
                }
            } else if (x == 2) {
                System.out.print("Base: ");
                y = sc.nextDouble();
                System.out.print("Altura: ");
                z = sc.nextDouble();
                if (y > 0 && z > 0) {
                    double a = y * z;
                    double p = 2 * (y + z);
                    System.out.println("Area: " + a);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(hist_idx < 20) {
                        hist_f[hist_idx] = "Rectangulo";
                        hist_a[hist_idx] = a;
                        hist_p[hist_idx] = p;
                        hist_idx++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else if (x == 3) {
                System.out.print("Lado 1: ");
                y = sc.nextDouble();
                System.out.print("Lado 2: ");
                z = sc.nextDouble();
                System.out.print("Lado 3: ");
                double w = sc.nextDouble();
                if (y > 0 && z > 0 && w > 0 && (y + z > w && y + w > z && z + w > y)) {
                    double s = (y + z + w) / 2;
                    double a = Math.sqrt(s * (s - y) * (s - z) * (s - w));
                    double p = y + z + w;
                    System.out.println("Area: " + a);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(hist_idx < 20) {
                        hist_f[hist_idx] = "Triangulo";
                        hist_a[hist_idx] = a;
                        hist_p[hist_idx] = p;
                        hist_idx++;
                    }
                } else {
                    System.out.println("Lados invalidos o no forman un triangulo");
                }
            } else if (x == 4) {
                System.out.print("Radio: ");
                y = sc.nextDouble();
                System.out.print("Altura: ");
                z = sc.nextDouble();
                if (y > 0 && z > 0) {
                    double area_base = 3.14159 * y * y;
                    double area_lateral = 2 * 3.14159 * y * z;
                    double area_total = 2 * area_base + area_lateral;
                    double vol = area_base * z;
                    System.out.println("Area Superficial: " + area_total);
                    System.out.println("Volumen: " + vol);
                    f = true;
                    if(hist_idx < 20) {
                        hist_f[hist_idx] = "Cilindro";
                        hist_a[hist_idx] = area_total;
                        hist_p[hist_idx] = vol;
                        hist_idx++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else {
                System.out.println("Opcion no valida");
            }

            if (f) {
                System.out.println("Calculo completado.");
            }
        }
        sc.close();
    }
}
