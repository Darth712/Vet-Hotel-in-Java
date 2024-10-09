package hva.Seasons;

public class Summer extends Season{
    @Override
    public int getDeciduousEffort() {return DECIDUOUS_SEASONAL_EFFORT[2];}
    @Override
    public int getEvergreenEffort() {return DECIDUOUS_SEASONAL_EFFORT[2];}
    @Override
    public String getDeciduousCycle() {return DECIDUOUS_BIO_CYCLE[2];}
    @Override
    public String getEvergreenCycle() {return DECIDUOUS_BIO_CYCLE[2];}
    
}
