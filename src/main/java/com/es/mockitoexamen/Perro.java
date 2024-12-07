package com.es.mockitoexamen;

public class Perro {
    private Ladra ladra;

    public Perro(Ladra ladra) {
        this.ladra = ladra;
    }

    public String ladrar() {
        String ladrido = "";
        for (int i = 0; i < 2; i++) {
            ladrido += ladra.ladrido();
            if (i < 1) {
                ladrido += " ";
            }
        }
        return ladrido;
    }

    public String contento() {
        String mensaje = ladra.aullido();
        mensaje += " " + ladra.ladrido();

        return mensaje;
    }

    public String emocionado(){
        int numLadridos = (int) (Math.random() * 10);
        int numAullidos = (int) (Math.random() * 10);

        if (numLadridos == 0) {
            numLadridos = 1;
        }

        String mensaje = "";
        for (int i = 0; i < numLadridos; i++) {
            mensaje += ladra.ladrido();
            if (i < numLadridos - 1) {
                mensaje += " ";
            }
        }
        mensaje += " ";
        for (int i = 0; i < numAullidos; i++) {
            mensaje += ladra.aullido();
            if (i < numAullidos - 1) {
                mensaje += " ";
            }
        }
        return mensaje;
    }
}
