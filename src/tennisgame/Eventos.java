/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tennisgame;

/**
 *
 * @author Lucho
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

final class Eventos extends JPanel implements Runnable, KeyListener {
	private double posicionPelotaEnX;
	private double posicionPelotaEnY;
	private final double posicionJugador1EnX;
	private double posicionJugador1EnY;
	private final double posicionJugador2EnX;
	private double posicionJugador2EnY;
	private final double velocidadDelJugador = 6.0;
	private final double velocidadDeLaPelota = 5.0;
	private int inicioJugador1 = 1;
	private int inicioJugador2 = 1;
	private int pelotaX = 1;
	private int pelotaY = 1;
        int puntoJugador1;
        int puntoJugador2;
        boolean juego, juegoTermina;
        Tennis tablero1 = new Tennis();   
        Tennis tablero2 = new Tennis();   
        String datos[] = new String[3];
        String[] stack = new String[3];
        Tablero tableroMarcador1=new Tablero();
        Tablero tableroMarcador2=new Tablero();
        int seleccionIdioma;
        
        protected Eventos(int idioma1,int idioma2) {
            juego=true;
            this.posicionPelotaEnX = 30;
            this.posicionPelotaEnY = 0;
            this.posicionJugador1EnX = 565;
            this.posicionJugador1EnY = 180;
            this.posicionJugador2EnX = 10;
            this.posicionJugador2EnY = 180;
          
            crearIdioma1(idioma1);
            crearIdioma2(idioma2);
            
            tableroMarcador1.setVisible(true);
            tableroMarcador1.setLocation(0, 0);
            tableroMarcador1.setTitle("Marcador");
            
            tableroMarcador2.setVisible(true);
            tableroMarcador2.setLocation(0, 400);
            tableroMarcador2.setTitle("Marcador");
	}
        
        
        public void crearIdioma1(int idioma){
            if(idioma==0) {
                tablero1.setIdioma(new IdiomaEspanol());
            }
            if(idioma==1){
                tablero1.setIdioma(new IdiomaIngles());
            }
            if(idioma==2){
                tablero1.setIdioma(new IdiomaAleman());
            }
        }
        
        public void crearIdioma2(int idioma){
            if(idioma==0) {
                tablero2.setIdioma(new IdiomaEspanol());
            }
            if(idioma==1){
                tablero2.setIdioma(new IdiomaIngles());
            }
            if(idioma==2){
                tablero2.setIdioma(new IdiomaAleman());
            }
        }
        
        @Override
	public void paint(Graphics gr) {
		super.paint(gr);
		Graphics2D g = (Graphics2D)gr;
		g.setColor(Color.red);
		g.fill(new Ellipse2D.Double(this.posicionPelotaEnX, this.posicionPelotaEnY, 20, 20));
		g.setColor(Color.black);
		g.fill(new Rectangle2D.Double(this.posicionJugador1EnX, this.posicionJugador1EnY, 15, 60));
		g.setColor(Color.black);
		g.fill(new Rectangle2D.Double(this.posicionJugador2EnX, this.posicionJugador2EnY, 15, 60));	
	}

        @Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();

		switch (c) {
			case KeyEvent.VK_DOWN:
				this.inicioJugador1 = 0;
				break;
                        case KeyEvent.VK_LEFT:
				this.inicioJugador1 = 2;
				break;
                        case KeyEvent.VK_RIGHT:
				this.inicioJugador1 = 3;
				break;    
			case KeyEvent.VK_UP:
				this.inicioJugador1 = 1;
				break;    
			case KeyEvent.VK_Z:
				this.inicioJugador2 = 0;
				break;
			case KeyEvent.VK_A:
				this.inicioJugador2 = 1;
				break;
		}

		super.repaint();
	
	}

        @Override
	public void keyReleased(KeyEvent e) {
	}

        @Override
	public void keyTyped(KeyEvent e) {
	}
        
	public void run() {
		while (juego) {
			if (inicioJugador1 == 0) {
				this.posicionJugador1EnY += this.velocidadDelJugador;
				if (this.posicionJugador1EnY > 315) {
					this.posicionJugador1EnY = 315;
				} 
			}
                       
			if (inicioJugador1 == 1) {
				this.posicionJugador1EnY -= this.velocidadDelJugador;
				if (this.posicionJugador1EnY < 0) {
					this.posicionJugador1EnY = 0;
				}
			}

			if (inicioJugador2 == 0) {
				this.posicionJugador2EnY += this.velocidadDelJugador;
				if (this.posicionJugador2EnY > 315) {
					this.posicionJugador2EnY = 315;
				}
			}
			if (inicioJugador2 == 1) {
				this.posicionJugador2EnY -= this.velocidadDelJugador;
				if (this.posicionJugador2EnY < 0) {
					this.posicionJugador2EnY = 0;
				}
			}
                       
                        puntoJugador1();
			puntoJugador2();
			
			if (pelotaY == 0) {
				this.posicionPelotaEnY -= this.velocidadDeLaPelota;
				if (this.posicionPelotaEnY < 0) {
					this.pelotaY = 1;
				}
			}
			if (pelotaY == 1) {
				this.posicionPelotaEnY += this.velocidadDeLaPelota;
				if (this.posicionPelotaEnY > 350) {
					this.pelotaY = 0;
				}
			}
                        
                        

			try {
				Thread.sleep((int)Math.round(30));
			} catch (Exception e) {}

			double check1 = this.posicionJugador1EnY-15;
			while (check1 <= this.posicionJugador1EnY+60) {
				if (this.posicionJugador1EnX == this.posicionPelotaEnX+20 && check1 == this.posicionPelotaEnY) {
					
					if (inicioJugador1 == 0) {
						this.pelotaX = 0;
						this.pelotaY = 1;
					}
					if (inicioJugador1 == 1) {
						this.pelotaX = 0;
						this.pelotaY = 0;
					}
				}
				check1 += 1.0;
			}

			double check2 = this.posicionJugador2EnY-15;
			while (check2 <= this.posicionJugador2EnY+60) {
				if (this.posicionJugador2EnX+15 == this.posicionPelotaEnX && check2 == this.posicionPelotaEnY) {
					if (inicioJugador2 == 0) {
						this.pelotaX = 1;
						this.pelotaY = 1;
					}
					if (inicioJugador2 == 1) {
						this.pelotaX = 1;
						this.pelotaY = 0;
					}
				}
				check2 += 1.0;
			}
                        
			super.repaint();
		}
	}
       
        public void puntoJugador2(){
            if (pelotaX == 0) {
				this.posicionPelotaEnX -= this.velocidadDeLaPelota;
				if (this.posicionPelotaEnX < 0) {
					this.pelotaX = 1;
					this.posicionPelotaEnX = 100;
                                        puntoJugador2 = tablero2.point(2);
                                        datos[0]=Integer.toString(puntoJugador1);
                                        datos[1]=Integer.toString(puntoJugador2);
                                        datos[2]=tablero2.score();
                                        tableroMarcador2.insertarDatosEnTabla(datos);
                                        finalizaJuego();
				}
			}
        }
        
        public void puntoJugador1(){
            if (pelotaX == 1) {
				this.posicionPelotaEnX += this.velocidadDeLaPelota;
                               
				if (this.posicionPelotaEnX > 570) {
					this.pelotaX = 0;
					this.posicionPelotaEnX = 360;
                                        puntoJugador1 = tablero1.point(1);
                                        datos[0]=Integer.toString(puntoJugador1);
                                        datos[1]=Integer.toString(puntoJugador2);
                                        datos[2]=tablero1.score();
                                        tableroMarcador1.insertarDatosEnTabla(datos);
                                        finalizaJuego();
				}
			}
        }
        
        public void finalizaJuego(){
           
            String mensaje = "";
            if(tablero1.score().equals("Player 1 wins")){mensaje =tablero1.score();}
            if(tablero1.score().equals("Jugador 1 gana")){mensaje =tablero1.score();}
            if(tablero1.score().equals("Spieler 1 Verdienen")){mensaje =tablero1.score();}
            
            if(tablero2.score().equals("Player 2 wins")){mensaje =tablero2.score();}
            if(tablero2.score().equals("Jugador 2 gana")){mensaje =tablero2.score();}
            if(tablero2.score().equals("Spieler 2 Verdienen")){mensaje =tablero2.score();}
            
            if(tablero1.score().equals("Player 1 wins") || tablero2.score().equals("Player 2 wins") ||
               tablero1.score().equals("Jugador 1 gana") || tablero2.score().equals("Jugador 2 gana") ||    
               tablero1.score().equals("Spieler 1 Verdienen") || tablero2.score().equals("Spieler 2 Verdienen")     ){
                juego=false;
                juegoTermina=true;
                JOptionPane.showMessageDialog(this, mensaje);
            }
            
            
        }
        
} 
