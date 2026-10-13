

public class Zone {
    


private String zoneName;
private Truck truck;


public Zone(String zoneName)
{
    this.zoneName = zoneName;
    truck = null;
}

public void addTruck(String truckId, String truckName, String cuisine)
{
    truck = new Truck(truckId, truckName, cuisine);

}

public void removeTruck()
{
    truck = null;
}

public void updateTruckRating(int newRating)
{
    if (truck !=null)
    {
        truck.updateRating(newRating);
    }
   
}

public String getZoneName()
{
    return zoneName;
}

public boolean hasTruck()
{
    return truck != null;
}

public String getTruckId()
{
    if (truck != null)
    {
        return truck.getId();
    }
    else
    {
        return "";
    }
}

public String toString()
{
    if (truck != null)
    {
        return ("Zone[Name: ") + zoneName + "\n" + truck.toString() + "\n]";
    }
    else
    {
        return ("Zone[Name :") + zoneName + "\n No Truck has been assinged to this Zone\n]";
    }

}


}