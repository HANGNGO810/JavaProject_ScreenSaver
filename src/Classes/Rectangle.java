package Classes;/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.awt.*;

public class Rectangle extends Shape {
    //Constructor
    public Rectangle(Color shapeColor, int width, int height, int xPos, int yPos) {
        super(shapeColor, width, height, xPos, yPos);
    }
    //Override method drawAShape
    @Override
    public void drawAShape(Graphics g) {
        g.setColor(this.getShapeColor());
        g.fillRect(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());
    }


}
