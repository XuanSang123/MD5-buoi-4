package ra.api.categy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.api.categy.dto.response.ResponseDto;
import ra.api.categy.entity.Employee;
import ra.api.categy.service.employee.IServiceEmployee;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private IServiceEmployee iServiceEmployee;

    @GetMapping
    public ResponseEntity<ResponseDto> getAllEmployee() {
        List<Employee> list = iServiceEmployee.findAll();
        return new ResponseEntity<>(new ResponseDto(list, HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getEmployeeById(@PathVariable Long id) {
        Employee employee1 = iServiceEmployee.findById(id);
        if (employee1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ResponseDto(employee1, HttpStatus.CREATED, HttpStatus.CREATED.value()), HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateEmploy(@PathVariable Long id, @RequestBody Employee employee) {
        Employee employee1 = iServiceEmployee.findById(id);

        if (employee1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee1.setId(employee.getId());
        employee1.setFullName(employee.getFullName());
        employee1.setAddress(employee.getAddress());
        employee1.setPhone(employee.getPhone());
        employee1.setStatus(employee.isStatus());
        employee1.setDepartment(employee.getDepartment());
        return new ResponseEntity<>(new ResponseDto(iServiceEmployee.save(employee1), HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable Long id
    ) {
        Employee employee1 = iServiceEmployee.findById(id);
        if (employee1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iServiceEmployee.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
