/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tennisgame;

/**
 *
 * @author Ch3ma
 */
public class Tennis {

    private int puntajeJugador1 = 0;
    private int puntajeJugador2 = 0;
    private Idioma idioma;
    int datos[]=new int[3];

    public int point(int numeroJugador) {
        if (numeroJugador == 1) {
            puntajeJugador1 = incrementa(puntajeJugador1);
            return puntajeJugador1; 
        } else {
            puntajeJugador2 = incrementa(puntajeJugador2);
            return puntajeJugador2;
        }
        
    }
    
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String score() {
        if (juegoEstaEmpatado()) {
            return scoreEmpatado();
        } else if (juegoTerminado()){
            return scoreConGanador();
        } else if (juegoConVentaja()) {
            return scoreConVentaja();
        } else {
            return scoreNormal();
        }
    }
    
    
    private int incrementa(int puntaje) {
        return (puntaje < 30) ? puntaje + 15 : puntaje + 10;
    }
    
    private String puntajeEnTexto(int puntaje) {
        return getIdioma().getNumber(puntaje);
    }
    
    private boolean juegoEstaEmpatado() {
        return puntajeJugador1 == puntajeJugador2;
    }
    
    private boolean juegoTerminado() {
        return (algunoLlevaMasDe40Puntos()) && algunoTienePuntosDeVentaja(20);
    }
    
    private boolean algunoLlevaMasDe40Puntos() {
        return (puntajeJugador1 == 60 || puntajeJugador2 == 60);
    }
    
    private boolean algunoTienePuntosDeVentaja(int numeroPuntos) {
        //return (Math.abs(puntajeJugador1 - puntajeJugador2) >= numeroPuntos);
        return (puntajeJugador1 == 60 || puntajeJugador2 == 60);
    }
    
    private boolean juegoConVentaja() {
        return (algunoLlevaMasDe40Puntos() && algunoTienePuntosDeVentaja(10));
    }
    
    private String jugadorConVentaja() {
        return (puntajeJugador1 > puntajeJugador2) ? "Player 1" : "Player 2";
    }
    
    private String scoreEmpatado() {
        return (puntajeJugador1 < 40) ? empateAll() : deuce();
    }
    
    private String scoreNormal() {
        return puntajeEnTexto(puntajeJugador1) + "-" + puntajeEnTexto(puntajeJugador2);
    }
    
    private String empateAll() {
        return puntajeEnTexto(puntajeJugador1) + "-" + getIdioma().getAll();
    }
    
    private String deuce() {
        return getIdioma().getDeuce();
    }
    
    private String scoreConGanador() {
        return jugadorConVentaja() + " " + getIdioma().getWins();
    }
    
    private String scoreConVentaja() {
        return jugadorConVentaja() + " " + getIdioma().getAdvantages();
    }
    
    private Idioma getIdioma() {
        return idioma;
    }
    
}
