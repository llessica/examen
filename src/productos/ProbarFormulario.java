package productos;

import javax.swing.JFrame;

public class ProbarFormulario {

    public static void main(String[] args) {
        JFrame formulario = new Formulario();
        
        formulario.setVisible(true);
        formulario.setSize(600, 500);
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formulario.setTitle("Productos");
    }
    
}
