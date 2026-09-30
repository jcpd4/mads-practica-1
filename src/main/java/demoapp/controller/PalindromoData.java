package demoapp.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PalindromoData {

    @NotEmpty(message = "El texto no puede estar vacío")
    @Size(min = 2, max = 50, message = "El texto debe tener entre 2 y 50 caracteres")
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
