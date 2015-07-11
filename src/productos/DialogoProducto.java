package productos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoProducto extends JDialog {

    private JTextField jtfId, jtfNombre, jtfCosto, jtfValor, jtfTalla, jtfCantMin, jtfCantMax, jtfGenero;
    private JButton jbtAceptar, jbtCancelar;
    private Productos productos;

    public DialogoProducto(Productos e) {
        this.productos = e;

        JPanel p1 = new JPanel(new GridLayout(5, 5));

        p1.add(new JLabel("Id"));
        p1.add(jtfId = new JTextField(10));
        
        p1.add(new JLabel("Nombre"));
        p1.add(jtfNombre = new JTextField(15));

        p1.add(new JLabel("Costo"));
        p1.add(jtfCosto = new JTextField(15));

        p1.add(new JLabel("Valor"));
        p1.add(jtfValor = new JTextField(15));
        
         p1.add(new JLabel("Talla"));
        p1.add(jtfTalla = new JTextField(5));
        
        p1.add(new JLabel("Cantidad Minima"));
        p1.add(jtfCantMin = new JTextField(10));
        
        p1.add(new JLabel("Cantidad Maxima"));
        p1.add(jtfCantMax = new JTextField(10));

        p1.add(new JLabel("Genero"));
        p1.add(jtfGenero = new JTextField(5));

        this.add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(jbtAceptar = new JButton("Aceptar"));
        p2.add(jbtCancelar = new JButton("Cancelar"));

        add(p2, BorderLayout.SOUTH);
        setTitle("Registro_Productos");
        setModal(true);

        if (productos != null) {
            // Vamos a actualizar
            jtfId.setText(productos.getId());
            jtfNombre.setText(productos.getNombre()); 
            jtfCosto.setText(productos.getCosto());
            jtfValor.setText(productos.getValor());
            jtfTalla.setText(productos.getTalla());
            jtfCantMin.setText(productos.getCantMin());
            jtfCantMax.setText(productos.getCantMax());
            jtfGenero.setText(productos.getGenero());
            
        }

        jbtAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               String Id=jtfId.getText();
                String Nombre = jtfNombre.getText();
                String Costo = jtfCosto.getText();
                String Valor = jtfValor.getText();
                String Talla = jtfTalla.getText();
                String CantMin = jtfCantMin.getText();
                String CantMax = jtfCantMax.getText();
                String Genero = jtfGenero.getText();

               /* try {
                    double promedio = Double.parseDouble(jtfPromedio.getText());
                    if (promedio >= 0 && promedio <= 5) {
                       */ if (productos == null) {
                            productos = new Productos(Id, Nombre, Costo, Valor, Talla, CantMin,
                            CantMax, Genero);
                        } else {
                            productos.setId(Id);
                           productos.setNombre(Nombre);
                            productos.setCosto(Costo);
                          productos.setValor(Valor);
                          productos.setTalla(Talla);
                          productos.setCantMin(CantMin);
                          productos.setCantMax(CantMax);
                          productos.setGenero(Genero);
                        }
                        setVisible(false);
                    /*} else {
                        JOptionPane.showMessageDialog(rootPane, "promedio debe estar entre 0 y 5", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Promedio inválido", "Error", JOptionPane.ERROR_MESSAGE);
                }*/

    }

        });

        jbtCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setSize(350, 200);
        setLocationRelativeTo(rootPane);
        setVisible(true);
    }

    public Productos getProductos() {
        return productos;
    }
}


/*
public class DialogoProducto extends JDialog {

    private JTextField jtfId, jtfNombre, jtfCosto, jtfValor, jtfTalla, jtfCantMin, jtfCantMax, jtfGenero;
    private JButton jbtAceptar, jbtCancelar;
    private Productos producto;

    public DialogoProducto(Productos e) {
        this.producto = e;

        JPanel p1 = new JPanel(new GridLayout(5, 5));

        p1.add(new JLabel("Id"));
        p1.add(jtfId = new JTextField(10));
        
        p1.add(new JLabel("Nombre"));
        p1.add(jtfNombre = new JTextField(15));

        p1.add(new JLabel("Costo"));
        p1.add(jtfCosto = new JTextField(15));

        p1.add(new JLabel("Valor"));
        p1.add(jtfValor = new JTextField(15));
        
         p1.add(new JLabel("Talla"));
        p1.add(jtfTalla = new JTextField(5));
        
        p1.add(new JLabel("Cantidad Minima"));
        p1.add(jtfCantMin = new JTextField(10));
        
        p1.add(new JLabel("Cantidad Maxima"));
        p1.add(jtfCantMax = new JTextField(10));

        p1.add(new JLabel("Genero"));
        p1.add(jtfGenero = new JTextField(5));
        
        
        this.add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(jbtAceptar = new JButton("Aceptar"));
        p2.add(jbtCancelar = new JButton("Cancelar"));

        add(p2, BorderLayout.SOUTH);
        setTitle("Registro_Productos");
        setModal(true);

        if (producto != null) {
            // Vamos a actualizar
            jtfId.setText(producto.getId());
            jtfNombre.setText(producto.getNombre()); 
            jtfCosto.setText(producto.getCosto());
            jtfValor.setText(producto.getValor());
            jtfTalla.setText(producto.getTalla());
            jtfCantMin.setText(producto.getCantMin());
            jtfCantMax.setText(producto.getCantMax());
            jtfGenero.setText(producto.getGenero());
            
                    }

        jbtAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Id=jtfId.getText();
                String Nombre = jtfNombre.getText();
                String Costo = jtfCosto.getText();
                String Valor = jtfValor.getText();
                String Talla = jtfTalla.getText();
                String CantMin = jtfCantMin.getText();
                String CantMax = jtfCantMax.getText();
                String Genero = jtfGenero.getText();
               

               
                    //double promedio = Double.parseDouble(jtfPromedio.getText());
                   // if (promedio >= 0 && promedio <= 5) {
                        if (producto == null) {
                            producto = new Productos (Id, Nombre, Costo, Valor, Talla, CantMin,
                            CantMax, Genero);
                        } else {
                            producto.setId(Id);
                           producto.setNombre(Nombre);
                            producto.setCosto(Costo);
                          producto.setValor(Valor);
                          producto.setTalla(Talla);
                          producto.setCantMin(CantMin);
                          producto.setCantMax(CantMax);
                          producto.setGenero(Genero);
}
                        setVisible(false);
                    } /*else {
                        JOptionPane.showMessageDialog(rootPane, "promedio debe estar entre 0 y 5", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Promedio inválido", "Error", JOptionPane.ERROR_MESSAGE);
                }*

            };


        });

        jbtCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setSize(350, 200);
        setVisible(true);
    }

    public Productos getProductos() {
        return producto;
    }
}
*/