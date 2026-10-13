public class Truck
{
    private String truckId;
    private String truckName;
    private String cuisine;
    private int rating;
    private String tier;


    public Truck(String truckId, String truckName, String cuisine)
    {
        this.truckId = truckId;
        this.truckName = truckName;
        this.cuisine = cuisine;
        rating = 0;
        setTier();
    }

    private void setTier()
    {
        if (rating <= 1)
        {
            tier = "Trainee";
        }
        else if (rating == 2)
        {
            tier = "Chef";
        }
        else if (rating <= 4)
        {
            tier = "Chief";
        } 
        else
        {
            tier = "Master";
        }  
    }


public void updateRating(int newRating)
{
    if (newRating >= 0 && newRating <= 5)
    {
        rating = newRating;
        setTier();
    }
}

public String getId()
{
    return truckId;
}

public String getName()
{
    return truckName;
}

public String getCuisine()
{
    return cuisine;
}

public int getRating()
{
    return rating;
}

public String getTier()
{
    return tier;
}

public String toString()
{
    return "Truck[ Id: " + truckId + " Name: " + truckName + " Cuisine " + cuisine + " \n Rating: " + rating + " Tier: " + tier + "";

}

}

