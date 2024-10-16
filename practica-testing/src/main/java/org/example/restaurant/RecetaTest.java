package org.example.restaurant;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RecetaTest {

    @Test
    public void receteConMasDeUnComponente(){
        Receta c = new Receta("Tortilla",10,2000);
        Ingrediente papa = new Ingrediente("papa","gramo",2,2);
        Ingrediente carne = new Ingrediente("carne","kilo",3,100);

        ItemReceta ir1= new ItemReceta(papa,2);
        ItemReceta ir2= new ItemReceta(carne,5);

        c.addIngrediente(ir1);
        c.addIngrediente(ir2);


        assertTrue("La receta debe contener mas e 1 item", c.getIngredientes().size()>1);

    }
}
