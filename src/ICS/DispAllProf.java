package ICS;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//from main menu to this GUI, then to dispprof GUI
public class DispAllProf extends JFrame{
    private JPanel DispAllProf;
    private JLabel Tittle;
    private JTextField IDinput;
    private JButton Find;
    private JLabel ID;
    private CustomerProfInterface cpi;
    public DispAllProf(CustomerProfInterface cpi) {
        setContentPane(DispAllProf);
        setTitle("Display all Profiles");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        this.cpi = cpi;
        Find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IDinput.getText();
                DispProf dispProf = new DispProf(cpi, id);
            }
        });
    }


}
