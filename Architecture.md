# Architecture.md

# JFR AI Performance Analyzer - Architecture Guide

## Introduction

JFR AI Performance Analyzer is designed as a modular, extensible performance diagnostics platform that automates the analysis of Java Flight Recorder (JFR) recordings.

The application separates the responsibilities of recording analysis, performance evaluation, AI-assisted interpretation, and report generation into independent components.

This layered design improves maintainability, testability, and extensibility.

---

# High-Level Architecture

```text
                    Spring Boot Application
                             │
                             ▼
                    Generate JFR Recording
                             │
                             ▼
                   JfrAnalysisService
                             │
                             ▼
                 EventExtractorService
                             │
                             ▼
                  PerformanceSummary
                             │
                             ▼
                  Metrics Calculator
                             │
                             ▼
                       Rule Engine
               ┌────────┼─────────┐
               ▼        ▼         ▼
          CpuRule  MemoryRule  ThreadRule
               │        │         │
               └────────┼─────────┘
                        ▼
                  AnalysisResult
                        │
            ┌───────────┴────────────┐
            ▼                        ▼
      Ollama AI Service      PDF Generator
            │                        │
            └───────────┬────────────┘
                        ▼
               Performance Report
```

---

# Application Layers

## 1. Performance Simulation Layer

Purpose:

Generate different JVM performance scenarios.

Endpoints:

```
GET /cpu

GET /memory

GET /threads

GET /io
```

Each endpoint intentionally produces a different workload.

Examples include:

* CPU-intensive calculations
* Heavy memory allocation
* Thread contention
* File I/O operations

---

## 2. JFR Analysis Layer

Responsible Classes

```
JfrAnalysisService

EventExtractorService
```

Responsibilities

* Open JFR recordings
* Read events using `jdk.jfr.consumer`
* Stream events one by one
* Extract useful JVM metrics

The analysis layer never loads the complete recording into memory, making it suitable for larger recordings.

---

## 3. Performance Summary Layer

Main Class

```
PerformanceSummary
```

Purpose

Store extracted JVM metrics.

Examples

```
CPU

Execution Samples

Average JVM CPU

Memory

GC Count

Allocation Events

Threads

Monitor Contention

Park Events

File IO

Read Events

Write Events
```

This object represents the raw analysis of the recording.

---

## 4. Rule Engine

Purpose

Evaluate application health using deterministic rules.

Current Rules

```
CpuRule

MemoryRule

ThreadRule

IORule
```

Each rule is responsible for a single aspect of performance evaluation.

Example

```
High CPU

↓

Subtract Score

↓

Generate Recommendation
```

The rule engine follows the Strategy Pattern, making it easy to add additional analysis rules in the future.

Examples of future rules:

* KafkaRule
* JDBCRule
* NetworkRule
* ExceptionRule

---

## 5. Analysis Result

Main Class

```
AnalysisResult
```

Purpose

Combine:

* Performance summary
* Overall score
* Health status
* Recommendations

This object represents the final machine-readable analysis.

---

## 6. AI Layer

Main Components

```
PromptBuilder

OllamaService
```

Responsibilities

* Convert AnalysisResult into a structured prompt
* Send the prompt to Ollama
* Receive natural language analysis

The application sends only structured metrics to the language model.

The original JFR recording is never transmitted.

Advantages

* Smaller prompt
* Faster inference
* Better accuracy
* Lower memory usage

---

## 7. PDF Generation Layer

Main Component

```
PdfReportGeneratorService
```

Responsibilities

Generate a professional performance report containing:

* Overall health
* CPU analysis
* Memory analysis
* Thread analysis
* File I/O analysis
* Recommendations
* AI-generated observations

The report is generated locally as a PDF.

---

# Data Flow

```
JFR Recording

↓

RecordingFile

↓

RecordedEvent

↓

EventExtractorService

↓

PerformanceSummary

↓

Rule Engine

↓

AnalysisResult

↓

Ollama

↓

PDF Report
```

---

# Design Principles

The project follows several software engineering principles.

## Single Responsibility Principle

Each component performs one well-defined task.

Examples

* Event extraction
* Rule evaluation
* AI communication
* PDF generation

---

## Open/Closed Principle

The Rule Engine is designed for extension without modification.

Adding a new rule requires implementing the AnalysisRule interface without changing existing code.

---

## Dependency Injection

Spring Boot manages all major components through dependency injection.

Benefits

* Loose coupling
* Easier testing
* Improved maintainability

---

## Separation of Concerns

Responsibilities are clearly divided into:

* Analysis
* Evaluation
* AI
* Reporting

Each layer operates independently.

---

# Technologies Used

| Component | Technology       |
| --------- | ---------------- |
| Language  | Java 17          |
| Framework | Spring Boot      |
| JFR API   | jdk.jfr.consumer |
| AI        | Ollama           |
| PDF       | OpenPDF          |
| REST      | Spring Web       |
| Build     | Maven            |

---

# Future Enhancements

The current architecture allows future enhancements without significant redesign.

Potential additions include:

* Kafka-specific analysis
* JDBC performance analysis
* HTTP latency analysis
* Comparison between multiple JFR recordings
* Interactive dashboard
* Historical trend analysis
* Automated scheduled analysis

---

# Conclusion

The JFR AI Performance Analyzer demonstrates how traditional JVM diagnostics can be combined with deterministic analysis and local AI models to automate performance investigations.

The modular architecture enables future expansion while keeping the codebase clean, maintainable, and aligned with modern Java development practices.
