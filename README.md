CICD-1 Lab 1
Browser / Swagger
 |
 +--> Catalog Service :8081 --> temporary Product List<>
 |
 +--> Order Service :8082 --> temporary Order List<>
Separate GitHub repositories
Separate open pull requests
Week 2: add JPA + H2
Week 3: add Order -> Catalog communication with OpenFeign

Week 3 Questions:

1. Which table owns the foreign key?
-- products owns the foreign key

2. Why can several Product rows refer to one Category?
-- because many product rows can store the same category id

3. What happens to an existing Product with CATEGORY_ID = NULL in this INNER JOIN?
-- it wont compile 

4. Which two SQL columns appear in the ON clause?
-- Categories and Product

