package ventas;

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

    public void guardar(Lista lista) {
        try {
            FileWriter fileWriter = new FileWriter(camino, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
                Ventas venta = (Ventas) iterator.next();
                printWriter.println(venta);
            }

            printWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Lista leer() {
        Lista Lista = new Lista();

        FileReader fileReader;
        try {

            File file = new File(camino);

            if (file.exists()) {
                fileReader = new FileReader(file);

                BufferedReader bufferReader = new BufferedReader(fileReader);
                String linea;

                while ((linea = bufferReader.readLine()) != null) {
                    String[] campoVenta = linea.split(" ");
                    Ventas venta = new Ventas(campoVenta[0], campoVenta[1], 
                            campoVenta[2], camino, campoVenta[3], campoVenta[4], campoVenta[5], campoVenta[6]);
                    Lista.insertarAlfinal(venta);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return Lista;
    }

}
