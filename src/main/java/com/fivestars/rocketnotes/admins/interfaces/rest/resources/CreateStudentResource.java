package com.fivestars.rocketnotes.admins.interfaces.rest.resources;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStudentResource {
    private String firstName;
    private String paternalLastName;
    private String maternalLastName;
    private String dni;
}