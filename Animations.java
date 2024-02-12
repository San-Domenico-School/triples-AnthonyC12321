import greenfoot.*;

/**
 * Animations for the cards.
 * 
 * @author Anthony C
 * @version 1/16/2024
 */
public class Animations  
{
   public static void wobble(Card[] a, World world)
   {
       Greenfoot.playSound("wobble.wav");
       for (int i = 0; i < 3; i ++)
       {
            a[i].setRotation(50);
       }
       
       Greenfoot.delay(25);
       
       for (int i = 0; i < 3; i ++)
       {
            a[i].setRotation(0);
       }
   }
   
   public static void slideAndTurn(Card[] a, World world)
   {
       Greenfoot.playSound("swoosh.wav");
       while (a[0].getX() < 500)
       {
           for (int i = 0; i < 3; i ++)
           {
               a[i].setRotation(50);
               a[i].setLocation(a[i].getX() + 10, a[i].getY());
           }
           Greenfoot.delay(1);
       }
       
       for (int i = 0; i < 3; i ++)
       {
            world.removeObject(a[i]);
       }
       
   }
}
