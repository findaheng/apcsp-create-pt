import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        if(getOneIntersectingObject(Robot.class) != null) {
            removeRobot(Robot.class);
            removeObject();
            ((StarGalaxy)getWorld()).setrobotCounter((((StarGalaxy)getWorld()).getrobotCounter())-1);
        }
    }
    
    public void removeRobot(java.lang.Class x) {
        getWorld().removeObject(getOneIntersectingObject(x));
    }
}    
