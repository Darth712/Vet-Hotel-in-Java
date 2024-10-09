package hva.Seasons;

public abstract class Season {
    // começam todos no inverno
    protected static final int[] DECIDUOUS_SEASONAL_EFFORT = {0, 1, 2, 5};
    protected static final int[] EVERGREEN_SEASONAL_EFFORT = {2, 1, 1, 1}; 
    protected static final String[] DECIDUOUS_BIO_CYCLE = {"SEMFOLHAS","GERARFOLHAS","COMFOLHAS","LARGARFOLHAS"};
    protected static final String[] EVERGREEN_BIO_CYCLE = {"LARGARFOLHAS","GERARFOLHAS","COMFOLHAS","COMFOLHAS"};

    public abstract int getDeciduousEffort();
    public abstract int getEvergreenEffort();
    public abstract String getDeciduousCycle();
    public abstract String getEvergreenCycle();

    
}
