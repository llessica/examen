package clientes;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class DialogoCliente extends JDialog {

    private JTextField jtfNombre, jtfApellido, jtfTelefono, jtfEmail, jtfGenero;
    private JButton jbtAceptar, jbtCancelar;
    private Cliente cliente;

    public DialogoCliente(Cliente e) {
        this.cliente = e;

        JPanel p1 = new JPanel(new GridLayout(5, 5));

        p1.add(new JLabel("Nombre"));
        p1.add(jtfNombre = new JTextField(15));

        p1.add(new JLabel("Apellido"));
        p1.add(jtfApellido = new JTextField(15));

        p1.add(new JLabel("Telefono"));
        p1.add(jtfTelefono = new JTextField(15));

        p1.add(new JLabel("Email"));
        p1.add(jtfEmail = new JTextField(5));

        p1.add(new JLabel("Genero"));
        p1.add(jtfGenero = new JTextField(5));

        this.add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(jbtAceptar = new JButton("Aceptar"));
        p2.add(jbtCancelar = new JButton("Cancelar"));

        add(p2, BorderLayout.SOUTH);
        setTitle("Cliente");
        setModal(true);

        if (cliente != null) {
            // Vamos a actualizar

            jtfNombre.setText(cliente.getNombre());
            jtfApellido.setText(cliente.getApellido());
            jtfTelefono.setText(cliente.getTelefono());
            jtfEmail.setText(cliente.getEmail());
            jtfGenero.setText(cliente.getGenero());

        }

        jbtAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String Nombre = jtfNombre.getText();
                String Apellido = jtfApellido.getText();
                String Telefono = jtfTelefono.getText();
                String Email = jtfEmail.getText();
                String Genero = jtfGenero.getText();


                if (cliente == null) {
                            cliente = new Cliente ( Nombre, Apellido, Telefono, Email, Genero);
                        } else {
                           
                           cliente.setNombre(Nombre);
                           cliente.setApellido(Apellido);
                           cliente.setTelefono(Telefono);
                           cliente.setEmail(Email);
                           cliente.setGenero(Genero);                       
                                                    
                        }
                        setVisible(false);
                    } /*else {
                        JOptionPane.showMessageDialog(rootPane, "promedio debe estar entre 0 y 5", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Promedio inválido", "Error", JOptionPane.ERROR_MESSAGE);
                }*

            };

            };*/

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

    public Cliente getCliente() {
        return cliente;
    }
}
