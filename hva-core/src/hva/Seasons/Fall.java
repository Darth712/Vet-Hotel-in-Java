package hva.Seasons;

/**
 * Class representing the Fall season, extending the abstract Season class.
 * Contains methods to get effort values and biological cycles for deciduous
 * and evergreen trees during this season.
 */
public class Fall extends SeasonState {

    private final int CODE = 2;

    public Fall(Season season) {
        super(season);
    }

    public int getCode() { return CODE;}



    @Override
    public void nextSeason() {
        getSeason().setSeasonState(new Winter(getSeason()));  // Change to the next state
    }

    /**
     * Retrieves the seasonal effort required for deciduous trees during the Fall.
     * 
     * @return the effort value for deciduous trees in Fall.
     */
    @Override
    public int getDeciduousEffort() {
        return getAllDeciduousEffort()[CODE]; // Fall is the 3th season in the array (index 2)
    }

    /**
     * Retrieves the seasonal effort required for evergreen trees during the Fall.
     * 
     * @return the effort value for evergreen trees in Fall.
     */
    @Override
    public int getEvergreenEffort() {
        return getAllEvergreenEffort()[CODE]; // Evergreen trees use the same effort value as deciduous in Fall
    }

    /**
     * Retrieves the biological cycle description for deciduous trees during the Fall.
     * 
     * @return the biological cycle for deciduous trees in Fall.
     */
    @Override
    public String getDeciduousCycle() {
        return getAllDeciduousCycle()[CODE]; // Fall's biological cycle for deciduous trees
    }

    /**
     * Retrieves the biological cycle description for evergreen trees during the Fall.
     * 
     * @return the biological cycle for evergreen trees in Fall.
     */
    @Override
    public String getEvergreenCycle() {
        return getAllEvergreenCycle()[CODE]; // Evergreen trees use the same biological cycle as deciduous in Fall
    }
}
