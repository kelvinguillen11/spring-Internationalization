package com.example.demo_springmvc.controller;

import com.example.demo_springmvc.entities.*;
import com.example.demo_springmvc.model.*;
import com.example.demo_springmvc.service.LocalizationService;
import com.example.demo_springmvc.validations.LibrosValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("libros")
public class LibrosController {


    EditorialesModel editorialesModel = new EditorialesModel();
    GenerosModel generosModel = new GenerosModel();
    AutoresModel autoresModel = new AutoresModel();
    LibrosModel librosModel = new LibrosModel();

    @Autowired
    private LocalizationService localizationService;



    @RequestMapping(value = "list", method = GET)
    public String listarLibros(ModelMap modelMap){
//Pasando la lista de editoriales hacia la vista
        modelMap.addAttribute("listaLibros", librosModel.listarLibros());
//Redireccionando a la página de libros.jsp
        return "libros/listar";
    }
    @RequestMapping(value = "create", method = GET)
    public String nuevoLibro(Model model){
        //Se le pasa a la vista el objeto que debe llenarse desde el formuario
        model.addAttribute("libro", new Libros());
        //Se le pasa a la vista las listas de autores, géneros y editoriales
        //Para llenar los campos select
        model.addAttribute("listaAutores",autoresModel.listarAutores());
        model.addAttribute("listaGeneros",generosModel.listarGeneros());
        model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
        return "libros/nuevo";
    }
    @RequestMapping(value = "create", method = POST)
    public String insertarLibro(@Valid @ModelAttribute("libro") Libros libro, Model model,
                                RedirectAttributes atributos, BindingResult result , Locale locale) {

        LibrosValidator librosValidator = new LibrosValidator(localizationService);
        librosValidator.validate(libro, result);
        if(result.hasErrors()){
            model.addAttribute("libro", new Libros());
            model.addAttribute("org.springframework.validation.BindingResult.libro", result);
            model.addAttribute("listaAutores",autoresModel.listarAutores());
            model.addAttribute("listaGeneros",generosModel.listarGeneros());
            model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
            return "libros/nuevo";
        }
        if(librosModel.insertarLibro(libro)>0){
            //Si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito",localizationService.getMessage("libro.registroExito", locale));
            //Redirección en el cliente hacia el método listarLibros()
            return "redirect:/libros/list";
        }
        else {
            //Sino se insertó regresamos al formulario de ingreso
            model.addAttribute("libro",libro);
            model.addAttribute("listaAutores",autoresModel.listarAutores());
            model.addAttribute("listaGeneros",generosModel.listarGeneros());
            model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
            return "libros/nuevo";
        }
    }
    @RequestMapping(value = "edit/{codigo}", method = GET)
    public String obtenerLibro(@PathVariable("codigo") String codigo, Model model){
        model.addAttribute("libro",
                librosModel.obtenerLibro(codigo));
        model.addAttribute("listaAutores",autoresModel.listarAutores());
        model.addAttribute("listaGeneros",generosModel.listarGeneros());
        model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
        return "libros/editar";
    }

    @RequestMapping(value = "edit/{codigo}", method = POST)
    public String modificarLibro(@Valid @ModelAttribute("libro") Libros libro, Model model,
                                     RedirectAttributes atributos,BindingResult result,Locale locale) {
        LibrosValidator librosValidator = new LibrosValidator(localizationService);
        librosValidator.validate(libro, result);
        if(result.hasErrors()){
            model.addAttribute("libro", new Libros());
            model.addAttribute("org.springframework.validation.BindingResult.libro", result);
            model.addAttribute("listaAutores",autoresModel.listarAutores());
            model.addAttribute("listaGeneros",generosModel.listarGeneros());
            model.addAttribute("listaEditoriales",editorialesModel.listarEditoriales());
            return "libros/nuevo";
        }
        if(librosModel.modificarLibro(libro)>0){
            atributos.addFlashAttribute("exito",localizationService.getMessage("libro.modificadoExito", locale));
            return "redirect:/libros/list";
        }
        else {
            model.addAttribute("libro",libro);
            return "libros/editar";
        }
    }

    @RequestMapping(value = "delete/{codigo}")
    public String eliminarLibro(@PathVariable("codigo") String codigo, Model
            model, RedirectAttributes atributos, Locale locale){
        model.addAttribute("libro",
                    librosModel.obtenerLibro(codigo));
        if(librosModel.eliminarLibro(codigo)>0){
            atributos.addFlashAttribute("exito", localizationService.getMessage("libro.eliminadoExito", locale));
        }
        else {
            model.addAttribute("fracaso",localizationService.getMessage("libro.eliminadoError", locale));
        }
        return "redirect:/libros/list";
    }
}
