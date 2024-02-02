import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The player uses cards to play.
 * 
 * @author Anthony C 
 * @version 2/1/2024
 */
public class Player extends Actor
{

    private Dealer dealer;
    private Card[] cardsSelected;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    
    public Player(Dealer a)
    {
        dealer = a;
        cardsSelected = new Card[3];
        cardsOnBoard = new ArrayList<Card>();
        selectedCardsIndex = new ArrayList<Integer>();
    }
    
    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if (threeCardsHaveBeenSelected)
        {
            dealer.setCardsSelected(cardsOnBoard, cardsSelected, selectedCardsIndex);
            dealer.checkIfTriple();
            resetCardsSelected();
        }
    }
    
    public void addedToWorld()
    {
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    private void selectCards()
    {
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
            {
                if(cardsOnBoard.get(i).getIsSelected())
                {
                    cardsOnBoard.get(i).setIsSelected(false);
                    cardsOnBoard.get(i).setImageSelected(false);
                    selectedCardsIndex.remove(selectedCardsIndex.indexOf(i));
                } else
                {
                    cardsOnBoard.get(i).setIsSelected(true);
                    cardsOnBoard.get(i).setImageSelected(true);
                    selectedCardsIndex.add(i);
                }
            } 
            
        }
    }
    
    private void resetCardsSelected()
    {
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            cardsOnBoard.get(i).setIsSelected(false);
            cardsOnBoard.get(i).setImageSelected(false);
        }
    }
    
    private boolean setCardsSelected()
    {
        if (selectedCardsIndex.size() == 3)
        {
            for (int i = 0; i < 3; i++)
            {
                cardsSelected[i] = cardsOnBoard.get(selectedCardsIndex.remove(0));
            }
            return true;
        }
        return false;
    }
}
