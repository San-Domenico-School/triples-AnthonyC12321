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
    
    private int triplesRemaining;
    private int numCardsInDeck = 81;
    private int score = 0;
    
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
        getWorld().showText(Integer.toString(numCardsInDeck), 312, 470);
        getWorld().showText(Integer.toString(score), 312, 505);
    }
    
    public void endGame()
    {
        getWorld().showText("Game Over", 250, 250);
         Greenfoot.stop();
    }
    
    public void checkIfTriple(Card[] cards)
    {
       cardsSelected = cards;
        if (((cards[0].getShape() == cards[1].getShape() && cards[1].getShape() == cards[2].getShape()) || (cards[0].getShape() != cards[1].getShape() && cards[1].getShape() != cards[2].getShape() && cards[0].getShape() != cards[2].getShape()))
       && ((cards[0].getColor() == cards[1].getColor() && cards[1].getColor() == cards[2].getColor()) || (cards[0].getColor() != cards[1].getColor() && cards[1].getColor() != cards[2].getColor() && cards[0].getColor() != cards[2].getColor()))
       && ((cards[0].getNumberOfShapes() == cards[1].getNumberOfShapes() && cards[1].getNumberOfShapes() == cards[2].getNumberOfShapes()) ||(cards[0].getNumberOfShapes() != cards[1].getNumberOfShapes() && cards[1].getNumberOfShapes() != cards[2].getNumberOfShapes() && cards[0].getNumberOfShapes() != cards[2].getNumberOfShapes()))
       && ((cards[0].getShading() == cards[1].getShading() && cards[1].getShading() == cards[2].getShading()) ||(cards[0].getShading() != cards[1].getShading() && cards[1].getShading() != cards[2].getShading() && cards[0].getShading() != cards[2].getShading()))
   )
       {
           actionIfTriple();
       } else
       {
           Animations.wobble(cardsSelected, getWorld());
       }
       
    }
    
    public boolean checkTriple(Card[] cards)
    {
       cardsSelected = cards;
        if (((cards[0].getShape() == cards[1].getShape() && cards[1].getShape() == cards[2].getShape()) || (cards[0].getShape() != cards[1].getShape() && cards[1].getShape() != cards[2].getShape() && cards[0].getShape() != cards[2].getShape()))
       && ((cards[0].getColor() == cards[1].getColor() && cards[1].getColor() == cards[2].getColor()) || (cards[0].getColor() != cards[1].getColor() && cards[1].getColor() != cards[2].getColor() && cards[0].getColor() != cards[2].getColor()))
       && ((cards[0].getNumberOfShapes() == cards[1].getNumberOfShapes() && cards[1].getNumberOfShapes() == cards[2].getNumberOfShapes()) ||(cards[0].getNumberOfShapes() != cards[1].getNumberOfShapes() && cards[1].getNumberOfShapes() != cards[2].getNumberOfShapes() && cards[0].getNumberOfShapes() != cards[2].getNumberOfShapes()))
       && ((cards[0].getShading() == cards[1].getShading() && cards[1].getShading() == cards[2].getShading()) ||(cards[0].getShading() != cards[1].getShading() && cards[1].getShading() != cards[2].getShading() && cards[0].getShading() != cards[2].getShading()))
   )
       {
           return true;
       } else
       {
           return false;
       }
       
    }
    
    public void actionIfTriple()
    {
        int[][] pos = {{cardsSelected[0].getX(), cardsSelected[0].getY()}, {cardsSelected[1].getX(), cardsSelected[1].getY()}, {cardsSelected[2].getX(), cardsSelected[2].getY()} };
        Animations.slideAndTurn(cardsSelected, getWorld());
        
        for (int i = 0; i < 3; i++)
        {
            if (numCardsInDeck >= 18)
            {
                getWorld().addObject(deck.getTopCard(), pos[i][0], pos[i][1]);
            }
        }
        
        numCardsInDeck -= 3;
        score++;
        setUI();
        
        
        World world = getWorld();
        ArrayList<Card> cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
        
        int[][] trips = new int[4][3];
        
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            trips[0][cardsOnBoard.get(i).getShape().ordinal()]++;
            trips[1][cardsOnBoard.get(i).getColor().ordinal()]++;
            trips[2][cardsOnBoard.get(i).getNumberOfShapes() - 1]++;
            trips[3][cardsOnBoard.get(i).getShading()]++;
        }

        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            if ( (trips[0][cardsOnBoard.get(i).getShape().ordinal()] < 3 && (trips[0][0] == 0 || trips[0][1] == 0 || trips[0][2] == 0)) 
            || ((trips[1][cardsOnBoard.get(i).getShape().ordinal()] < 3 && (trips[1][0] == 0 || trips[1][1] == 0 || trips[1][2] == 0)))
            || ((trips[2][cardsOnBoard.get(i).getShape().ordinal()] < 3 && (trips[2][0] == 0 || trips[2][1] == 0 || trips[2][2] == 0)))
            || ((trips[3][cardsOnBoard.get(i).getShape().ordinal()] < 3 && (trips[3][0] == 0 || trips[3][1] == 0 || trips[3][2] == 0)))
            )
            {
                i++;
            } else
            {
                break; 
            }
            
            endGame();
            
        }
        
        Card[] cardsTested = new Card[3];
        
        boolean triplesHere = false;
        
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            for (int j = 0; j < cardsOnBoard.size(); j++)
            {
                for (int k = 0; k < cardsOnBoard.size(); k++)
                {
                    if (i != j && j != k && k != i)
                    {
                        cardsTested[0] = cardsOnBoard.get(i); 
                        cardsTested[1] = cardsOnBoard.get(j); 
                        cardsTested[2] = cardsOnBoard.get(k);
                         if (checkTriple(cardsTested))
                        {
                            triplesHere = true;
                        }
                    }
                }
            }
           
            
            if (triplesHere)
            {
                break;
            }
            
        }
        
        if (!triplesHere)
        {
            endGame();
        }
        
        /*if (trips[0][0] * trips[0][1] * trips[0][2] == 0 
            && trips[1][0] * trips[1][1] * trips[1][2] == 0 
            && trips[2][0] * trips[2][1] * trips[2][2] == 0 
            && trips[3][0] * trips[3][1] * trips[3][2] == 0 
            
            && 
            
            trips[0][0] == 0 || trips[0][1] == 0 || trips[0][2] == 0 
            && trips[1][0] == 0 || trips[1][1] == 0 || trips[1][2] == 0
            && trips[2][0] == 0 || trips[2][1] == 0 || trips[2][2] == 0
            && trips[3][0] == 0 || trips[3][1] == 0 || trips[3][2] == 0 )
            
            {
               endGame(); 
            }*/
            
        
        
        
        
        
    }    
    
    public void setCardsSelected(ArrayList<Card> CardList, Card[] cardObjects, ArrayList<Integer> integers) 
    {
        
    }   
    
    public void act()
    {
        // Add your action code here.
    }
}
