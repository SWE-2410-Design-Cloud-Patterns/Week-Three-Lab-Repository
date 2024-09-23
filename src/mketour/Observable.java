package mketour;

public interface Observable {

    /**
     * Method for adding a observer
     * @param observer observer
     */
    void registerObserver(ChallengeObserver observer);

    /**
     * Method for removing an observer
     * @param observer observer
     */
    void unRegisterObserver(ChallengeObserver observer);

    /**
     * method for notifying a observer
     */
    void notifyObservers();
}
