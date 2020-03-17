package BusinessLogicLayer;

public class Disease
{
    private String name;
    private String discription;
    public Disease(String name, String discription)
    {
        this.name = name;
        this.discription = discription;
    }
    public String getname()
    {
        return name;
    }
    public String getDiscription()
    {
        return discription;
    }
}
