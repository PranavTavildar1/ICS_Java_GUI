package ICS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProfConfirmation extends JFrame{
    private JLabel Headlbl;
    private JLabel Conflbl;
    private JButton okButton;
    private JPanel DelConfpanel;

    public DeleteProfConfirmation(String labelTxt) {
        setContentPane(DelConfpanel);
        setTitle("Delete Profile");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Conflbl.setText(labelTxt);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
