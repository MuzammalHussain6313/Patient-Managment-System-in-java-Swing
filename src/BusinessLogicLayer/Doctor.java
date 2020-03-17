package BusinessLogicLayer;

public class Doctor
{
    private String name;
    private String spacialization;
    public Doctor(String name,String spacialization)
    {
        this.name = name;
        this.spacialization = spacialization;
    }
    public void setSpacialization(String spacialization)
    {
        this.spacialization=spacialization;
    }
    public String getName()
    {
        return name;
    }
    public String getSpacialization()
    {
        return spacialization;
    }
}
