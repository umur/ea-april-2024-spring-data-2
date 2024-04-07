package com.ea.service;

import com.ea.FetchType;
import com.ea.Operation;
import com.ea.domain.OperationLog;
import com.ea.domain.Product;
import com.ea.dto.ProductDto;
import com.ea.repository.OperationLogRepository;
import com.ea.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.ehcache.sizeof.SizeOf;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final EntityManager entityManager;
    private final ProductRepository productRepository;
    private final OperationLogRepository operationLogRepository;


    public void getAllProducts() {

        final Long startTime = System.currentTimeMillis();
        final long usedMemoryBefore = getCurrentlyUsedMemory();

        Session session = entityManager.unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        stats.clear();
        stats.setStatisticsEnabled(true);

        List<Product> allProducts = productRepository.findAll();

                List<ProductDto> productList = allProducts
                .stream().map(ProductDto::new).toList();

        final Long endTime = System.currentTimeMillis();
        final long usedMemoryAfter = getCurrentlyUsedMemory();

        SizeOf sizeOf = SizeOf.newInstance();
        long size = sizeOf.deepSizeOf(allProducts);


        OperationLog operationLog = OperationLog.builder()
                .fetchMode(Operation.SELECT)
                .fetchType(FetchType.LAZY)
                .isChildEntityLoaded(true)
                .overallExecutionTime(endTime - startTime)
                .dataTransferSize(size)
                .noOfSqlQueries(stats.getPrepareStatementCount())
                .usedMemoryBefore(usedMemoryBefore)
                .usedMemoryAfter(usedMemoryAfter)
                .memoryUsage(usedMemoryAfter - usedMemoryBefore).build();

        operationLogRepository.save(operationLog);

        System.out.println("STAT DATA START");
        stats.logSummary();
        System.out.println("STAT DATA END");

    }



    private long getCurrentlyUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        return totalMemory - freeMemory;
    }
}
