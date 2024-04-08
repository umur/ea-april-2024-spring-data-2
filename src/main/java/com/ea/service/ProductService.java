package com.ea.service;

import com.ea.FetchType;
import com.ea.Operation;
import com.ea.domain.OperationLog;
import com.ea.domain.Product;
import com.ea.repository.OperationLogRepository;
import com.ea.repository.ProductRepository;
import com.ea.util.ObjectSizeEstimator;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private static final Runtime RUNTIME = Runtime.getRuntime();
    private final EntityManager entityManager;
    private final ProductRepository productRepository;
    private final OperationLogRepository operationLogRepository;


    public void getAllProducts() {

        final Long startTime = System.currentTimeMillis();

        Session session = entityManager.unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        stats.clear();
        stats.setStatisticsEnabled(true);

        RUNTIME.gc();
        final long usedMemoryBefore = getCurrentlyUsedMemory();


        List<Product> allProducts = productRepository.findAll();


        final Long endTime = System.currentTimeMillis();
        final long usedMemoryAfter = getCurrentlyUsedMemory();
        long estimateSizeOfAllProducts = ObjectSizeEstimator.estimateSize(allProducts);

        OperationLog operationLog = OperationLog.builder()
                .batchSize(10)
                .fetchMode(Operation.BATCH)
                .fetchType(FetchType.EAGER)
                .overallExecutionTime(endTime - startTime)
                .dataTransferSize(estimateSizeOfAllProducts)
                .noOfSqlQueries(stats.getPrepareStatementCount())
                .usedMemoryBefore(usedMemoryBefore)
                .usedMemoryAfter(usedMemoryAfter)
                .memoryUsage(usedMemoryAfter - usedMemoryBefore).build();

        operationLogRepository.save(operationLog);

        stats.logSummary();
        RUNTIME.gc();
    }



    private long getCurrentlyUsedMemory() {
        long totalMemory = RUNTIME.totalMemory();
        long freeMemory = RUNTIME.freeMemory();
        return totalMemory - freeMemory;
    }
}
