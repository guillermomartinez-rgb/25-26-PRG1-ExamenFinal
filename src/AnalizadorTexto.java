import java.util.Scanner;

class AnalizadorTexto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Analizador de Texto - Herramienta Linguistica v2.0");
        System.out.println("Introduce un texto (mínimo 10 caracteres):");
        String texto = sc.nextLine();

        if (texto.length() < 10) {
            System.out.println("El texto es demasiado corto");
            return;
        }

        int vocales = 0;
        int consonantes = 0;
        int numeros = 0;
        int espacios = 0;
        int otros = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    vocales++;
                } else {
                    consonantes++;
                }
            } else if (c >= '0' && c <= '9') {
                numeros++;
            } else if (c == ' ') {
                espacios++;
            } else {
                otros++;
            }
        }

        System.out.println("ESTADÍSTICAS BÁSICAS");
        System.out.println("Longitud: " + texto.length());
        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);
        System.out.println("Números: " + numeros);
        System.out.println("Espacios: " + espacios);
        System.out.println("Otros: " + otros);

        if (vocales > consonantes && consonantes > 0 && texto.length() > 20 && espacios >= 2 && numeros == 0) {
            System.out.println("Categoría: Texto literario con alta densidad vocálica");
        } else if (consonantes > vocales && vocales > 0 && texto.length() > 15 && (otros >= 3 || numeros >= 2) && espacios >= 1) {
            System.out.println("Categoría: Texto técnico o científico");
        } else if (numeros > 5 && (vocales + consonantes) < texto.length() / 2 && espacios < texto.length() / 10 && otros >= 2) {
            System.out.println("Categoría: Código o expresión matemática");
        } else if (espacios > texto.length() / 5 && vocales > 0 && consonantes > 0 && numeros < 3 && otros < vocales / 2) {
            System.out.println("Categoría: Texto informal o conversacional");
        } else {
            System.out.println("Categoría: Texto genérico");
        }

        int palabras = 1;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ' && i < texto.length() - 1 && texto.charAt(i + 1) != ' ') {
                palabras++;
            }
        }
        System.out.println("Palabras estimadas: " + palabras);

        double densidadVocales = (vocales * 100.0) / texto.length();
        if (densidadVocales > 45 && vocales > 10 && consonantes > 5 && espacios > 2) {
            System.out.println("¡Texto muy fluido!");
        } else if (densidadVocales < 25 && consonantes > 10 && (otros > 5 || numeros > 3)) {
            System.out.println("Texto complejo de leer");
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                tieneMayuscula = true;
            }
            if (c >= 'a' && c <= 'z') {
                tieneMinuscula = true;
            }
        }

        if (tieneMayuscula && tieneMinuscula && texto.charAt(0) >= 'A' && texto.charAt(0) <= 'Z' && (texto.charAt(texto.length() - 1) == '.' || texto.charAt(texto.length() - 1) == '!' || texto.charAt(texto.length() - 1) == '?') && espacios > 0) {
            System.out.println("Formato: Oración bien formada");
        } else if (tieneMayuscula && !tieneMinuscula && numeros >= 2 && espacios < texto.length() / 10) {
            System.out.println("Formato: Código o identificador");
        } else {
            System.out.println("Formato: Variado");
        }
    }
}
