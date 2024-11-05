package Classes;/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.awt.*;

public abstract class Shape {//Shape is a parent class, subclasses are inherited from Shape included: Bowtie, Circle, Diamond, Flower, Rectangle, Triangle
    //region Properties
    private Color shapeColor;
    private int width;
    private int height;
    private int xPos;
    private int yPos;
    private int xSpeed = 0;	 //Moving speeds x of Shape
    private int ySpeed = 0; //Moving speeds y of Shape

    //The purpose of the variable (collisionStatus) is to set the condition on setxSpeed and setySpeed methods to manage the direction change
    private boolean collisionStatus =false;;//true: collided; false: not collided

    //endregion
    //Constructor
    public Shape(Color shapeColor, int width, int height, int xPos, int yPos) {
        this.shapeColor = shapeColor;
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;

        //Set xSpeed and ySpeed randomly, but must be greater than zero to ensure the new object is moving after being generated.
        while (xSpeed==0){
            xSpeed = (int) (Math.random()*9-4);
        }
        while (ySpeed==0){
            ySpeed = (int) (Math.random()*9-4);
        }
    }

    //Abstract method
    public abstract void drawAShape(Graphics g);

    //Method to move the shape
    public void moveTheShape(int panelWidth, int panelHeight){
        //Variables to store the position plus speed of object
        int tempX=xPos+xSpeed;
        int tempY=yPos+ySpeed;

        //Conditions to ensure when the panel is RESIZED, the object does not move out of the panel
        //If object's position plus speed is less than zero --> set its value back to zero
        //If object's position plus speed is greater than or equal to panel's width/height minus width/height--> set its value is panels width/height minus width/height
        if(tempX<=0)
            this.setxPos(0);
        else if (tempX>=(panelWidth-width))
            this.setxPos(panelWidth-width);
        else
            this.setxPos(tempX);
        if(tempY<=0)
            this.setyPos(0);
        else if(tempY>=(panelHeight-height))
            this.setyPos(panelHeight-height);
        else
            this.setyPos(tempY);
    }

    //Method to get current position of the Shape
    public int[][] getPositionThisObject(){
        //Get position of a rectangle around the object
        int [][] positionList = new int [4][2];//2D array to store 4 position, each position has 2 elements: positionX and positionY
        //Left-Top (x, y)
        positionList[0][0]= xPos;
        positionList[0][1]= yPos;
       //Left-bottom (x, y+h)
        positionList[1][0]= xPos;
        positionList[1][1]= yPos+height;
        // Right-Top (x+w, y)
        positionList[2][0]= xPos+width;
        positionList[2][1]= yPos;
        //Right-Bottom (x+w, y+h)
        positionList[3][0]= xPos+width;
        positionList[3][1]= yPos+height;

        return positionList; //this is 2D array [ [x, y], [x, y+h], [x+w, y], [x+w, y+h] ]
    }

    //Method to detect collision between shapes - Detect position of THIS Object and THAT Object
    public boolean intersects(int [][] thatObjectPos){
        //Get position x and y of "THIS OBJECT"
        int leftBottomX = this.getPositionThisObject()[0][0]; //x
        int rightBottomX = this.getPositionThisObject()[3][0]; //x+w
        int leftTopY = this.getPositionThisObject()[0][1];//y
        int leftBottomY = this.getPositionThisObject()[3][1];//y+h

        // boolean isCollided to check if 2 objects are collided, and change status to break the loop
        boolean isCollided = false;

        /*Collision Detection Logic
        Iterate over each pixel within the bounds of one of the object
        It's iterating over the x-coordinates (x) from leftBottomX to rightBottomX and the y-coordinates (y) from leftTopY to leftBottomY.
        Within the nested loops, the code checks if the current pixel (x, y) falls within the bounding box of the other object (thatObject)
        If yes: the isCollided flag is set to true -->  indicating a collision has occurred
        The loop terminates early if a collision is detected (!isCollided condition).
        */
        for (int x=leftBottomX;x<=rightBottomX && !isCollided;x++)
            for(int y=leftTopY;y<=leftBottomY && !isCollided;y++)
                if(thatObjectPos[0][0]<=x && thatObjectPos[3][0]>=x && thatObjectPos[0][1]<=y &&thatObjectPos[3][1]>=y )
                    isCollided = true;

        return isCollided;

        //other option: This option is worked but still have some collision problem: sometimes 2 objects can be stick together
        //Loop into thatObject: 2 conditions: if x<length and isCollided is true then continue, if isCollided change status to false -> break the loop
        // for(int x=0; x<thatObjectPos.length && !isCollided; x++) { //x:0,1, 2, 3
        // if((thatObjectPos[x][0]>= leftBottomX) && (thatObjectPos[x][0]<= rightBottomX) &&(thatObjectPos[x][1] >= leftTopY) && (thatObjectPos[x][1] <=leftBottomY))
        //      {//This object is collided with that object --> break the loop
        //          isCollided=true;
        //       }
        // }

    }

    //Method to create Colors
    public Color createColor (Color mainColor){
        // Extracting RGB components of color1
        int r1 = mainColor.getRed();
        int g1 = mainColor.getGreen();
        int b1 = mainColor.getBlue();
        // Calculating complementary color
        int r2 = 255 - r1;
        int g2 = 255 - g1;
        int b2 = 255 - b1;
        // Creating color2
        Color color2 = new Color(r2, g2, b2);
        // Creating color2
        return new Color(r2, g2, b2);
    }

    //Method to create Gradient Paint
    public Graphics2D drawWithGradient(Graphics2D g, int x1, int x2, int y1, int y2) {
        //Define colors
        Color color1= this.getShapeColor();
        // Creating color2 by calling function createColor
        Color color2 = this.createColor(color1);

        //Create a GradientPaint object
        GradientPaint gradientPaint = new GradientPaint(x1, y1, color1, x2, y2, color2);
        g.setPaint(gradientPaint);
        return g;
    }

    //region Getters/Setters
    public int getxSpeed() {
        return xSpeed;
    }
    public void setxSpeed(int xSpeed) {
        //check if the shape is not collided and speed is not zero then allow to set the speed x
        if(xSpeed!=0 && !this.collisionStatus)
            this.xSpeed = xSpeed;
    }
    public int getySpeed() {
        return ySpeed;
    }
    public void setySpeed(int ySpeed) {
        //check if the shape is not collided and speed is not zero then allow to set the speed y
        if( ySpeed!=0 && !this.collisionStatus)
            this.ySpeed = ySpeed;
    }
    public Color getShapeColor() {
        return shapeColor;
    }
    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getxPos() {
        return xPos;
    }
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }
    public int getyPos() {
        return yPos;
    }
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    public boolean isCollisionStatus() {
        return collisionStatus;
    }
    public void setCollisionStatus(boolean collisionStatus) {
        this.collisionStatus = collisionStatus;
    }
    //endregion
}
