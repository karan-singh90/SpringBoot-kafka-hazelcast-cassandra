package com.employee.HazecastCongfiguration;

import com.employee.CassandraEntity.EmployeeEntity;
import com.hazelcast.map.AbstractEntryProcessor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
@Slf4j
public class EmployeeEntryProcessor extends AbstractEntryProcessor<String, EmployeeEntity> {
    public EmployeeEntryProcessor() {
    }

    EmployeeEntity emp;
    public EmployeeEntryProcessor(EmployeeEntity employee) {
        emp = employee;
    }

    @Override
    public Object process(Map.Entry<String, EmployeeEntity> entry) {
        log.info("EmployeeEntryProcessor updating values: " + emp);
        entry.setValue(emp);
        return null;
    }
}
