package com.fivestars.rocketnotes.admins.domain.services;


import com.fivestars.rocketnotes.admins.domain.model.commands.CreateTeacherCommand;
import com.fivestars.rocketnotes.admins.domain.model.commands.UpdateTeacherCommand;

public interface TeacherCommandService {
    Long handle(CreateTeacherCommand command);

    void handleUpdate(UpdateTeacherCommand command);

    void handleDelete(Long teacherId);
}