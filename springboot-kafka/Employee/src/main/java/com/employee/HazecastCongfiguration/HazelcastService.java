package com.employee.HazecastCongfiguration;

import com.employee.CassandraEntity.EmployeeEntity;
import com.employee.Service.Serviceclass;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Slf4j
@Service
public class HazelcastService implements Serviceclass<EmployeeEntity> {

    @Autowired
    HazelcastInstance hazelcastInstance;

    @Override
    public boolean add(EmployeeEntity emp) {
        try {
            IMap<Object,Object> iMap= hazelcastInstance.getMap("employeescache");
            //without entry processor
//            iMap.put(emp.getEmpId(), emp);// will store the data into jvms memory.
//            log.info("EmplyeeId "+emp.getEmpId()+" Employee"+emp);
   //Store implementation can be called synchronously (write-through) or asynchronously (write-behind) depending on the configuration.
            //with entry processor
            log.info("hazelcastService::update() called");
            iMap.executeOnKey(emp.getEmpId(), new EmployeeEntryProcessor(emp));
            return true;
        } catch (Exception ex) {
            log.error("Error adding Employee: {}", ex.getMessage());
            return false;
        }
    }

    @Override
    public EmployeeEntity get(String id) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void update(EmployeeEntity object) {

    }

    @Override
    public List<EmployeeEntity> getAll() {
        return null;
    }
}
