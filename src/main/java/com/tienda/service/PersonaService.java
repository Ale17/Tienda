/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aleja
 */
@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional (readOnly = true)
    public List<Persona> getAllPerson() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    @Transactional
    public void savePerson(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    @Transactional (readOnly = true)
    public Persona getPersonById(long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(long id) {
        personaRepository.deleteById(id);
    }
}
