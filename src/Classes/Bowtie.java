package Classes;/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Bowtie extends Shape {
    //Constructor
    public Bowtie(Color shapeColor, int width, int height, int xPos, int yPos) {
        super(shapeColor, width, height, xPos, yPos);
    }
    //Method to drawAShape
    @Override
    public void drawAShape(Graphics g) {
        //Declare variables and set the value
        int x = this.getxPos();
        int y= this.getyPos();
        int height = this.getHeight();
        int width = this.getWidth();

        //Get color gradient by calling function drawWithGradient in Shape class and downcast g to g2d
        Graphics2D g2d = drawWithGradient ((Graphics2D) g, 0, height/2, width/2, 0);

        //Define a couple of arrays to hold x and y coordinates for the points we'll be drawing
        int[] xPos = {x, x+width, x+width, x+width, x+width, x, x};
        int[] yPos = {y, y+height, y+height, y, y, y+height, y};

        //Create a GeneralPath object
        GeneralPath path = new GeneralPath();

        //put the pen to starting location
        path.moveTo(xPos[0], yPos[0]);

        //move to each point locations, drawing a line when it moves.
        path.lineTo(xPos[1], yPos[1]);
        path.lineTo(xPos[2], yPos[2]);
        path.lineTo(xPos[3], yPos[3]);
        path.lineTo(xPos[4], yPos[4]);
        path.lineTo(xPos[5], yPos[5]);
        path.lineTo(xPos[6], yPos[6]);
        //Call the function to fill the path
        g2d.fill(path);
    }

    //Function to flip the bowtie horizontally or vertically when collision happened
    //checks the value of the horizontally parameter. If it's true, the method performs a horizontal flip; otherwise, it performs a vertical flip.
    //The method swaps the width and height of the Bowtie object.
    public void flipBowtie(boolean horizontally) {
        int temp;
        if (horizontally) {
            // Flip horizontally
            temp = this.getWidth();
            this.setWidth(this.getHeight());
            this.setHeight(temp);
        } else {
            // Flip vertically
            temp = this.getHeight();
            this.setHeight(this.getWidth());
            this.setWidth(temp);
        }
    }

}