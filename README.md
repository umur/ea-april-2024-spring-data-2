**Spring Data II Report**

**Fetching Strategies**

Each of these fetching strategies has its own trade-offs in terms of the number of SQL queries, the amount of data transferred from the database, and the performance of the operation. The best strategy to use depends on the specific requirements of your application and the characteristics of your data.

**1. SELECT**

* **Implementation:** The `getBySelectBenchmark` method in the `ProductService` class fetches all `ProductSelect` entities from the database. The entity uses `@Fetch(FetchMode.SELECT)` to retrieve Reviews.
* **Observation:** 1000 products and 100 related reviews each. 1000 total SQL queries (same as the number of products fetched).
* **Performance:**
    * Completion time: 1585 milliseconds
    * Memory usage: ~158476 megabytes
    * SQL queries: 1000
* **Practical Use:** Scenarios requiring analysis of properties or relationships of a large set of database data with associated entities.

**2. JOIN**

* **Implementation:** The `getByJoinBenchmark` method in the `ProductService` class fetches all `ProductJoin` entities from the database. The entity uses `@Fetch(FetchMode.JOIN)` to retrieve Reviews.
* **Observation:** 1000 products and 100 related reviews each. 1000 total SQL queries (same as the number of products fetched).
* **Performance:**
    * Completion time: 1750 milliseconds
    * Memory usage: ~197616 megabytes
    * SQL queries: 1000
* **Practical Use:** Combining data from multiple related database tables or entities into a single result set.

**3. SUBSELECT**

* **Implementation:** The `getBySubselectBenchmark` method in the `ProductService` class fetches all `ProductSubselect` entities from the database. The entity uses `@Fetch(FetchMode.SUBSELECT)` to retrieve Reviews.
* **Observation:**  1000 products with 100 associated reviews each fetched with just 2 SQL queries.
* **Performance:**
    * Completion time: 421 milliseconds (fastest)
    * Memory usage: ~217727 megabytes
    * SQL queries: 2 (most efficient)
* **Practical Use:** Fetching data with associated entities where the associated entities are rarely accessed, or their number varies greatly.

**4. BATCH**

* **Implementation:** The `getByBatchBenchmark` method in the `ProductService` class fetches all `ProductBatch` entities from the database. The entity uses `@BatchSize(size = 200)` to retrieve Reviews.
* **Observation:** 1000 products with 100 associated reviews each fetched with 6 SQL queries.
* **Performance:**
    * Completion time: 540 milliseconds
    * Memory usage: ~134214 megabytes
    * SQL queries: 6 (moderate)
* **Practical Use:** Fetching large amounts of data with associated entities with moderate efficiency, especially where the number of associated entities can vary.

**Summary**

This Spring Data JPA II Report explores four fetching strategies: `getBySelect()`, `getByJoin()`, `getBySubselect()`, and `getByBatch()`.  Understanding the trade-offs of each in terms of SQL queries, data transfer, and performance helps developers optimize their data retrieval based on their application's specific needs.