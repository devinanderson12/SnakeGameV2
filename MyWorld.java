import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Snake[] snake = new Snake[(600*400)/(31*36)] ;
    private int tailIndex = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {       
        super(600, 400, 1); 
        prepare();
       
    }
    
    public void act(){ 
  
      if (Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Food(), Greenfoot.getRandomNumber(780), Greenfoot.getRandomNumber(360));
        }
    }
    private void prepare() {
       snake[0] = new Snake();
       addObject(snake[0], 150, 179);
       Food Food = new Food();
       addObject(Food,599,399);
       
    }        
    public Snake getHead(){
        return snake[0];
    }
    
    public Snake getTail(){
        Snake tail = null;
        
        for(int i = 0; snake[i] != null && i < snake.length; i++){
           tail = snake[i]; 
        }
        
        return tail;
    }
    
    public void setbody(Snake s){
       tailIndex++;
       snake[tailIndex] = s;
    }
    
}
