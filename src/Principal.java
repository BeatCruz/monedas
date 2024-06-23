import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion=0;
        String menu = """
                ****************************
                1 - Dólar => Peso argentino
                2 - Peso argentino => Dólar
                3 - Dólar => Real brasileño
                4 - Real brasileño => Dólar
                5 - Dólar => Peso colombiano
                6 - Peso colombiano => Dólar
                7 - Salir
                Elija una opción válida:
                ****************************
                """;
        Scanner lectura = new Scanner(System.in);
        int next;
        while (opcion != 7){
            System.out.println(menu);
            opcion = lectura.nextInt();

            switch(opcion){
                case 1:
                    convertir("USD", "ARS", lectura);
                    System.out.println("¿Desea realizar otra operación? ");
                    System.out.println("1.Sí 2.No");
                    next = lectura.nextInt();
                    if(next == 1){
                        break;
                    }else{
                        opcion = 7;
                        break;
                    }
                case 2:
                    convertir("ARS", "USD", lectura);
                    System.out.println("¿Desea realizar otra operación? ");
                    System.out.println("1.Sí 2.No");
                    next = lectura.nextInt();
                    if(next == 1){
                        break;
                    }else{
                        opcion = 7;
                        break;
                    }
                case 3:
                    convertir("USD", "BRL", lectura);
                    System.out.println("¿Desea realizar otra operación? ");
                    System.out.println("1.Sí 2.No");
                    next = lectura.nextInt();
                    if(next == 1){
                        break;
                    }else{
                        opcion = 7;
                        break;
                    }
                case 4:
                    convertir("BRL", "USD", lectura);
                    System.out.println("¿Desea realizar otra operación? ");
                    System.out.println("1.Sí 2.No");
                    next = lectura.nextInt();
                    if(next == 1){
                        break;
                    }else{
                        opcion = 7;
                        break;
                    }
                case 5:
                    convertir("USD", "COP", lectura);
                    System.out.println("¿Desea realizar otra operación? ");
                    System.out.println("1.Sí 2.No");
                    next = lectura.nextInt();
                    if(next == 1){
                        break;
                    }else{
                        opcion = 7;
                        break;
                    }
                case 6:
                    convertir("COP", "USD", lectura);
                    System.out.println("¿Desea realizar otra operación? ");
                    System.out.println("1.Sí 2.No");
                    next = lectura.nextInt();
                    if(next == 1){
                        break;
                    }else{
                        opcion = 7;
                        break;
                    }
                case 7:
                    System.out.println("Hasta pronto!!");
                    break;
                default:
                    System.out.println("Elegir una opción del menú");

            }
        }
    }

    private static void convertir(String baseCode, String targetCode, Scanner lectura) {
        System.out.println("Ingrese el monto: ");
        double cantidad = lectura.nextDouble();
        MonedaConvertir mconvertir = new MonedaConvertir(baseCode, targetCode, cantidad);
        try{
            double resultado = mconvertir.convert();
            System.out.println(cantidad + " "+ baseCode+" = "+resultado+" "+targetCode);
            System.out.println("La conversión fue exitosa");

        }catch (IOException | InterruptedException e){
            System.out.println("Error al convertir: "+e.getMessage());
        }

    }
}
