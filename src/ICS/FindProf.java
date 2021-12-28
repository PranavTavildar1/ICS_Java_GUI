package ICS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//from main menu to this GUI, then to custprof Gui
public class FindProf extends JFrame{
    private JPanel FindProf;
    private JButton Find;
    private JTextField IDinput;
    private JTextField LNinput;
    private JLabel Tittle;
    private JLabel ID;
    private JLabel LN;
    private CustomerProfInterface cpi;

    public FindProf(CustomerProfInterface incpi) {
        setContentPane(FindProf);
        setTitle("Find Profile");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.cpi = incpi;
        Find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IDinput.getText();
                String ln = LNinput.getText();
                CustomerProf cp = cpi.getDatabase().findProfile(id,ln);
                CustProf bigchungus = new CustProf(cp, cpi);
            }
        });
    }



}
