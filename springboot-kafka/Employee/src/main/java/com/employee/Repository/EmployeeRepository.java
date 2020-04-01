package com.employee.Repository;

import com.employee.CassandraEntity.EmployeeEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CassandraRepository<EmployeeEntity,String> {
}
