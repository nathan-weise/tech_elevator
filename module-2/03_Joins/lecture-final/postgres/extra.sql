-- Display all the films and their language

SELECT title, language.name
FROM film
JOIN language ON film.language_id = language.language_id;

-- Display all the films and in English

SELECT title, language.name
FROM film
JOIN language ON film.language_id = language.language_id
WHERE language.name = 'English';

-- Display all the films with their category

SELECT title, category.name
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id;

-- Display all the films with a category of Horror

SELECT title, category.name
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Horror';


-- Display all the films with a category of Horror and title that begins with the letter F

SELECT title, category.name
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Horror' AND title LIKE 'F%';


-- Who acted in what together?

-- How many times have two actors appeared together?

-- What movies did the two most often acted together actors appear in together?
