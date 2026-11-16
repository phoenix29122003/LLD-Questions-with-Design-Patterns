package SnakeLadderDesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeLadder {
    public Board board;
    public Map<Integer,Integer>ladderMap;
    public Map<Integer,Integer>snakeMap;
    public Dice dice;
    public Map<Player,Integer>playerMap;
    public Queue<Player>players;

    public SnakeLadder(Integer winningIdx, Integer numberOfFaces){
        this.board=new Board(winningIdx);
        this.ladderMap=new HashMap<>();
        this.snakeMap=new HashMap<>();
        this.dice=new Dice(numberOfFaces);
        this.playerMap=new HashMap<>();
        this.players=new LinkedList<>();
    }

    public void addPlayers(Player player){
        this.players.add(player);
        this.playerMap.put(player, 0);
    }

    public void initializeGame(){
        snakeMap.put(99, 54);
        snakeMap.put(70, 55);
        snakeMap.put(52, 42);
        snakeMap.put(25, 2);
        snakeMap.put(95, 72);

        ladderMap.put(6, 25);
        ladderMap.put(11, 40);
        ladderMap.put(60, 85);
        ladderMap.put(46, 90);
        ladderMap.put(17, 69);
    }

    public void printBoard(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                Integer idx=10*i+j+1;
                if(ladderMap.containsKey(idx)==false && snakeMap.containsKey(idx)==false){
                    System.out.print(idx);
                    System.out.print(" ");
                }
                else if(ladderMap.containsKey(idx)){
                    System.out.print("L");
                    System.out.print(" ");
                }
                else if(snakeMap.containsKey(idx)){
                    System.out.print("S");
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printPlayerCurrentPosition(Map<Player,Integer>playerMap, Player player){
        Integer idx=playerMap.get(player);
        System.out.println(player.name + " has reached to: "+idx);
    }

    public void startGame(){
        while(players.size()!=0){
            Player currentPlayer=players.poll();
            Integer diceFaceValue=dice.rollDice();
            Integer playerCurrentPosition=playerMap.get(currentPlayer);
            Integer newPosition = diceFaceValue+playerCurrentPosition;
            while(newPosition>100){
                diceFaceValue=dice.rollDice();
                newPosition = diceFaceValue+playerCurrentPosition;
            }

            if(newPosition==100){
                System.out.println("Winner Found. "+currentPlayer.name +" is the winner");
                return;
            }

            if(snakeMap.containsKey(newPosition)){
                newPosition=snakeMap.get(newPosition);
                System.out.println("Oops snake bit. New position is: "+newPosition);
            }

            if(ladderMap.containsKey(newPosition)){
                newPosition=ladderMap.get(newPosition);
                System.out.println("Hurrah!, Ladder found. New position is: "+newPosition);
            }

            playerMap.put(currentPlayer, newPosition);
            printPlayerCurrentPosition(playerMap, currentPlayer);
            players.add(currentPlayer);
        }
    }

}
