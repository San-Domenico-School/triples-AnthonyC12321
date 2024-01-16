import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Card extends Actor
{
   public enum Shape
   {
       TRIANGLE, SQUARE, CIRCLE, NO_SHAPE
   }
   
   public enum Color
   {
       RED, GREEN, BLUE, NO_COLOR
   }
   
   private Shape shape;
   private Color color;
   private boolean isSelected;
   private GreenfootImage cardImage, selectedCardImage;
   private int numberOfShapes, shading;
   
   
   public Card(Shape a, Color b, int e, int f, GreenfootImage c, GreenfootImage d)
   {
       shape = a;
       color = b;
       cardImage = c;
       selectedCardImage = d;
       numberOfShapes = e;
       shading = f;
       setImage(cardImage);
   }
   
   public Shape getShape()
   {
       return shape;
   }
   
   public Color getColor()
   {
       return color;
   }
   
   public boolean getIsSelected()
   {
       return isSelected;
   }
   
   public GreenfootImage getCardImage()
   {
       return cardImage;
   }
   
   public GreenfootImage getSelectedCardImage()
   {
       return selectedCardImage;
   }
   
   public int getNumberOfShapes()
   {
       return numberOfShapes;
   }
   
   public int getShading()
   {
       return shading;
   }
   
   public void setIsSelected(boolean a)
   {
       isSelected = a;
   }
}

