package com.devops.eventmanagement.models.service;

import com.devops.eventmanagement.models.entity.Ciudad;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICiudadService {
    List<Ciudad> listaCiudades();
}
