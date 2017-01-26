import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    private Snake ahead;
    private Snake behind;
    private int xToGet = -1;
    private int yToGet = -1;
    public Snake(){
        
    }
     
    public Snake(Snake p){
        ahead = p;
        
    }
    
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        MyWorld world = (MyWorld)getWorld();
        
        if( this == world.getHead()){
            checkhit();
            checkKeyPress();
        }
        doMovement();
        
    }
    

     private void checkhit(){
         MyWorld world = (MyWorld)getWorld();
         Snake tail = world.getTail();
         Snake body;
         
         if( isTouching(Food.class) ){          

             body = new Snake( tail );
             tail.setBehind( body );
             
             if (tail.getRotation() == 270) 
             {
                 world.addObject( body, tail.getX(), tail.getY() + 36 );
                 world.setbody( body );
             }
                
             if (tail.getRotation() == 90) 
             {
                 world.addObject( body, tail.getX(), tail.getY() - 36 );
                 world.setbody( body );
             }
                
             if (tail.getRotation() == 180) 
             {
                 world.addObject( body, tail.getX() + 31, tail.getY() );
                 world.setbody( body );
             }
                
             if (tail.getRotation() == 0) 
             {
                 world.addObject( body, tail.getX() - 31, tail.getY() );
                 world.setbody( body );
             }
             
             removeTouching(Food.class);
         } 
    }
     private void checkKeyPress()
    {
        MyWorld world = (MyWorld)getWorld();
        
        if (Greenfoot.isKeyDown("up")) 
        {
            setRotation(270);
            if (behind != null){
                behind.setXToGet( getX() );
            }
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setRotation(90);
              if (behind != null){
                behind.setXToGet( getX() );
            }
        }
        
         if (Greenfoot.isKeyDown("left")) 
        {
            setRotation(180);
               if (behind != null){
                behind.setYToGet( getY() );
            }
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setRotation(0);
               if (behind != null){
                behind.setYToGet( getY() );
            }
        }  
    }
    
    private void doMovement(){
        MyWorld world = (MyWorld)getWorld();
        Snake head = world.getHead();
        
        if(head == this){
            move(1);
        } else {
            
             if (xToGet != -1 && xToGet < getX() ){
                 setLocation( getX() - 1, getY() );
             } else if(xToGet != -1 && xToGet > getX() ){
                 setLocation( getX() + 1, getY() );
             } else if(yToGet != -1 && yToGet > getY() ){
                 setLocation( getX() , getY() + 1 );
             } else if(yToGet != -1 && yToGet < getY() ){
                 setLocation( getX() , getY() - 1 );
             } else {
                 
                 if( behind != null && xToGet != -1 ){
                     behind.setXToGet( xToGet );
                 } else if ( behind != null && yToGet != -1 ){
                     behind.setYToGet( yToGet );
                 }
                 
                 xToGet = -1;
                 yToGet = -1;
                 setRotation( ahead.getRotation() );
                 move(1);
             }
        
        }
        
    }
    
    public void setBehind( Snake s ){
        behind = s;
    }
    public void setXToGet(int x){
        xToGet = x;
    }
    
     public void setYToGet(int y){
        yToGet = y;
    }
    
   
}
