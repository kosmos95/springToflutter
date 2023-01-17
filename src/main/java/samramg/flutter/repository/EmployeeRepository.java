package samramg.flutter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samramg.flutter.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    public boolean existsByFirstNameAndLastName(String firstName, String lastName);

    public boolean existsBy(int id);
}
