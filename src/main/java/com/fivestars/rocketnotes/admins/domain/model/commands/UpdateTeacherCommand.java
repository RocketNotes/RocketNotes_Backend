package com.fivestars.rocketnotes.admins.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateTeacherCommand {
    private final Long id;
    private final String firstName;
    private final String paternalLastName;
    private final String maternalLastName;
    private final String dni;
    private final String phone;
    private final String email;
}