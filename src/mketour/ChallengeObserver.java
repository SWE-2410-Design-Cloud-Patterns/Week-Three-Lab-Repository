package mketour;

import mketour.actors.MobileEntity;
import mketour.actors.Person;
import java.util.List;

/**
 * interface class for ChallengeObserver
 */
public interface ChallengeObserver {

    /**
     * method for updating
     * @param museum museum
     * @param mobileEntity person
     */
    void update(List<Museum> museum, MobileEntity mobileEntity);

}
