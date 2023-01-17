package samramg.flutter.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samramg.flutter.entity.EmployeeEntity;
import samramg.flutter.model.Employee;
import samramg.flutter.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {

        try{
            List<EmployeeEntity> employees = employeeRepository.findAll();
            List<Employee> customEmployee = new ArrayList<>();
            employees.stream().forEach(e->{
                Employee employee = new Employee();
                BeanUtils.copyProperties(e, employee);
                customEmployee.add(employee);
            });
            return customEmployee;
        }catch (Exception e){
            throw e;
        }
    }

    public String addEmployee(EmployeeEntity employee) {
        try {
            if (!employeeRepository.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
                employeeRepository.save(employee);
                return "Employee add successfullly";
            } else {
                return "This employee already exists in the database";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String removeEmployee(EmployeeEntity employee) {
        try{
            if (employeeRepository.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
                employeeRepository.save(employee);
                return "Employee deleted successfully.";
            } else {
                return "Employee does not exist.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public String updateEmployee(EmployeeEntity employee) {
        try {
            if (employeeRepository.existsBy(employee.getId())) {
                employeeRepository.save(employee);
                return "Employee updated successfully.";
            } else {
                return "Employee does not exist.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    }

