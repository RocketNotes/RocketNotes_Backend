package com.fivestars.rocketnotes.admins.domain.services;

import com.fivestars.rocketnotes.admins.domain.model.commands.CreateStudentCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateStudentCommand;

public interface StudentCommandService {
    Long handle(CreateStudentCommand command);

    void handleUpdate(UpdateStudentCommand command);

    void deleteStudent(Long id);
}
