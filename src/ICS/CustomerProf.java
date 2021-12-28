package ICS;

public class CustomerProf {
    String adminID;
    //ID number of administrative personnel that created the profile.
    String firstName;
    //Customer’s first name
    String lastName;
    //Customer’s last name
    String address;
    //Customer’s home address
    String phone;
    //Customer’s home phone number
    float income;
    //Household income
    String status;
    //Use of the vehicle -- “Business” or “Personal” or “Both”
    String use;
    //Current status of the customer -- “Active”, or “Inactive”
    VehicleInfo vehicleInfo;
    //Contains information about the vehicle owned by the customer.


    CustomerProf(String a,String b,String c,String d,String e,float f,String g,
                 String h,VehicleInfo i) {
        adminID = a;
        firstName = b;
        lastName = c;
        address = d;
        phone = e;
        income = f;
        status = g;
        use = h;
        vehicleInfo = i;
    }

    String getadminID()
    {
        return adminID;
    }
    String getFirstName()
    {
        return firstName;
    }
    String getLastName()
    {
        return lastName;
    }
    String getAddress()
    {
        return address;
    }
    String getPhone()
    {
        return phone;
    }
    float getIncome()
    {
        return income;
    }
    String getStatus()
    {
        return status;
    }
    String getUse()
    {
        return use;
    }
    VehicleInfo getVehicleInfo()
    {
        return vehicleInfo;
    }

    void updateFirstName(String i)
    {
        firstName = i;
    }
    void updateLastName(String i)
    {
        lastName = i;
    }
    void updateAddress(String i)
    {
        address = i;
    }
    void updatePhone(String i)
    {
        phone = i;
    }
    void updateIncome(float i)
    {
        income = i;
    }
    void updateStatus(String i)
    {
        status = i;
    }
    void updateUse(String i){use = i;}
    void updateVehicleInfo(VehicleInfo i)
    {
        vehicleInfo = i;
    }
}

