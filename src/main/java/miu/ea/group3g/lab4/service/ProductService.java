package miu.ea.group3g.lab4.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.ea.group3g.lab4.entity.*;
import miu.ea.group3g.lab4.repository.*;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductJoinRepository productRepository;
    private final ProductSelectLazyRepository productSelectLazyRepo;
    private final ProductSelectEagerRepository productSelectEagerRepo;
    private final ProductSubSelectLazyRepository productSubSelectLazyRepo;
    private final ProductSubSelectEagerRepository productSubSelectEagerRepo;
    private final ProductBatchLazyRepository productBatchLazyRepo;
    private final ProductBatchEagerRepository productBatchEagerRepo;

    //join
    public List<ProductJoin> getAll() {
        List<ProductJoin> ret = productRepository.findAll();
        return ret;
    }

    public List<ProductSelectLazy> getAllSelectLazy() {
        List<ProductSelectLazy> ret = productSelectLazyRepo.findAll();
        return ret;
    }
    public List<ProductSelectEager> getAllSelectEager() {
        return productSelectEagerRepo.findAll();
    }
    public List<ProductSubSelectLazy> getAllSubSelectLazy() {
        return productSubSelectLazyRepo.findAll();
    }
    public List<ProductSubSelectEager> getAllSubSelectEager() {
        return productSubSelectEagerRepo.findAll();
    }
    public List<ProductBatchLazy> getAllBatchLazy() {
        return productBatchLazyRepo.findAll();
    }
    public List<ProductBatchEager> getAllBatchEager() {
        return productBatchEagerRepo.findAll();
    }

}
