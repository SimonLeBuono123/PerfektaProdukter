package org.example.inlamning1;

import org.example.inlamning1.workers.Worker;

import java.util.List;

public interface WorkerRepo {
    void create(String type);
    void update();
    void remove();
    void findAverageIncomeByGender();

   int findWorkerById(int workerId);
    List<Worker> findAllWorkers();
    List<Worker> findAllEmployees();

    List<Worker> findAllInterns();

    int workerAmount();

}
