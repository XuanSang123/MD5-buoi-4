package ra.api.categy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.api.categy.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
