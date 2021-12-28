package ICS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfile extends JFrame {
    private JTextField adminIDTxtField;
    private JTextField FNameTxtField;
    private JLabel LastName;
    private JTextField LNameTxtField;
    private JLabel Address;
    private JLabel Heading;
    private JLabel AdminID;
    private JLabel FirstName;
    private JTextField AdressTxtField;
    private JLabel Phone;
    private JTextField PhoneTxtField;
    private JLabel Income;
    private JTextField IncomeTxtField;
    private JLabel Use;
    private JComboBox UseComboBox;
    private JLabel Status;
    private JComboBox StatusComboBox;
    private JLabel Model;
    private JTextField ModelTxtField;
    private JLabel Year;
    private JTextField YearTxtField;
    private JLabel Type;
    private JComboBox TypeComboBox;
    private JLabel Method;
    private JComboBox MethodComboBox;
    private JPanel CPpanel;
    private JButton submitButton;
    private CustomerProfInterface cpi;

    public CreateProfile(CustomerProfInterface incpi)
    {
        setContentPane(CPpanel);
        setTitle("Create Profile");
        setSize(450,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.cpi = incpi;

        //Combo box Values for CustomerProf


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cAdminID = adminIDTxtField.getText();
                String fName = FNameTxtField.getText();
                String lName = LNameTxtField.getText();
                String address = AdressTxtField.getText();
                String phone = PhoneTxtField.getText();
                float income = Float.parseFloat(IncomeTxtField.getText());
                String status = StatusComboBox.getSelectedItem().toString();
                String use = UseComboBox.getSelectedItem().toString();
                //Vehicle Inputs
                String model = ModelTxtField.getText();
                String year = YearTxtField.getText();

                String type = TypeComboBox.getSelectedItem().toString();
                String method = MethodComboBox.getSelectedItem().toString();
                //Converting to objects
                VehicleInfo v = new VehicleInfo(model,year,type,method);
                CustomerProf cp = new CustomerProf(cAdminID,fName,lName,address,phone,income,status,use,v);
                //implementing method
                cpi.getDatabase().insertNewProfile(cp);
                cpi.writeToDB();
                System.out.println("The new entry has been added");

            }
        });
    }
}
