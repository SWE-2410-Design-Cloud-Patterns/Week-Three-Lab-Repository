/*
 * Course: SWE2410
 * Fall 2024
 * Lab 3 - Tourist Observer
 * Name: Jawadul Chowdhury
 * Submission Date: 9/23/24
 */
package mketour;


import javafx.scene.image.Image;
import mketour.actors.MobileEntity;
import java.util.List;


/**
 * class for ArtChallengeObserver
 */
public class ArtChallengeObserver implements ChallengeObserver {

    private static final Image ART_IMAGE = new Image("mketour/img/wood-gatherer.png");
    private static final int HEIGHT = 100;
    private static final int WIDTH = 100;
    private static final int FONT_SIZE = 20;

    /**
     * method for updating
     * this is the method where all the business logic is
     * @param museums list of museums
     * @param mobileEntity the person
     */
    @Override
    public void update(List<Museum> museums, MobileEntity mobileEntity) {
        for(Museum museum : museums) {
            if(museum.isTagged(mobileEntity.getLocation())) {
                CityMap.setChallengeText("Artistic Works Found: ", FONT_SIZE);
                CityMap.setChallengeImage(ART_IMAGE, HEIGHT, WIDTH);
            }
        }


    }



}
