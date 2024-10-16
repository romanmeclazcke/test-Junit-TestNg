package org.example.restaurant;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void NoExistenUsuariosRepetidos(){
        ArrayList<Usuario> aux = new ArrayList<>();

        ArrayList<Usuario> aux2 = new ArrayList<>();
        Usuario a = new Usuario("Roman",1,2000,"romanmeclazcke@gmail.com" );
        Usuario b = new Usuario("romancito",1,1000,"romanmeclazcke@gmail.com" );
        Usuario c = new Usuario("romaneta",1,50,"romanmeclazcke12@gmail.com" );
        Usuario d = new Usuario("pepe",1,300,"romanmeclazcke123@gmail.com" );

        aux2.add(a);
        aux2.add(b);
        aux2.add(c);
        aux.add(d);

        for (Usuario u: aux2){
            for (Usuario u2: aux){
                assertNotEquals(u,u2);
            }
        }
    }

    @Test
    public void UsuarioCorreoValido(){
        ArrayList<Usuario> aux2 = new ArrayList<>();
        Usuario a = new Usuario("Roman",1,2000,"roman@a.com" );
        Usuario b = new Usuario("romancito",1,1000,"romanmeclazcke@gmail.com" );
        Usuario c = new Usuario("romaneta",1,50,"romanmeclazcke12@gmail.com" );
        Usuario d = new Usuario("pepe",1,300,"romanmeclazcke123gmail.com" );

        aux2.add(a);
        aux2.add(b);
        aux2.add(c);


        for (Usuario usuario : aux2) {
            assertTrue("El email del usuario " + usuario.nombreYApellido + " no es válido.", usuario.emailEsValido());
        }
    }
}
