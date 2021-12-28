package ICS;
import java.io.*;

import java.util.*;
import java.util.Locale;

public class CustomerProfDB {
    //fields
    private int numCustomer;
    private int currentCustomerIndex;
    private String filename;
    private CustomerProf[] customerList = {};

    public CustomerProfDB(String filename){
        //Constructor
        this.filename = filename;
        initializeDatabase(this.filename);

    }

    //DONE
    public void insertNewProfile(CustomerProf cp){

        int n = this.customerList.length;
        CustomerProf[] newList = new CustomerProf[n+1];
        for(int i =0; i<n; i++){
            newList[i] = this.customerList[i];
        }
        newList[n] = cp;
        this.customerList = newList;
    }

    //DONE
    public boolean deleteProfile(String adminID, String lName){
        boolean flag = false;
        int n = this.customerList.length;
        CustomerProf[] newList = new CustomerProf[n-1];
        for(int i =0, j = 0; i<n; i++){
            if (!(this.customerList[i].getadminID().equals(adminID) && this.customerList[i].getLastName().equals(lName))){
                try{
                    newList[j++] = this.customerList[i];
                }
                catch (Exception e){
                    return false;
                }
            }
            else{
                flag = true;
            }

        }
        this.customerList = newList;
        return flag;
    }
    //DONE
    public CustomerProf findProfile(String adminID, String lName){
        int n = this.customerList.length;
        for(int i =0; i<n; i++){
            if (this.customerList[i].getadminID().equals(adminID) && this.customerList[i].getLastName().equals(lName))
                return this.customerList[i];
        }
        throw new NoSuchElementException("This element does not exist, or you do not have permission to see it");

    }

//DONE
    public void writeAllCustomerProf(){
        File oldFile = new File(this.filename);
        oldFile.delete();
        File myObj = new File("tempfile.txt");

        try {
            FileWriter myWriter = new FileWriter("tempfile.txt");
            for (CustomerProf cp: this.customerList){
                myWriter.write(cp.getadminID());
                myWriter.write("\n");
                myWriter.write(cp.getFirstName());
                myWriter.write("\n");
                myWriter.write(cp.getLastName());
                myWriter.write("\n");
                myWriter.write(cp.getAddress());
                myWriter.write("\n");
                myWriter.write(cp.getPhone());
                myWriter.write("\n");
                myWriter.write(Float.toString(cp.getIncome()));
                myWriter.write("\n");
                myWriter.write(cp.getStatus());
                myWriter.write("\n");
                myWriter.write(cp.getUse());
                myWriter.write("\n");
                myWriter.write(cp.getVehicleInfo().getModel());
                myWriter.write("\n");
                myWriter.write(cp.getVehicleInfo().getYear());
                myWriter.write("\n");
                myWriter.write(cp.getVehicleInfo().getType());
                myWriter.write("\n");
                myWriter.write(cp.getVehicleInfo().getMethod());
                myWriter.write("\n");

            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        myObj.renameTo(oldFile);
    }

//DONE
    private void initializeDatabase(String fName){
        // ------------USERINFO-------------
        //CustomerProf Obj
        CustomerProf cp;
        //adminID
        String adminID;
        //firstname
        String firstName;
        //lastname
        String lastName;
        //address
        String address;
        //telephone
        String telephone;
        //income
        float income;
        //status
        String status;
        //use
        String use;

        // ------------VEHICLEINFO-------------
        //VehicleInfo Obj
        VehicleInfo v;
        //model
        String model;
        //year
        String year;
        //type
        String type;
        //method
        String method;

        //array containing single value
        CustomerProf[] append;

        File fileObj = new File(this.filename);
        try
        {
            if(fileObj.createNewFile()){

                return;
            }

            else
            {
                try
                {
                    Scanner fileSC = new Scanner(new File(this.filename));
                    while(fileSC.hasNextLine())
                    {
                        adminID = fileSC.nextLine();
                        firstName = fileSC.nextLine();
                        lastName = fileSC.nextLine();
                        address = fileSC.nextLine();
                        telephone = fileSC.nextLine();
                        income = Float.parseFloat(fileSC.nextLine());
                        status = fileSC.nextLine();
                        use = fileSC.nextLine();
                        model = fileSC.nextLine();
                        year = fileSC.nextLine();
                        type = fileSC.nextLine();
                        method = fileSC.nextLine();

                        v = new VehicleInfo(model,year,type,method);
                        cp = new CustomerProf(adminID,firstName,lastName,address,telephone,income,status,use, v);
                        append = new CustomerProf[1];
                        append[0] = cp;

                        this.customerList = concat(this.customerList,append);

                    }

                }

                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    //helper method
    private CustomerProf[] concat(CustomerProf[] arr1, CustomerProf[] arr2){
        int arr1len = arr1.length;
        int arr2len = arr2.length;
        int n = arr1len+ arr2len;
        CustomerProf[] result = new CustomerProf[n];
        if (arr1len == 0)
        {
            result = arr2;
            return result;
        }
        for (int i = 0; i < arr1len; i++)
        {
            result[i] = arr1[i];
        }

        result[n-1] = arr2[0];
        return result;
    }
    public CustomerProf[] getCustomerList(){
        return this.customerList;
    }
}
