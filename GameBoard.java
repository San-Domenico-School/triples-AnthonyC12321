import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard extends World
{
    private final int NUM_CARDS_IN_DECK = 81;
    
    public GameBoard()
    {   
        super(430, 600, 1, false); 
        prepareScene();
    }
    
    private void prepareScene()
    {
        
        
        Dealer dealer = new Dealer(81);
        Player player = new Player(dealer);
        addObject(player, -30, -30);
        addObject(dealer, -30, -30);
        
        player.addedToWorld();
    }


}
