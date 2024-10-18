package hva.Seasons;

public class Season {
    private SeasonState _state;

    /**
     * Constructs a season with the specified state
     * 
     * @param state
     */
    public Season(SeasonState state) {
        _state = state;
    }

    /**
     * Advances the Season state to the next one
     * 
     */
    public void nextSeason () {
        _state.nextSeason();
    }

    /**
     * Gets the Season of the state
     * 
     * @return Season
     */
    public Season getSeasonState(){
        return _state.getSeason();
    }

    /**
     * Sets the Season state to a new one
     * 
     * @param state
     */
    public void setSeasonState(SeasonState state) {
        _state = state;
    }
}
