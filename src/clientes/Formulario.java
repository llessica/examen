package clientes;


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
    private JList jlstCliente;
    private DefaultListModel defaultListModel;
    private DialogoCliente DialogoCliente;
    private Lista listaCliente;
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
        listaCliente = new Lista();

        archivo = new Archivo("c:\\Cliente.txt");
        listaCliente = archivo.leer();
        poblarJList();

        jlstCliente = new JList(defaultListModel);
        jlstCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.add(new JScrollPane(jlstCliente), BorderLayout.CENTER);

        jlstCliente.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int indiceSeleccionado = jlstCliente.getSelectedIndex();

                //JOptionPane.showMessageDialog(rootPane, "Indice seleccionado " + indiceSeleccionado);
            }
        });

        jbtAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                DialogoCliente = new DialogoCliente(null);

                Cliente cliente = DialogoCliente.getCliente();
                listaCliente.insertarAlfinal(cliente);
                poblarJList();
                archivo.guardar(listaCliente);

            }
        });

        jbtActualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstCliente.getSelectedIndex();

                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un cliente", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    DialogoCliente = new DialogoCliente(listaCliente.infoEnPosicion(indiceSeleccionado + 1));
                    archivo.guardar(listaCliente);
                    poblarJList();
                }
            }
        });

        jbtBorrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstCliente.getSelectedIndex();
                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un cliente", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(rootPane, "Realmente desea borrar el cliente seleccionado", "Confirmar Borrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        listaCliente.borrar(indiceSeleccionado + 1);
                        archivo.guardar(listaCliente);
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
                    Cliente cliente = buscar(nombre);
                    if (cliente!= null) {
                        DialogoCliente = new DialogoCliente (cliente);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "El cliente " + nombre + " no se encontro en la lista", "Resultado Búsqueda", JOptionPane.INFORMATION_MESSAGE);
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
        for (Iterator iterator = listaCliente.iterator(); iterator.hasNext();) {
            Cliente cliente = (Cliente) iterator.next();
            defaultListModel.addElement(cliente);
        }
    }

    private Cliente buscar(String nombre) {
        for (Iterator iterator = listaCliente.iterator(); iterator.hasNext();) {
            Cliente cliente = (Cliente) iterator.next();
            if (cliente.getNombre().contains(nombre)) {
                return cliente;
            }
        }
        return null;
    }
}




