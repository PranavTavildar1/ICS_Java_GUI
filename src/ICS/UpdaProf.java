package ICS;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//from main menu to this GUI, then to upda GUI
public class UpdaProf extends JFrame{
    private CustomerProfInterface cpi;
    private JPanel UpdaProf;
    private JLabel Title;
    private JTextField IDinput;
    private JTextField LNinput;
    private JComboBox DropDown;
    private JButton Find;
    private JLabel ID;
    private JLabel LN;
    private JLabel UpdaFiel;
    public UpdaProf(CustomerProfInterface incpi) {
        setContentPane(UpdaProf);
        setTitle("Update Profile");
        setSize(450,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.cpi = incpi;
        Find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IDinput.getText();
                String ln = LNinput.getText();
                String updateitem = DropDown.getSelectedItem().toString();
                CustomerProf cp = cpi.getDatabase().findProfile(id,ln);

                Upda UpdaInstance = new Upda(cpi, cp, updateitem);
            }
        });
    }



}
