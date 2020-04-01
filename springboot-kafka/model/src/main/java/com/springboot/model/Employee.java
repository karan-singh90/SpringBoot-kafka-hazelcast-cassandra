package com.springboot.model;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.StringJoiner;

@Getter@Setter@NoArgsConstructor
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private String empId;
    private String firstname;
    private String lastname;
    private String address;
    private String empCode;

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("empId='" + empId + "'")
                .add("firstname='" + firstname + "'")
                .add("lastname='" + lastname + "'")
                .add("address='" + address + "'")
                .add("empCode='" + empCode + "'")
                .toString();
    }
}
