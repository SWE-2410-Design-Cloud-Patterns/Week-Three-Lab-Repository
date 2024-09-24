package mketour;


import javafx.scene.image.Image;
import mketour.actors.MobileEntity;
import java.util.List;


/**
 * class for ArtChallengeObserver
 */
public class ArtChallengeObserver implements ChallengeObserver {

    private static Image artImage = new Image("mketour/img/wood-gatherer.png");

    /**
     * method for updating
     * this is the method where all the business logic is
     * @param museums list of museums
     * @param mobileEntity the person
     */
    @Override
    public void update(List<Museum> museums, MobileEntity mobileEntity) {

        System.out.println("Activated the update!");
        for(Museum museum : museums) {
            if(museum.isTagged(mobileEntity.getLocation())) {
                CityMap.setChallengeText("Works!", 20);
                CityMap.setChallengeImage(artImage, 100, 100);
            }
        }


    }



}
