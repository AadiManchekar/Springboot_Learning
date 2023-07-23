docker compose up -d

Run the Project

docker exec -it <container_id> bash

\c aadi

\d
(You should see table and a sequence)

execute below commands to populate the data

INSERT INTO question (id, question_title, option1, option2, option3, option4, right_answer, difficulty_level, category)
VALUES
  (1, 'What is the output of 2 + 2?', '3', '4', '5', '6', '4', 'Easy', 'Java'),
  (2, 'Which keyword is used to define a constant in Java?', 'var', 'let', 'final', 'const', 'final', 'Medium', 'Java'),
  (3, 'What does JVM stand for?', 'Java Visual Machine', 'Java Virtual Module', 'Java Virtual Machine', 'JavaScript Virtual Machine', 'Java Virtual Machine', 'Easy', 'Java'),
  (4, 'What does the method System.out.println() do?', 'Prints the text on the console', 'Prints the text in a popup dialog', 'Stores the text in a file', 'Does nothing', 'Prints the text on the console', 'Easy', 'Java'),
  (5, 'Which loop is guaranteed to execute at least once?', 'while loop', 'do-while loop', 'for loop', 'if statement', 'do-while loop', 'Medium', 'Java'),
  (6, 'In Python, how do you create a dictionary?', 'my_dict = {}', 'my_dict = []', 'my_dict = ()', 'my_dict = set()', 'my_dict = {}', 'Easy', 'Python'),
  (7, 'What is the result of 10 % 3?', '3', '3.333', '0.333', '1', '1', 'Easy', 'Python'),
  (8, 'What is the correct way to comment multiple lines in Python?', '/* This is a comment */', '// This is a comment', '/* This is a comment */', '# This is a comment', '# This is a comment', 'Medium', 'Python'),
  (9, 'What is the output of print("Hello " + "World")?', 'Hello World', 'HelloWorld', 'Hello+World', 'Hello  World', 'Hello World', 'Easy', 'Python'),
  (10, 'What is the correct way to define a function in Python?', 'def my_function()', 'function my_function()', 'def my_function:', 'function my_function:', 'def my_function():', 'Medium', 'Python'),
  (11, 'In C, which header file is required to use printf()?', 'stdio.h', 'conio.h', 'stdlib.h', 'math.h', 'stdio.h', 'Easy', 'C'),
  (12, 'What does the sizeof() operator in C return?', 'Size of a variable', 'Size of a function', 'Size of a pointer', 'Size of a data type', 'Size of a data type', 'Medium', 'C'),
  (13, 'How do you declare a pointer in C?', 'int ptr;', 'int *ptr;', 'pointer ptr;', 'int &ptr;', 'int *ptr;', 'Easy', 'C'),
  (14, 'What is the result of 3 + 5.0 in C?', '3.5', '8.0', '8', '5', '8.0', 'Medium', 'C'),
  (15, 'In C, what is the correct way to access the value of a pointer?', 'ptr', '*ptr', '&ptr', '&&ptr', '*ptr', 'Easy', 'C'),
  (16, 'What is the output of printf("Hello %s", "World")?', 'Hello World', 'Hello%s', 'Hello %s', 'Hello', 'Hello World', 'Medium', 'C'),
  (17, 'What is the main function signature in C?', 'main()', 'int main()', 'void main()', 'int main(void)', 'int main()', 'Easy', 'C'),
  (18, 'In C, what is the correct way to include a header file named "header.h"?', 'include "header.h"', '#include <header.h>', '#include "header.h"', 'header.h', '#include "header.h"', 'Medium', 'C'),
  (19, 'How do you allocate memory for an array in C?', 'int arr = malloc(size);', 'int arr[] = new int[size];', 'int arr[];', 'int *arr = (int *)malloc(size);', 'int *arr = (int *)malloc(size);', 'Easy', 'C'),
  (20, 'What is the correct format specifier for a double in printf()?', '%d', '%f', '%lf', '%s', '%f', 'Medium', 'C');
