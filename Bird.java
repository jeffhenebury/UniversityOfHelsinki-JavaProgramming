/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeff
 */
public class Bird {

    private String commonName;
    private String latinName;
    private int numberOfObservations;

    public Bird(String commonName, String latinName) {
        this.commonName = commonName;
        this.latinName = latinName;
        this.numberOfObservations = 0;
    }

    public void setNumberOfObservations(int numberOfObservations) {
        this.numberOfObservations = numberOfObservations;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public int getNumberOfObservations() {
        return numberOfObservations;
    }

    @Override
    public String toString() {
        if (this.getNumberOfObservations() == 1) {
            return commonName + " (" + latinName + "): " + numberOfObservations + " observation";
        } else {
            return commonName + " (" + latinName + "): " + numberOfObservations + " observations";
        }
    }
}
