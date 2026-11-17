# CSA09 – Programming in Java – Assignment 2 (CO2)

**Student:** Add your name  
**Register number:** 192472207 (verify before submission)  
**Java version:** Java 8+ (tested with the installed JDK)

## Folder structure
- `Q01` – String, StringBuilder and StringBuffer benchmark
- `Q02` – ArrayList, LinkedList and ArrayDeque comparison
- `Q03` – HashSet and hashCode–equals contract
- `Q04` – HashMap, TreeMap and LinkedHashMap inventory
- `Q05` – Generics, Comparator and reusable leaderboard
- `Q06` – PriorityQueue emergency triage
- `Q07` – Diagnose, redesign and validate string construction

## Run each question in VS Code
Open this root folder in VS Code. Open Terminal → New Terminal. Run each question from its folder:

```powershell
cd Q01
javac TicketBuilderBenchmark.java
java TicketBuilderBenchmark
cd ..
cd Q02
javac ListBenchmark.java
java ListBenchmark
cd ..
cd Q03
javac Attendance.java
java Attendance
cd ..
cd Q04
javac PharmacyInventory.java
java PharmacyInventory
cd ..
cd Q05
javac LeaderboardDemo.java
java LeaderboardDemo
cd ..
cd Q06
javac Triage.java
java Triage
cd ..
cd Q07
javac RedesignBenchmark.java
java RedesignBenchmark
```

## Important evidence instructions
1. Run every program on your own computer. Timing results depend on the CPU, JVM, background processes and warm-up, so do not copy another person's timings.
2. Run benchmark questions more than once; record repeated results and calculate averages/medians for your report. The programs print timing data to the terminal.
3. Save terminal screenshots inside the matching Q folder. Add raw timing output (CSV or text) and your own analysis.
4. Q1 includes three workloads; Q2 and Q4 use three data sizes; Q3 includes duplicate and mutable-key tests; Q5 includes tie cases; Q6 includes severity and arrival-order logic; Q7 compares original and redesigned string construction.
5. Some written parts (predictions, measured evidence, fairness rule justification and final engineering conclusion) must be written from your own executions and understanding. Code output alone does not satisfy the assignment.

## GitHub submission
Create repository `CSA09-<YourRegisterNumber>-Assignment2`. Commit progressively: at least one commit per question, as required by the assignment. Do not upload everything in a single final commit.

Example commands from the project root:
```bash
git init
git add Q01 && git commit -m "Add Q1 string benchmark"
git add Q02 && git commit -m "Add Q2 list comparison"
git add Q03 && git commit -m "Add Q3 hash contract tests"
git add Q04 && git commit -m "Add Q4 map inventory comparison"
git add Q05 && git commit -m "Add Q5 generic leaderboard"
git add Q06 && git commit -m "Add Q6 emergency triage"
git add Q07 && git commit -m "Add Q7 redesign benchmark"
git add README.md .gitignore && git commit -m "Add assignment documentation"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/CSA09-YOURREGNO-Assignment2.git
git push -u origin main
```
Replace the URL with your actual GitHub repository URL.
