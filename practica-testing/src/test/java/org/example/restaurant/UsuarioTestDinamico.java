package org.example.restaurant;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UsuarioTestDinamico {

    @DataProvider(name = "emailProvider")
    public Object[][] emailProvider() {
        return new Object[][] {
                { new Usuario("Nombre Apellido", 1, 1000, "nombre.apellido@example.com") },
                { new Usuario("Nombre Apellido 2", 1, 1000, "nombre2.apellido@example.com") },
                { new Usuario("Nombre Apellido 3", 1, 1000, "nombre3.apellido@example.com") },
        };
    }

    @Test(dataProvider = "emailProvider")
    public void testEmailValido(Usuario usuario) {
        assertTrue(usuario.email.contains("@"), "El correo electrónico debe contener '@'");
    }
}
