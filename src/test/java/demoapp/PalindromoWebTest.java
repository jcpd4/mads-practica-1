package demoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PalindromoWebTest {

    @Autowired
    private MockMvc mockMvc;

    // 1. Comprueba que GET /palindromo devuelve 200 OK y carga el formulario
    @Test
    public void getPalindromoMuestraFormulario() throws Exception {
        this.mockMvc.perform(get("/palindromo"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Comprobador de Palíndromos")));
    }

    // 2. Comprueba que al enviar una palabra palíndroma responde "SÍ es palíndromo"
    @Test
    public void postPalindromoTextoValidoEsPalindromo() throws Exception {
        this.mockMvc.perform(post("/palindromo")
                .param("texto", "radar"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("SÍ es palíndromo")));
    }

    // 3. Comprueba que al enviar una palabra no palíndroma responde "NO es
    // palíndromo"
    @Test
    public void postPalindromoTextoValidoNoEsPalindromo() throws Exception {
        this.mockMvc.perform(post("/palindromo")
                .param("texto", "perro"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("NO es palíndromo")));
    }

    // 4. Comprueba que al enviar el texto vacío se detectan errores de validación
    @Test
    public void postPalindromoTextoVacioTieneErrores() throws Exception {
        this.mockMvc.perform(post("/palindromo")
                .param("texto", ""))
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());
    }
}
