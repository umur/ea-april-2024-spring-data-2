package com.ea.domain;

import com.ea.FetchType;
import com.ea.Operation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Operation fetchMode;

    @Enumerated(EnumType.STRING)
    private FetchType fetchType;

    private Long noOfSqlQueries;

    private Long overallExecutionTime;

    private Long dataTransferSize;

    private Long usedMemoryBefore;

    private Long usedMemoryAfter;

    private Long memoryUsage;

    @Column(columnDefinition = "TEXT")
    private String sampleQueries;

    private int batchSize;

}
