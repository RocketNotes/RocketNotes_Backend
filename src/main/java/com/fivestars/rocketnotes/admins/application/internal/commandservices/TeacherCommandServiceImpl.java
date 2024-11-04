package com.fivestars.rocketnotes.admins.application.internal.commandservices;

import com.fivestars.rocketnotes.admins.domain.model.aggregates.Teacher;
import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.services.TeacherCommandService;
import com.fivestars.rocketnotes.admins.infrastructure.persistence.jpa.repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherCommandServiceImpl implements TeacherCommandService {

    private final TeacherRepository teacherRepository;

    @Override
    public Long handle(CreateTeacherCommand command) {
        Teacher teacher = new Teacher(
                command.firstName(),
                command.paternalLastName(),
                command.maternalLastName(),
                command.dni(),
                command.phone(),
                command.email()
        );
        teacherRepository.save(teacher);
        return teacher.getId();
    }

    @Override
    @Transactional
    public void handleUpdate(UpdateTeacherCommand command) {
        Teacher teacher = teacherRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Profesor no encontrado"));

        teacher.setFirstName(command.getFirstName());
        teacher.setPaternalLastName(command.getPaternalLastName());
        teacher.setMaternalLastName(command.getMaternalLastName());
        teacher.setDni(command.getDni());
        teacher.setPhone(command.getPhone());
        teacher.setEmail(command.getEmail());

        teacherRepository.save(teacher);
    }

    @Override
    @Transactional
    public void handleDelete(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}