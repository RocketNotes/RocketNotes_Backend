package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Student;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateStudentCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateStudentCommand;
import com.fivestars.rocketnotes.admins.domain.services.StudentCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;

    @Override
    public Long handle(CreateStudentCommand command) {
        Student student = new Student(
                command.firstName(),
                command.paternalLastName(),
                command.maternalLastName(),
                command.dni(),
                command.classrooms()
        );
        studentRepository.save(student);
        return student.getId();
    }

    @Override
    @Transactional
    public void handleUpdate(UpdateStudentCommand command) {
        Student student = studentRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));

        student.setFirstName(command.getFirstName());
        student.setPaternalLastName(command.getPaternalLastName());
        student.setMaternalLastName(command.getMaternalLastName());
        student.setDni(command.getDni());
        student.setClassrooms(command.getClassrooms());

        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Estudiante no encontrado");
        }
        studentRepository.deleteById(id);
    }
}