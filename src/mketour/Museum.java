/*
 * Course: SWE2410
 * Fall 2024
 * Lab 3 - Tourist Observer
 * Name: Jawadul Chowdhury
 * Submission Date: 9/23/24
 */

package mketour;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import mketour.actors.MobileEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * A rectangular area representing an art museum.
 *
 * The Museum is similar to a MobileEntity, except that it does not move
 * and it has a rectangular rather than circular tag area.
 */
public class Museum implements Taggable, Observable {

    private List<ChallengeObserver> observers = new ArrayList<>();
    private final CityMap cityMap;
    public static final int MUSEUM_WIDTH = 40;
    public static final int MUSEUM_HEIGHT = 50;
    public static final int MUSEUM_LEFT_CORNER = 500-64;
    public static final int MUSEUM_TOP_CORNER = 250+3;
    private final Rectangle area;

    public Museum(CityMap cityMap) {
        area = new Rectangle(MUSEUM_WIDTH, MUSEUM_HEIGHT);
        area.setStroke(Color.RED);
        area.setFill(Color.RED.deriveColor(1, 1, 1, 0.2));
        area.relocate(MUSEUM_LEFT_CORNER, MUSEUM_TOP_CORNER);

        cityMap.addNodeToMap(area);
        cityMap.addTaggableToMap(this);
        this.cityMap = cityMap;
    }

    /**
     * method for adding a observer
     * @param observer observer
     */
    public void registerObserver(ChallengeObserver observer) {
        observers.add(observer);
        System.out.println("Works!");
    }

    /**
     * method for removing a observer
     * @param observer observer
     */
    public void unRegisterObserver(ChallengeObserver observer) {
        observers.remove(observer);
        System.out.println("Doesn't Work!");
    }

    /**
     * method for notifying the observers
     */
    public void notifyObservers() {
        for(ChallengeObserver observer : observers) {
            System.out.println("Notified the observer, activated the update!");
            observer.update(CityMap.getMuseums(), CityMap.getMainCharacter());
        }
    }

    /**
     * Determines if point falls within the rectangular region shown on the map
     * @param location The location to check
     * @return true of within region
     */
    @Override
    public boolean isTagged(Point2D location) {
        return location.getX() > MUSEUM_LEFT_CORNER
            && location.getY() > MUSEUM_TOP_CORNER
            && location.getX() < MUSEUM_LEFT_CORNER + MUSEUM_WIDTH
            && location.getY() < MUSEUM_TOP_CORNER + MUSEUM_HEIGHT;
    }

    /**
     * Respond to being tagged by another entity.
     * @param entity The entity performing the tagging.
     */
    @Override
    public void taggedBy(MobileEntity entity) {

        // works on getting the main character
        MobileEntity mainCharacter = CityMap.getMainCharacter();

        // museum getting tagged by person
        if(entity.isTagged(mainCharacter.getLocation())) {
            notifyObservers();
        }

        if(CityMap.DEBUG_LEVEL > 0)
            System.out.println(this + " was tagged by " + entity);
    }



    /**
     * @return a unique description of this Museum, including a hashcode
     */
    @Override
    public String toString() {
        return "Museum "+Integer.toHexString(super.hashCode());
    }
}
