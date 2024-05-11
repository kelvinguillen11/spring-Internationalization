package com.example.demo_springmvc.validations;

import com.example.demo_springmvc.entities.Libros;
import com.example.demo_springmvc.service.LocalizationService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibrosValidator implements Validator {

    private LocalizationService localizationService;

    public LibrosValidator(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @Override
    public boolean supports(Class clazz){
        return Libros.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Pattern patNumeros = Pattern.compile("\\d+");
        Libros libro = (Libros) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoLibro",
                "field.codigoLibro.required", localizationService.getMessage("libro.codigoError", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombreLibro",
                "field.nombreLibro.required", localizationService.getMessage("libro.nombreError", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "existencias",
                "field.existencias.required", localizationService.getMessage("libro.existenciasError", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precio",
                "field.precio.required", localizationService.getMessage("libro.precioError", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "autoresByCodigoAutor.codigoAutor",
                "field.autoresByCodigoAutor.codigoAutor.required", localizationService.getMessage("libro.AutorError", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "editorialesByCodigoEditorial.codigoEditorial",
                "field.editorialesByCodigoEditorial.codigoEditorial.required", localizationService.getMessage("libro.editorialError", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "generosByIdGenero.idGenero",
                "field.generosByIdGenero.idGenero.required", localizationService.getMessage("libro.generoError", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion",
                "field.descripcion.required", localizationService.getMessage("libro.descripcionError", LocaleContextHolder.getLocale()));
            String existenciasToEvaluate = String.valueOf(libro.getExistencias());
            Matcher num = patNumeros.matcher(existenciasToEvaluate);
        if (!num.matches()) {
            errors.rejectValue("existencias", "field.existencias.invalid", localizationService.getMessage("libro.existenciasValido", LocaleContextHolder.getLocale()));
        }

    }
}
