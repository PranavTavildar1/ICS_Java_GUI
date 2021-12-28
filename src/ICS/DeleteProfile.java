package ICS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProfile extends JFrame {
    private CustomerProfInterface cpi;
    private JLabel TitleLabel;
    private JLabel AdminIDlbl;
    private JLabel LastNamelbl;
    private JTextField AdminIDTxtField;
    private JTextField LNameTxtField;
    private JPanel DPpanel;
    private JButton Deletebtn;

    public DeleteProfile(CustomerProfInterface incpi)
    {
        setContentPane(DPpanel);
        setTitle("Delete Profile");
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.cpi = incpi;

        Deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aID = AdminIDTxtField.getText();
                String Lname = LNameTxtField.getText();
                if (cpi.getDatabase().deleteProfile(aID,Lname))
                {
                    DeleteProfConfirmation window = new DeleteProfConfirmation("Profile Successfully Deleted");
                }
                else
                {
                    DeleteProfConfirmation window = new DeleteProfConfirmation("either this value does not exist or you do not have permission to change or remove this value");
                }
                cpi.writeToDB();
            }
        });
    }
}
