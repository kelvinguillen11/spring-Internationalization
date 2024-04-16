package com.example.demo_springmvc.controller;

import com.example.demo_springmvc.entities.Editoriales;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo_springmvc.model.EditorialesModel;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("editoriales")
public class EditorialesController {
    EditorialesModel editorialesModel = new EditorialesModel();
    @RequestMapping(value = "list", method = GET)
    public String listarEditoriales(ModelMap modelMap){
//Pasando la lista de editoriales hacia la vista
        modelMap.addAttribute("listaEditoriales",
                editorialesModel.listarEditoriales());
//Redireccionando a la página de editorailes.jsp
        return "editoriales/listar";
    }
    @RequestMapping(value = "create", method = GET)
    public String nuevoEditorial(Model model){
//Se le pasa a la vista el objecto que debe llenarse desde el formuario
        model.addAttribute("editorial", new Editoriales());
        return "editoriales/nuevo";
    }
    //Este método se ejecuta al enviar el formulario desde la vista
    @RequestMapping(value = "create", method = POST)
    public String insertarEditorial(@ModelAttribute("ëditorial") Editoriales
                                            editorial, Model model, RedirectAttributes atributos) {
        if(editorialesModel.insertarEditorial(editorial)>0){
//Si se insertó, se pasa el mensaje de éxito
            atributos.addFlashAttribute("exito","Editorial registrado exitosamente");
//Redirección en el cliente hacia el método listarEditoriales()
            return "redirect:/editoriales/list";
        }
        else {
//Sino se insertó regresamos al formulario de ingreso
            model.addAttribute("editorial",editorial);
            return "editoriales/nuevo";
        }
    }
    @RequestMapping(value = "edit/{codigo}", method = GET)
    public String obtenerEditorial(@PathVariable("codigo") String codigo, Model model){
        model.addAttribute("editorial",
                editorialesModel.obtenerEditorial(codigo));
        return "editoriales/editar";
    }
    //Este método se ejecuta al enviar el formulario de edición
    @RequestMapping(value = "edit/{codigo}", method = POST)
    public String modificarEditorial(Editoriales editorial, Model model,
                                     RedirectAttributes atributos) {
        if(editorialesModel.modificarEditorial(editorial)>0){
            atributos.addFlashAttribute("exito","Editorial modificado exitosamente");
            return "redirect:/editoriales/list";
        }
        else {
            model.addAttribute("editorial",editorial);
            return "editoriales/editar";
        }
    }
    //El código del editorial a eliminar se recibe por la url
    @RequestMapping(value = "delete/{codigo}")
    public String eliminarEditorial(@PathVariable("codigo") String codigo, Model
            model, RedirectAttributes atributos){
        model.addAttribute("editorial",
                editorialesModel.obtenerEditorial(codigo));
        if(editorialesModel.eliminarEditorial(codigo)>0){
            atributos.addFlashAttribute("exito","Editorial eliminado exitosamente");
        }
        else {
            model.addAttribute("fracaso","no se puede eliminar este editorial");
        }
        return "redirect:/editoriales/list";
    }
}
