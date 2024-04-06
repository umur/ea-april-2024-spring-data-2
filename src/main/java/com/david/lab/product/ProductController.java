package com.david.lab.product;

import com.david.lab.product.model.BenchmarkResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Benchmark APIs")
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("select-benchmark")
    @Operation(summary = "Benchmark - Strategy used = SELECT")
    public ResponseEntity<BenchmarkResponse> getBySelectBenchmark() {
        return ResponseEntity.ok(productService.getBySelectBenchmark());
    }

    @GetMapping("join-benchmark")
    @Operation(summary = "Benchmark - Strategy used = JOIN")
    public ResponseEntity<BenchmarkResponse> getByJoinBenchmark() {
        return ResponseEntity.ok(productService.getByJoinBenchmark());
    }

    @GetMapping("subselect-benchmark")
    @Operation(summary = "Benchmark - Strategy used = SUBSELECT")
    public ResponseEntity<BenchmarkResponse> getBySubselectBenchmark() {
        return ResponseEntity.ok(productService.getBySubselectBenchmark());
    }

    @GetMapping("batch-benchmark")
    @Operation(summary = "Benchmark - Strategy used = SELECT with BATCH = 200")
    public ResponseEntity<BenchmarkResponse> getByBatchBenchmark() {
        return ResponseEntity.ok(productService.getByBatchBenchmark());
    }

}