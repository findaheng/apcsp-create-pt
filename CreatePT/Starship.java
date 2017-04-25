import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Starship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starship extends Actor
{
    int counter = 0;
    
    int angle = 0;
    int rotate = 4;
    
    int foSpeed = 4;
    int revSpeed = -1;
    int gunSpeed = 18;
    
    int setTimer = 300;
    int radSetTimer = 20;
    int rfTimer = 0;
    int radTimer = 0;
    int shotTimer = 0;
    
    
    //scale down image of starship
    public Starship()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        setImage(image);
    }
    
    
    
    /**
     * Act - do whatever the Starship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        control();
        rfPowerup();
        radPowerup();
        shotPowerup();
        
        if(shotTimer > 0) {
            rfTimer = 0;
            shotShoot();
            shotTimer--;
        }
        
        if(radTimer > 0) {
            radShoot();
            radTimer--;
        }
        
        if(rfTimer > 0) {
            shotTimer = 0;
            rfShoot(10);
            rfTimer--;
        } else {
            shoot();
        }
        
        counter++;
    }  
    
    
    //create laser method
    public void createLaser(int x) {
        Laser laser = new Laser();
        getWorld().addObject(laser, getX(), getY());
        laser.setRotation(x);
    }
    
    
    //shoot methods
    public void shoot() {
       if(Greenfoot.isKeyDown("space") == true) {
            if(counter % gunSpeed == 0) {                
                createLaser(getRotation());
            }
        } 
    }
    public void rfShoot(int x) {
       if(Greenfoot.isKeyDown("space") == true) {
            if(counter % gunSpeed == 0 || counter % gunSpeed == x) {                
                createLaser(getRotation());
            }
        } 
    }
    public void shotShoot() {
       if(Greenfoot.isKeyDown("space") == true) {
            if(counter % gunSpeed == 0) {                
                createLaser(getRotation());
                createLaser(getRotation()+10);
                createLaser(getRotation()-10);
            }
        } 
    }    
    public void radShoot() {
       if(counter % gunSpeed == 0) {
            createLaser(getRotation());
            for(int i = 0; i<12; i++){
               createLaser(getRotation()+30*i);
            }
        }
    }
    
    
    //movement controls
    public void control() {
        if(Greenfoot.isKeyDown("up") == true) {
            move(foSpeed);
        }
        if(Greenfoot.isKeyDown("down") == true) {
            move(revSpeed);
        }
        if(Greenfoot.isKeyDown("left") == true) {
            setRotation(angle-rotate);
            angle-=rotate;
        }
        if(Greenfoot.isKeyDown("right") == true) {
            setRotation(angle+rotate);
            angle+=rotate;
        }
    }
    
    
    //remove powerups
    public void removePowerup(java.lang.Class x) {
        getWorld().removeObject(getOneIntersectingObject(x));
    }
    public void rfPowerup() {
        if(getOneIntersectingObject(RapidFirePowerup.class) != null) {
            removePowerup(RapidFirePowerup.class);
            ((StarGalaxy)getWorld()).setrfPowerupCounter((((StarGalaxy)getWorld()).getrfPowerupCounter())-1);
            rfTimer = setTimer;
        }
    }
    public void radPowerup() {
        if(getOneIntersectingObject(RadiationPowerup.class) != null) {
            removePowerup(RadiationPowerup.class);
            ((StarGalaxy)getWorld()).setradPowerupCounter((((StarGalaxy)getWorld()).getradPowerupCounter())-1);
            radTimer = radSetTimer;
        }
    }
    public void shotPowerup() {
        if(getOneIntersectingObject(ShotgunPowerup.class) != null) {
            removePowerup(ShotgunPowerup.class);
            ((StarGalaxy)getWorld()).setshotPowerupCounter((((StarGalaxy)getWorld()).getshotPowerupCounter())-1);
            shotTimer = setTimer;
        }
    }
    
    //get position methods
    public int getStarshipX() {
        return getX();
    }
    public int getStarshipY() {
        return getY();
    }
}
