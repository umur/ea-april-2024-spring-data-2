package com.david.lab.service;

import com.david.lab.model.BenchmarkResponse;
import com.david.lab.model.batch.ProductBatchEager;
import com.david.lab.model.batch.ProductBatchLazy;
import com.david.lab.model.join.ProductJoinEager;
import com.david.lab.model.join.ProductJoinLazy;
import com.david.lab.model.select.ProductSelectEager;
import com.david.lab.model.select.ProductSelectLazy;
import com.david.lab.model.subselect.ProductSubselectEager;
import com.david.lab.model.subselect.ProductSubselectLazy;
import com.david.lab.repository.batch.ProductBatchEagerRepository;
import com.david.lab.repository.batch.ProductBatchLazyRepository;
import com.david.lab.repository.join.ProductJoinEagerRepository;
import com.david.lab.repository.join.ProductJoinLazyRepository;
import com.david.lab.repository.select.ProductSelectEagerRepository;
import com.david.lab.repository.select.ProductSelectLazyRepository;
import com.david.lab.repository.subselect.ProductSubselectEagerRepository;
import com.david.lab.repository.subselect.ProductSubselectLazyRepository;
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
public class BenchmarkService {

    public static final SizeOf SIZE_OF = SizeOf.newInstance();

    private final ProductSelectLazyRepository productSelectLazyRepository;
    private final ProductJoinLazyRepository productJoinLazyRepository;
    private final ProductSubselectLazyRepository productSubselectLazyRepository;
    private final ProductBatchLazyRepository productBatchLazyRepository;

    private final ProductSelectEagerRepository productSelectEagerRepository;
    private final ProductJoinEagerRepository productJoinEagerRepository;
    private final ProductSubselectEagerRepository productSubselectEagerRepository;
    private final ProductBatchEagerRepository productBatchEagerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public BenchmarkResponse getBySelectBenchmarkLazy() {
        Statistics stats = getStats();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("select lazy");
        List<ProductSelectLazy> productSelectLazies = productSelectLazyRepository.findAll();
        for (ProductSelectLazy productSelectLazy : productSelectLazies)
            productSelectLazy.getReviewedProduct().getFirst();

        stopWatch.stop();
        long dataSize = SIZE_OF.deepSizeOf(productSelectLazies);
        return getBenchmarkResponse(dataSize, stopWatch, stats);
    }

    public BenchmarkResponse getByJoinBenchmarkLazy() {
        Statistics stats = getStats();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("join lazy");
        List<ProductJoinLazy> productSelects = productJoinLazyRepository.findAll();
        for (ProductJoinLazy productproductJoinEager : productSelects)
            productproductJoinEager.getReviewedProduct().getFirst();

        stopWatch.stop();
        long dataSize = SIZE_OF.deepSizeOf(productSelects);
        return getBenchmarkResponse(dataSize, stopWatch, stats);
    }

    public BenchmarkResponse getBySubselectBenchmarkLazy() {
        Statistics stats = getStats();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("subselect lazy");
        List<ProductSubselectLazy> productSubselectLazies = productSubselectLazyRepository.findAll();
        for (ProductSubselectLazy productSubselectLazy : productSubselectLazies)
            productSubselectLazy.getReviewedProduct().getFirst();

        stopWatch.stop();
        long dataSize = SIZE_OF.deepSizeOf(productSubselectLazies);
        return getBenchmarkResponse(dataSize, stopWatch, stats);
    }

    public BenchmarkResponse getByBatchBenchmarkLazy() {
        Statistics stats = getStats();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("batch lazy");
        List<ProductBatchLazy> productBatchLazies = productBatchLazyRepository.findAll();
        for (ProductBatchLazy productBatchLazy : productBatchLazies)
            productBatchLazy.getReviewedProduct().getFirst();

        stopWatch.stop();
        long dataSize = SIZE_OF.deepSizeOf(productBatchLazies);
        return getBenchmarkResponse(dataSize, stopWatch, stats);
    }

    public BenchmarkResponse getBySelectBenchmarkEager() {
        Statistics stats = getStats();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("select eager");
        List<ProductSelectEager> productSelectEagers = productSelectEagerRepository.findAll();
        for (ProductSelectEager productSelectEager : productSelectEagers)
            productSelectEager.getReviewedProduct().getFirst();

        stopWatch.stop();
        long dataSize = SIZE_OF.deepSizeOf(productSelectEagers);
        return getBenchmarkResponse(dataSize, stopWatch, stats);
    }

    public BenchmarkResponse getByJoinBenchmarkEager() {
        Statistics stats = getStats();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("join eager");
        List<ProductJoinEager> productJoinEagers = productJoinEagerRepository.findAll();
        for (ProductJoinEager productJoinEager : productJoinEagers)
            productJoinEager.getReviewedProduct().getFirst();

        stopWatch.stop();
        long dataSize = SIZE_OF.deepSizeOf(productJoinEagers);
        return getBenchmarkResponse(dataSize, stopWatch, stats);
    }

    public BenchmarkResponse getBySubselectBenchmarkEager() {
        Statistics stats = getStats();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("subselect eager");
        List<ProductSubselectEager> productSubselectEagers = productSubselectEagerRepository.findAll();
        for (ProductSubselectEager productSubselectEager : productSubselectEagers)
            productSubselectEager.getReviewedProduct().getFirst();

        stopWatch.stop();
        long dataSize = SIZE_OF.deepSizeOf(productSubselectEagers);
        return getBenchmarkResponse(dataSize, stopWatch, stats);
    }

    public BenchmarkResponse getByBatchBenchmarkEager() {
        Statistics stats = getStats();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("batch eager");
        List<ProductBatchEager> productBatchEagers = productBatchEagerRepository.findAll();
        for (ProductBatchEager productBatchEager : productBatchEagers)
            productBatchEager.getReviewedProduct().getFirst();

        stopWatch.stop();
        long dataSize = SIZE_OF.deepSizeOf(productBatchEagers);
        return getBenchmarkResponse(dataSize, stopWatch, stats);
    }

    private static BenchmarkResponse getBenchmarkResponse(long dataSize, StopWatch stopWatch, Statistics stats) {
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double dataTransferRate = dataSize / stopWatch.getTotalTimeSeconds();
        return new BenchmarkResponse(stopWatch.getTotalTimeMillis(), usedMemory, stats.getPrepareStatementCount(), dataTransferRate);
    }

    private Statistics getStats() {
        Session session = entityManager.unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        stats.clear();
        stats.setStatisticsEnabled(true);
        return stats;
    }

}