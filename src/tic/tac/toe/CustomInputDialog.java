package tic.tac.toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomInputDialog extends JDialog {
    private JTextField inputField;
    private JButton okButton;
    private String userInput;

    public CustomInputDialog(JFrame parent, String message) {
        super(parent, true); // Hace que la ventana emergente sea modal y bloquea la ventana principal
        setTitle("Custom Input Dialog");

        // Configura el campo de entrada de texto
        inputField = new JTextField(20);

        // Configura el botón "Aceptar"
        okButton = new JButton("Aceptar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userInput = inputField.getText();
                dispose(); // Cierra la ventana emergente cuando se hace clic en "Aceptar"
            }
        });

        // Crea un panel para organizar los componentes
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(message), BorderLayout.NORTH);
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(okButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent); // Centra la ventana emergente con respecto a la ventana principal
        setResizable(false); // Evita que se pueda redimensionar la ventana emergente
    }

    public String showDialog() {
        setVisible(true); // Muestra la ventana emergente y espera a que el usuario haga clic en "Aceptar"
        return userInput;
    }
}

