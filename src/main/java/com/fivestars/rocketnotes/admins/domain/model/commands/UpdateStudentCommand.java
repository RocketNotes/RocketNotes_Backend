package com.fivestars.rocketnotes.admins.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UpdateStudentCommand {
    private Long id;
    private String firstName;
    private String paternalLastName;
    private String maternalLastName;
    private String dni;
    private List<Long> classrooms;
}