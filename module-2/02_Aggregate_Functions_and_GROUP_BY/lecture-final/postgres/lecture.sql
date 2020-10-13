-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name, population
FROM country
ORDER BY population DESC;


--Names of countries and continents in ascending order

SELECT name, continent
FROM country
ORDER BY continent ASC, name DESC;


-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

SELECT name, district, population
FROM city
WHERE countrycode = 'USA'
ORDER BY name, population DESC;



-- LIMITING RESULTS

-- The 10 largest countries in the world

SELECT name, surfacearea
FROM country
ORDER BY surfacearea DESC
LIMIT 10;



-- The name and life expectancy of the countries with the 10 highest life expectancies.

SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC, name
LIMIT 10;


-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip

SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC, name
LIMIT 20 OFFSET 10;


-- CONCATENATING OUTPUTS

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

SELECT (language || ' is spoken in the country with code ' || countrycode) AS phrase FROM countrylanguage;



-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city

SELECT (name || ', ' || district) AS city_state
FROM city
WHERE district IN ('California', 'Oregon', 'Washington')
ORDER BY district, name;




-- AGGREGATE FUNCTIONS

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table

SELECT COUNT(*) FROM city;


-- Also counts the number of rows in the city table

SELECT COUNT(name) FROM city;

SELECT COUNT(name) FROM country;
SELECT COUNT(indepyear) FROM country; --lower because of null values
SELECT COUNT(*) FROM country;

-- Average Life Expectancy in the World

SELECT AVG(lifeexpectancy) FROM country;


-- Total population in Ohio

SELECT SUM(population), AVG(population)
FROM city
WHERE district = 'Ohio';


-- The surface area of the smallest country in the world

SELECT MIN(surfacearea), MAX(surfacearea) FROM country;


-- The number of countries who declared independence in 1991

SELECT COUNT(name)
FROM country
WHERE indepyear = 1991;

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.

SELECT SUM(population), round(AVG(population), 2) AS average_pop, COUNT(*)
FROM city;



-- Gets the MIN population and the MAX population from the city table.

SELECT MIN(population), MAX(population)
FROM city;


-- GROUP BY

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.

SELECT * FROM city;

SELECT countrycode, MIN(population), MAX(population)
FROM city
GROUP BY countrycode;



-- Count the number of countries where each language is spoken, ordered from most countries to least

SELECT * FROM countrylanguage;

SELECT language, COUNT(countrycode) AS country_count
FROM countrylanguage
GROUP BY language
ORDER BY country_count DESC;

-- Count the number of official languages and the number of unofficial languages per country

SELECT countrycode, isofficial, COUNT(language)
FROM countrylanguage
GROUP BY countrycode, isofficial
ORDER BY countrycode;


-- Average life expectancy of each continent ordered from highest to lowest

SELECT continent, AVG(lifeexpectancy)
FROM country
GROUP BY continent
ORDER BY avg DESC;



-- Exclude Antarctica from consideration for average life expectancy

SELECT continent, round(CAST(AVG(lifeexpectancy) AS numeric), 2) AS avg_expectancy --ANSI
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY avg_expectancy DESC;


SELECT continent, round(AVG(lifeexpectancy)::numeric, 2) AS avg_expectancy --Postgres specific
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY avg_expectancy DESC;


-- Sum of the population of cities in each state in the USA ordered by state name

SELECT district, SUM(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

-- The average population of cities in each state in the USA ordered by state name


SELECT district, AVG(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

SELECT district, round(AVG(population))
FROM city
WHERE countrycode = 'USA'
GROUP BY district
HAVING AVG(population) > 300000
ORDER BY district;

SELECT name, COUNT(name)
FROM city
GROUP BY name
HAVING COUNT(name) > 1
ORDER BY COUNT(name) DESC;


-- SUBQUERIES
-- Find the names of cities under a given government leader

SELECT DISTINCT headofstate FROM country;

SELECT name
FROM city
WHERE countrycode IN (SELECT code FROM country WHERE headofstate = 'Elisabeth II');

SELECT name
FROM city
WHERE countrycode = (SELECT code FROM country WHERE name = 'China');

-- Find the names of cities whose country they belong to has not declared independence yet

SELECT name
FROM city
WHERE countrycode IN (SELECT code FROM country WHERE indepyear IS NULL);

