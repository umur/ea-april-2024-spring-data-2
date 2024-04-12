package com.david.lab.controller;

import com.david.lab.model.BenchmarkResponse;
import com.david.lab.service.BenchmarkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Benchmark APIs")
@RestController
@RequestMapping("benchmark")
@RequiredArgsConstructor
public class BenchmarkController {

    private final BenchmarkService benchmarkService;

    @GetMapping("select-benchmark-lazy")
    @Operation(summary = "Benchmark - Strategy used = [SELECT], Fetch mode = [LAZY]")
    public ResponseEntity<BenchmarkResponse> getBySelectBenchmark() {
        return ResponseEntity.ok(benchmarkService.getBySelectBenchmarkLazy());
    }

    @GetMapping("join-benchmark-lazy")
    @Operation(summary = "Benchmark - Strategy used = [JOIN], Fetch mode = [LAZY]")
    public ResponseEntity<BenchmarkResponse> getByJoinBenchmark() {
        return ResponseEntity.ok(benchmarkService.getByJoinBenchmarkLazy());
    }

    @GetMapping("subselect-benchmark-lazy")
    @Operation(summary = "Benchmark - Strategy used = [SUBSELECT], Fetch mode = [LAZY]")
    public ResponseEntity<BenchmarkResponse> getBySubselectBenchmark() {
        return ResponseEntity.ok(benchmarkService.getBySubselectBenchmarkLazy());
    }

    @GetMapping("batch-benchmark-lazy")
    @Operation(summary = "Benchmark - Strategy used = [SELECT] with BATCH SIZE = 200, Fetch mode = [LAZY]")
    public ResponseEntity<BenchmarkResponse> getByBatchBenchmark() {
        return ResponseEntity.ok(benchmarkService.getByBatchBenchmarkLazy());
    }

    @GetMapping("select-benchmark-eager")
    @Operation(summary = "Benchmark - Strategy used = [SELECT], Fetch mode = [EAGER]")
    public ResponseEntity<BenchmarkResponse> getBySelectBenchmarkEager() {
        return ResponseEntity.ok(benchmarkService.getBySelectBenchmarkEager());
    }

    @GetMapping("join-benchmark-eager")
    @Operation(summary = "Benchmark - Strategy used = [JOIN], Fetch mode = [EAGER]")
    public ResponseEntity<BenchmarkResponse> getByJoinBenchmarkEager() {
        return ResponseEntity.ok(benchmarkService.getByJoinBenchmarkEager());
    }

    @GetMapping("subselect-benchmark-eager")
    @Operation(summary = "Benchmark - Strategy used = [SUBSELECT], Fetch mode = [EAGER]")
    public ResponseEntity<BenchmarkResponse> getBySubselectBenchmarkEager() {
        return ResponseEntity.ok(benchmarkService.getBySubselectBenchmarkEager());
    }

    @GetMapping("batch-benchmark-eager")
    @Operation(summary = "Benchmark - Strategy used = [SELECT] with BATCH SIZE = 200, Fetch mode = [EAGER]")
    public ResponseEntity<BenchmarkResponse> getByBatchBenchmarkEager() {
        return ResponseEntity.ok(benchmarkService.getByBatchBenchmarkEager());
    }

}