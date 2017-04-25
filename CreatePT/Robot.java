import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
  
   /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
  public void act() 
  {
      //robot follows starship
      //double diffX = Math.abs((getRobotX()-(((StarGalaxy)getWorld()).getStarship()).getStarshipX()));
      //double diffY = Math.abs((getRobotY()-(((StarGalaxy)getWorld()).getStarship()).getStarshipY()));        
      if(getOneIntersectingObject(Starship.class) != null) {
          gameOver();
      } 
      
      Starship starshipPos = ((StarGalaxy)getWorld()).getObjects(Starship.class).get(0);
      turnTowards(starshipPos.getX(),starshipPos.getY());
      move(1);  
  } 
     
  //get position methods
  public int getRobotX() {       
      return getX();
  }
  public int getRobotY() {
      return getY(); 
  }
  
  //game over method
  public void gameOver() {
      GameOver gameOver = new GameOver();
      getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
      move(4);
      Greenfoot.stop();
    }
}   
