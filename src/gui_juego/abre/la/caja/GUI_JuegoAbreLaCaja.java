/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui_juego.abre.la.caja;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class GUI_JuegoAbreLaCaja extends  JFrame {
private JPanel pSuperior, Pcentral,Pinferior,Pbotones,Oriente,Ooriente,Ooccidente,inferior;
private JLabel icono,puntuacion,nivel,vidas1;
private JScrollPane deslizar;
private JTextArea puntos,trabajo;
private JButton iniciar, colorBotones[][],botonNivel[],juegoTerminar,vidas[];
private ArrayList<String>patronBotones;
private int filas=4, columnas=3;


   

  
 private void initGUI() {
    patronBotones= new ArrayList<>();
    pSuperior    = new  JPanel ();
    Ooccidente   = new  JPanel ();
    juegoTerminar= new JButton("Abandonar Juego");
    juegoTerminar.setPreferredSize(new Dimension(140,18));
    iniciar      = new JButton ("Jugar");
    iniciar.setPreferredSize(new Dimension(86,18));
    Ooccidente.add(iniciar,BorderLayout.WEST);
    Ooriente   = new  JPanel ();
    puntuacion   = new  JLabel("Puntuacion:");
    puntos       = new  JTextArea(1,30);
    puntos.setBorder(BorderFactory.createTitledBorder(null, "Vera su puntuación  obtenida a lo largo del juego...",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,new Font("Calibri",Font.PLAIN,12),Color.BLACK));
    puntos.setBackground(Color.LIGHT_GRAY);
    Ooriente.add(juegoTerminar);Ooriente.add(puntuacion);Ooriente.add(puntos);
    pSuperior.add(Ooccidente,BorderLayout.WEST);pSuperior.add(Ooriente,BorderLayout.WEST);
    pSuperior.setBorder(BorderFactory.createTitledBorder(null, "Panel superior...",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Calibri",Font.PLAIN,12),Color.BLACK));
    add(pSuperior,BorderLayout.NORTH);
    
    Pcentral     = new  JPanel ();
     icono       = new  JLabel();
     icono.setIcon(new ImageIcon("src/Recursos/1.png"));
     icono.setBounds(27,10,20,70);
     Pbotones    = new  JPanel ();
     
    colorBotones = new JButton[filas][columnas];
    Pbotones= new JPanel(new GridLayout(4,3,6,6));
         for (int i=0;i< filas;i++){
         for (int j=0;j< columnas;j++) {
          
          colorBotones[i][j] = new JButton("");
          colorBotones[i][j].setBorderPainted(true);
          colorBotones[i][j].setOpaque(true);
          ManejaTeclas teclas = new ManejaTeclas();
          colorBotones[i][j].addActionListener(teclas);
          if(i==0)
          {colorBotones[i][j].setBackground(Color.blue);}
          if(i==1)
          {colorBotones[i][j].setBackground(new Color(200, 30, 30));}
          if(i==2)
          {colorBotones[i][j].setBackground(new Color(233, 250, 63));}
          if(i==3)
          {colorBotones[i][j].setBackground(new Color(44, 199, 93 ));}
          Pbotones.add((colorBotones[i][j]));
          
      }
       
      }
    Pcentral.add(icono,BorderLayout.WEST);
     
   
     
     Oriente     = new  JPanel (new GridLayout(2,2,4,4));
     trabajo       = new  JTextArea(
             "Objetivo del juego\n"+"El objetivo de este juego es fortalecer la memoria a corto plazo y la memoria de trabajo que son-\n" +
             "críticas a la hora de almacenar temporalmente la información y manipularla para dar respuestas-\n" +
             "rápidas.\n" +"Para Jugarlo hay que memorizar y repetir en el orden correcto la secuencia de teclas de colores que\n" +
             "se irán resaltando en un tablero.\n" +
             "Para abrir completamente la caja fuerte se resaltará una secuencia de 5 botones, la cual se va dando\n" +
             "progresivamente aumentando de a una, a medida que el usuario repita la secuencia proporcionada\n" +
             "correctamente. Y por cada acierto se va sumando a la puntuación.");
    trabajo.setBounds(0,0,40,40);
    trabajo.setBackground(Color.LIGHT_GRAY);
     Oriente.setBorder(BorderFactory.createTitledBorder(null, "Panel de teclas y objetivo del juego...",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Calibri",Font.PLAIN,12),Color.BLACK));
     Oriente.add(Pbotones,BorderLayout.CENTER);Oriente.add(trabajo,BorderLayout.SOUTH);
    add(Pcentral,BorderLayout.WEST);
    add(Oriente,BorderLayout.CENTER);
    deslizar= new JScrollPane(trabajo);
    deslizar.setBackground(Color.LIGHT_GRAY);
     Oriente.add(deslizar);
    
     
     
     Pinferior   = new  JPanel (); 
     
     vidas1 = new  JLabel ("Vidas:");
     Pinferior.add(vidas1);
     vidas = new JButton[2];
     
     for (int l=0;l< vidas.length;l++) {
          
          vidas[l] = new JButton(""+(l+0));
          vidas[l].setPreferredSize(new Dimension(80,18));
          Pinferior.add(vidas[l]);
         
     }
     
    
     nivel = new JLabel ("Nivel :");
     Pinferior.add(nivel);
     botonNivel  = new JButton [1];
     
     for (int l=0;l< botonNivel.length;l++) {
          
          botonNivel[l] = new JButton(""+(l+1));
          botonNivel[l].setPreferredSize(new Dimension(80,18));
          Pinferior.add(botonNivel[l]);
         
     }
     
     Pinferior.setBorder(BorderFactory.createTitledBorder(null, "Panel inferior...",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,new Font("Calibri",Font.PLAIN,12),Color.BLACK));
     add(Pinferior,BorderLayout.SOUTH);
     
      pSuperior.setBackground(Color.LIGHT_GRAY);
      Pcentral.setBackground(Color.LIGHT_GRAY);
      Pinferior.setBackground(Color.LIGHT_GRAY);
      Pbotones.setBackground(Color.LIGHT_GRAY);
      Oriente.setBackground(Color.LIGHT_GRAY);
      Ooriente.setBackground(Color.LIGHT_GRAY);
      Ooccidente.setBackground(Color.LIGHT_GRAY);
       
       ManejaTeclas teclas = new ManejaTeclas();
       iniciar.addActionListener(teclas);
       juegoTerminar.addActionListener(teclas);
       
      
    };
    public GUI_JuegoAbreLaCaja(){
    initGUI();
    
    this.setTitle("Juego Abre La Caja");
    this.setSize(700,450); 
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    trabajo.setEditable(false);
    puntos.setEditable(false);
    this.setResizable(false);
    
    
    };

  
    public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable(){
           @Override
      public void run (){
      GUI_JuegoAbreLaCaja GUI_JuegoAbreLaCaja = new  GUI_JuegoAbreLaCaja();
      
    }

    });

    }
    
    class ManejaTeclas implements ActionListener,FocusListener{
       int cVidas,puntos,topeNumeros;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==iniciar)
            {
             //iniciar  las variables del juego 
               cVidas=1;
               puntos=0;
               topeNumeros=50;
               
             // hacer los botones de forma aleatoria
             for (int i=0;i< filas;i++)    {
             for (int j=0;j< columnas;j++) {
             int alea= (int)(Math.random()*topeNumeros);
              colorBotones[i][j].setText(""+alea);
          
            }
       
            }
            // hacer los botones de forma aleatoria
          }
        }

        @Override
        public void focusGained(FocusEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void focusLost(FocusEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

}