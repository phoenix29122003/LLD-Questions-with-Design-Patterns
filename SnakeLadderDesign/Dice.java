package SnakeLadderDesign;

import java.util.Random;

public class Dice {
    public Integer numberOfFaces;

    public Dice(Integer numberOfFaces){
        this.numberOfFaces=numberOfFaces;
    }

    public Integer rollDice(){
        Random random=new Random();
        Integer diceFaceNumber=random.nextInt(numberOfFaces)+1;
        return diceFaceNumber;
    }
}
