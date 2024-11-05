Author: HangNgo

JAVA PROGRAM - SCREEN SAVER

Use Java to create a simple graphical screensaver program, to demonstrate your understanding of graphics, polymorphism, and other OOP concepts.
When first run, the screensaver app will appear as a blank window. Whenever the user clicks anywhere in the window, a random shape will be created and appear onscreen, and will start moving around the window. The user should be able to add as many shapes to the screensaver as they want, by continuing to click on the window.
The screensaver program must:
•	Include a class for each specific shape that is drawn, which are all subclasses of a superclass called Shape.
•	Define at least four different shape classes, such as Circle, Triangle or Diamond.
•	Include at least one irregular shape, such as Bowtie, Cross, Star or LetterQ. Feel free to be creative.
•	Use at least three different visual states for all shapes, such as colors, sizes, gradients, patterns or images.
•	Store all shape objects in an ArrayList of Shape objects. Arraylist is used when iterating through all active shape objects.
•	Use a Timer object to animate the screensaver, through the moving and redrawing of all shape objects contained in the arraylist.
•	Include collision detection between all moving shape objects and the “walls” of the application window. On wall collision, the shapes should rebound, to stay in the visual area of the window.
•	Include collision detection between the moving shapes themselves. A collision between any two shapes should result in at least one visual change in both shapes, such as change of direction, speed, color, etc.
•	Respond properly to a re-sizing of the program window. In other words, if the window is expanded, all moving shapes will know that the window’s boundaries have changed and use the new dimensions when determining collision.
Program Structure

