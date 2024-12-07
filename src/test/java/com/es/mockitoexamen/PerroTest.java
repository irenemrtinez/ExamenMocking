package com.es.mockitoexamen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class PerroTest {
    private Perro perro;
    private Ladra ladra;

    @BeforeEach
    public void setUp() {
        this.ladra = mock(Ladra.class);
        this.perro = new Perro(ladra);
    }

    /**
     * Test comprueba que, si el metodo ladrido devuelve algo
     * el metodo ladrar funciona correctamente
     */
    @Test
    public void comoLadra() {
        when(ladra.ladrido()).thenReturn("guau");
        String mensaje = perro.ladrar();
        String expected = "guau guau";

        assertEquals(expected, mensaje);
    }

    @Test
    public void numeroLadridos() {
        when(ladra.ladrido()).thenReturn("guau");
        perro.ladrar();
        
        verify(ladra, times(2)).ladrido();
    }

    @Test
    public void comoLadraRaro() {
        when(ladra.ladrido()).thenReturn("guau").thenReturn("gu");
        String mensaje = perro.ladrar();
        String expected = "guau gu";

        assertEquals(expected, mensaje);
    }

    @Test
    public void contento() {
        when(ladra.ladrido()).thenReturn("guau").thenReturn("gu");
        when(ladra.aullido()).thenReturn("auuu");
        String mensaje = perro.contento();
        String expected = "auuu guau";

        assertEquals(expected, mensaje);
        InOrder inOrder = Mockito.inOrder(ladra);
        inOrder.verify(ladra).aullido();
        inOrder.verify(ladra).ladrido();

    }

    @Test
    public void emocionado() {
        perro.emocionado();
        verify(ladra, atLeast(0)).aullido();
        verify(ladra, atMost(10)).aullido();
        verify(ladra, atLeast(1)).ladrido();
        verify(ladra, atMost(10)).ladrido();
    }

}
