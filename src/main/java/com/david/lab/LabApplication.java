package com.david.lab;

import com.david.lab.model.User;
import com.david.lab.model.batch.ProductBatchEager;
import com.david.lab.model.batch.ProductBatchLazy;
import com.david.lab.model.batch.ReviewBatchEager;
import com.david.lab.model.batch.ReviewBatchLazy;
import com.david.lab.model.join.ProductJoinEager;
import com.david.lab.model.join.ProductJoinLazy;
import com.david.lab.model.join.ReviewJoinEager;
import com.david.lab.model.join.ReviewJoinLazy;
import com.david.lab.model.select.ProductSelectEager;
import com.david.lab.model.select.ProductSelectLazy;
import com.david.lab.model.select.ReviewSelectEager;
import com.david.lab.model.select.ReviewSelectLazy;
import com.david.lab.model.subselect.ProductSubselectEager;
import com.david.lab.model.subselect.ProductSubselectLazy;
import com.david.lab.model.subselect.ReviewSubselectEager;
import com.david.lab.model.subselect.ReviewSubselectLazy;
import com.david.lab.repository.UserRepository;
import com.david.lab.repository.batch.ProductBatchEagerRepository;
import com.david.lab.repository.batch.ProductBatchLazyRepository;
import com.david.lab.repository.batch.ReviewBatchEagerRepository;
import com.david.lab.repository.batch.ReviewBatchLazyRepository;
import com.david.lab.repository.join.ProductJoinEagerRepository;
import com.david.lab.repository.join.ProductJoinLazyRepository;
import com.david.lab.repository.join.ReviewJoinEagerRepository;
import com.david.lab.repository.join.ReviewJoinLazyRepository;
import com.david.lab.repository.select.ProductSelectEagerRepository;
import com.david.lab.repository.select.ProductSelectLazyRepository;
import com.david.lab.repository.select.ReviewSelectEagerRepository;
import com.david.lab.repository.select.ReviewSelectLazyRepository;
import com.david.lab.repository.subselect.ProductSubselectEagerRepository;
import com.david.lab.repository.subselect.ProductSubselectLazyRepository;
import com.david.lab.repository.subselect.ReviewSubselectEagerRepository;
import com.david.lab.repository.subselect.ReviewSubselectLazyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootApplication
public class LabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }

}