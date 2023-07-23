docker compose up -d

Run the Project

docker exec -it <container_id> bash

\c aadi

\d
(You should see table and a sequence)

execute below commands to populate the data

INSERT INTO question (id, difficulty_level, option1, option2, option3, option4, question_title, right_answer)
VALUES
(1, 'Easy', 'Apple', 'Banana', 'Orange', 'Grapes', 'What is the name of a red fruit?', 'Apple'),
(2, 'Medium', 'USA', 'France', 'China', 'Germany', 'Which country has the Eiffel Tower?', 'France'),
(3, 'Hard', 'Football', 'Basketball', 'Cricket', 'Tennis', 'Which sport uses a racket?', 'Tennis'),
(4, 'Easy', 'Dog', 'Cat', 'Elephant', 'Lion', 'What is a common pet?', 'Dog'),
(5, 'Medium', 'Java', 'Python', 'C++', 'JavaScript', 'Which programming language is used for web development?', 'JavaScript'),
(6, 'Hard', 'Amazon', 'Google', 'Microsoft', 'Apple', 'Which company owns the search engine "Bing"?', 'Microsoft'),
(7, 'Easy', 'January', 'March', 'May', 'July', 'Which month has 31 days?', 'July'),
(8, 'Medium', 'Red', 'Blue', 'Green', 'Yellow', 'What color is a ripe banana?', 'Yellow'),
(9, 'Hard', 'Mercury', 'Venus', 'Mars', 'Jupiter', 'Which planet is closest to the Sun?', 'Mercury'),
(10, 'Easy', 'Cow', 'Horse', 'Pig', 'Sheep', 'What animal produces milk?', 'Cow'),
(11, 'Medium', 'Tokyo', 'New York', 'London', 'Paris', 'Which city is known for the Big Ben?', 'London'),
(12, 'Hard', 'Albert Einstein', 'Isaac Newton', 'Charles Darwin', 'Nikola Tesla', 'Who proposed the theory of general relativity?', 'Albert Einstein'),
(13, 'Easy', 'Circle', 'Square', 'Triangle', 'Rectangle', 'What shape has three sides?', 'Triangle'),
(14, 'Medium', 'Atlantic', 'Pacific', 'Indian', 'Arctic', 'Which ocean is the largest?', 'Pacific'),
(15, 'Hard', 'Aston Martin', 'Ferrari', 'Lamborghini', 'Porsche', 'Which car brand has a horse in its logo?', 'Ferrari');
