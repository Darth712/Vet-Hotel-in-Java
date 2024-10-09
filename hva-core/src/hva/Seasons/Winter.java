package hva.Seasons;

public class Winter extends Season{
    @Override
    public int getDeciduousEffort() {return DECIDUOUS_SEASONAL_EFFORT[0];}
    @Override
    public int getEvergreenEffort() {return DECIDUOUS_SEASONAL_EFFORT[0];}
    @Override
    public String getDeciduousCycle() {return DECIDUOUS_BIO_CYCLE[0];}
    @Override
    public String getEvergreenCycle() {return DECIDUOUS_BIO_CYCLE[0];}
    
}
