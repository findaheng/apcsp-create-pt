import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Robot-Destroyer is a simple spaceship-controlled game. The objective is to destroy as many robots 
 * as you can. Use the arrow keys or WASD to move and the space button to shoot. Powerups are 
 * available to help you destroy robots.
 * #9060 
 * V.1 (a version number or a date)
 */
public class StarGalaxy extends World
{
    int rfPowerupCounter = 0;
    int radPowerupCounter = 0;
    int shotPowerupCounter = 0;
    int powerupLimit = 3;
    
    int robotCounter = 0;
    int robotLimit = 5;
    
    Starship starship;
    Counter counter;
    
    /**
     * Constructor for objects of class StarGalaxy.
     * 
     */
    public StarGalaxy()
    {    
        super(900,700, 1); 
        setPaintOrder(GameOver.class, Starship.class, Laser.class);
        starship = new Starship();
        addObject(starship, getWidth()/2, getHeight()/2);
        counter = new Counter();
        addObject(counter, 60, 20);
    }
    
    
    
    public void act() {
        int powerupProb = Greenfoot.getRandomNumber(3);
        int robotProb = Greenfoot.getRandomNumber(100);
        
        if(powerupProb < 2 && rfPowerupCounter < powerupLimit) {
            createRapidFirePowerup();
            rfPowerupCounter++;
        } else if(powerupProb < 3 && radPowerupCounter < powerupLimit) {
            createRadiationPowerup();
            radPowerupCounter++;
        } else if(powerupProb < 4 && shotPowerupCounter < powerupLimit) {
            createShotgunPowerup();
            shotPowerupCounter++;
        }
        
        if(robotProb < 5 && robotCounter < robotLimit) {
            createRobot();
            robotCounter++;
        }
        
    }
    
    
    //create methods
    public void createRobot() {   
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        Robot robot = new Robot();
        
        
        int distance = (int)Math.sqrt(Math.pow((x-starship.getStarshipX()),2)+Math.pow((y-starship.getStarshipY()),2));
        if(distance > 10) {
            addObject(robot, x, y);
        } else {
            createRobot();
        }
    }
    public void createRapidFirePowerup() {
        RapidFirePowerup rfPowerup = new RapidFirePowerup();
        addObject(rfPowerup, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }
    public void createRadiationPowerup() {
        RadiationPowerup radPowerup = new RadiationPowerup();
        addObject(radPowerup, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }
    public void createShotgunPowerup() {
        ShotgunPowerup shotPowerup = new ShotgunPowerup();
        addObject(shotPowerup, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }

    
    
    //get & set methods
    public int getrfPowerupCounter() {
        return rfPowerupCounter;
    }
    public void setrfPowerupCounter(int x) {
        rfPowerupCounter = x;
    }
    public int getradPowerupCounter() {
        return radPowerupCounter;
    }
    public void setradPowerupCounter(int x) {
        radPowerupCounter = x;
    }
    public int getshotPowerupCounter() {
        return shotPowerupCounter;
    }
    public void setshotPowerupCounter(int x) {
        shotPowerupCounter = x;
    }
    public int getrobotCounter() {
        return robotCounter;
    }
    public void setrobotCounter(int x) {
        robotCounter = x;
    }
    public Starship getStarship() {
        return starship;
    }
}
