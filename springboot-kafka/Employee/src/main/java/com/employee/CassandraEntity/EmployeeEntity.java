package com.employee.CassandraEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table("employees")
@Getter@Setter@NoArgsConstructor
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @PrimaryKey("empId")
    private String empId;
    private String firstname;
    private String lastname;
    private String address;
    private String empCode;

    @Override
    public String toString() {

            return "Employee [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address+" empCode=" + empCode + "]";

    }
}
