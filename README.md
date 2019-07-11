<b>This project determines the type of a triangle and collects this triangles in repository since the application was launched.</b>

The main program running allows us to select an action in the program:

d: Enter new single Triangle  | e: Display last Triangle | f: Upload file with Triangles | g: Display all Triangles | q: Quit


<b> --- Enter new Triangle  --- </b>

User's input is checked thru three validators before will create new Triangle object.
It is necessary to be sure if user enters 
[1] only 3 arguments,
[2] each of argument being double value, 
[3] arguments which allow to build Triangle.
After that, the program can create new Triangle with a parameter of input arguments and select type of triangle

<b> --- Display all Triangles without duplicates  --- </b>

Each new Triangle is saved in Triangle Repository List. 
When it is necessary to get List without duplicates, 
program use function "equals and hashCode" inside Triangle Class 
to compare all objects during creating new List

