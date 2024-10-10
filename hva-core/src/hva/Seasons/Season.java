package hva.Seasons;

/**
 * Abstract class representing a Season.
 * Provides abstract methods to get the effort values and biological cycles for both deciduous and evergreen trees.
 * The data is stored in static arrays that describe the behavior of trees across the four seasons.
 */
public abstract class Season {

    // Seasonal effort required for deciduous trees, with the seasons starting from Winter.
    protected static final int[] DECIDUOUS_SEASONAL_EFFORT = {0, 1, 2, 5}; // Winter, Spring, Summer, Fall
    // Seasonal effort required for evergreen trees, with the seasons starting from Winter.
    protected static final int[] EVERGREEN_SEASONAL_EFFORT = {2, 1, 1, 1}; // Winter, Spring, Summer, Fall

    // Biological cycles for deciduous trees across the seasons.
    protected static final String[] DECIDUOUS_BIO_CYCLE = {"SEMFOLHAS", "GERARFOLHAS", "COMFOLHAS", "LARGARFOLHAS"};
    // Biological cycles for evergreen trees across the seasons.
    protected static final String[] EVERGREEN_BIO_CYCLE = {"LARGARFOLHAS", "GERARFOLHAS", "COMFOLHAS", "COMFOLHAS"};

    /**
     * Gets the seasonal effort for deciduous trees in the current season.
     * 
     * @return the effort value for deciduous trees.
     */
    public abstract int getDeciduousEffort();

    /**
     * Gets the seasonal effort for evergreen trees in the current season.
     * 
     * @return the effort value for evergreen trees.
     */
    public abstract int getEvergreenEffort();

    /**
     * Gets the biological cycle stage for deciduous trees in the current season.
     * 
     * @return the biological cycle stage for deciduous trees.
     */
    public abstract String getDeciduousCycle();

    /**
     * Gets the biological cycle stage for evergreen trees in the current season.
     * 
     * @return the biological cycle stage for evergreen trees.
     */
    public abstract String getEvergreenCycle();
}
