package ICS;

public class VehicleInfo {
    String model;
    //Name of the vehicle model
    String year;
    //Year in which the vehicle was manufactured.
    String type;
    //Type of vehicle, must select from: sedan, hatchback, luxury, sport, other
    String method;
    //How the vehicle was acquired -- must select from: new, certified pre-owned, used, other

    VehicleInfo(String a ,String b ,String c ,String d) {
        model = a;
        year = b;
        type = c;
        method = d;
    }

    String getModel()
    {
        return model;
    }
    String getYear()
    {
        return year;
    }
    String getType()
    {
        return type;
    }
    String getMethod()
    {
        return method;
    }

    void updateModel (String i)
    {
        model = i;
    }
    void updateYear (String i)
    {
        year = i;
    }
    void updateType (String i)
    {
        type = i;
    }
    void updateMethod (String i)
    {
        method = i;
    }
}
