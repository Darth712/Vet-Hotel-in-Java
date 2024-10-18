package hva.Seasons;

/**
 * Class representing the Winter season.
 * Implements the abstract methods from the Season class to provide 
 * the effort values and biological cycles for deciduous and evergreen trees during Winter.
 */
public class Winter extends SeasonState {

    public Winter(Season season) {
        super (season);
    }

    @Override
    public void nextSeason() {
        getSeason().setSeasonState(new Spring(getSeason()));  // Change to the next state
    }
    /**
     * Gets the seasonal effort for deciduous trees in Winter.
     * 
     * @return the effort value for deciduous trees in Winter.
     */
    @Override
    public int getDeciduousEffort() {
        return DECIDUOUS_SEASONAL_EFFORT[0]; // Winter effort for deciduous trees
    }

    /**
     * Gets the seasonal effort for evergreen trees in Winter.
     * 
     * @return the effort value for evergreen trees in Winter.
     */
    @Override
    public int getEvergreenEffort() {
        return DECIDUOUS_SEASONAL_EFFORT[0]; // Winter effort for evergreen trees (note: should use EVERGREEN_SEASONAL_EFFORT if applicable)
    }

    /**
     * Gets the biological cycle stage for deciduous trees in Winter.
     * 
     * @return the biological cycle stage for deciduous trees in Winter.
     */
    @Override
    public String getDeciduousCycle() {
        return DECIDUOUS_BIO_CYCLE[0]; // Winter biological cycle for deciduous trees
    }

    /**
     * Gets the biological cycle stage for evergreen trees in Winter.
     * 
     * @return the biological cycle stage for evergreen trees in Winter.
     */
    @Override
    public String getEvergreenCycle() {
        return DECIDUOUS_BIO_CYCLE[0]; // Winter biological cycle for evergreen trees (note: should use EVERGREEN_BIO_CYCLE if applicable)
    }
}
