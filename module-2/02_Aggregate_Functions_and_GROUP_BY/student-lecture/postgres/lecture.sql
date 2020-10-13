-- ORDERING RESULTS

-- Populations of all countries in descending order




--Names of countries and continents in ascending order




-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)





-- LIMITING RESULTS

-- The 10 largest countries in the world





-- The name and average life expectancy of the countries with the 10 highest life expectancies.







-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip




-- CONCATENATING OUTPUTS

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.




-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city







-- AGGREGATE FUNCTIONS

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.



-- Counts the number of rows in the city table



-- Also counts the number of rows in the city table



-- Average Life Expectancy in the World



-- Total population in Ohio




-- The surface area of the smallest country in the world





-- The number of countries who declared independence in 1991



-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.



-- Gets the MIN population and the MAX population from the city table.



-- GROUP BY

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.





-- Count the number of countries where each language is spoken, ordered from most countries to least




-- Count the number of official languages and the number of unofficial languages per country




-- Average life expectancy of each continent ordered from highest to lowest





-- Exclude Antarctica from consideration for average life expectancy






-- Sum of the population of cities in each state in the USA ordered by state name






-- The average population of cities in each state in the USA ordered by state name






-- SUBQUERIES
-- Find the names of cities under a given government leader



-- Find the names of cities whose country they belong to has not declared independence yet



















