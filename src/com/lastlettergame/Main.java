package com.lastlettergame;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        Player firstPlayer = new Player(Type.FIRST);
        Player secondPlayer = new Player(Type.SECOND);

        firstPlayer.setOtherPlayer(secondPlayer);
        secondPlayer.setOtherPlayer(firstPlayer);

        while (isRunning) {
            try {
                firstPlayer.getIn();
                secondPlayer.getIn();
            } catch (Exception e) {
                System.out.println("Игра окончена!");
                isRunning = false;
            }
        }
    }
}
