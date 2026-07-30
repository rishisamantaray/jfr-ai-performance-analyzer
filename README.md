# 🚀 JFR AI Performance Analyzer

> An AI-powered JVM Performance Analysis tool built with **Java 17**, **Spring Boot**, **JDK Flight Recorder (JFR)**, **Ollama**, and **OpenPDF**.

---

## 📖 Overview

JFR AI Performance Analyzer is an end-to-end performance diagnostics application that automates the analysis of **JDK Flight Recorder (JFR)** recordings.

Instead of manually inspecting JFR recordings using JDK Mission Control, this application:

* Parses JFR recordings programmatically
* Extracts JVM performance metrics
* Detects CPU, Memory, Thread, and File I/O bottlenecks
* Applies a rule engine to evaluate application health
* Uses a local LLM (Ollama) to generate human-readable performance insights
* Produces a professional PDF performance report

The project demonstrates modern Java development, JVM internals, performance engineering, and local AI integration.

---

# ✨ Features

* 📊 CPU Performance Analysis
* 🧠 Memory & Garbage Collection Analysis
* 🧵 Thread Contention Detection
* 💾 File I/O Analysis
* ⚙️ Rule-Based Performance Evaluation
* 🤖 AI-Powered Performance Recommendations (Ollama)
* 📄 PDF Performance Report Generation
* 🔍 Programmatic JFR Parsing using `jdk.jfr.consumer`

---

# 🏗️ Architecture

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
                     Rule Engine
                             │
                             ▼
                     AnalysisResult
                             │
               ┌─────────────┴─────────────┐
               ▼                           ▼
        Ollama AI Analysis          PDF Generator
               │                           │
               └─────────────┬─────────────┘
                             ▼
                AI Performance Report (PDF)
```

---

# 🛠 Technology Stack

| Category              | Technology             |
| --------------------- | ---------------------- |
| Language              | Java 17                |
| Framework             | Spring Boot 3          |
| Build Tool            | Maven                  |
| Performance Profiling | JDK Flight Recorder    |
| JFR Analysis          | `jdk.jfr.consumer` API |
| AI                    | Ollama (Local LLM)     |
| PDF Generation        | OpenPDF                |
| REST API              | Spring Web             |
| Monitoring            | Spring Boot Actuator   |

---

# 📂 Project Structure

```text
jfr-ai-performance-analyzer
│
├── docs/
├── recordings/
├── reports/
├── src/
│   ├── controller/
│   ├── service/
│   │   ├── analysis/
│   │   └── ai/
│   ├── report/
│   ├── model/
│   ├── dto/
│   └── config/
│
├── pom.xml
└── README.md
```

---

# 🔄 Project Workflow

1. Generate a JDK Flight Recorder (`.jfr`) recording.
2. Read the recording using the JFR Consumer API.
3. Extract important JVM events.
4. Build a structured performance summary.
5. Apply rule-based analysis.
6. Calculate the overall performance score.
7. Generate AI-based recommendations using Ollama.
8. Produce a PDF performance report.

---

# 🚀 Getting Started

## Prerequisites

* Java 17+
* Maven 3.9+
* Ollama
* JDK Mission Control (optional)

---

## Clone the Repository

```bash
git clone https://github.com/<your-github-username>/jfr-ai-performance-analyzer.git

cd jfr-ai-performance-analyzer
```

---

## Build the Project

```bash
mvn clean install
```

---

## Start the Application

```bash
mvn spring-boot:run
```

---

# 📊 Generate a JFR Recording

Start recording:

```bash
jcmd <PID> JFR.start name=Performance settings=profile
```

Trigger workload:

```text
GET /cpu
GET /memory
GET /threads
GET /io
```

Stop recording:

```bash
jcmd <PID> JFR.stop name=Performance filename=recordings/demo.jfr
```

---

# 🔍 Analyze a Recording

```text
GET /analyze?file=recordings/demo.jfr
```

---

# 🤖 Generate an AI Report

```text
GET /ai-report?file=recordings/demo.jfr
```

The application sends the structured performance summary to a locally running Ollama model to generate a professional performance assessment.

---

# 📄 Generate the PDF Report

```text
GET /report?file=recordings/demo.jfr
```

The generated report is saved under:

```text
reports/PerformanceReport.pdf
```

---

# 📚 Key Learning Outcomes

This project demonstrates practical experience with:

* JVM Performance Engineering
* Java Flight Recorder (JFR)
* JFR Consumer API
* Spring Boot REST APIs
* Rule Engine Design
* SOLID Principles
* Strategy Design Pattern
* Local LLM Integration
* Prompt Engineering
* PDF Report Generation

---

# 🛣️ Roadmap

### Completed

* Spring Boot Application
* CPU Stress Simulator
* Memory Stress Simulator
* Thread Contention Simulator
* File I/O Simulator
* JFR Recording Parser
* Rule Engine
* PDF Report Generation
* Ollama Integration

### Planned Enhancements

* Historical comparison between JFR recordings
* REST endpoint for JFR file upload
* Kafka-specific JFR analysis rules
* Interactive dashboard
* Unit and integration tests
* Docker deployment

---

# 🤝 Contributing

Contributions, suggestions, and feature requests are welcome. Feel free to fork the repository, open an issue, or submit a pull request.

---

## 👨‍💻 Author

**Pratyush Samantaray**

Java Backend Developer | JVM Performance Enthusiast | Kafka & Confluent Engineer

If you found this project useful, consider giving it a ⭐ on GitHub.
