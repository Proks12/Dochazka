package ui;

import service.DochazkaService;
import model.StavDochazky;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Docházkový systém");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField student = new JTextField();
        JTextField vyuc = new JTextField();

        JButton ulozit = new JButton("Zapsat docházku");
        ulozit.addActionListener(e -> {
            try {
                new DochazkaService().zapsatDochazku(
                        Integer.parseInt(student.getText()),
                        Integer.parseInt(vyuc.getText()),
                        StavDochazky.PRITOMEN,
                        ""
                );
                JOptionPane.showMessageDialog(this, "Uloženo");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("ID studenta"));
        add(student);
        add(new JLabel("ID vyučování"));
        add(vyuc);
        add(ulozit);
    }
}
