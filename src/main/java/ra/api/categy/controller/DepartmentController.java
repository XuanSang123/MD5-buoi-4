package ra.api.categy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.api.categy.dto.response.ResponseDto;
import ra.api.categy.entity.Category;
import ra.api.categy.entity.Department;
import ra.api.categy.service.department.IServiceDepartment;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private IServiceDepartment iServiceDepartment;

    @GetMapping
    public ResponseEntity<ResponseDto> getAllDepartment() {
        List<Department> list = iServiceDepartment.findAll();
        return new ResponseEntity<>(new ResponseDto(list, HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(new ResponseDto(iServiceDepartment.save(department), HttpStatus.CREATED, HttpStatus.CREATED.value()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getDepartmentById(@PathVariable Long id) {
        Department department1 = iServiceDepartment.findById(id);
        if (department1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ResponseDto(department1, HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Department department1 = iServiceDepartment.findById(id);
        if (department1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        department1.setId(department.getId());
        department1.setName(department.getName());
        department1.setStatus(department.isStatus());
        department1.setEmployeeList(department.getEmployeeList());
        return new ResponseEntity<>(new ResponseDto(iServiceDepartment.save(department1), HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteDepartment(@PathVariable Long id) {
        Department department1 = iServiceDepartment.findById(id);
        if (department1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iServiceDepartment.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ResponseDto> updateStatusDepartment(@PathVariable Long id, @RequestParam boolean status) {

        Department department1 = iServiceDepartment.findById(id);
        if (department1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        department1.setStatus(status);

        return new ResponseEntity<>(new ResponseDto(iServiceDepartment.save(department1), HttpStatus.OK, HttpStatus.OK.value()), HttpStatus.OK);

    }
}
