package ventas;


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

public class DialogoVentas extends JDialog {

    private JTextField jtfNroFactura, jtfVendedor, jtfCliente, jtfNombre_Producto, jtfValor,
            jtfSubTotal, jtfIva, jtfTotal;
    private JButton jbtAceptar, jbtCancelar;
    private Ventas venta;

    public DialogoVentas(Ventas e) {
        this.venta = e;

        JPanel p1 = new JPanel(new GridLayout(5, 5));

        p1.add(new JLabel("NroFactura"));
        p1.add(jtfNroFactura = new JTextField(15));

        p1.add(new JLabel("Vendedor"));
        p1.add(jtfVendedor = new JTextField(15));

        p1.add(new JLabel("Cliente"));
        p1.add(jtfCliente = new JTextField(15));

        p1.add(new JLabel("Nombre_Producto"));
        p1.add(jtfNombre_Producto = new JTextField(15));

        p1.add(new JLabel("Valor"));
        p1.add(jtfValor = new JTextField(10));

        p1.add(new JLabel("Subtotal"));
        p1.add(jtfSubTotal = new JTextField(10));

        p1.add(new JLabel("Iva"));
        p1.add(jtfIva = new JTextField(10));

        p1.add(new JLabel("Total"));
        p1.add(jtfTotal = new JTextField(10));

        this.add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(jbtAceptar = new JButton("Aceptar"));
        p2.add(jbtCancelar = new JButton("Cancelar"));

        add(p2, BorderLayout.SOUTH);
        setTitle("Registros_Ventas");
        setModal(true);

        if (venta != null) {
            // Vamos a actualizar
            jtfNroFactura.setText(venta.getNroFactura());
            jtfVendedor.setText(venta.getVendedor());
            jtfCliente.setText(venta.getCliente());
            jtfNombre_Producto.setText(venta.getNombre_Producto());
            jtfValor.setText(venta.getValor());
            jtfSubTotal.setText(venta.getSubTotal());
            jtfIva.setText(venta.getIva());
            jtfTotal.setText(venta.getTotal());

        }

        jbtAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String NroFactura = jtfNroFactura.getText();
                String Vendedor = jtfVendedor.getText();
                String Cliente = jtfCliente.getText();
                String Nombre_Producto = jtfNombre_Producto.getText();
                String Valor = jtfValor.getText();
                String Subtotal = jtfSubTotal.getText();
                String Iva = jtfIva.getText();
                String Total = jtfTotal.getText();

                /*try {
                 double promedio = Double.parseDouble(jtfPromedio.getText());
                 if (promedio >= 0 && promedio <= 5) {*/
                 if (venta == null) {
                 venta = new Ventas (NroFactura, Vendedor, Cliente, Nombre_Producto, 
                         Valor, Subtotal, Iva, Total );
                 } else {
                 venta.setNroFactura(NroFactura);
                 venta.setVendedor(Vendedor);
                 venta.setCliente(Cliente);
                 venta.setNombre_Producto(Nombre_Producto);
                 venta.setValor(Valor);
                 venta.setSubTotal(Subtotal);
                 venta.setIva(Iva);
                 venta.setTotal(Total);                 
                 }
                 setVisible(false);
                /* } else {
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

    public Ventas getVentas() {
        return venta;
    }
}
