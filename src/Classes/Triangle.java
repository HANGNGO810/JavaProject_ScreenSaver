package Classes;/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.awt.*;

public class Triangle extends Shape {
    //constructor
    public Triangle(Color shapeColor, int width, int height, int xPos, int yPos) {
        super(shapeColor, width, height, xPos, yPos);
    }
    //Override the abstract method drawAShape
    @Override
    public void drawAShape(Graphics g) {
        //Variables
        int x = this.getxPos();
        int y= this.getyPos();
        int height = this.getHeight();
        int width = this.getWidth();

        //Get the gradient pen by calling function drawWithGradient in the Shape object
        //Downcast Graphics g to Graphics2D g2d (Graphics is parent class & Graphics2D is a subclass)
        Graphics2D g2d = drawWithGradient((Graphics2D) g, width+100, height+50, width+200, height+100);
        //Draw a triangle
        g2d.drawLine(x, y, x+width, y);
        g2d.drawLine(x+width, y, x+width/2, y+height);
        g2d.drawLine(x+width/2, y+height, x, y);
        //Fill the oval inside the rectangle
        g2d.fillOval(x+width/3, y, width/3, height-height/4);
    }
}
