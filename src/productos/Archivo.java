package productos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Archivo {

    private final String camino;

    public Archivo(String camino) {
        this.camino = camino;
    }

    public void guardar(Lista listaProducto) {
        try {
            FileWriter fileWriter = new FileWriter(camino, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Iterator iterator = listaProducto.iterator(); iterator.hasNext();) {
                    Productos producto = (Productos) iterator.next();
                printWriter.println(producto);
            }

            printWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Lista leer() {
        Lista listaProducto = new Lista();

        FileReader fileReader;
        try {

            File file = new File(camino);

            if (file.exists()) {
                fileReader = new FileReader(file);

                BufferedReader bufferReader = new BufferedReader(fileReader);
                String linea;

                while ((linea = bufferReader.readLine()) != null) {
                    String[] campoProducto = linea.split(" ");
                    Productos producto = new Productos(campoProducto[0], campoProducto[1], campoProducto[2] , 
                            campoProducto[3], campoProducto[4], campoProducto[5], campoProducto[6], campoProducto[7]);
                    listaProducto.insertarAlfinal(producto);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listaProducto;
    }

}
