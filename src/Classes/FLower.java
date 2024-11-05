package Classes;/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import Classes.Shape;

import java.awt.*;

public class FLower extends Shape {
    public FLower(Color shapeColor, int width, int height, int xPos, int yPos) {
        super(shapeColor, width, height, xPos, yPos);
    }

    @Override
    public void drawAShape(Graphics g) {
        int tempWidth = getWidth()/3;
        int tempHeight = getHeight()/3;

        //Get position x, y and width, height
        int x= this.getxPos();
        int y= this.getyPos();
        int height = this.getHeight();
        int width = this.getWidth();

        //Get the gradient pen by calling function drawWithGradient in the Shape object
        Graphics2D g2d = drawWithGradient((Graphics2D) g, width+100, height+50, width+200, height+100);

        g2d.fillOval(x+tempWidth, y, tempWidth, tempHeight);
        g2d.fillOval(x+tempWidth, y+tempHeight*2, tempWidth, tempHeight);
        g2d.fillOval(x, y+tempHeight, tempWidth, tempHeight);
        g2d.fillOval(x+tempWidth*2, y+tempHeight, tempWidth, tempHeight);

        //Color for flower center
        g2d.setColor(Color.white);
        g2d.fillOval(x+tempWidth, y+tempHeight, tempWidth, tempHeight);
    }

    //Method flower blossoms
    public void blossom() {
        // change the height and width of flower, ensure the width and height are always less than 50
        if(this.getHeight()<=50 && this.getWidth()<=50) {
            setHeight(this.getHeight() + this.getHeight() / 5);
            setWidth(this.getWidth() + this.getWidth() / 5);
        }
        else {
            this.setHeight(30);
            this.setWidth(30);
        }

    }
}
