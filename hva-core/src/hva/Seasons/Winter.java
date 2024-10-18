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
     * Retrieves the seasonal effort required for deciduous trees during the Winter.
     * 
     * @return the effort value for deciduous trees in Winter.
     */
    @Override
    public int getDeciduousEffort() {
        return getAllDeciduousEffort()[0]; // Winter is the 4th season in the array (index 0)
    }

    /**
     * Retrieves the seasonal effort required for evergreen trees during the Winter.
     * 
     * @return the effort value for evergreen trees in Winter.
     */
    @Override
    public int getEvergreenEffort() {
        return getAllEvergreenEffort()[0]; // Evergreen trees use the same effort value as deciduous in Winter
    }

    /**
     * Retrieves the biological cycle description for deciduous trees during the Winter.
     * 
     * @return the biological cycle for deciduous trees in Winter.
     */
    @Override
    public String getDeciduousCycle() {
        return getAllDeciduousCycle()[0]; // Winter's biological cycle for deciduous trees
    }

    /**
     * Retrieves the biological cycle description for evergreen trees during the Winter.
     * 
     * @return the biological cycle for evergreen trees in Winter.
     */
    @Override
    public String getEvergreenCycle() {
        return getAllEvergreenCycle()[0]; // Evergreen trees use the same biological cycle as deciduous in Winter
    }
}
