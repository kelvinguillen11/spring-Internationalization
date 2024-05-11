package com.example.demo_springmvc.validations;
import com.example.demo_springmvc.entities.Editoriales;
import com.example.demo_springmvc.service.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EditorialValidator implements Validator {

    private LocalizationService localizationService;

    public EditorialValidator(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }
    @Override
    public boolean supports(Class clazz) {
        return Editoriales.class.equals(clazz); // clase del bean al que da soporte este validador
    }
    @Override
    public void validate(Object target, Errors errors) {
        Pattern patTelefono = Pattern.compile("[267][0-9]{3}-[0-9]{4}");
        Editoriales editorial = (Editoriales) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoEditorial",
                "field.codigoEditorial.required",localizationService.getMessage("editorial.codigoObligatorio", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombreEditorial",
                "field.nombreEditorial.required",localizationService.getMessage("editorial.nombreObligatorio", LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contacto",
                "field.contacto.required",localizationService.getMessage("editorial.contactoObligatorio", LocaleContextHolder.getLocale()));
        Matcher mat = patTelefono.matcher(editorial.getTelefono());
        if (!mat.matches()) {
            errors.rejectValue("telefono", "field.telefono.invalid", localizationService.getMessage("editorial.telefonoValido", LocaleContextHolder.getLocale()));
        }
    }
}

