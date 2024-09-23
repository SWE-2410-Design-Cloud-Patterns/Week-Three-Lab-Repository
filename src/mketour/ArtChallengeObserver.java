package mketour;


import static mketour.CityMap.setChallengeImage;
import static mketour.CityMap.setChallengeText;

/**
 * class for ArtChallengeObserver
 */
public class ArtChallengeObserver implements ChallengeObserver {


    /**
     * method for updating
     */
    @Override
    public void update() {
        setChallengeText();
        setChallengeImage();


    }



}
