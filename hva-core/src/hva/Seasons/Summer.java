package hva.Seasons;

/**
 * Class representing the Summer season.
 * Implements the abstract methods from the Season class to provide 
 * the effort values and biological cycles for deciduous and evergreen trees during Summer.
 */
public class Summer extends SeasonState {

    public Summer(Season season) {
        super (season);
    }

    @Override
    public void nextSeason() {
        getSeason().setSeasonState(new Fall(getSeason()));  // Change to the next state
    }

    /**
     * Retrieves the seasonal effort required for deciduous trees during the Summer.
     * 
     * @return the effort value for deciduous trees in Summer.
     */
    @Override
    public int getDeciduousEffort() {
        return getAllDeciduousEffort()[2]; // Summer is the 4th season in the array (index 2)
    }

    /**
     * Retrieves the seasonal effort required for evergreen trees during the Summer.
     * 
     * @return the effort value for evergreen trees in Summer.
     */
    @Override
    public int getEvergreenEffort() {
        return getAllEvergreenEffort()[2]; // Evergreen trees use the same effort value as deciduous in Summer
    }

    /**
     * Retrieves the biological cycle description for deciduous trees during the Summer.
     * 
     * @return the biological cycle for deciduous trees in Summer.
     */
    @Override
    public String getDeciduousCycle() {
        return getAllDeciduousCycle()[2]; // Summer's biological cycle for deciduous trees
    }

    /**
     * Retrieves the biological cycle description for evergreen trees during the Summer.
     * 
     * @return the biological cycle for evergreen trees in Summer.
     */
    @Override
    public String getEvergreenCycle() {
        return getAllEvergreenCycle()[2]; // Evergreen trees use the same biological cycle as deciduous in Summer
    }
}
