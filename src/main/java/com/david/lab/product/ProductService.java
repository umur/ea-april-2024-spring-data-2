package com.david.lab.product;

import com.david.lab.product.model.*;
import com.david.lab.product.repository.ProductBatchRepository;
import com.david.lab.product.repository.ProductJoinRepository;
import com.david.lab.product.repository.ProductSelectRepository;
import com.david.lab.product.repository.ProductSubselectRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.ehcache.sizeof.SizeOf;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductSelectRepository productSelectRepository;
    private final ProductJoinRepository productJoinRepository;
    private final ProductSubselectRepository productSubselectRepository;
    private final ProductBatchRepository productBatchRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public BenchmarkResponse getBySelectBenchmark() {
        Session session = entityManager.unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        stats.clear();
        stats.setStatisticsEnabled(true);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Select");
        List<ProductSelect> productSelects = productSelectRepository.findAll();
        for (ProductSelect productSelect : productSelects)
            productSelect.getReviewedProduct().getFirst();

        stopWatch.stop();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SizeOf sizeOf = SizeOf.newInstance();
        long dataSize = sizeOf.deepSizeOf(productSelects);
        double dataTransferRate = dataSize / stopWatch.getTotalTimeSeconds();
        return new BenchmarkResponse(stopWatch.getTotalTimeMillis() + " ms elapsed.",
                usedMemory / 1024 + " megabytes.", stats.getPrepareStatementCount() + " SQL queries.", dataTransferRate + " bytes/sec.");
    }

    public BenchmarkResponse getByJoinBenchmark() {
        Session session = entityManager.unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        stats.clear();
        stats.setStatisticsEnabled(true);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Join");
        List<ProductJoin> productSelects = productJoinRepository.findAll();
        for (ProductJoin productproductJoin : productSelects)
            productproductJoin.getReviewedProduct().getFirst();

        stopWatch.stop();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SizeOf sizeOf = SizeOf.newInstance();
        long dataSize = sizeOf.deepSizeOf(productSelects);
        double dataTransferRate = dataSize / stopWatch.getTotalTimeSeconds();
        return new BenchmarkResponse(stopWatch.getTotalTimeMillis() + " ms elapsed.",
                usedMemory / 1024 + " megabytes.", stats.getPrepareStatementCount() + " SQL queries.", dataTransferRate + " bytes/sec.");
    }

    public BenchmarkResponse getBySubselectBenchmark() {
        Session session = entityManager.unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        stats.clear();
        stats.setStatisticsEnabled(true);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Subselect");
        List<ProductSubselect> productSubselects = productSubselectRepository.findAll();
        for (ProductSubselect productSubselect : productSubselects)
            productSubselect.getReviewedProduct().getFirst();

        stopWatch.stop();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SizeOf sizeOf = SizeOf.newInstance();
        long dataSize = sizeOf.deepSizeOf(productSubselects);
        double dataTransferRate = dataSize / stopWatch.getTotalTimeSeconds();
        return new BenchmarkResponse(stopWatch.getTotalTimeMillis() + " ms elapsed.",
                usedMemory / 1024 + " megabytes.", stats.getPrepareStatementCount() + " SQL queries.", dataTransferRate + " bytes/sec.");
    }

    public BenchmarkResponse getByBatchBenchmark() {
        Session session = entityManager.unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        stats.clear();
        stats.setStatisticsEnabled(true);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Batch");
        List<ProductBatch> productBatches = productBatchRepository.findAll();
        for (ProductBatch productBatch : productBatches)
            productBatch.getReviewedProduct().getFirst();

        stopWatch.stop();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SizeOf sizeOf = SizeOf.newInstance();
        long dataSize = sizeOf.deepSizeOf(productBatches);
        double dataTransferRate = dataSize / stopWatch.getTotalTimeSeconds();
        return new BenchmarkResponse(stopWatch.getTotalTimeMillis() + " ms elapsed.",
                usedMemory / 1024 + " megabytes.", stats.getPrepareStatementCount() + " SQL queries.", dataTransferRate + " bytes/sec.");
    }

}