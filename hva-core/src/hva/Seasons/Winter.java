package hva.Seasons;

/**
 * Class representing the Winter season.
 * Implements the abstract methods from the Season class to provide 
 * the effort values and biological cycles for deciduous and evergreen trees during Winter.
 */
public class Winter extends SeasonState {

    private final int CODE = 3;

    /**
     * Constructor for the Winter Class.
     * 
     * @param season
     */
    public Winter(Season season) {
        super(season);
    }

    /**
     * Gets the Winter code.
     */
    public int getCode() { return CODE;}

    /**
     * Advances the season to the next one.
     */
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
        return getAllDeciduousEffort()[CODE]; // Winter is the 4th season in the array (index 3)
    }

    /**
     * Retrieves the seasonal effort required for evergreen trees during the Winter.
     * 
     * @return the effort value for evergreen trees in Winter.
     */
    @Override
    public int getEvergreenEffort() {
        return getAllEvergreenEffort()[CODE]; // Evergreen trees use the same effort value as deciduous in Winter
    }

    /**
     * Retrieves the biological cycle description for deciduous trees during the Winter.
     * 
     * @return the biological cycle for deciduous trees in Winter.
     */
    @Override
    public String getDeciduousCycle() {
        return getAllDeciduousCycle()[CODE]; // Winter's biological cycle for deciduous trees
    }

    /**
     * Retrieves the biological cycle description for evergreen trees during the Winter.
     * 
     * @return the biological cycle for evergreen trees in Winter.
     */
    @Override
    public String getEvergreenCycle() {
        return getAllEvergreenCycle()[CODE]; // Evergreen trees use the same biological cycle as deciduous in Winter
    }
}
