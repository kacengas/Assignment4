package Assigment4.model;

public abstract class  Valuables
{
    protected String type;

    protected Valuables (String type)
    {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
