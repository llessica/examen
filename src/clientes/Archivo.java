package clientes;

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

    public void guardar(Lista listaCliente) {
        try {
            FileWriter fileWriter = new FileWriter(camino, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Iterator iterator = listaCliente.iterator(); iterator.hasNext();) {
                Cliente cliente = (Cliente) iterator.next();
                printWriter.println(cliente);
            }

            printWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Lista leer() {
        Lista listaCliente = new Lista();

        FileReader fileReader;
        try {

            File file = new File(camino);

            if (file.exists()) {
                fileReader = new FileReader(file);

                BufferedReader bufferReader = new BufferedReader(fileReader);
                String linea;

                while ((linea = bufferReader.readLine()) != null) {
                    String[] campoCliente = linea.split(" ");
                    Cliente cliente = new Cliente(camino, camino, camino, campoCliente[0] , campoCliente[1]);
                    listaCliente.insertarAlfinal(cliente);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listaCliente;
    }

}
