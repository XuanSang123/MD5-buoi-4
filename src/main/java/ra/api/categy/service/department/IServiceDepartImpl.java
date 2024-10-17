package ra.api.categy.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.api.categy.entity.Department;
import ra.api.categy.repository.IDepartmentRepo;

import java.util.List;
@Service
public class IServiceDepartImpl implements IServiceDepartment{
    @Autowired
    private IDepartmentRepo departmentRepo;
    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepo.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepo.deleteById(id);

    }
}
