package Classes;/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.awt.*;

public class Circle extends Shape{
    //Constructor
    public Circle(Color shapeColor, int width, int height, int xPos, int yPos) {
        super(shapeColor, width, height, xPos, yPos);
    }
    //Method drawAShape
    @Override
    public void drawAShape(Graphics g) {
        //Get the Gradient paint by calling function drawWithGradient from parent object (Shape)
        Graphics2D g2d = drawWithGradient((Graphics2D) g, this.getWidth()/2, this.getHeight()/2,this.getWidth()/4 , this.getHeight()/4);
        //Draw a filled oval
        g2d.setColor(this.getShapeColor());
        g2d.fillOval(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());
    }
    //Method to change color of circle to white
    public void whiteningCircle() {
      setShapeColor(Color.white);
    }


}
