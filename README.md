# Data-Structures-3rd-Project

This project uses stack and queue, to explore a maze and, hopefully, find a way out of it. This assignment will try two such approaches, in which of these approaches you will start from some initial position within the maze and evaluate the neighboring locations until either you find a way out, or you discover that there is no way out. The rough outline of both approaches is to examine locations around the current position and decide which need to be examined further and which definitely do not lead to an exit.

This project is a combination of code given by the instructor, Professor Joanna Klukowska, and my own implementations.
I am responsible for my own implementations for the "set of locations" that is used in the algorithm that will be discussed below. 
  -PossibleLocationsStack class
  -PossibleLocationsQueue class
  -PossibleLocationsStackTest - test class for the class PossibleLocationsStack
  -PossibleLocationsQueueTest - test class for the class PossibleLocationsQueue

Professor Klukowska provided the algorithm and source code for following classes:
  -Labyrinth - the class that represents a 2D rectangular maze
  -Simulation- the actual program that simulates an exploration of a maze
  -PossibleLocations - the interface that provides requirements for the two classes that you need to implement
  -Location - the class that represents a position/location of a single square in the maze
  -SquareType - the enumerated type describing different types of squares in the maze

Algorithm provided by Professor Klukowska:
The program is started with two command line arguments (you can either run it in a terminal or in an IDE, like Eclipse, as long as there is a way of specifying the command line arguments for the program). If the program is run with fewer than two arguments, it is an error (the program prints an error message and terminates). If the program is run with more than two arguments, the additional arguments are ignored. The first command line argument is a name of an input file containing a maze to be used by the program. (This project comes with two such files. You can (and should) create your own mazes for testing.) The name of the file can be entered as an absolute or relative path.

The program should keep a set of locations that need to be examined (places that we might need to get back to in order to test another alternative, for example when we have two choices and we can only follow one of them right away). The exact representation of this set does not matter from the point of view of the algorithm. At the very beginning the set consists of a single location that is the initial position. We explore the maze by repeating the following steps:
• if the set is empty, there is no way out of the maze - algorithm ends;
• otherwise we take the next element from the set
  – if the location that we just picked has been visited before, no need to look at it again, we skip the rest of this step
  – if the location is an exit, we found the solution - algorithm ends
  – otherwise, we examine all of the neighbors of that location, for each location that is not a wall, we add it to the set of
locations we are maintaining and then mark the current location as visited.   
