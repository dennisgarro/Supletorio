import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        LinkedList<ObjPizza> lista = new LinkedList<>();
        ObjPizza obj = new ObjPizza();
        while (continuar) {
            int opt = 0;
            System.out.println("ingrese la opcion requerida");
            System.out.println("1: llenar registro");
            System.out.println("2: mostrar registros");
            System.out.println("3: buscar registro");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    lista = obj.LLenarRegistro(lista);
                    break;
                case 2:
                    obj.Mostrar(lista, 1, null);
                    break;
                case 3:
                    ObjPizza objResult = new ObjPizza();
                    String tipo = "";
                    System.out.println("ingrese el registro que desea buscar");
                    tipo = sc.next();objResult
                     = obj.Buscarregistro(tipo, lista);
                    obj.Mostrar(null, 2, objResult);
                    break;

                default:
                    continuar = false;
                    break;
            }
        }
    }
}
