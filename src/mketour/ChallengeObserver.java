/*
 * Course: SWE2410
 * Fall 2024
 * Lab 3 - Tourist Observer
 * Name: Jawadul Chowdhury
 * Submission Date: 9/23/24
 */
package mketour;

import mketour.actors.MobileEntity;
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
