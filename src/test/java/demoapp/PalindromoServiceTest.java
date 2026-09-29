package demoapp;

import demoapp.service.PalindromoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PalindromoServiceTest {

    @Autowired
    private PalindromoService palindromoService;

    @Test
    public void contextLoads() {
        assertThat(palindromoService).isNotNull();
    }

    @Test
    public void testPalabrasPalindromas() {
        assertThat(palindromoService.esPalindromo("radar")).isTrue();
        assertThat(palindromoService.esPalindromo("reconocer")).isTrue();
        assertThat(palindromoService.esPalindromo("Anita lava la tina")).isTrue();
    }

    @Test
    public void testPalabrasNoPalindromas() {
        assertThat(palindromoService.esPalindromo("hola")).isFalse();
        assertThat(palindromoService.esPalindromo("perro")).isFalse();
    }
}
