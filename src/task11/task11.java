package task11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task11 {
    public static void main(String[] args) {
        String[] suits = {"SPADE", "HEARTS", "CLUB", "TREE"};
        String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        List<String> deck = new ArrayList<>();

        //52 cards in a card
        Integer numberOfCards = suits.length * ranks.length;

        //To generate the 52 cards
        for (Integer i = 0; i < suits.length; i++){
            for (Integer x = 0; x < ranks.length; x++){
                deck.add(suits[i] + " " + ranks[x]);
                //Create deck of cards in order SPADE1, SPADE 2, SPADE 3......
            }
        }
        for (String card : deck){
            System.out.println(card);
        }

        System.out.println("---------------------------------------");

        //TO SHUFFLE THE DECK OF CARDS
        Collections.shuffle(deck);

        //PRINT THE SHUFFLED DECK
        for (String card : deck){
            System.out.println(card);
        }

        System.out.println("---------------------------------------");

        System.out.println(numberOfCards + " cards");
    }
}
