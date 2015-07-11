package productos;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Formulario extends JFrame {

    private JButton jbtAgregar, jbtActualizar, jbtBorrar, jbtBuscar, jbtMenu;
    private JList jlstProducto;
    private DefaultListModel defaultListModel;
    private DialogoProducto DialogoProducto;
    private Lista listaProducto;
    private JTextField jtfNombre;
    private Archivo archivo;

    public Formulario() {
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(jbtAgregar = new JButton("Agregar"));
        p1.add(jbtActualizar = new JButton("Actualizar"));
        p1.add(jbtBorrar = new JButton("Borrar"));
        p1.add(jbtBuscar = new JButton("Buscar"));
        p1.add(jtfNombre = new JTextField(15));
        p1.add(jbtMenu = new JButton("Menu"));

        this.add(p1, BorderLayout.NORTH);

        defaultListModel = new DefaultListModel();
        listaProducto = new Lista();
        
        archivo = new Archivo("c:\\Producto.txt");
        listaProducto = archivo.leer();

        poblarJList();

        jlstProducto = new JList(defaultListModel);
        jlstProducto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.add(new JScrollPane(jlstProducto), BorderLayout.CENTER);

        jlstProducto.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int indiceSeleccionado = jlstProducto.getSelectedIndex();

                //JOptionPane.showMessageDialog(rootPane, "Indice seleccionado " + indiceSeleccionado);
            }
        });

        jbtAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                DialogoProducto = new DialogoProducto(null);

                Productos producto = DialogoProducto.getProductos();
                listaProducto.insertarAlfinal(producto);
                poblarJList();
                archivo.guardar(listaProducto);

            }
        });

        jbtActualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstProducto.getSelectedIndex();

                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un estudiante", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    DialogoProducto = new DialogoProducto(listaProducto.infoEnPosicion(indiceSeleccionado + 1));
                    archivo.guardar(listaProducto);
                    poblarJList();
                }
            }
        });

        jbtBorrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstProducto.getSelectedIndex();
                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar la compra", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(rootPane, "Realmente desea borrar la compra seleccionada", "Confirmar Borrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        listaProducto.borrar(indiceSeleccionado + 1);
                        archivo.guardar(listaProducto);
                        poblarJList();
                    }
                }
            }
        });

        jbtBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String nombre = jtfNombre.getText().trim();
                if (!nombre.isEmpty()) {
                    Productos producto = buscar(nombre);
                    if (producto != null) {
                        DialogoProducto = new DialogoProducto(producto);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "El producto " + nombre + " no se encontro en la lista", "Resultado Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        
        jbtMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame menu = new softses.Softses();
                setVisible(false);
            }
        });
    }

    private void poblarJList() {
        defaultListModel.removeAllElements();
        for (Iterator iterator = listaProducto.iterator(); iterator.hasNext();) {
            Productos producto = (Productos) iterator.next();
            defaultListModel.addElement(producto);
        }
    }

    private Productos buscar(String nombre) {
        for (Iterator iterator = listaProducto.iterator(); iterator.hasNext();) {
            Productos producto = (Productos) iterator.next();
            if (producto.getNombre().contains(nombre)) {
                return producto;
            }
        }
        return null;
    }
}




































/*
public class Formulario extends JFrame {

    private JButton jbtAgregar, jbtActualizar, jbtBorrar, jbtBuscar;
    private JList jlstProducto;
    private DefaultListModel defaultListModel;
    private DialogoProducto DialogoProducto;
    private Lista listaProducto;
    private JTextField jtfNombre;
    private Archivo archivo;

    public Formulario() {
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(jbtAgregar = new JButton("Agregar"));
        p1.add(jbtActualizar = new JButton("Actualizar"));
        p1.add(jbtBorrar = new JButton("Borrar"));
       p1.add(jbtBuscar = new JButton("Buscar"));
       p1.add(jtfNombre = new JTextField(15));
        
        this.add(p1, BorderLayout.NORTH);

        defaultListModel = new DefaultListModel();
         listaProducto = new Lista();
//        defaultListModel.addElement("Bill Gates");
//        defaultListModel.addElement("Mark Zuckenber");
//        defaultListModel.addElement(new Estudiante("James", "Rodriguez", 3.8));
        archivo = new Archivo("c:\\Estudiante.txt");
        listaProducto = archivo.leer();
        //poblarJList();


        //listaProducto.insertarAlfinal(new Productos("0001", " Pantalón ", " 50.000 ", 
              //  "55.000", " S ", " 25 ", " 50 ", "Femenino"));
       // listaProducto.insertarAlfinal(new Productos("0002", " Camiseta ", " 25.000 ", 
               // "30.000", " M ", " 25 ", " 50 ", "Masculino"));
listaProducto.insertarAlfinal(new Productos("  ID    ", " Producto ", " Costo ",
                "Valor", " Talla  ", " Cant. Minima ", " Cant Max. ", "Genero"));v
        poblarJList();

        jlstProducto = new JList(defaultListModel);
        jlstProducto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.add(new JScrollPane(jlstProducto), BorderLayout.CENTER);

        jlstProducto.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int indiceSeleccionado = jlstProducto.getSelectedIndex();

                //JOptionPane.showMessageDialog(null, "Indice seleccionado " + indiceSeleccionado);
            }
        });

        jbtAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                DialogoProducto = new DialogoProducto(null);

                Productos producto = DialogoProducto.getProductos();
                listaProducto.insertarAlfinal(producto);
                poblarJList();
                archivo.guardar(listaProducto);
            }
        });

        jbtActualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstProducto.getSelectedIndex();

                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un producto", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
              /*      DialogoProducto = new DialogoProducto(listaProducto.infoEnPosicion(indiceSeleccionado + 1));
                    poblarJList();
                }
            }
        });
         jbtBorrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstProducto.getSelectedIndex();
                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un Producto", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(rootPane, "Realmente desea borrar el producto seleccionado", "Confirmar Borrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        listaProducto.borrar(indiceSeleccionado + 1);
                        archivo.guardar(listaProducto );
                        poblarJList();
                    }
                }
            }
        });

        jbtBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nombre = jtfNombre.getText().trim();
                if (!Nombre.isEmpty()) {
                    Productos producto = buscar(Nombre);
                    if (producto != null) {
                        DialogoProducto = new DialogoProducto(producto);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "La venta " + Nombre + " no se encuentra la lista", "Resultado Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

    }

    private void poblarJList() {
        defaultListModel.removeAllElements();
     /*   for (Iterator iterator = listaProducto.iterator(); iterator.hasNext();) {
            Productos producto = (Productos) iterator.next();
            defaultListModel.addElement(producto);
        }
    }
     private Productos buscar(String Nombre) {
      /*  for (Iterator iterator = listaProducto.iterator(); iterator.hasNext();) {
            Productos producto = (Productos) iterator.next();
            if (producto.getNombre().contains(Nombre)) {
                return producto;
            }
        }
        return null;
    }
}

*/
