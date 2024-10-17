package ra.api.categy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.api.categy.entity.Department;

public interface IDepartmentRepo extends JpaRepository<Department,Long> {
}
