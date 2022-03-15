/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author aleja
 */
@Controller
@Slf4j
public class PersonasController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;

    @GetMapping("/personas")
    public String index(Model model) {
        List<Persona> listaPersonas = personaService.getAllPerson();
        model.addAttribute("titulo", "Personas");
        model.addAttribute("personas", listaPersonas);
        return "personas";
    }

    @GetMapping("/nuevaPersona")
    public String nuevaPersona(Model model) {
        List<Pais> listaPais = paisService.listCountry();
        model.addAttribute("paises", listaPais);
        model.addAttribute("persona", new Persona());
        return "modificarPersona";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePerson(persona);
        return "redirect:/personas";
    }
    
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model){
        Persona p = personaService.getPersonById(idPersona);
        List <Pais> listaPais = paisService.listCountry();
        model.addAttribute("persona", p);
        model.addAttribute("paises", listaPais);
        return "modificarPersona";
    }

    @GetMapping("/delete/{id}")
    public String modificarPersona(@PathVariable("id") Long idPersona) {
        personaService.delete(idPersona);
        return "redirect:/personas";
    }
}
