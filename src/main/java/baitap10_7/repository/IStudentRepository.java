package baitap10_7.repository;

import baitap10_7.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IStudentRepository extends JpaRepository<Student,Long> {
}
