/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp2.parly.p4f;
import javax.swing.JOptionPane;

/** 
 *Parly
 *CECILIA GUTIÉRREZ DE LARA HERNÁNDEZ
 *NORMA LEDEZMA MARTÍNEZ
 *ERICK EDUARDO GERVACCI ROMERO
 *DIEGO SANTANA LEIVA
 *BENITO RAFAEL MORANTE VÁZQUEZ
 */

public class SPP2ParlyP4F {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        int t = solicitaInt("Ingrese el número de artículos que quiera agregrar al inventario");
        String [][] productos = new String [t][3];
        boolean rellenado = false;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(" 1.Inventario\n 2.Vender\n 3.Salir\n"));
            switch (opcion) {
                case 1:
                    productos = MatrizInventario(t);
                    rellenado = true;
                    break;
                case 2:
                    if (rellenado){
                       desplegarInventario(productos);
                       double[] venta = MatrizVenta(productos);
                       Total(venta);
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Adiós!");
                    System.exit(0);
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "Opción Incorrecta");

            }
        } while (opcion != 3);
    }

    public static double solicitaDouble(String mensaje) {
        String dato;
        double num = 0;
        boolean flag;

        do {
            try {
                dato = JOptionPane.showInputDialog(null, mensaje);
                num = Double.parseDouble(dato);
                flag = false;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error");
                flag = true;
            }
        } while (flag);
        return num;
    }
    public static int solicitaInt(String mensaje) {
        String dato;
        int num = 0;
        boolean flag;

        do {
            try {
                dato = JOptionPane.showInputDialog(null, mensaje);
                num = Integer.parseInt(dato);
                flag = false;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error");
                flag = true;
            }
        } while (flag);
        return num;
    }
    public static String solicitaString(String mensaje) {
        String dato = "";
        boolean flag;

        do {
            try {
                dato = JOptionPane.showInputDialog(null, mensaje);
                flag = false;
            } catch (Exception ex) {
                //JOptionPane.showMessageDialog(null, "Error");
                dato = "salir";
                flag = true;
            }
        } while (flag);
        return dato;
    }

    public static String[][] MatrizInventario(int t) {
        String[][] Matriz = new String[t][3];
        for (int i = 0; i < Matriz.length; i++) {
            Matriz[i][0] = solicitaString("Clave (producto "+(i+1)+")");
            Matriz[i][1] = solicitaString("Info (producto "+(i+1)+")");
            Matriz[i][2] = solicitaString("Precio (producto "+(i+1)+")");
        }
        return Matriz;
    }
    public static void desplegarInventario(String[][]productos){
        for(int i=0;i<productos.length;i++){
            JOptionPane.showMessageDialog(null,"Producto "+(i+1)
            +"\nClave: "+productos[i][0]
            +"\nInfo: "+productos[i][1]
            +"\nPrecio: "+productos[i][2]
            +"\n");
        }
    }
    public static double[] MatrizVenta(String[][] inventario) {
        
        int t = 10000000;
        double dato=0;
        int contador=0;
        double[] Matriz = new double[t];
        String articulo = "";
        do {
            articulo = solicitaString("Ingrese el código del artículo");
            if (articulo!=null){
            for (int i = 0; i < inventario.length; i++) {
                if(articulo.equals(inventario[i][0])){
                    JOptionPane.showMessageDialog(null,inventario[i][1]+"(Producto "+(i+1)+")");
                    dato = Double.parseDouble(inventario[i][2]);
                    Matriz[contador] = dato;
                    contador = contador+1;
                }   
            }
        } 
        }while (articulo!=null);
        
        return Matriz;
    }
    
    public static void Total(double [] venta){
        double total = 0;
        for (int i=0; i<venta.length; i++){
            total = total+venta[i];
        }
        JOptionPane.showMessageDialog(null, "El total a pagar es de:\n"+"$" + total);
    }
}
