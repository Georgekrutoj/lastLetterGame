package com.lastlettergame;

import java.util.Scanner;

public class Player {
    public static final String stopWord = "стоп";
    private final String typeWord;
    private String lastWord;
    private Player otherPlayer;
    private final Scanner scanner = new Scanner(System.in);

    public Player(Type type) {
        this.typeWord = switch (type) {
            case FIRST -> "Первый";
            case SECOND -> "Второй";
        };
        this.setLastWord("а");
    }

    @Override
    public String toString() {
        return "Player{" +
                "typeWord='" + typeWord + '\'' +
                ", lastWord='" + lastWord + '\'' +
                ", otherPlayer=" + otherPlayer +
                ", scanner=" + scanner +
                '}';
    }

    public String getTypeWord() {
        return typeWord;
    }

    public String getLastWord() {
        return lastWord;
    }

    public void setLastWord(String lastWord) {
        this.lastWord = lastWord;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public void getIn() throws Exception {
        if (this.getOtherPlayer().getLastWord().isEmpty()) {
            System.out.printf("%s игрок, введите любое слово: ", this.getTypeWord());
        } else {
            System.out.printf("%s игрок, введите слово на \"%s\": ", this.getTypeWord(), this.getOtherPlayer().getLastWord().charAt(this.getOtherPlayer().getLastWord().length() - 1));
        }

        this.setLastWord(this.scanner.nextLine().toLowerCase());

        if (this.getLastWord().isEmpty()) {
            this.getIn();
        } else if (this.getLastWord().equals(Player.stopWord)) {
            throw new Exception("Game over!");
        }
        else if (this.getOtherPlayer().getLastWord().charAt(this.getOtherPlayer().getLastWord().length() - 1) != this.lastWord.charAt(0)) {
            this.getIn();
        }
    }
}
