package Classes;/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.awt.*;

public class Diamond extends Shape {
    //Constructor
    public Diamond(Color shapeColor, int width, int height, int xPos, int yPos) {
        super(shapeColor, width, height, xPos, yPos);
    }
    //Override the abstract method
    @Override
    public void drawAShape(Graphics g) {
        //Get the size of diamond
        int width = this.getWidth();
        int height = this.getHeight();

        // Calculate center coordinates
        int centerX = width / 2;
        int centerY = height / 2;

        // Define diamond points
        int[] xPoints = {centerX+this.getxPos(), width+this.getxPos(), centerX+this.getxPos(), this.getxPos()};
        int[] yPoints = {this.getyPos(), centerY+this.getyPos(), height+this.getyPos(), centerY+this.getyPos()};

        // Create GradientPaint for top half
        Graphics2D g2d = drawWithGradient((Graphics2D) g, centerX, centerY - 50, centerX, centerY);
        g2d.fillPolygon(xPoints, yPoints, 4);

        // Create GradientPaint for bottom half
        GradientPaint gradientBottom = new GradientPaint(centerX, centerY, createColor(this.getShapeColor()), centerX, centerY + 50, this.getShapeColor());
        g2d.setPaint(gradientBottom);
        g2d.fillPolygon(xPoints, yPoints, 4);
    }
}
