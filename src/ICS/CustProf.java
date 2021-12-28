package ICS;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustProf extends JFrame{
    private JPanel CustProf;
    private JLabel Tittle;
    private JButton close;
    private JLabel ID;
    private JLabel IDoutput;
    private JLabel FN;
    private JLabel FNoutput;
    private JLabel LN;
    private JLabel LNoutput;
    private JLabel Address;
    private JLabel Addressoutput;
    private JLabel Phone;
    private JLabel Phoneoutput;
    private JLabel Income;
    private JLabel Incomeoutput;
    private JLabel Use;
    private JLabel Useoutput;
    private JLabel Status;
    private JLabel Statusoutput;
    private JLabel Model;
    private JLabel Modeloutput;
    private JLabel Year;
    private JLabel Yearoutput;
    private JLabel Type;
    private JLabel Typeoutput;
    private JLabel Method;
    private JLabel Methodoutput;
    private CustomerProfInterface cpi;
    private CustomerProf cp;
    public CustProf(CustomerProf cp, CustomerProfInterface cpi) {
        setContentPane(CustProf);
        setTitle("Find Profile");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.cpi = cpi;
        this.cp = cp;

        IDoutput.setText(cp.getadminID());
        FNoutput.setText(cp.getFirstName());
        LNoutput.setText(cp.getLastName());
        Addressoutput.setText(cp.getAddress());
        Phoneoutput.setText(cp.getPhone());
        Incomeoutput.setText(Float.toString(cp.getIncome()));
        Useoutput.setText(cp.getUse());
        Statusoutput.setText(cp.getStatus());
        Modeloutput.setText(cp.getVehicleInfo().getModel());
        Yearoutput.setText(cp.getVehicleInfo().getYear());
        Typeoutput.setText(cp.getVehicleInfo().getType());
        Methodoutput.setText(cp.getVehicleInfo().getMethod());

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
