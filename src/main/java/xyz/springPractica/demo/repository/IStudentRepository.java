package xyz.springPractica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.springPractica.demo.models.entitys.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
