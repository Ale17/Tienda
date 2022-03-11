/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aleja
 */
@Repository
public interface IPersonaService {
  public List<Persona> getAllPerson();
  public void savePerson (Persona persona);
  public Persona getPersonById (long id);
  public void delete (long id);
}
