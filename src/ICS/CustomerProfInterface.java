package ICS;

import java.util.Scanner;

public class CustomerProfInterface {
    private CustomerProfDB database;
    private String adminID;
    public CustomerProfInterface(String fileName){
        this.database = new CustomerProfDB(fileName);
        this.adminID = "";
    }
    //driver
    public static void main(String[] args) {
        String fileName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a file path for the database:");
        fileName = sc.nextLine();
        CustomerProfInterface cpi = new CustomerProfInterface(fileName);
        cpi.getUserChoice();
    }

    private void getUserChoice(){
        Scanner sc = new Scanner(System.in);
        String adminID;
        System.out.println("Enter AdminID");
        String userAdminID = sc.nextLine();
        changeAdminID(userAdminID);
        lp : while(true){
            //Displaying Menu
            System.out.println("1: Insert a new Customer Profile");
            System.out.println("2: Delete Customer Profile");
            System.out.println("3: Find and Display Customer Profile");
            System.out.println("4: Modify Customer Attributes");
            System.out.println("5: Display All Profiles");
            System.out.println("6: Save");
            System.out.println("7: Program termination");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    insertCustomerProf();
                    break;
                case 2:
                    deleteCustomerProf();
                    break;
                case 3:
                    displayCustomerProf();
                    break;
                case 4:
                    updateCustomerProfile();
                    break;
                case 5:
                    displayAllCustomerProf();
                    break;
                case 6:
                    writeToDB();
                    break;
                case 7:
                    writeToDB();
                    break lp;
                default:
                    System.out.println("invalid choice" +"\n");



            }

        }
        System.out.println("The program has been terminated. Have a great day!");

    }
    //Done
    public void insertCustomerProf(){
        Scanner sc = new Scanner(System.in);
        //Customer inputs
        String cAdminID = this.getAdminID();
        System.out.println("Give a first name");
        String fName = sc.nextLine();
        System.out.println("Give a last name");
        String lName = sc.nextLine();
        System.out.println("Give an address");
        String address = sc.nextLine();
        System.out.println("Give a Phone Number");
        String phone = sc.nextLine();
        System.out.println("Give an income");
        float income = Float.parseFloat(sc.nextLine());
        System.out.println("Give a status");
        String status = sc.nextLine();
        System.out.println("Give a use");
        String use = sc.nextLine();
        //Vehicle Inputs
        System.out.println("Give a vehicle model");
        String model = sc.nextLine();
        System.out.println("Give a vehicle year");
        String year = sc.nextLine();
        System.out.println("Give a vehicle type");
        String type = sc.nextLine();
        System.out.println("Give a vehicle method");
        String method = sc.nextLine();
        //Converting to objects
        VehicleInfo v = new VehicleInfo(model,year,type,method);
        CustomerProf cp = new CustomerProf(cAdminID,fName,lName,address,phone,income,status,use,v);
        //implementing method
        this.database.insertNewProfile(cp);
        System.out.println("The new entry has been added");
    }
    public void deleteCustomerProf(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a last name");
        String cLName= sc.nextLine();
        boolean succ = this.database.deleteProfile(this.getAdminID(),cLName);
        if(succ) System.out.println("Operation successful");
        else{
            System.out.println("either this value does not exist or you do not have permission to change or remove this value \n");
        }
    }

    public void displayCustomerProf(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a last name");
        String cLName= sc.nextLine();
        try{
            CustomerProf cp = this.database.findProfile(this.getAdminID(),cLName);
            System.out.println("Customer Profile:");
            System.out.println("AdminID: " + cp.getadminID());
            System.out.println("First Name: " + cp.getFirstName());
            System.out.println("Last Name: "+ cp.getLastName());
            System.out.println("Address: "+cp.getAddress());
            System.out.println("Telephone Number: "+cp.getPhone());
            System.out.println("Income: "+cp.getIncome());
            System.out.println("Status: "+cp.getStatus());
            System.out.println("Use: "+ cp.getUse());
            System.out.println("Vehicle Information:");
            //model year type method
            System.out.println("Vehicle Model: " + cp.getVehicleInfo().getModel());
            System.out.println("Vehicle Year: " + cp.getVehicleInfo().getYear());
            System.out.println("Vehicle Type: " + cp.getVehicleInfo().getType());
            System.out.println("Vehicle Method: " + cp.getVehicleInfo().getMethod()+"\n");
        }
        catch(Exception e){
            System.out.println("This element does not exist, or you do not have permission to display it");
        }

    }

    public void displayAllCustomerProf(){
        for (CustomerProf cp: this.database.getCustomerList()) {
            if (cp.getadminID().equals(this.adminID)){
                System.out.println("Customer Profile:");
                System.out.println("AdminID: " + cp.getadminID());
                System.out.println("First Name: " + cp.getFirstName());
                System.out.println("Last Name: "+ cp.getLastName());
                System.out.println("Address: "+cp.getAddress());
                System.out.println("Telephone Number: "+cp.getPhone());
                System.out.println("Income: "+cp.getIncome());
                System.out.println("Status: "+cp.getStatus());
                System.out.println("Use: "+ cp.getUse());
                System.out.println("Vehicle Information:");
                System.out.println("Vehicle Model: " + cp.getVehicleInfo().getModel());
                System.out.println("Vehicle Year: " + cp.getVehicleInfo().getYear());
                System.out.println("Vehicle Type: " + cp.getVehicleInfo().getType());
                System.out.println("Vehicle Method: " + cp.getVehicleInfo().getMethod()+"\n");
            }
        }

    }

    public void updateCustomerProfile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a last name");
        String cLName= sc.nextLine();
        CustomerProf cp = this.database.findProfile(this.getAdminID(), cLName);
        System.out.println("Select an attribute to change:");
        System.out.println("1: Address");
        System.out.println("2: Phone");
        System.out.println("3: Use");
        System.out.println("4: Status");
        System.out.println("5: Vehicle Model");
        System.out.println("6: Vehicle Year");
        System.out.println("7: Vehicle Type");
        System.out.println("8: Vehicle Method");
        int choice = sc.nextInt();
        String newInput;
        switch (choice){
            case 1:
                sc.nextLine();
                System.out.println("Enter new input");
                newInput = sc.nextLine();
                cp.updateAddress(newInput);
                break;
            case 2:
                sc.nextLine();
                System.out.println("Enter new input");
                newInput = sc.nextLine();
                cp.updatePhone(newInput);
                break;
            case 3:
                sc.nextLine();
                System.out.println("Enter new input");
                newInput = sc.nextLine();
                cp.updateUse(newInput);
                break;
            case 4:
                sc.nextLine();
                System.out.println("Enter new input");
                newInput = sc.nextLine();
                cp.updateStatus(newInput);
                break;
            case 5:
                sc.nextLine();
                System.out.println("Enter new input");
                newInput = sc.nextLine();
                cp.getVehicleInfo().updateModel(newInput);
                break;
            case 6:
                sc.nextLine();
                System.out.println("Enter new input");
                newInput = sc.nextLine();
                cp.getVehicleInfo().updateYear(newInput);
                break;
            case 7:
                sc.nextLine();
                System.out.println("Enter new input");
                newInput = sc.nextLine();
                cp.getVehicleInfo().updateType(newInput);
                break;
            case 8:
                sc.nextLine();
                System.out.println("Enter new input");
                newInput = sc.nextLine();
                cp.getVehicleInfo().updateMethod(newInput);
                break;
            default:
                System.out.println("invalid choice" +"\n");
        }

    }

    public void writeToDB(){
        this.database.writeAllCustomerProf();
    }

    //fetch and update functions
    public String getAdminID(){
        return this.adminID;
    }
    public CustomerProfDB getDatabase() {return this.database;}
    public void changeAdminID(String newID){
        this.adminID = newID;
    }

}
