/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author MEDIATECNICA#
 */
public class Softses extends JFrame implements ActionListener {

    private JButton jbtClientes, jbtProductos, jbtVentas;

    public Softses() {

        super.setTitle("Menu");
        super.setSize(350, 200);
        super.setLayout(null);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

        jbtClientes = new JButton("clientes");
        jbtClientes.setBounds(50, 20, 100, 20);
        jbtClientes.addActionListener(this);
        this.add(jbtClientes);

        jbtProductos = new JButton("productos");
        jbtProductos.setBounds(50, 50, 100, 20);
        jbtProductos.addActionListener(this);
        this.add(jbtProductos);

        jbtVentas = new JButton("ventas");
        jbtVentas.setBounds(50, 80, 100, 20);
        jbtVentas.addActionListener(this);
        this.add(jbtVentas);

        this.repaint();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Softses softses = new Softses();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbtClientes) {
            JFrame formulario = new clientes.Formulario();

            formulario.setVisible(true);
            formulario.setSize(600, 500);
            formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            formulario.setTitle("Clientes");
            this.setVisible(false);
            this.dispose();
        }
        
        if (ae.getSource() == jbtProductos) {
            JFrame formulario = new productos.Formulario();

            formulario.setVisible(true);
            formulario.setSize(600, 500);
            formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            formulario.setTitle("Productos");
            this.setVisible(false);
            this.dispose();
        }
        
        if (ae.getSource() == jbtVentas) {
            JFrame formulario = new ventas.Formulario();

            formulario.setVisible(true);
            formulario.setSize(600, 500);
            formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            formulario.setTitle("Registro_Ventas");
            this.setVisible(false);
            this.dispose();
        }
    }

}
