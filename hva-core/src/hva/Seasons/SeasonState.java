package hva.Seasons;

import java.io.Serializable;
/**
 * Abstract class representing a Season.
 * Provides abstract methods to get the effort values and biological cycles for both deciduous and evergreen trees.
 * The data is stored in arrays that describe the behavior of trees across the four seasons.
 */
public abstract class SeasonState implements Serializable{

    // Seasonal effort required for deciduous trees, with the seasons starting from Winter.
    private final int[] DECIDUOUS_SEASONAL_EFFORT = {1, 2, 5, 0}; // Spring, Summer, Fall, Winter
    // Seasonal effort required for evergreen trees, with the seasons starting from Winter.
    private final int[] EVERGREEN_SEASONAL_EFFORT = {1, 1, 1, 2}; // Spring, Summer, Fall, Winter

    // Biological cycles for deciduous trees across the seasons.
    private final String[] DECIDUOUS_BIO_CYCLE = {"GERARFOLHAS", "COMFOLHAS", "LARGARFOLHAS", "SEMFOLHAS"};
    // Biological cycles for evergreen trees across the seasons.
    private final String[] EVERGREEN_BIO_CYCLE = {"GERARFOLHAS", "COMFOLHAS", "COMFOLHAS", "LARGARFOLHAS"};

    

    private Season _season;

   

    /**
     * Constructs a Season State with the specified season.
     * 
     * @param season
     */
    public SeasonState (Season season) {
        _season = season;
    }

    /**
     * Gets the code from a certain season.
     * 
     * @return
     */
    public abstract int getCode();
    /**
     * Advances the current season to the next one.
     */
    public abstract void nextSeason();


    /**
     * Gets the season.
     * 
     * @return _season
     */
    public Season getSeason() {
        return _season;
    }
    /**
     * Sets the season state to a new one.
     * 
     * @param season
     */
    public void setSeason(Season season) {
        _season = season;
    }
    
    /**
 * Retrieves the seasonal cleaning effort for all deciduous trees.
 * 
 * @return An array of integers representing the seasonal cleaning effort for deciduous trees.
 */
public int[] getAllDeciduousEffort() {
    return DECIDUOUS_SEASONAL_EFFORT;
}

/**
 * Retrieves the seasonal cleaning effort for all evergreen trees.
 * 
 * @return An array of integers representing the seasonal cleaning effort for evergreen trees.
 */
public int[] getAllEvergreenEffort() {
    return EVERGREEN_SEASONAL_EFFORT;
}

/**
 * Retrieves the biological cycle for all deciduous trees.
 * 
 * @return An array of strings representing the biological cycle for deciduous trees.
 */
public String[] getAllDeciduousCycle() {
    return DECIDUOUS_BIO_CYCLE;
}

/**
 * Retrieves the biological cycle for all evergreen trees.
 * 
 * @return An array of strings representing the biological cycle for evergreen trees.
 */
public String[] getAllEvergreenCycle() {
    return EVERGREEN_BIO_CYCLE;
}

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
