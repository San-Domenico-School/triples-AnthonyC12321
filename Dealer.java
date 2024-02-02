import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    
    private Deck deck;
    private ArrayList<Card> cardsOnBoard = new ArrayList<Card>();
    private ArrayList<Integer> selectedCardsIndex = new ArrayList<Integer>();
    private Card[] cardsSelected;
    private int numCardsInDeck, triplesRemaining;
    
    public Dealer(int numCardsInDeck)
    {
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);
        cardsSelected = new Card[3];
    }
    
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
    }
    
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        
        World world = getWorld();
        
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 5; a++)
            {
                world.addObject(deck.getTopCard(), i * 135 + 79, a * 80 + 70);
            }
        }
    }
    
    public void setUI()
    {
        getWorld().showText(Integer.toString(deck.getNumCardsInDeck() + 15), 312, 470);
        getWorld().showText(Integer.toString(0), 312, 505);
    }
    
    public void endGame()
    {
        
    }
    
    public void checkIfTriple()
    {
        
    }
    
    public void actionIfTriple()
    {
        
    }    
    
    public void setCardsSelected(ArrayList<Card> CardList, Card[] cardObjects, ArrayList<Integer> integers) 
    {
        
    }   
    
    public void act()
    {
        // Add your action code here.
    }
}
