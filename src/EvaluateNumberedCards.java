import DataTypes.Card;
import Enumerations.CardType;

import java.util.*;

public class EvaluateNumberedCards {
    public boolean play(List<Card> cards){
        //check if there are any cards
        if(cards.isEmpty())
            return false;

        TreeMap<Integer, Integer> valueCount = new TreeMap<>();

        for(Card card : cards){
            //check if we got only Number type cards
            if(card.getType() != CardType.Number)
                return false;


            //increase count of cards
            try{
                valueCount.replace(
                        card.getValue(),
                        valueCount.get(card.getValue()) + 1
                );
            }
            //create count for cards
            catch (Exception e){
                valueCount.put(card.getValue(), 1);
            }
        }


        //option 1 & option 2
        if(valueCount.keySet().size() == 1){
            int count = valueCount.get(cards.get(0).getValue());

            return count == 1 || count == 2;

        }

        //option 3
        else{
            ArrayList<Integer> numsList = new ArrayList<>();
            for(Integer num : valueCount.keySet()){
                for(int i = 0; i < valueCount.get(num); i++){
                    numsList.add(num);
                }
            }
            //size is last reachable index
            int size = numsList.size() - 1;

            //check if there are 2 max numbers
            if(numsList.get(size) == numsList.get(size - 1)){
                return false;
            }

            //get max and subtract from it all other numbers, if == 0 they form equation
            int equation = numsList.get(size);
            for(int i = 0; i < size; i++){
                equation -= numsList.get(i);
            }

            return equation == 0;
        }

        //we will never get here but java was showing missing return statement problem
    }
}
