import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int score = 0;
    
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        setImage(new GreenfootImage("Score: "+score, 24, Color.WHITE, Color.BLACK));
    }    
    
    
    //get and set score methods
    public int getScore() {
        return score;
    }
    public void setScore(int x) {
        score = x;
    }
}
