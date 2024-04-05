
## Lab4 -- Experiment of Fetching strategies - Group 3G

### Group members

1.  Truong Hoang Son (Sonny) - 617315

2.  Bui Ba Quyen (Mike) - 617282

3.  Nguyen Huu Chi (Sean) - 617310

# Spring Data II

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

[FetchMode SELECT]

![A screenshot of a computer program Description automatically
generated](./images/media/image1.png){width="7.5in"
height="3.567361111111111in"}

**Number of Query**: 1

**Observation:** LAZY

**Query**:

Hibernate: select u1_0.id,u1_0.name from user u1_0

(100 times upon serialization for restful service)

Hibernate: select
r1_0.user_id,r1_0.id,r1_0.comment,p1_0.id,p1_0.name,p1_0.price from
review r1_0 left join product p1_0 on p1_0.id=r1_0.product_id where
r1_0.user_id=?

**Time taken**: \~ 11.35 seconds.

![A screenshot of a computer Description automatically
generated](./images/media/image2.png){width="3.8750284339457566in"
height="0.8333398950131233in"}

**Memory**: \~ 473Mb

![A screenshot of a computer Description automatically
generated](./images/media/image3.png){width="7.5in"
height="3.279166666666667in"}

**Practical Use:**

[FetchMode JOIN]{.mark}

![A screenshot of a computer program Description automatically
generated](./images/media/image4.png){width="7.5in"
height="3.714583333333333in"}

![A screen shot of a computer Description automatically
generated](./images/media/image5.png){width="7.5in"
height="1.7097222222222221in"}

**Number of Query**: N+1

**Observation**: EAGER

Hibernate: select u1_0.id,u1_0.name from user u1_0

(100 times) Hibernate: select
r1_0.user_id,r1_0.id,r1_0.comment,p1_0.id,p1_0.name,p1_0.price from
review r1_0 left join product p1_0 on p1_0.id=r1_0.product_id where
r1_0.user_id=?

**Time taken**: \~15 seconds.

![A screenshot of a computer Description automatically
generated](./images/media/image6.png){width="3.953153980752406in"
height="0.7135465879265092in"}

**Memory**: \~547Mb =\> higher than SELECT mode

![A screenshot of a computer Description automatically
generated](./images/media/image7.png){width="7.5in"
height="3.2041666666666666in"}

**Practical Use:**

[FetchMode SUBSELECT]{.mark}

![A screenshot of a computer program Description automatically
generated](./images/media/image8.png){width="7.5in"
height="4.751388888888889in"}

**Number of Query**: 1

**Observation**: LAZY

Hibernate: select u1_0.id,u1_0.name from user u1_0

(1 time query when serialization from restful service)

Query: Hibernate: select
r1_0.user_id,r1_0.id,r1_0.comment,p1_0.id,p1_0.name,p1_0.price from
review r1_0 left join product p1_0 on p1_0.id=r1_0.product_id where
r1_0.user_id in (select u1_0.id from user u1_0)

**Time taken**: \~ 15 seconds.

![A screenshot of a computer Description automatically
generated](./images/media/image9.png){width="3.83336176727909in"
height="0.7500054680664917in"}

**Memory**: \~750Mb (Highest)

![A screenshot of a computer Description automatically
generated](./images/media/image10.png){width="7.5in"
height="3.2159722222222222in"}

**Practical Use:**

[Fetch mode BATCH]{.mark}

![A screenshot of a computer screen Description automatically
generated](./images/media/image11.png){width="7.5in" height="4.8625in"}

**Number of Query**: 1 + (total record / batchSize)

Hibernate: select u1_0.id,u1_0.name from user u1_0

In this case, query 100 Users with batch size = 10, will result in 10
queries

Query: Hibernate: select
r1_0.user_id,r1_0.id,r1_0.comment,p1_0.id,p1_0.name,p1_0.price from
review r1_0 left join product p1_0 on p1_0.id=r1_0.product_id where
r1_0.user_id in (?,?,?,?,?,?,?,?,?,?)

**Observation**: follow the FetchMode, number of queries is divided by
(total record / batchSize)

**Time taken**: \~13.20 seconds.

![A screenshot of a computer Description automatically
generated](./images/media/image12.png){width="3.8489862204724408in"
height="0.7239632545931759in"}

**Memory**: 688 Mb

![A screenshot of a computer Description automatically
generated](./images/media/image13.png){width="7.5in"
height="3.1506944444444445in"}

**Practical Use:**

Comparing the performance of different fetch modes (SELECT, JOIN,
SUBSELECT) involves considering various factors such as the size and
complexity of your data model, the number of associations, and the
specific use case of your application. Let\'s discuss the performance
characteristics of each fetch mode:

**FetchMode.SELECT**:

> **Pros**:
>
> Simple and straightforward fetching strategy.
>
> Can be efficient for fetching small collections or when lazy loading
> is preferred.
>
> **Cons**:
>
> Prone to the N+1 query problem, where each association fetches
> additional data through separate SELECT statements, leading to
> performance degradation.
>
> Not suitable for fetching large collections or deep object graphs due
> to the potential for excessive database round-trips.

**FetchMode.JOIN**:

> **Pros**:
>
> Reduces the number of database round-trips by fetching all associated
> entities in a single SQL SELECT statement with JOINs.
>
> Can improve performance for fetching large collections or when eager
> loading is necessary.
>
> **Cons**:
>
> May result in Cartesian product if associations have many-to-many
> relationships or if the fetched entities have deep object graphs,
> leading to excessive data duplication.
>
> Can increase memory usage and network traffic due to fetching
> unnecessary data.

**FetchMode.SUBSELECT**:

> **Pros**:
>
> Reduces the number of database round-trips compared to
> FetchMode.SELECT by grouping associated entities within a single
> subquery.
>
> Suitable for scenarios where eager loading is necessary but fully
> eager fetching (as with JOIN) is not desired.
>
> **Cons**:
>
> May still result in multiple SQL SELECT statements being executed,
> especially if there are many associations or if fetched entities have
> their own associations.
>
> Performance can degrade if there are too many associations or if the
> subqueries fetch unnecessary data.

In general, the optimal fetch mode depends on your specific use case and
performance requirements. For example:

-   Use FetchMode.SELECT for lazy loading of small collections or when
	the N+1 query problem is manageable.

-   Use FetchMode.JOIN for eager loading of large collections or when
	minimizing database round-trips is critical.

-   Use FetchMode.SUBSELECT as a compromise between SELECT and JOIN,
	suitable for scenarios where eager loading is necessary but fully
	eager fetching is not desired.

[Reports]{.mark}

-   Time Report

```{=html}
<!-- -->
```
-   Memory Report

￼![](./images/142f20c639a9b3c588a85c97eee3a9edd330514b.png){width="5.02083552055993in"
height="3.0208333333333335in"}

-   Number of SQL Queries

![](./images/137d7218aa1e2fe60f2917d5a450592195ae83d0.png){width="5.0in"
height="2.2916666666666665in"}

-   Transfer Data Size : seem to be same for all Fetch Strategies
