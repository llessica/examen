package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Menu;
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
    private JList jlstVenta;
    private DefaultListModel defaultListModel;
    private DialogoVentas DialogoVentas;
    private Lista listaVenta;
    private JTextField jtfNroFactura;
    private Archivo archivo;

    public Formulario() {
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(jbtAgregar = new JButton("Agregar"));
        p1.add(jbtActualizar = new JButton("Actualizar"));
        p1.add(jbtBorrar = new JButton("Borrar"));
        p1.add(jbtBuscar = new JButton("Buscar"));
        p1.add(jtfNroFactura = new JTextField(14));
        p1.add(jbtMenu = new JButton("Menu"));

        this.add(p1, BorderLayout.NORTH);

        defaultListModel = new DefaultListModel();
        listaVenta = new Lista();

        archivo = new Archivo("c:\\Ventas.txt");
        listaVenta = archivo.leer();
        poblarJList();

        jlstVenta = new JList(defaultListModel);
        jlstVenta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.add(new JScrollPane(jlstVenta), BorderLayout.CENTER);

        jlstVenta.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int indiceSeleccionado = jlstVenta.getSelectedIndex();

                //JOptionPane.showMessageDialog(rootPane, "Indice seleccionado " + indiceSeleccionado);
            }
        });

        jbtAgregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                DialogoVentas = new DialogoVentas(null);

                Ventas Venta = DialogoVentas.getVentas();
                listaVenta.insertarAlfinal(Venta);
                poblarJList();
                archivo.guardar(listaVenta);

            }
        });

        jbtActualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstVenta.getSelectedIndex();

                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una venta", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    DialogoVentas = new DialogoVentas(listaVenta.infoEnPosicion(indiceSeleccionado + 1));
                    archivo.guardar(listaVenta);
                    poblarJList();
                }
            }
        });

        jbtBorrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indiceSeleccionado = jlstVenta.getSelectedIndex();
                if (indiceSeleccionado == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una venta", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(rootPane, "Realmente desea borrar la venta seleccionado", "Confirmar Borrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        listaVenta.borrar(indiceSeleccionado + 1);
                        archivo.guardar(listaVenta);
                        poblarJList();
                    }
                }
            }
        });

        jbtBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String NroFactura = jtfNroFactura.getText().trim();
                if (!NroFactura.isEmpty()) {
                    Ventas venta = buscar(NroFactura);
                    if (venta != null) {
                        DialogoVentas = new DialogoVentas(venta);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "La venta " + NroFactura + " no se encuentra la lista", "Resultado Búsqueda", JOptionPane.INFORMATION_MESSAGE);
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
        for (Iterator iterator = listaVenta.iterator(); iterator.hasNext();) {
            Ventas venta = (Ventas) iterator.next();
            defaultListModel.addElement(venta);
        }
    }

    private Ventas buscar(String NroFactura) {
        for (Iterator iterator = listaVenta.iterator(); iterator.hasNext();) {
            Ventas venta = (Ventas) iterator.next();
            if (venta.getNroFactura().contains(NroFactura)) {
                return venta;
            }
        }
        return null;
    }
}
