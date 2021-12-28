package ICS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispProf extends JFrame{
    private JPanel DispProf;
    private JLabel Tittle;
    private JButton Next;
    private JLabel ID;
    private JLabel IDinput;
    private JLabel FN;
    private JLabel FNoutput;
    private JLabel LM;
    private JLabel LMoutput;
    private JLabel Address;
    private JLabel Addressoutput;
    private JLabel Phone;
    private JLabel Phoneoutput;
    private JLabel Income;
    private JLabel Incomeoutput;
    private JLabel Use;
    private JLabel Useoutput;
    private JLabel Status;
    private JLabel statusoutput;
    private JLabel Model;
    private JLabel Modeloutput;
    private JLabel Year;
    private JLabel Yearoutput;
    private JLabel Type;
    private JLabel Typeoutput;
    private JLabel Method;
    private JLabel Methodoutput;
    private CustomerProfInterface cpi;
    private int cnt;
    public DispProf(CustomerProfInterface cpi, String adminID) {
        setContentPane(DispProf);
        setTitle("Display all Profiles");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.cpi = cpi;
        int length = 0;
        int count = 0;
        CustomerProf[] unfilteredcustomerlist = cpi.getDatabase().getCustomerList();
        for (CustomerProf cp: cpi.getDatabase().getCustomerList()) {
            if (cp.getadminID().equals(adminID))
            {
                length++;
            }
        }
        CustomerProf[] filteredcustomerlist = new CustomerProf[length];
        for (CustomerProf cp: cpi.getDatabase().getCustomerList()) {
            if (cp.getadminID().equals(adminID))
            {
                filteredcustomerlist[count] = cp;
                count++;
            }
        }
        this.cnt = 0;
        setCustomerAttributes(filteredcustomerlist, this.cnt);

        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cnt++;
                setCustomerAttributes(filteredcustomerlist, cnt);
            }
        });
    }
    private void setCustomerAttributes(CustomerProf[] customerlist, int i)
    {
        CustomerProf cp = customerlist[i];
        FNoutput.setText(cp.getFirstName());
        LM.setText(cp.getLastName());
        Addressoutput.setText(cp.getAddress());
        Phoneoutput.setText(cp.getPhone());
        Incomeoutput.setText(Float.toString(cp.getIncome()));
        Useoutput.setText(cp.getUse());
        statusoutput.setText(cp.getStatus());
        Modeloutput.setText(cp.getVehicleInfo().getModel());
        Yearoutput.setText(cp.getVehicleInfo().getYear());
        Typeoutput.setText(cp.getVehicleInfo().getType());
        Methodoutput.setText(cp.getVehicleInfo().getMethod());

    }


}
