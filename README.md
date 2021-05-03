# 21S_SE_Box
This contains instructions for how to run the program (the "Wood Wizard"). Includes versions for if the project is being run through a maven project or as a single java file.

First, change directories to the proper file location: the maven project folder if using maven, or the folder containing the BoxMaker.java file.
Ex:
>>> cd BoxMakerFolder
>>> ls
BoxMaker.java


To compile the program:
For maven:
>>> mvn compile

For single java file
>>> javac BoxMaker.java

To run the compiled program:
For maven:
>>> java -cp target/classes BoxMaker

For single java file
>>> java BoxMaker

Upon running the program you will recieve the following prompt:
Enter the desired dimensions for your box (in inches), each within 2-25in:
Length:

Follow the prompt, entering the desired dimensions (in inches) of the box you are wishing to create.
Ex:
Enter the desired dimensions for your box (in inches), each within 2-25in:
Length: 3
Width: 4
Height: 5

After inputting the box's dimensions, you will recieve the following prompt:
Do you want inserts (will show up in inserts.svg)? [Y/N]
Response:

Respond with Y if you want to create inserts in addition to your box (will be located in a separate SVG file upon completion), and N if you want just the box.
If you respond with Y, you will be further prompted for the desired height of the inserts and the number of rows/columns to be created in the box by the inserts.
Upon completion of the prompts, or if you respond with N, the program will ouput that the SVGs have been generated.

Example Y:
Do you want inserts (will show up in inserts.svg)? [Y/N]
Response: N
Generating box with size: 3.0in x 4.0in x 5.0in.
Box Generated

Example N:
Do you want inserts (will show up in inserts.svg)? [Y/N]
Response: y
What height would you like the inserts to be? 1-5.0in:
Insert Height: 5
How many rows of sections do you want? 2-5:
Rows: 2
How many columns of sections do you want? 2-5:
Columns: 2
Generating box with size: 3.0in x 4.0in x 5.0in.
Additionally generating 5.0in tall inserts to create 2.0 x 2.0 sections in the box.
Box Generated
Inserts Generated

The program will then terminate, and in the current file location, regarless of use of maven or single java file, the SVG file will be created (if already present) or updated (if already present).
The box will be located in output.svg
The inserts will be located in inserts.svg
