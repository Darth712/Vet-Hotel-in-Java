package hva.Seasons;

public class Fall extends Season{
    @Override
    public int getDeciduousEffort() {return DECIDUOUS_SEASONAL_EFFORT[3];}
    @Override
    public int getEvergreenEffort() {return DECIDUOUS_SEASONAL_EFFORT[3];}
    @Override
    public String getDeciduousCycle() {return DECIDUOUS_BIO_CYCLE[3];}
    @Override
    public String getEvergreenCycle() {return DECIDUOUS_BIO_CYCLE[3];}

    

    
}
