import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ObjPizza {
    String tipoPizza;
    String Tamano;
    Double Precio;
    int porciones;
    Scanner sc = new Scanner(System.in);

    public String getTipoPizza() {
        return tipoPizza;
    }

    public void setTipoPizza(String tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String tamano) {
        Tamano = tamano;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public LinkedList<ObjPizza> LLenarRegistro(LinkedList<ObjPizza> lista) {
        boolean continuar = true;

        int opt = 0;
        while (continuar) {
            ObjPizza obj = new ObjPizza();
            System.out.println("ingrese el tipo pizza");
            obj.setTipoPizza(sc.next());
            System.out.println("ingrese el tamaño");
            obj.setTamano(sc.next());
            System.out.println("Ingrese el precio");
            obj.setPrecio(sc.nextDouble());            
            obj.setPorciones(obj.llenarPorciones());
            lista.add(obj);
            System.out.println("desea continuar 1:Si, 2: no");
            while (!sc.hasNextInt()) {
                System.out.println("por favor ingreser un numero");
                sc.next();
            }
            opt = sc.nextInt();
            if (opt == 2) {
                continuar = false;
            }
        }
        return lista;
    }

    public void Mostrar(LinkedList<ObjPizza> lista, int opcion, ObjPizza objeto) {
        if (opcion == 1) {
            for (ObjPizza obj : lista) {
                String mensaje = " el tipo Pizza es: " + obj.getTipoPizza() + "\n" +
                        "el Tamano es: " + obj.getTamano() + "\n" +
                        "el Precio es: " + obj.getPrecio() + "\n" +
                        "las porciones son: " + obj.getPorciones() + "\n";
                // System.out.println(" el tipo Pizza es: " + obj.getTipoPizza());
                // System.out.println(" el Tamano es: " + obj.getTamano());
                // System.out.println(" el Precio es: " + obj.getPrecio() );
                // System.out.println(" las porciones son: " + obj.getPorciones() + "\n");
                JOptionPane.showMessageDialog(null, mensaje, "mensaje", 1);
            }
        } else {
            String mensaje = " el tipo Pizza es: " + objeto.getTipoPizza() + "\n" +
                    "el Tamano es: " + objeto.getTamano() + "\n" +
                    "el Precio es: " + objeto.getPrecio() + "\n" +
                    "las porciones son: " + objeto.getPorciones() + "\n";
            JOptionPane.showMessageDialog(null, mensaje, "mensaje", 1);
        }

    }

    public ObjPizza Buscarregistro(String tipo, LinkedList<ObjPizza> lista) {
        ObjPizza objResult = new ObjPizza();
        for (ObjPizza obj : lista) {
            if (obj.getTipoPizza().equalsIgnoreCase(tipo)) {
                objResult.setTipoPizza(tipo);
                objResult.setTamano(obj.getTamano());
                objResult.setPrecio(obj.getPrecio());
                objResult.setPorciones(obj.getPorciones());
            }

        }
        return objResult;
    }

    public int llenarPorciones() {
        int opt = 0, cantidad = 0;
        System.out.println("seleccione el tamaño");
        System.out.println("1:personal");
        System.out.println("2:mediana");
        System.out.println("3:grande");
        System.out.println("4:Familia");
        opt = sc.nextInt();
        switch (opt) {
            case 1:
                cantidad = 4;
                break;
            case 2:
                cantidad = 6;
                break;
            case 3:
                cantidad = 8;
                break;

            default:
                cantidad = 12;
                break;
        }
        return cantidad;

    }
}