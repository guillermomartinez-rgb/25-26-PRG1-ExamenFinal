import java.util.Scanner;

public class CalculadoraDescuentos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora de Descuentos - Tienda Online");

       boolean salir = false;
while (!salir)
 {
            System.out.println("[1] Realizar Nueva Compra");
            System.out.println("[2] Salir");
            System.out.print("Opcion: ");
            int menuOpt = sc.nextInt();
            sc.nextLine(); 

            if (menuOpt == 2) {
                System.out.println("Saliendo del sistema.");
                break;
            }
            if (menuOpt != 1) {
                System.out.println("Opcion no valida.");
                continue;
            }
            
            // Carrito de compra y precios
            String[] nombres_p = new String[10];
            double[] precios_p = new double[10];
            int[] cants_p = new int[10];
            int n_prods = 0;

            System.out.println("Carrito de Compra");
            while (n_prods < 10) {
                System.out.print("Nombre del producto (o 'fin' para terminar): ");
                String nombre = sc.nextLine();

                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }

                nombres_p[n_prods] = nombre;

                double precio;
                do {
                    System.out.print("Precio de '" + nombre + "': ");
                    precio = sc.nextDouble();
                } while (precio <= 0);
                precios_p[n_prods] = precio;

                int cantidad;
                do {
                    System.out.print("Cantidad de '" + nombre + "': ");
                    cantidad = sc.nextInt();
                } while (cantidad <= 0);
                cants_p[n_prods] = cantidad;

                sc.nextLine();
                n_prods++;
            }

            // Calcular total del carrito
            double p_total = 0;
            int c_total = 0;
            for(int i=0; i < n_prods; i++) {
                p_total += precios_p[i] * cants_p[i];
                c_total += cants_p[i];
            }

            int t;
            do {
                System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
                t = sc.nextInt();
            } while (t < 1 || t > 4);

            int rebajasOpt;
            do {
                System.out.print("Es temporada de rebajas? (1: Si / 2: No): ");
                rebajasOpt = sc.nextInt();
            } while (rebajasOpt != 1 && rebajasOpt != 2);

            boolean esRebajas = (rebajasOpt == 1);

            double descuento = 0;

            if (t == 1) {
                if (esRebajas) descuento += 0.10;
                if (c_total >= 5) descuento += 0.05;
            } else if (t == 2) {
                descuento += 0.15;
                if (esRebajas) descuento += 0.10;
                if (c_total >= 3) descuento += 0.08;
            } else if (t == 3) {
                descuento += 0.20;
                if (esRebajas) descuento += 0.15;
                if (c_total >= 2) descuento += 0.10;
            } else if (t == 4) {
                descuento += 0.30;
                if (esRebajas) descuento += 0.20;
                if (c_total >= 1) descuento += 0.15;
            }

            double pf = p_total * (1 - descuento);

            if (pf > 500) {
                pf -= 50;
            }

            if (pf < 0) {
                pf = 0;
            }
            System.out.println("Resumen de Compra");
            System.out.println("Precio original total: " + p_total + " euros");
            System.out.println("Numero total de productos: " + c_total);
            System.out.println("Precio final con descuento: " + pf + " euros");
            System.out.println("Ahorro total: " + (p_total - pf) + " euros");
            if (p_total > 0) {
                double porcentaje = ((p_total - pf) / p_total) * 100;
                System.out.println("Porcentaje de ahorro: " + porcentaje + "%");
            }
        }
        sc.close();
    }
}
