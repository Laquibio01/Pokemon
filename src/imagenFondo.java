/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aaron
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class imagenFondo extends JPanel{
private Image fondo=null;
@Override
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
}
public void setImage(String image){
    if (image!=null) {
        fondo=new ImageIcon(getClass().getResource(image)).getImage();
    }
  }
}