
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.*;

public class m {
    public static void main(String[] args) {
        JButton bpin1 = new JButton("1");
   bpin1.setBounds(73,428,83,52);
   bpin1.setBackground(Color.BLACK);
   bpin1.setOpaque(false);
   bpin1.setContentAreaFilled(false);
   bpin1.setFocusable(false);
   bpin1.setBorder(null);
   bpin1.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin1.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
         String bt = ((JButton)e.getSource()).getText();
            String ct = bepin.getText();
            bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin1);

   JButton bpin2 = new JButton("2");
   bpin2.setBounds(182,428,83,52);
   bpin2.setBackground(Color.BLACK);
   bpin2.setOpaque(false);
   bpin2.setContentAreaFilled(false);
   bpin2.setFocusable(false);
   bpin2.setBorder(null);
   bpin2.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin2.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin2);

   JButton bpin3 = new JButton("3");
   bpin3.setBounds(292,428,83,52);
   bpin3.setBackground(Color.BLACK);
   bpin3.setOpaque(false);
   bpin3.setContentAreaFilled(false);
   bpin3.setFocusable(false);
   bpin3.setBorder(null);
   bpin3.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin3.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin3);

   JButton bpin4 = new JButton("4");
   bpin4.setBounds(73,486,83,52);
   bpin4.setBackground(Color.BLACK);
   bpin4.setOpaque(false);
   bpin4.setContentAreaFilled(false);
   bpin4.setFocusable(false);
   bpin4.setBorder(null);
   bpin4.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin4.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin4);

   JButton bpin5 = new JButton("5");
   bpin5.setBounds(182,486,83,52);
   bpin5.setBackground(Color.BLACK);
   bpin5.setOpaque(false);
   bpin5.setContentAreaFilled(false);
   bpin5.setFocusable(false);
   bpin5.setBorder(null);
   bpin5.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin5.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin5);

   JButton bpin6 = new JButton("6");
   bpin6.setBounds(292,486,83,52);
   bpin6.setBackground(Color.BLACK);
   bpin6.setOpaque(false);
   bpin6.setContentAreaFilled(false);
   bpin6.setFocusable(false);
   bpin6.setBorder(null);
   bpin6.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin6.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin6);

   JButton bpin7 = new JButton("7");
   bpin7.setBounds(73,544,83,52);
   bpin7.setBackground(Color.BLACK);
   bpin7.setOpaque(false);
   bpin7.setContentAreaFilled(false);
   bpin7.setFocusable(false);
   bpin7.setBorder(null);
   bpin7.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin7.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin7);

   JButton bpin8 = new JButton("8");
   bpin8.setBounds(182,544,83,52);
   bpin8.setBackground(Color.BLACK);
   bpin8.setOpaque(false);
   bpin8.setContentAreaFilled(false);
   bpin8.setFocusable(false);
   bpin8.setBorder(null);
   bpin8.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin8.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin8);

   JButton bpin9 = new JButton("9");
   bpin9.setBounds(292,544,83,52);
   bpin9.setBackground(Color.BLACK);
   bpin9.setOpaque(false);
   bpin9.setContentAreaFilled(false);
   bpin9.setFocusable(false);
   bpin9.setBorder(null);
   bpin9.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin9.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin9);

   JButton bpin0 = new JButton("0");
   bpin0.setBounds(182,602,83,52);
   bpin0.setBackground(Color.BLACK);
   bpin0.setOpaque(false);
   bpin0.setContentAreaFilled(false);
   bpin0.setFocusable(false);
   bpin0.setBorder(null);
   bpin0.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   bpin0.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = bepin.getText();
              bepin.setText(ct + bt);
      }
   });
   frbpin.add(bpin0);

   JButton pinok = new JButton();
   pinok.setBounds(292,602,83,52);
   pinok.setBackground(Color.BLACK);
   pinok.setOpaque(false);
   pinok.setContentAreaFilled(false);
   pinok.setFocusable(false);
   pinok.setBorder(null);
   pinok.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   frbpin.add(pinok);
   
   JButton bpinent = new JButton();
   bpinent.setBounds(425,430,168,65);
   bpinent.setBackground(Color.BLACK);
   bpinent.setOpaque(false);
   bpinent.setContentAreaFilled(false);
   bpinent.setFocusable(false);
   bpinent.setBorder(null);
   bpinent.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   bpinent.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         int correct = Integer.parseInt(bepin.getText());

        if(correct != 1234){
            bepin.setText(null);
        }
        else{
            JOptionPane.showMessageDialog(null,"Happy banking!");
            bepin.setText(null);
            mainbasics.setVisible(true);
            mainbpin.dispose();
        }  
      }
   });
   frbpin.add(bpinent);

   JButton bpinclr = new JButton();
   bpinclr.setBounds(425,502,168,65);
   bpinclr.setBackground(Color.BLACK);
   bpinclr.setOpaque(false);
   bpinclr.setContentAreaFilled(false);
   bpinclr.setFocusable(false);
   bpinclr.setBorder(null);
   bpinclr.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   bpinclr.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          bepin.setText(null);
      }
   });
   frbpin.add(bpinclr);

   JButton bpincan = new JButton();
   bpincan.setBounds(425,572,168,65);
   bpincan.setBackground(Color.BLACK);
   bpincan.setOpaque(false);
   bpincan.setContentAreaFilled(false);
   bpincan.setFocusable(false);
   bpincan.setBorder(null);
   bpincan.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   bpincan.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         int cancel = JOptionPane.showConfirmDialog(null,"Sure? You want to cancel?", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (cancel == JOptionPane.YES_OPTION) 
         {
            mainbasics.setVisible(true);
            mainbpin.dispose();
         }
         else if (cancel == JOptionPane.NO_OPTION) 
         {
             
         }
      }
   });
   frbpin.add(bpincan);
    }
}
