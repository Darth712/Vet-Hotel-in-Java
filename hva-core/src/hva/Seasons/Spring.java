package hva.Seasons;

public class Spring extends Season{
    @Override
    public int getDeciduousEffort() {return DECIDUOUS_SEASONAL_EFFORT[1];}
    @Override
    public int getEvergreenEffort() {return DECIDUOUS_SEASONAL_EFFORT[1];}
    @Override
    public String getDeciduousCycle() {return DECIDUOUS_BIO_CYCLE[1];}
    @Override
    public String getEvergreenCycle() {return DECIDUOUS_BIO_CYCLE[1];}

}
