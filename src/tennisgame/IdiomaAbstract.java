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
abstract class IdiomaAbstract implements Idioma {
    
    @Override
    public String getNumber(int puntaje) {
        switch (puntaje) {
            case 15:
                return getFifteen();
            case 30:
                return getThirty();
            case 40:
                return getForty();
            default:
                return getZero();
        }
    }
    
    public abstract String getZero();
    
    public abstract String getFifteen();
    
    public abstract String getThirty();
    
    public abstract String getForty();
}
