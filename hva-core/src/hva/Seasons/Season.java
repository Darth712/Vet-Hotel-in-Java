package hva.Seasons;

import java.io.Serializable;

public class Season implements Serializable{



    private SeasonState _state = new Spring(this);



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

    /**
     * Gets the seasonal effort for deciduous trees in the current season.
     * 
     * @return the effort value for deciduous trees.
     */
    public int getDeciduousEffort() {
        return _state.getDeciduousEffort();
    }

    /**
     * Gets the seasonal effort for evergreen trees in the current season.
     * 
     * @return the effort value for evergreen trees.
     */
    public int getEvergreenEffort() {
        return _state.getEvergreenEffort();

    }

    /**
     * Gets the biological cycle stage for deciduous trees in the current season.
     * 
     * @return the biological cycle stage for deciduous trees.
     */
    public String getDeciduousCycle() {
        return _state.getDeciduousCycle();

    }

    /**
     * Gets the biological cycle stage for evergreen trees in the current season.
     * 
     * @return the biological cycle stage for evergreen trees.
     */
    public String getEvergreenCycle() {
        return _state.getEvergreenCycle();
    }
}
