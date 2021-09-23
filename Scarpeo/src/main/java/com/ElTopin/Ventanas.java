package com.ElTopin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.stereotype.Repository;




@Repository

public class Ventanas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static void openWebpage() {
	    try {
	        Desktop.getDesktop().browse(new URL("http://localhost:2333").toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public JFrame crearVenatanaInicio()  {
		/*Ventana*/
		JFrame frame = new JFrame("El Topín - Herramienta SEO");
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        frame.setSize(width/2, height/2);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("topo.png")));
       
        
        
        GridLayout experimentLayout = new GridLayout(4,4);
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(48, 47, 47));
        panelPrincipal.setLayout(experimentLayout);
        
        JPanel posicion1 = new JPanel(new BorderLayout());
         posicion1.setBackground(new Color(48, 47, 47));
         JPanel posicion2 = new JPanel(new BorderLayout());
         posicion2.setBackground(new Color(48, 47, 47));
         JPanel posicion3 = new JPanel(new BorderLayout());
         posicion3.setBackground(new Color(48, 47, 47));
         JPanel posicion4 = new JPanel(new BorderLayout());
         posicion4.setBackground(new Color(48, 47, 47));
         JPanel posicion5 = new JPanel(new BorderLayout());
         posicion5.setBackground(new Color(48, 47, 47));
         
        
        
        	
        	
        	JLabel posicion6 = new JLabel(new ImageIcon(this.getClass().getResource("topo.png")));
        	//panelArribaIzquierda.setText("Se ve");
        	posicion6.setOpaque(true);
        	posicion6.setBackground(new Color(48, 47, 47));
        	
        	
        	
        	
        	JLabel posicion7 = new JLabel("El Topín");
        	
        	posicion7.setForeground(new Color(255,255,255));
        	posicion7.setBackground(new Color(48, 47, 47));
        	//posicion7.setBounds(10, 10, 100, 100);
        	Font font;
			try {
				font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("LuckiestGuy-Regular.ttf"));
				posicion7.setFont(font.deriveFont(Font.BOLD, 44));
				
			} catch (FontFormatException e) {
				posicion7.setFont(new Font("Serif", Font.BOLD, 40));
				e.printStackTrace();
			} catch (IOException e) {
				posicion7.setFont(new Font("Serif", Font.BOLD, 40));
				e.printStackTrace();
				
			}
        
			 JPanel posicion8 = new JPanel(new BorderLayout());
	         posicion8.setBackground(new Color(48, 47, 47));
	         JPanel posicion9 = new JPanel(new BorderLayout());
	         posicion9.setBackground(new Color(48, 47, 47));
	         JLabel posicion10 = new JLabel();
	     
	         JButton posicion11 = new JButton("Sacar al Topín");	        
	         	posicion11.setPreferredSize(new Dimension(40, 40));
	         	posicion11.setBackground(new Color(91,88,88));
	         	posicion11.setForeground(new Color(91,88,88));
	         	ActionListener oyenteAccion = new ActionListener() {
	         		
	         		@Override
		         	public void actionPerformed(ActionEvent ae) {
	         			openWebpage();
		         		
		         	}
	         	};
	         	
	         	
	         	
	         	posicion11.addActionListener(oyenteAccion);
	         	Font font2;
	         	try {
					font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("LoveYaLikeASister-Regular.ttf"));
					posicion11.setFont(font2.deriveFont(Font.BOLD, 17));
					
				} catch (FontFormatException e) {
					posicion11.setFont(new Font("Serif", Font.BOLD, 17));
					e.printStackTrace();
				} catch (IOException e) {
					posicion11.setFont(new Font("Serif", Font.BOLD, 17));
					e.printStackTrace();
					
				}
	         	
	         JPanel posicion12 = new JPanel(new BorderLayout());
	         posicion12.setBackground(new Color(48, 47, 47));
	         JPanel posicion13 = new JPanel(new BorderLayout());
	         posicion13.setBackground(new Color(48, 47, 47));
	         JLabel posicion14 = new JLabel();
	         posicion14.setBackground(new Color(48, 47, 47));
	         JPanel posicion15 = new JPanel(new BorderLayout());
	         posicion15.setBackground(new Color(48, 47, 47));
	         JPanel posicion16 = new JPanel(new BorderLayout());
	         posicion16.setBackground(new Color(48, 47, 47));
        
        
	         panelPrincipal.add(posicion1);
	         panelPrincipal.add(posicion2);
	         panelPrincipal.add(posicion3);
	         panelPrincipal.add(posicion4);
	         panelPrincipal.add(posicion5);
	         panelPrincipal.add(posicion6);
	         panelPrincipal.add(posicion7);
	         panelPrincipal.add(posicion8);
	         panelPrincipal.add(posicion9);
	         panelPrincipal.add(posicion10);
	         panelPrincipal.add(posicion11);
	         panelPrincipal.add(posicion12);
	         panelPrincipal.add(posicion13);
	         panelPrincipal.add(posicion14);
	         panelPrincipal.add(posicion15);
	         panelPrincipal.add(posicion16);
	         
        
        
        
         
        frame.setContentPane(panelPrincipal);
        frame.setVisible(true);
        return frame;
	}
	
}
