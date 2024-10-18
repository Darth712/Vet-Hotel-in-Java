package hva.Seasons;

/**
 * Class representing the Summer season.
 * Implements the abstract methods from the Season class to provide 
 * the effort values and biological cycles for deciduous and evergreen trees during Summer.
 */
public class Summer extends SeasonState {

    private final int CODE = 1;

    public Summer(Season season) {
        super(season);
    }

    public int getCode() { return CODE;}

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
        return getAllDeciduousEffort()[CODE]; // Summer is the 2nd season in the array (index 1)
    }

    /**
     * Retrieves the seasonal effort required for evergreen trees during the Summer.
     * 
     * @return the effort value for evergreen trees in Summer.
     */
    @Override
    public int getEvergreenEffort() {
        return getAllEvergreenEffort()[CODE]; // Evergreen trees use the same effort value as deciduous in Summer
    }

    /**
     * Retrieves the biological cycle description for deciduous trees during the Summer.
     * 
     * @return the biological cycle for deciduous trees in Summer.
     */
    @Override
    public String getDeciduousCycle() {
        return getAllDeciduousCycle()[CODE]; // Summer's biological cycle for deciduous trees
    }

    /**
     * Retrieves the biological cycle description for evergreen trees during the Summer.
     * 
     * @return the biological cycle for evergreen trees in Summer.
     */
    @Override
    public String getEvergreenCycle() {
        return getAllEvergreenCycle()[CODE]; // Evergreen trees use the same biological cycle as deciduous in Summer
    }
}
