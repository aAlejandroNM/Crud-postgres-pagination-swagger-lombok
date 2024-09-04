package xyz.springPractica.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.springPractica.demo.models.entitys.Student;
import xyz.springPractica.demo.repository.IStudentRepository;

import java.util.Objects;
import java.util.Optional;

    @Service
    public class StudentService {
        @Autowired
        private IStudentRepository iStudentRepository;

        public Student saveStudent(Student student) {

            if (Objects.isNull(student.getId())) {
                System.out.println("Saving student: " + student);
                return iStudentRepository.save(student);
            }
            return null;
        }

        public Page<Student> getAllStudent(Integer page, Integer size, Boolean enablePagination){
            return iStudentRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
        }

        public Optional<Student> findById(Long id){
            return iStudentRepository.findById(id);
        }

        public void deleteStudent(Long id){
            iStudentRepository.deleteById(id);
        }

        public Student editStudent(Student student) {
            if (iStudentRepository.existsById(student.getId())) {
                return iStudentRepository.save(student);
            }
            return null;
        }

        public boolean existById(Long id) {
            return iStudentRepository.existsById(id);
        }
    }
