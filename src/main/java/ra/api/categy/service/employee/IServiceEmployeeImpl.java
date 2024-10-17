package ra.api.categy.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.api.categy.entity.Department;
import ra.api.categy.entity.Employee;

import java.util.List;

@Service
public class IServiceEmployeeImpl implements IServiceEmployee {
    @Autowired
    private IServiceEmployee serviceEmployee;

    @Override
    public List<Employee> findAll() {
        return serviceEmployee.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return serviceEmployee.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return serviceEmployee.save(employee);
    }

    @Override
    public void delete(Long id) {
        serviceEmployee.delete(id);
    }
}

