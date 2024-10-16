package org.example.restaurant;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PedidoTest {


    @Test
    public void pedidoReduceDineroUsuario() throws SinSaldoException {
        Usuario u = new Usuario("roman meclazcke", 1, 1000, "romanmeclazcke@gmail.com");
        Pedido p = new Pedido();
        p.setUsuario(u);

        Float saldoInicial = u.getSaldo();

        Producto pr1 = new ProductoBasico("papa", 100, 100); // Precio total: 100
        Producto pr2 = new ProductoBasico("carne", 200, 200); // Precio total: 200

        ItemPedido it1 = new ItemPedido(1, pr1);
        ItemPedido it2 = new ItemPedido(2, pr2);

        p.agregarItem(it1);
        p.agregarItem(it2);

        p.solicitarPedido();


        float totalPedido = p.totalPedido();
        Float saldoFinal = u.getSaldo();

        assertTrue("Error al descontar el saldo", saldoFinal == saldoInicial - totalPedido);
    }


    @Test
    public void testGanaciaMayor20Porciento() throws SinSaldoException {
        Usuario u = new Usuario("roman meclazcke", 1, 1000000000, "romanmeclazcke@gmail.com");
        Pedido p = new Pedido();
        Producto pr1 = new ProductoBasico("papa", 1000, 99999);
        Producto pr2 = new ProductoBasico("carne", 10000, 99999);

        ItemPedido it1 = new ItemPedido(1, pr1);
        ItemPedido it2 = new ItemPedido(2, pr2);

        p.agregarItem(it1);
        p.agregarItem(it2);
        p.setUsuario(u);
        p.solicitarPedido();


        Float totalGanacia = p.totalPedido()-p.totalPedidoBase();
        Float porcentajeGanancia = (totalGanacia / p.totalPedidoBase()) * 100;
        System.out.println(porcentajeGanancia);
        System.out.println(totalGanacia);
        assertTrue("La elaboracion no supera el 20% de ganacia", porcentajeGanancia>20);
    }

}
