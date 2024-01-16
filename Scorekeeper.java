/**
 * Keeps score.
 * 
 * @author Anthony C
 * @version 1/16/2024
 * 
 **/
public class Scorekeeper  
{

    private static int decksize, score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize(int a)
    {
        decksize = a;
    }
    
    public static void updateScore()
    {
        score++;
    }
    
    public static int getScore()
    {
        return score;
    }
    

}
