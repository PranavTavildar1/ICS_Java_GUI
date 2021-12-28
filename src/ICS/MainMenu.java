package ICS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MainMenu extends JFrame{
    private JRadioButton createProfileRadioButton;
    private JPanel mainpanel;
    private JRadioButton deleteProfileRadioButton;
    private JRadioButton updateProfileRadioButton;
    private JRadioButton findDisplayProfilesRadioButton;
    private JRadioButton displayAllProfilesRadioButton;
    private JLabel Header;
    private JButton selectButton;
    private CustomerProfInterface globcpi;


    public MainMenu(CustomerProfInterface cpi)
    {
        setContentPane(mainpanel);
        setTitle("ICS System GUI");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.globcpi = cpi;


        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (createProfileRadioButton.isSelected())
                {
                    CreateProfile prof1 = new CreateProfile(globcpi);
                }
                if (deleteProfileRadioButton.isSelected())
                {
                    DeleteProfile prof2 = new DeleteProfile(globcpi);
                }
                if (updateProfileRadioButton.isSelected())
                {
                    UpdaProf prof3 = new UpdaProf(globcpi);
                }
                if (findDisplayProfilesRadioButton.isSelected()){
                    FindProf prof4 = new FindProf(globcpi);
                }
                if(displayAllProfilesRadioButton.isSelected()){
                    DispAllProf prof5 = new DispAllProf(globcpi);
                }
            }
        });
    }

    public static void main(String[] args) {
        Scanner basedSC = new Scanner(System.in);
        System.out.println("Enter a file path for the database:");
        String fileName = basedSC.nextLine();
        CustomerProfInterface cpi = new CustomerProfInterface(fileName);
        MainMenu driver = new MainMenu(cpi);

    }
}

