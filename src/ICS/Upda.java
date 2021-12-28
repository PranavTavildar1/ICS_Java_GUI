package ICS;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Upda extends JFrame{
    private JButton Submit;
    private JTextField Updainput;
    private JLabel Title;
    private JLabel ID;
    private JLabel LN;
    private JLabel UpdaFiel;
    private JLabel IDoutput;
    private JLabel LNoutput;
    private JPanel Update;
    private CustomerProfInterface cpi;

    public Upda(CustomerProfInterface incpi, CustomerProf cp, String attribute) {
        setContentPane(Update);
        setTitle("Update Profile");
        setSize(450,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.cpi = incpi;
        UpdaFiel.setText(attribute);

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updatedVal = Updainput.getText();
                switch (attribute){
                    case "Address":
                        System.out.println("Selected addy");
                        cp.updateAddress(updatedVal);
                        break;
                    case "Phone":
                        cp.updatePhone(updatedVal);
                        break;
                    case "Use":
                        cp.updateUse(updatedVal);
                        break;
                    case "Status":
                        cp.updateStatus(updatedVal);
                        break;
                    case "Model":
                        cp.getVehicleInfo().updateModel(updatedVal);
                        break;
                    case "Year":
                        cp.getVehicleInfo().updateYear(updatedVal);
                        break;
                    case "Type":
                        cp.getVehicleInfo().updateType(updatedVal);
                        break;
                    case "Method":
                        cp.getVehicleInfo().updateMethod(updatedVal);
                        break;

                    default:
                        System.out.println("Something went wrong and its not recognizing inputs");
                }
                cpi.writeToDB();


            }
        });
    }


}
