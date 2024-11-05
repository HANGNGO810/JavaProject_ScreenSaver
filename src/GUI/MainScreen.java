/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/* Name: Hang Ngo
   Date: April 8, 2024
   Description: Assignment 4 - Screen Saver
   Reference: Jeoff's Moving Car Solution
*/

package GUI;
import java.awt.*;
import javax.swing.*;
public class MainScreen extends JFrame {
    private JPanel contentPane;
    //Main method
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainScreen frame = new MainScreen();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // Constructor method
    public MainScreen() {
        // Set-up for main window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 10, 850, 950);
        setTitle("Screen Saver");

        // Create the content pane with a border layout
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // Create an instance of DrawingScreen
        DrawingScreen myDrawing = new DrawingScreen();
        myDrawing.setBackground(Color.black);

        // Add the DrawingScreen to the content pane's center
        contentPane.add(myDrawing, BorderLayout.CENTER);
        contentPane.setBackground(Color.orange);
    }
}
