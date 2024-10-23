package hva.Seasons;

/**
 * Class representing the Spring season.
 * Implements the abstract methods from the Season class to provide 
 * the effort values and biological cycles for deciduous and evergreen trees during Spring.
 */
public class Spring extends SeasonState{

    private final int CODE = 0;

    /**
     * Constructor for the Spring Class.
     * 
     * @param season
     */
    public Spring(Season season) {
        super(season);
    }

    /**
     * Gets the Spring code.
     */
    public int getCode() { return CODE;}

    /**
    * Advances the season to the next one.
    */
    @Override
    public void nextSeason() {
        getSeason().setSeasonState(new Summer(getSeason()));  // Change to the next state
    }

    /**
     * Retrieves the seasonal effort required for deciduous trees during the Spring.
     * 
     * @return the effort value for deciduous trees in Spring.
     */
    @Override
    public int getDeciduousEffort() {
        return getAllDeciduousEffort()[CODE]; // Spring is the 4th season in the array (index 0)
    }

    /**
     * Retrieves the seasonal effort required for evergreen trees during the Spring.
     * 
     * @return the effort value for evergreen trees in Spring.
     */
    @Override
    public int getEvergreenEffort() {
        return getAllEvergreenEffort()[CODE]; // Evergreen trees use the same effort value as deciduous in Spring
    }

    /**
     * Retrieves the biological cycle description for deciduous trees during the Spring.
     * 
     * @return the biological cycle for deciduous trees in Spring.
     */
    @Override
    public String getDeciduousCycle() {
        return getAllDeciduousCycle()[CODE]; // Spring's biological cycle for deciduous trees
    }

    /**
     * Retrieves the biological cycle description for evergreen trees during the Spring.
     * 
     * @return the biological cycle for evergreen trees in Spring.
     */
    @Override
    public String getEvergreenCycle() {
        return getAllEvergreenCycle()[CODE]; // Evergreen trees use the same biological cycle as deciduous in Spring
    }
}
