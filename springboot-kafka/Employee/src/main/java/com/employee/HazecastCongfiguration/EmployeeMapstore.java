package com.employee.HazecastCongfiguration;

import com.employee.CassandraEntity.EmployeeEntity;
import com.employee.Repository.EmployeeRepository;
import com.hazelcast.core.MapStore;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component@Slf4j
public class EmployeeMapstore implements MapStore<String, EmployeeEntity> {
    @Autowired
    EmployeeRepository repo;
    @Override
    public void store(String s, EmployeeEntity employeeEntity) {
        log.info("EmployeeMapStore::store() called");
        repo.save(employeeEntity);
        log.info("Stored in cassandra");
    }

    @Override
    public void storeAll(Map<String, EmployeeEntity> map) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void deleteAll(Collection<String> collection) {

    }

    @Override
    public EmployeeEntity load(String s) {
        return null;
    }

    @Override
    public Map<String, EmployeeEntity> loadAll(Collection<String> collection) {
        return null;
    }

    @Override
    public Iterable<String> loadAllKeys() {
        return null;
    }
}
