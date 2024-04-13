# Spring Data II

## Lab4 -- Experiment of Fetching strategies - Group 3G

### Group members

1.  Truong Hoang Son (Sonny) - 617315

2.  Bui Ba Quyen (Mike) - 617282

3.  Nguyen Huu Chi (Sean) - 617310

---

The goal of this assignment is to learn the fetching strategies supported by Spring Data JPA, understand their differences, and assess their impact on application performance. Through this exercise, you will learn how to optimize data retrieval in a Spring Boot application by employing various fetching strategies such as `select`, `join`, `subselect`, and `batch`.

###  Requirements

---
* Make domain models for `user`,`product`, `review`.
* Populate the database with sample data including **at least** 100 users, 1000 products, and 1000 reviews for each product.
* Implement methods in your service layer, each demonstrating one of the fetching strategies (`select`, `join`, `subselect`, `batch`).
* Measure the number of SQL queries generated and the execution time for each fetching strategy.
* Analyze the differences in performance among the fetching strategies, focusing on the trade-offs between the number of queries generated and the overall execution time.
* Discuss the scenarios in which each fetching strategy would be most effective, considering factors such as data size, association complexity, and application requirements.

## Submission

Please find the PDF file for the report https://github.com/cnguyen36/ea-april-2024-spring-data-2/blob/main/EA%20Lab4%20-%20Group%203G.pdf
