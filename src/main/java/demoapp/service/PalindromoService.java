package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromoService {

    public boolean esPalindromo(String texto) {
        if (texto == null) {
            return false;
        }
        // Quitamos espacios y pasamos a minúsculas para comparar
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        if (limpio.isEmpty()) {
            return false;
        }
        String invertido = new StringBuilder(limpio).reverse().toString();
        return limpio.equals(invertido);
    }
}
