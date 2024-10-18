package hva.Seasons;

/**
 * Class representing the Spring season.
 * Implements the abstract methods from the Season class to provide 
 * the effort values and biological cycles for deciduous and evergreen trees during Spring.
 */
public class Spring extends SeasonState {

    public Spring(Season season) {
        super(season);
    }

    @Override
    public void nextSeason() {
        getSeason().setSeasonState(new Summer(getSeason()));  // Change to the next state
    }

    /**
     * Gets the seasonal effort for deciduous trees in Spring.
     * 
     * @return the effort value for deciduous trees in Spring.
     */
    @Override
    public int getDeciduousEffort() {
        return DECIDUOUS_SEASONAL_EFFORT[1]; // Spring effort for deciduous trees
    }

    /**
     * Gets the seasonal effort for evergreen trees in Spring.
     * 
     * @return the effort value for evergreen trees in Spring.
     */
    @Override
    public int getEvergreenEffort() {
        return DECIDUOUS_SEASONAL_EFFORT[1]; // Spring effort for evergreen trees (note: should use EVERGREEN_SEASONAL_EFFORT if applicable)
    }

    /**
     * Gets the biological cycle stage for deciduous trees in Spring.
     * 
     * @return the biological cycle stage for deciduous trees in Spring.
     */
    @Override
    public String getDeciduousCycle() {
        return DECIDUOUS_BIO_CYCLE[1]; // Spring biological cycle for deciduous trees
    }

    /**
     * Gets the biological cycle stage for evergreen trees in Spring.
     * 
     * @return the biological cycle stage for evergreen trees in Spring.
     */
    @Override
    public String getEvergreenCycle() {
        return DECIDUOUS_BIO_CYCLE[1]; // Spring biological cycle for evergreen trees (note: should use EVERGREEN_BIO_CYCLE if applicable)
    }
}
