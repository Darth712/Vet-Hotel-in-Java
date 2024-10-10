package hva.Seasons;

/**
 * Class representing the Summer season.
 * Implements the abstract methods from the Season class to provide 
 * the effort values and biological cycles for deciduous and evergreen trees during Summer.
 */
public class Summer extends Season {

    /**
     * Gets the seasonal effort for deciduous trees in Summer.
     * 
     * @return the effort value for deciduous trees in Summer.
     */
    @Override
    public int getDeciduousEffort() {
        return DECIDUOUS_SEASONAL_EFFORT[2]; // Summer effort for deciduous trees
    }

    /**
     * Gets the seasonal effort for evergreen trees in Summer.
     * 
     * @return the effort value for evergreen trees in Summer.
     */
    @Override
    public int getEvergreenEffort() {
        return DECIDUOUS_SEASONAL_EFFORT[2]; // Summer effort for evergreen trees (note: should use EVERGREEN_SEASONAL_EFFORT if applicable)
    }

    /**
     * Gets the biological cycle stage for deciduous trees in Summer.
     * 
     * @return the biological cycle stage for deciduous trees in Summer.
     */
    @Override
    public String getDeciduousCycle() {
        return DECIDUOUS_BIO_CYCLE[2]; // Summer biological cycle for deciduous trees
    }

    /**
     * Gets the biological cycle stage for evergreen trees in Summer.
     * 
     * @return the biological cycle stage for evergreen trees in Summer.
     */
    @Override
    public String getEvergreenCycle() {
        return DECIDUOUS_BIO_CYCLE[2]; // Summer biological cycle for evergreen trees (note: should use EVERGREEN_BIO_CYCLE if applicable)
    }
}
