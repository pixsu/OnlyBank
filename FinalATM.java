import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class FinalATM {
   public static String[] currency = {"USD","EUR","CNY","GBP","JPY","KRW","INR","CAD","THB","AED"};
   public static int attempt = 3;
   private static double value = 0;
   private static double bal = 5000;
   private static double maxvalue = 5000;
   public static void main(String[] args) {
   

// SCREEN -------------------------------------------------------------------------------------------------------------//

   JFrame mainload = new JFrame();
   mainload.setSize(1000,720);
   mainload.setLocationRelativeTo(null);
   mainload.setResizable(false);
   mainload.setVisible(true);

   JLabel frload = new JLabel();
   frload.setLayout(null);
   frload.setBounds(0,0,1000,700);
   frload.setBackground(Color.white);
   frload.setIcon(new ImageIcon("difframe.png"));
   mainload.add(frload);

   JLabel loading = new JLabel();
   loading.setLayout(null);
   loading.setBounds(36,26,600,345);
   loading.setIcon(new ImageIcon("loading.gif"));
   loading.setOpaque(true);
   frload.add(loading);

   JButton click = new JButton();
   click.setBounds(0,0,600,345);
   click.setBackground(Color.BLACK);
   click.setOpaque(false);
   click.setContentAreaFilled(false);
   click.setFocusable(false);
   click.setBorder(null);
   click.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));

   JPanel slot = new JPanel();
   slot.setBounds(668,406,308,268);
   slot.setBackground(Color.black);
   slot.setOpaque(false);
   frload.add(slot);

   JLabel inscard = new JLabel();
   inscard.setBounds(0,0,308,268);
   inscard.setBackground(Color.black);
   inscard.setIcon(new ImageIcon("insert.gif"));
   inscard.setOpaque(false);
   inscard.setVisible(true);
   slot.add(inscard);

// LOGIN OPTIONS ----------------------------------------------------------------------------------------------------//
   JFrame main = new JFrame (); 
   main.setSize(1000,720);
   main.setLocationRelativeTo(null);
   main.setResizable(false);
   main.setVisible(false);

   JLabel frame = new JLabel();
   frame.setLayout(null);
   frame.setBounds(0,0,1000,700);
   frame.setBackground(Color.white);
   frame.setIcon(new ImageIcon("mainframe.png"));
   main.add(frame);

   JLabel login = new JLabel();
   login.setLayout(null);
   login.setBounds(36,26,600,345);
   login.setIcon(new ImageIcon("login.png"));
   login.setOpaque(true);
   frame.add(login);

   JButton biometric = new JButton();
   biometric.setBounds(157,121,84,130);
   biometric.setContentAreaFilled(false);
   biometric.setBackground(Color.black);
   biometric.setOpaque(false);
   biometric.setBorder(null);
   login.add(biometric);

   JButton mpin = new JButton();
   mpin.setBounds(319,121,84,130);
   mpin.setContentAreaFilled(false);
   mpin.setBackground(Color.black);
   mpin.setOpaque(false);
   mpin.setBorder(null);
   login.add(mpin);

// IF PIN ----------------------------------------------------------------------------------------------------------//
   
   JFrame mainpin = new JFrame ();
   mainpin.setSize(1000,720);
   mainpin.setLocationRelativeTo(null);
   mainpin.setResizable(false);
   mainpin.setVisible(false);

   JLabel frpin = new JLabel();
   frpin.setLayout(null);
   frpin.setBounds(0,0,1000,700);
   frpin.setBackground(Color.white);
   frpin.setIcon(new ImageIcon("mainframe.png"));
   mainpin.add(frpin);

   JLabel pin = new JLabel();
   pin.setLayout(null);
   pin.setBounds(36,26,600,345);
   pin.setIcon(new ImageIcon("pin.png"));
   frpin.add(pin);

   JPasswordField epin = new JPasswordField();
   epin.setBounds(230,162,200,50);
   epin.setHorizontalAlignment(JPasswordField.CENTER);
   epin.setBackground(Color.white);
   epin.setOpaque(false);
   epin.setBorder(null);
   epin.setFont(new Font("Arial Bold", Font.BOLD,35));
   epin.addKeyListener(new KeyAdapter()
   {
       public void keyTyped(KeyEvent e)
       {
           if (epin.getText().length() >= 6)
           {
               e.consume();
           }
       }
   });
   pin.add(epin);


// END PIN -----------------------------------------------------------------------------------------------------------//





// CHOICES -----------------------------------------------------------------------------------------------------------//

   JFrame mainoption = new JFrame ();
   mainoption.setSize(1000,720);
   mainoption.setLocationRelativeTo(null);
   mainoption.setResizable(false);
   mainoption.setVisible(false); 

   JLabel froption = new JLabel();
   froption.setLayout(null);
   froption.setBounds(0,0,1000,700);
   froption.setBackground(Color.white);
   froption.setIcon(new ImageIcon("mainframe.png"));
   mainoption.add(froption);

   JLabel option = new JLabel();
   option.setLayout(null);
   option.setBounds(36,26,600,345);
   option.setIcon(new ImageIcon("choices.png"));
   froption.add(option);

   JButton convert = new JButton();
   convert.setBounds(55,175,90,90);
   convert.setContentAreaFilled(false);
   convert.setBackground(Color.black);
   convert.setOpaque(false);
   convert.setBorder(null);
   option.add(convert);

   JButton loan = new JButton();
   loan.setBounds(325,175,90,90);
   loan.setContentAreaFilled(false);
   loan.setBackground(Color.black);
   loan.setOpaque(false);
   loan.setBorder(null);
   option.add(loan);
   
   JButton bank = new JButton();
   bank.setBounds(191,175,90,90);
   bank.setContentAreaFilled(false);
   bank.setBackground(Color.black);
   bank.setOpaque(false);
   bank.setBorder(null);
   option.add(bank);

   JButton online = new JButton();
   online.setBounds(460,175,90,90);
   online.setContentAreaFilled(false);
   online.setBackground(Color.black);
   online.setOpaque(false);
   online.setBorder(null);
   option.add(online); 

// END CHOICES ----------------------------------------------------------------------------------------------//






// IF BIO ----------------------------------------------------------------------------------------------------------//

   JFrame mainbio = new JFrame("Scanning... Please wait...");
   mainbio.setSize(500,100);
   mainbio.setLocationRelativeTo(null);
   mainbio.setResizable(false);
   mainbio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   JProgressBar scan = new JProgressBar(0,100);
   scan.setValue(0);
   scan.setStringPainted(true);
   scan.setIndeterminate(true);
   mainbio.add(scan, "South");
   mainbio.setVisible(false);

// END BIO ----------------------------------------------------------------------------------------------------------//





// CURRENCY CONVERTER -----------------------------------------------------------------------------------------------//

   JFrame maincconv = new JFrame ();
   maincconv.setSize(1000,720);
   maincconv.setLocationRelativeTo(null);
   maincconv.setResizable(false);
   maincconv.setVisible(false);

   JLabel frcconv = new JLabel();
   frcconv.setLayout(null);
   frcconv.setBounds(0,0,1000,700);
   frcconv.setBackground(Color.white);
   frcconv.setIcon(new ImageIcon("mainframe.png"));
   maincconv.add(frcconv);

   JLabel cconv = new JLabel();
   cconv.setLayout(null);
   cconv.setBounds(36,26,600,345);
   cconv.setIcon(new ImageIcon("convert.png"));
   frcconv.add(cconv);

   JComboBox c1 = new JComboBox(currency);
   c1.setSelectedIndex(0);
   c1.setBounds(90,120,150,25);
   c1.setForeground(Color.white);
   c1.setBackground(Color.darkGray);
   c1.setOpaque(false);
   c1.setBorder(new EmptyBorder(0,0,0,0));
   c1.setFont(new Font("GT-HelveticaPPlot", Font.BOLD,15));
   cconv.add(c1);

   JTextField insert = new JTextField();
   insert.setBounds(91,163,143,50);
   insert.setHorizontalAlignment(JTextField.CENTER);
   insert.setBackground(Color.white);
   insert.setForeground(Color.white);
   insert.setOpaque(false);
   insert.setBorder(null);
   insert.setFont(new Font("Arial Bold", Font.BOLD,30));
   cconv.add(insert);

   JTextField peso = new JTextField();
   peso.setBounds(369,163,143,50);
   peso.setHorizontalAlignment(JTextField.CENTER);
   peso.setBackground(Color.white);
   peso.setForeground(Color.white);
   peso.setOpaque(false);
   peso.setEnabled(false);
   peso.setBorder(null);
   peso.setFont(new Font("Arial Bold", Font.BOLD,30));
   cconv.add(peso);

// LOAN ------------------------------------------------------------------------------------------------------------//
   JFrame mainborrow = new JFrame ();
   mainborrow.setSize(1000,720);
   mainborrow.setLocationRelativeTo(null);
   mainborrow.setResizable(false);
   mainborrow.setVisible(false);

   JLabel frborrow = new JLabel();
   frborrow.setLayout(null);
   frborrow.setBounds(0,0,1000,700);
   frborrow.setBackground(Color.white);
   frborrow.setIcon(new ImageIcon("mainframe.png"));
   mainborrow.add(frborrow);

   JLabel borrow = new JLabel();
   borrow.setLayout(null);
   borrow.setBounds(36,26,600,345);
   borrow.setIcon(new ImageIcon("loan.png"));
   frborrow.add(borrow);

   JPanel loanreceipt = new JPanel();
   loanreceipt.setLayout(null);
   loanreceipt.setBounds(692,10,265,382);
   loanreceipt.setBackground(Color.BLACK);
   loanreceipt.setVisible(false);
   loanreceipt.setOpaque(true);
   frborrow.add(loanreceipt);

   JLabel lreceipt = new JLabel();
   lreceipt.setBounds(0,0,265,382);
   lreceipt.setIcon(new ImageIcon("lreceipt.png"));
   loanreceipt.add(lreceipt);
   
   JTextField ltrans = new JTextField();
   ltrans.setBounds(140,160,100,18);
   ltrans.setFont(new Font("Courier New", Font.PLAIN, 10));
   ltrans.setBorder(null);
   ltrans.setOpaque(false);
   ltrans.setHorizontalAlignment(JTextField.RIGHT);
   lreceipt.add(ltrans);

   JTextField lamnt = new JTextField();
   lamnt.setBounds(140,175,100,18);
   lamnt.setFont(new Font("Courier New", Font.PLAIN, 10));
   lamnt.setBorder(null);
   lamnt.setOpaque(false);
   lamnt.setHorizontalAlignment(JTextField.RIGHT);
   lreceipt.add(lamnt);

   JTextField lbal = new JTextField();
   lbal.setBounds(140,209,100,18);
   lbal.setFont(new Font("Courier New", Font.PLAIN, 10));
   lbal.setBorder(null);
   lbal.setOpaque(false);
   lbal.setHorizontalAlignment(JTextField.RIGHT);
   lreceipt.add(lbal);

   JTextField LAmount = new JTextField();
   LAmount.setBounds(298,127,220,45);
   LAmount.setHorizontalAlignment(JTextField.CENTER);
   LAmount.setBackground(Color.white);
   LAmount.setOpaque(false);
   LAmount.setBorder(null);
   LAmount.setFont(new Font("Arial Bold", Font.BOLD,35));
   borrow.add(LAmount);

// TRANSACTION -----------------------------------------------------------------------------------------------------//

   JFrame mainbpin = new JFrame ();
   mainbpin.setSize(1000,720);
   mainbpin.setLocationRelativeTo(null);
   mainbpin.setResizable(false);
   mainbpin.setVisible(false);

   JLabel frbpin = new JLabel();
   frbpin.setLayout(null);
   frbpin.setBounds(0,0,1000,700);
   frbpin.setBackground(Color.white);
   frbpin.setIcon(new ImageIcon("mainframe.png"));
   mainbpin.add(frbpin);

   JLabel bpin = new JLabel();
   bpin.setLayout(null);
   bpin.setBounds(36,26,600,345);
   bpin.setIcon(new ImageIcon("pin.png"));
   frbpin.add(bpin);

   JPasswordField bepin = new JPasswordField();
   bepin.setBounds(230,162,200,50);
   bepin.setHorizontalAlignment(JPasswordField.CENTER);
   bepin.setBackground(Color.white);
   bepin.setOpaque(false);
   bepin.setBorder(null);
   bepin.setFont(new Font("Arial Bold", Font.BOLD,35));
   bepin.addKeyListener(new KeyAdapter()//user's input in JTextField is limited to 6 charactes only
   {
       public void keyTyped(KeyEvent e)
       {
           if (bepin.getText().length() >= 6)
           {
               e.consume();
           }
       }
   });
   bpin.add(bepin);

// BANK ------------------------------------------------------------------------------------------------------------//

   JFrame mainbasics = new JFrame ();
   mainbasics.setSize(1000,720);
   mainbasics.setLocationRelativeTo(null);
   mainbasics.setResizable(false);
   mainbasics.setVisible(false);

   JLabel frbasics = new JLabel();
   frbasics.setLayout(null);
   frbasics.setBounds(0,0,1000,700);
   frbasics.setBackground(Color.white);
   frbasics.setIcon(new ImageIcon("mainframe.png"));
   mainbasics.add(frbasics);

   JLabel basics = new JLabel();
   basics.setLayout(null);
   basics.setBounds(36,26,600,345);
   basics.setIcon(new ImageIcon("BANK.gif"));
   frbasics.add(basics);

   JPanel bankreceipt = new JPanel();
   bankreceipt.setLayout(null);
   bankreceipt.setBounds(692,10,265,382);
   bankreceipt.setBackground(Color.BLACK);
   bankreceipt.setVisible(false);
   bankreceipt.setOpaque(true);
   frbasics.add(bankreceipt);

   JLabel breceipt = new JLabel();
   breceipt.setBounds(0,0,265,382);
   breceipt.setIcon(new ImageIcon("receipt.png"));
   bankreceipt.add(breceipt);
   
   JTextField btrans = new JTextField();
   btrans.setBounds(140,160,100,18);
   btrans.setFont(new Font("Courier New", Font.PLAIN, 10));
   btrans.setBorder(null);
   btrans.setOpaque(false);
   btrans.setHorizontalAlignment(JTextField.RIGHT);
   breceipt.add(btrans);

   JTextField bamnt = new JTextField();
   bamnt.setBounds(140,175,100,18);
   bamnt.setFont(new Font("Courier New", Font.PLAIN, 10));
   bamnt.setBorder(null);
   bamnt.setOpaque(false);
   bamnt.setHorizontalAlignment(JTextField.RIGHT);
   breceipt.add(bamnt);

   JTextField bbal = new JTextField();
   bbal.setBounds(140,209,100,18);
   bbal.setFont(new Font("Courier New", Font.PLAIN, 10));
   bbal.setBorder(null);
   bbal.setOpaque(false);
   bbal.setHorizontalAlignment(JTextField.RIGHT);
   breceipt.add(bbal);

   JTextField BAmount = new JTextField();
   BAmount.setBounds(85,167,185,45);
   BAmount.setHorizontalAlignment(JTextField.CENTER);
   BAmount.setForeground(Color.white);
   BAmount.setBackground(Color.white);
   BAmount.setOpaque(false);
   BAmount.setBorder(null);
   BAmount.setFont(new Font("Arial Bold", Font.BOLD,35));
   basics.add(BAmount);

   JButton withdraw = new JButton();
   withdraw.setBounds(343,64,257,57);
   withdraw.setContentAreaFilled(false);
   withdraw.setBackground(Color.black);
   withdraw.setOpaque(false);
   withdraw.setBorder(null);
   
   JButton deposit = new JButton();
   deposit.setBounds(343,145,257,57);
   deposit.setContentAreaFilled(false);
   deposit.setBackground(Color.black);
   deposit.setOpaque(false);
   deposit.setBorder(null);
   

   JButton balance = new JButton();
   balance.setBounds(343,225,257,57);
   balance.setContentAreaFilled(false);
   balance.setBackground(Color.black);
   balance.setOpaque(false);
   balance.setBorder(null);
   balance.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e)
      {  
       
         int result = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "", JOptionPane.YES_NO_OPTION);
         BAmount.setText(null);
         if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,"Your current balance is: "+ bal);                                            
            BAmount.setText(null);
         } 
         else if (result == JOptionPane.NO_OPTION) {
            BAmount.setText(null);
         } 
    
      }
   });
   basics.add(balance);
   

// ONLINE PAYMENT --------------------------------------------------------------------------------------------------//

   JFrame mainbills = new JFrame ();
   mainbills.setSize(1000,720);
   mainbills.setLocationRelativeTo(null);
   mainbills.setResizable(false);
   mainbills.setVisible(false);

   JLabel frbills = new JLabel();
   frbills.setLayout(null);
   frbills.setBounds(0,0,1000,700);
   frbills.setBackground(Color.white);
   frbills.setIcon(new ImageIcon("mainframe.png"));
   mainbills.add(frbills);

   JLabel bills = new JLabel();
   bills.setLayout(null);
   bills.setBounds(36,26,600,345);
   bills.setIcon(new ImageIcon("online.png"));
   frbills.add(bills);

   JTextField OPAmount = new JTextField();
   OPAmount.setBounds(190,82,220,45);
   OPAmount.setHorizontalAlignment(JTextField.CENTER);
   OPAmount.setForeground(Color.white);
   OPAmount.setBackground(Color.white);
   OPAmount.setFocusable(false);
   OPAmount.setOpaque(false);
   OPAmount.setBorder(null);
   OPAmount.setFont(new Font("Arial Bold", Font.BOLD,35));
   bills.add(OPAmount);

   JTextField anam = new JTextField();
   anam.setBounds(290,189,200,43);
   anam.setHorizontalAlignment(JTextField.CENTER);
   anam.setBackground(Color.white);
   anam.setOpaque(false);
   anam.setBorder(null);
   anam.setFont(new Font("Arial Bold", Font.BOLD,30));
   bills.add(anam);

   JTextField anum = new JTextField();
   anum.setBounds(290,250,200,43);
   anum.setHorizontalAlignment(JTextField.CENTER);
   anum.setBackground(Color.white);
   anum.setOpaque(false);
   anum.setBorder(null);
   anum.setFont(new Font("Arial Bold", Font.BOLD,30));
   bills.add(anum);

   JPanel olreceipt = new JPanel();
   olreceipt.setLayout(null);
   olreceipt.setBounds(692,10,265,382);
   olreceipt.setBackground(Color.BLACK);
   olreceipt.setVisible(true);
   olreceipt.setOpaque(true);
   frbills.add(olreceipt);

   JLabel pmreceipt = new JLabel();
   pmreceipt.setBounds(0,0,265,382);
   pmreceipt.setIcon(new ImageIcon("opreceipt.png"));
   olreceipt.add(pmreceipt);

   JTextField opnam = new JTextField();
   opnam.setBounds(140,145,100,18);
   opnam.setFont(new Font("Courier New", Font.PLAIN, 10));
   opnam.setBorder(null);
   opnam.setFocusable(false);
   opnam.setOpaque(false);
   opnam.setHorizontalAlignment(JTextField.RIGHT);
   pmreceipt.add(opnam);
   
   JTextField optype = new JTextField();
   optype.setBounds(140,160,100,18);
   optype.setFont(new Font("Courier New", Font.PLAIN, 10));
   optype.setBorder(null);
   optype.setOpaque(false);
   optype.setFocusable(false);
   optype.setHorizontalAlignment(JTextField.RIGHT);
   pmreceipt.add(optype);

   JTextField opamnt = new JTextField();
   opamnt.setBounds(140,175,100,18);
   opamnt.setFont(new Font("Courier New", Font.PLAIN, 10));
   opamnt.setBorder(null);
   opamnt.setFocusable(false);
   opamnt.setOpaque(false);
   opamnt.setHorizontalAlignment(JTextField.RIGHT);
   pmreceipt.add(opamnt);

   JTextField opnum = new JTextField();
   opnum.setBounds(140,193,100,18);
   opnum.setFont(new Font("Courier New", Font.PLAIN, 10));
   opnum.setBorder(null);
   opnum.setOpaque(false);
   opnum.setFocusable(false);
   opnum.setHorizontalAlignment(JTextField.RIGHT);
   pmreceipt.add(opnum);

   JTextField opbal = new JTextField();
   opbal.setBounds(140,209,100,18);
   opbal.setFont(new Font("Courier New", Font.PLAIN, 10));
   opbal.setBorder(null);
   opbal.setFocusable(false);
   opbal.setOpaque(false);
   opbal.setHorizontalAlignment(JTextField.RIGHT);
   pmreceipt.add(opbal);

// END ONLINE PAYMENT -----------------------------------------------------------------------------------------------------------------------//





// BILLER -----------------------------------------------------------------------------------------------------------------------------------//

   JFrame mainbiller = new JFrame();
   mainbiller.setSize(1000,720);
   mainbiller.setLocationRelativeTo(null);
   mainbiller.setResizable(false);
   mainbiller.setVisible(false);

   JLabel frbiller = new JLabel();
   frbiller.setLayout(null);
   frbiller.setBounds(0,0,1000,700);
   frbiller.setBackground(Color.white);
   frbiller.setIcon(new ImageIcon("mainframe.png"));
   mainbiller.add(frbiller);

   JLabel biller = new JLabel();
   biller.setLayout(null);
   biller.setBounds(36,26,600,345);
   biller.setIcon(new ImageIcon("payment.gif"));
   frbiller.add(biller);

   JButton pldt = new JButton();
   pldt.setBounds(63,31,132,82);
   pldt.setContentAreaFilled(false);
   pldt.setBackground(Color.black);
   pldt.setOpaque(false);
   pldt.setBorder(null);
   pldt.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(pldt);

   JButton sky = new JButton();
   sky.setBounds(228,31,132,82);
   sky.setContentAreaFilled(false);
   sky.setBackground(Color.black);
   sky.setOpaque(false);
   sky.setBorder(null);
   sky.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(sky);

   JButton nationalu = new JButton();
   nationalu.setBounds(394,31,132,82);
   nationalu.setContentAreaFilled(false);
   nationalu.setBackground(Color.black);
   nationalu.setOpaque(false);
   nationalu.setBorder(null);
   nationalu.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(nationalu);

   JButton mwater = new JButton();
   mwater.setBounds(63,134,132,82);
   mwater.setContentAreaFilled(false);
   mwater.setBackground(Color.black);
   mwater.setOpaque(false);
   mwater.setBorder(null);
   mwater.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(mwater);

   JButton converge = new JButton();
   converge.setBounds(228,134,132,82);
   converge.setContentAreaFilled(false);
   converge.setBackground(Color.black);
   converge.setOpaque(false);
   converge.setBorder(null);
   converge.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(converge);

   JButton meralco = new JButton();
   meralco.setBounds(394,134,132,82);
   meralco.setContentAreaFilled(false);
   meralco.setBackground(Color.black);
   meralco.setOpaque(false);
   meralco.setBorder(null);
   meralco.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(meralco);

   JButton gcash = new JButton();
   gcash.setBounds(63,237,132,82);
   gcash.setContentAreaFilled(false);
   gcash.setBackground(Color.black);
   gcash.setOpaque(false);
   gcash.setBorder(null);
   gcash.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(gcash);

   JButton globe = new JButton();
   globe.setBounds(228,237,132,82);
   globe.setContentAreaFilled(false);
   globe.setBackground(Color.black);
   globe.setOpaque(false);
   globe.setBorder(null);
   globe.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(globe);

   JButton beep = new JButton();
   beep.setBounds(394,237,132,82);
   beep.setContentAreaFilled(false);
   beep.setBackground(Color.black);
   beep.setOpaque(false);
   beep.setBorder(null);
   beep.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         anum.setText(null);
         anam.setText(null);
         OPAmount.setText(null);
         mainbiller.dispose();
         mainbills.setVisible(true);
      }
   });
   biller.add(beep);

// END SCREEN -------------------------------------------------------------------------------------------------------//




// PIN KEY PAD  ----------------------------------------------------------------------------------------------------------//

   JButton pin1 = new JButton("1");
   pin1.setBounds(73,428,83,52);
   pin1.setBackground(Color.BLACK);
   pin1.setOpaque(false);
   pin1.setContentAreaFilled(false);
   pin1.setFocusable(false);
   pin1.setBorder(null);
   pin1.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin1.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
         String bt = ((JButton)e.getSource()).getText();
            String ct = epin.getText();
            epin.setText(ct + bt);
      }
   });
   frpin.add(pin1);

   JButton pin2 = new JButton("2");
   pin2.setBounds(182,428,83,52);
   pin2.setBackground(Color.BLACK);
   pin2.setOpaque(false);
   pin2.setContentAreaFilled(false);
   pin2.setFocusable(false);
   pin2.setBorder(null);
   pin2.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin2.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin2);

   JButton pin3 = new JButton("3");
   pin3.setBounds(292,428,83,52);
   pin3.setBackground(Color.BLACK);
   pin3.setOpaque(false);
   pin3.setContentAreaFilled(false);
   pin3.setFocusable(false);
   pin3.setBorder(null);
   pin3.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin3.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin3);

   JButton pin4 = new JButton("4");
   pin4.setBounds(73,486,83,52);
   pin4.setBackground(Color.BLACK);
   pin4.setOpaque(false);
   pin4.setContentAreaFilled(false);
   pin4.setFocusable(false);
   pin4.setBorder(null);
   pin4.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin4.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin4);

   JButton pin5 = new JButton("5");
   pin5.setBounds(182,486,83,52);
   pin5.setBackground(Color.BLACK);
   pin5.setOpaque(false);
   pin5.setContentAreaFilled(false);
   pin5.setFocusable(false);
   pin5.setBorder(null);
   pin5.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin5.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin5);

   JButton pin6 = new JButton("6");
   pin6.setBounds(292,486,83,52);
   pin6.setBackground(Color.BLACK);
   pin6.setOpaque(false);
   pin6.setContentAreaFilled(false);
   pin6.setFocusable(false);
   pin6.setBorder(null);
   pin6.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin6.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin6);

   JButton pin7 = new JButton("7");
   pin7.setBounds(73,544,83,52);
   pin7.setBackground(Color.BLACK);
   pin7.setOpaque(false);
   pin7.setContentAreaFilled(false);
   pin7.setFocusable(false);
   pin7.setBorder(null);
   pin7.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin7.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin7);

   JButton pin8 = new JButton("8");
   pin8.setBounds(182,544,83,52);
   pin8.setBackground(Color.BLACK);
   pin8.setOpaque(false);
   pin8.setContentAreaFilled(false);
   pin8.setFocusable(false);
   pin8.setBorder(null);
   pin8.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin8.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin8);

   JButton pin9 = new JButton("9");
   pin9.setBounds(292,544,83,52);
   pin9.setBackground(Color.BLACK);
   pin9.setOpaque(false);
   pin9.setContentAreaFilled(false);
   pin9.setFocusable(false);
   pin9.setBorder(null);
   pin9.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin9.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin9);

   JButton pin0 = new JButton("0");
   pin0.setBounds(182,602,83,52);
   pin0.setBackground(Color.BLACK);
   pin0.setOpaque(false);
   pin0.setContentAreaFilled(false);
   pin0.setFocusable(false);
   pin0.setBorder(null);
   pin0.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   pin0.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pin0);

   JButton pinbs = new JButton();
   pinbs.setBounds(73,602,83,52);
   pinbs.setBackground(Color.BLACK);
   pinbs.setOpaque(false);
   pinbs.setContentAreaFilled(false);
   pinbs.setFocusable(false);
   pinbs.setBorder(null);
   pinbs.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   pinbs.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
          String bt = ((JButton)e.getSource()).getText();
              String ct = epin.getText();
              epin.setText(ct + bt);
      }
   });
   frpin.add(pinbs);

   JButton pinok = new JButton();
   pinok.setBounds(292,602,83,52);
   pinok.setBackground(Color.BLACK);
   pinok.setOpaque(false);
   pinok.setContentAreaFilled(false);
   pinok.setFocusable(false);
   pinok.setBorder(null);
   pinok.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   frpin.add(pinok);
   
   JButton pinent = new JButton();
   pinent.setBounds(425,430,168,65);
   pinent.setBackground(Color.BLACK);
   pinent.setOpaque(false);
   pinent.setContentAreaFilled(false);
   pinent.setFocusable(false);
   pinent.setBorder(null);
   pinent.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   pinent.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         int correct = Integer.parseInt(epin.getText());

         if (attempt != 0) {
            if(correct != 123456){
               attempt--;
               JOptionPane.showMessageDialog(null, "Wrong input! "+attempt+" attempt/s left!"," Error",JOptionPane.ERROR_MESSAGE);
               epin.setText(null);

            }
            else{
               JOptionPane.showMessageDialog(null,"Happy banking!");
               attempt = 3;
               epin.setText(null);
               mainoption.setVisible(true);
               mainpin.dispose();
            }  
         }
         if (attempt == 0) {
            JOptionPane.showMessageDialog(null,"Login Failed!","Login unsucessful",JOptionPane.ERROR_MESSAGE);
            mainpin.dispose();
            mainload.setVisible(true);
            click.setEnabled(false);
         }
      }
   });
   frpin.add(pinent);

   JButton pinclr = new JButton();
   pinclr.setBounds(425,502,168,65);
   pinclr.setBackground(Color.BLACK);
   pinclr.setOpaque(false);
   pinclr.setContentAreaFilled(false);
   pinclr.setFocusable(false);
   pinclr.setBorder(null);
   pinclr.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   pinclr.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          epin.setText(null);
      }
   });
   frpin.add(pinclr);

   JButton pincan = new JButton();
   pincan.setBounds(425,572,168,65);
   pincan.setBackground(Color.BLACK);
   pincan.setOpaque(false);
   pincan.setContentAreaFilled(false);
   pincan.setFocusable(false);
   pincan.setBorder(null);
   pincan.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
   pincan.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         int cancel = JOptionPane.showConfirmDialog(null,"Sure? You want to cancel?", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (cancel == JOptionPane.YES_OPTION) 
         {
            mainload.setVisible(true);
            mainpin.dispose();
         }
         else if (cancel == JOptionPane.NO_OPTION) 
         {
             
         }
      }
   });
   frpin.add(pincan);

// END PIN KEY PAD ------------------------------------------------------------------------------------------------------//

   




// CONVERT KEY PAD -----------------------------------------------------------------------------------------------------------//

   JButton con1 = new JButton("1");
   con1.setBounds(73,428,83,52);
   con1.setBackground(Color.BLACK);
   con1.setOpaque(false);
   con1.setContentAreaFilled(false);
   con1.setFocusable(false);
   con1.setBorder(null);
   con1.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
   con1.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con1);

      JButton con2 = new JButton("2");
      con2.setBounds(182,428,83,52);
      con2.setBackground(Color.BLACK);
      con2.setOpaque(false);
      con2.setContentAreaFilled(false);
      con2.setFocusable(false);
      con2.setBorder(null);
      con2.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con2);

      JButton con3 = new JButton("3");
      con3.setBounds(292,428,83,52);
      con3.setBackground(Color.BLACK);
      con3.setOpaque(false);
      con3.setContentAreaFilled(false);
      con3.setFocusable(false);
      con3.setBorder(null);
      con3.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con3.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con3);

      JButton con4 = new JButton("4");
      con4.setBounds(73,486,83,52);
      con4.setBackground(Color.BLACK);
      con4.setOpaque(false);
      con4.setContentAreaFilled(false);
      con4.setFocusable(false);
      con4.setBorder(null);
      con4.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con4.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con4);

      JButton con5 = new JButton("5");
      con5.setBounds(182,486,83,52);
      con5.setBackground(Color.BLACK);
      con5.setOpaque(false);
      con5.setContentAreaFilled(false);
      con5.setFocusable(false);
      con5.setBorder(null);
      con5.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con5.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con5);

      JButton con6 = new JButton("6");
      con6.setBounds(292,486,83,52);
      con6.setBackground(Color.BLACK);
      con6.setOpaque(false);
      con6.setContentAreaFilled(false);
      con6.setFocusable(false);
      con6.setBorder(null);
      con6.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con6.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con6);

      JButton con7 = new JButton("7");
      con7.setBounds(73,544,83,52);
      con7.setBackground(Color.BLACK);
      con7.setOpaque(false);
      con7.setContentAreaFilled(false);
      con7.setFocusable(false);
      con7.setBorder(null);
      con7.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con7.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con7);

      JButton con8 = new JButton("8");
      con8.setBounds(182,544,83,52);
      con8.setBackground(Color.BLACK);
      con8.setOpaque(false);
      con8.setContentAreaFilled(false);
      con8.setFocusable(false);
      con8.setBorder(null);
      con8.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con8.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con8);

      JButton con9 = new JButton("9");
      con9.setBounds(292,544,83,52);
      con9.setBackground(Color.BLACK);
      con9.setOpaque(false);
      con9.setContentAreaFilled(false);
      con9.setFocusable(false);
      con9.setBorder(null);
      con9.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con9.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con9);

      JButton con0 = new JButton("0");
      con0.setBounds(182,602,83,52);
      con0.setBackground(Color.BLACK);
      con0.setOpaque(false);
      con0.setContentAreaFilled(false);
      con0.setFocusable(false);
      con0.setBorder(null);
      con0.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      con0.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = insert.getText();
               insert.setText(ct + bt);
         }
      });
      frcconv.add(con0);

      JButton conent = new JButton();
      conent.setBounds(425,430,168,65);
      conent.setBackground(Color.BLACK);
      conent.setOpaque(false);
      conent.setContentAreaFilled(false);
      conent.setFocusable(false);
      conent.setBorder(null);
      conent.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      conent.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Double a,b,c = 0.00;
            a = Double.valueOf(insert.getText());
            try{
            if (c1.getSelectedIndex()==0) {
               b = a*54.68; 
               c = (b*100)/100.0;}
            if (c1.getSelectedIndex()==1) {
               b = a*58.09; 
               c = (b*100)/100.0;}
            if (c1.getSelectedIndex()==2) {
               b = a*7.93; 
               c = (b*100)/100.0;} 
            if (c1.getSelectedIndex()==3) {
               b = a*66.30;
               c = (b*100)/100.0;} 
            if (c1.getSelectedIndex()==4) {
               b = a*0.41;
               c = (b*100)/100.0; }
            if (c1.getSelectedIndex()==5) {
               b = a*0.042;
               c = (b*100)/100.0; }
            if (c1.getSelectedIndex()==6) {
               b = a*0.66; 
               c = (b*100)/100.0;}
            if (c1.getSelectedIndex()==7) {
               b = a*39.88; 
               c = (b*100)/100.0; }
            if (c1.getSelectedIndex()==8) {
               b = a*1.59;
               c = (b*100)/100.0; }
            if (c1.getSelectedIndex()==9) {
               b = a*14.89; 
               c = (b*100)/100.0;}
            peso.setText(String.valueOf(c));
        }catch(Exception x){System.out.println("");}
         }
      });
      frcconv.add(conent);

      JButton conclr = new JButton();
      conclr.setBounds(425,502,168,65);
      conclr.setBackground(Color.BLACK);
      conclr.setOpaque(false);
      conclr.setContentAreaFilled(false);
      conclr.setFocusable(false);
      conclr.setBorder(null);
      conclr.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      conclr.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            insert.setText(null);
            peso.setText(null);
         }
      });
      frcconv.add(conclr);

      JButton concan = new JButton();
      concan.setBounds(425,572,168,65);
      concan.setBackground(Color.BLACK);
      concan.setOpaque(false);
      concan.setContentAreaFilled(false);
      concan.setFocusable(false);
      concan.setBorder(null);
      concan.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      concan.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int cancel = JOptionPane.showConfirmDialog(null,"Sure? You want to cancel?", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cancel == JOptionPane.YES_OPTION) 
            {
               mainoption.setVisible(true);
               maincconv.dispose();
            }
            else if (cancel == JOptionPane.NO_OPTION) 
            {
                  
            }
         }
      });
      frcconv.add(concan);

// END CONVERT KEY PAD ------------------------------------------------------------------------------------------------//





// LOAN KEY PAD ------------------------------------------------------------------------------------------------------//

      JButton bor1 = new JButton("1");
      bor1.setBounds(73,428,83,52);
      bor1.setBackground(Color.BLACK);
      bor1.setOpaque(false);
      bor1.setContentAreaFilled(false);
      bor1.setFocusable(false);
      bor1.setBorder(null);
      bor1.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor1.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor1);

      JButton bor2 = new JButton("2");
      bor2.setBounds(182,428,83,52);
      bor2.setBackground(Color.BLACK);
      bor2.setOpaque(false);
      bor2.setContentAreaFilled(false);
      bor2.setFocusable(false);
      bor2.setBorder(null);
      bor2.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor2);

      JButton bor3 = new JButton("3");
      bor3.setBounds(292,428,83,52);
      bor3.setBackground(Color.BLACK);
      bor3.setOpaque(false);
      bor3.setContentAreaFilled(false);
      bor3.setFocusable(false);
      bor3.setBorder(null);
      bor3.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor3.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor3);

      JButton bor4 = new JButton("4");
      bor4.setBounds(73,486,83,52);
      bor4.setBackground(Color.BLACK);
      bor4.setOpaque(false);
      bor4.setContentAreaFilled(false);
      bor4.setFocusable(false);
      bor4.setBorder(null);
      bor4.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor4.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor4);

      JButton bor5 = new JButton("5");
      bor5.setBounds(182,486,83,52);
      bor5.setBackground(Color.BLACK);
      bor5.setOpaque(false);
      bor5.setContentAreaFilled(false);
      bor5.setFocusable(false);
      bor5.setBorder(null);
      bor5.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor5.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor5);

      JButton bor6 = new JButton("6");
      bor6.setBounds(292,486,83,52);
      bor6.setBackground(Color.BLACK);
      bor6.setOpaque(false);
      bor6.setContentAreaFilled(false);
      bor6.setFocusable(false);
      bor6.setBorder(null);
      bor6.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor6.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor6);

      JButton bor7 = new JButton("7");
      bor7.setBounds(73,544,83,52);
      bor7.setBackground(Color.BLACK);
      bor7.setOpaque(false);
      bor7.setContentAreaFilled(false);
      bor7.setFocusable(false);
      bor7.setBorder(null);
      bor7.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor7.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor7);

      JButton bor8 = new JButton("8");
      bor8.setBounds(182,544,83,52);
      bor8.setBackground(Color.BLACK);
      bor8.setOpaque(false);
      bor8.setContentAreaFilled(false);
      bor8.setFocusable(false);
      bor8.setBorder(null);
      bor8.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor8.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor8);

      JButton bor9 = new JButton("9");
      bor9.setBounds(292,544,83,52);
      bor9.setBackground(Color.BLACK);
      bor9.setOpaque(false);
      bor9.setContentAreaFilled(false);
      bor9.setFocusable(false);
      bor9.setBorder(null);
      bor9.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor9.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor9);

      JButton bor0 = new JButton("0");
      bor0.setBounds(182,602,83,52);
      bor0.setBackground(Color.BLACK);
      bor0.setOpaque(false);
      bor0.setContentAreaFilled(false);
      bor0.setFocusable(false);
      bor0.setBorder(null);
      bor0.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bor0.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = LAmount.getText();
               LAmount.setText(ct + bt);
         }
      });
      frborrow.add(bor0);

      JButton borok = new JButton("OK");
      borok.setForeground(Color.BLUE);
      borok.setBounds(292,602,83,52);
      borok.setBackground(Color.BLACK);
      borok.setOpaque(false);
      borok.setEnabled(true);
      borok.setBorder(null);
      borok.setFocusable(false);
      borok.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      borok.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            mainborrow.dispose();
            mainpin.setVisible(true);
         }
      });
      frborrow.add(borok);

      JButton bordec= new JButton(".");
      bordec.setContentAreaFilled(false);
      bordec.setBounds(73,602,83,52);
      bordec.setBackground(Color.BLACK);
      bordec.setOpaque(false);
      bordec.setBorder(null);
      bordec.setFocusable(false);
      bordec.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bordec.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String bt = ((JButton)e.getSource()).getText();
            String ct = OPAmount.getText();
            OPAmount.setText(ct + bt);
         }
      });
      frborrow.add(bordec);
   
      JButton borent = new JButton();
      borent.setBounds(425,430,168,65);
      borent.setBackground(Color.BLACK);
      borent.setOpaque(true);
      borent.setContentAreaFilled(false);
      borent.setFocusable(false);
      borent.setBorder(null);
      borent.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
    

      JButton borcan = new JButton();
      borcan.setBounds(425,572,168,65);
      borcan.setBackground(Color.BLACK);
      borcan.setOpaque(false);
      borcan.setContentAreaFilled(false);
      borcan.setFocusable(false);
      borcan.setBorder(null);
      borcan.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      borcan.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int cancel = JOptionPane.showConfirmDialog(null,"Sure? You want to cancel?", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cancel == JOptionPane.YES_OPTION) 
            {
               mainoption.setVisible(true);
               mainborrow.dispose();
               loanreceipt.setVisible(false);
               lamnt.setText(null);
               ltrans.setText(null);
               lbal.setText(null);
            }
            else if (cancel == JOptionPane.NO_OPTION) 
            {
                  
            }
         }
      });
      frborrow.add(borcan);
      
      JButton borclr = new JButton();
      borclr.setBounds(425,502,168,65);
      borclr.setBackground(Color.BLACK);
      borclr.setOpaque(false);
      borclr.setContentAreaFilled(false);
      borclr.setFocusable(false);
      borclr.setBorder(null);
      borclr.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      borclr.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            LAmount.setText(null);
         }
      });
      frborrow.add(borclr);

// END LOAN KEY PAD --------------------------------------------------------------------------------------------------//





// BANK KEY PAD ------------------------------------------------------------------------------------------------------//

      JButton bas1 = new JButton("1");
      bas1.setBounds(73,428,83,52);
      bas1.setBackground(Color.BLACK);
      bas1.setOpaque(false);
      bas1.setContentAreaFilled(false);
      bas1.setFocusable(false);
      bas1.setBorder(null);
      bas1.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               String bt = ((JButton)e.getSource()).getText();
                  String ct = BAmount.getText();
                  BAmount.setText(ct + bt);
            }
         });
      frbasics.add(bas1);

      JButton bas2 = new JButton("2");
      bas2.setBounds(182,428,83,52);
      bas2.setBackground(Color.BLACK);
      bas2.setOpaque(false);
      bas2.setContentAreaFilled(false);
      bas2.setFocusable(false);
      bas2.setBorder(null);
      bas2.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
            }
         });
      frbasics.add(bas2);

      JButton bas3 = new JButton("3");
      bas3.setBounds(292,428,83,52);
      bas3.setBackground(Color.BLACK);
      bas3.setOpaque(false);
      bas3.setContentAreaFilled(false);
      bas3.setFocusable(false);
      bas3.setBorder(null);
      bas3.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas3.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
         }
      });
      frbasics.add(bas3);

      JButton bas4 = new JButton("4");
      bas4.setBounds(73,486,83,52);
      bas4.setBackground(Color.BLACK);
      bas4.setOpaque(false);
      bas4.setContentAreaFilled(false);
      bas4.setFocusable(false);
      bas4.setBorder(null);
      bas4.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas4.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
         }
      });
      frbasics.add(bas4);

      JButton bas5 = new JButton("5");
      bas5.setBounds(182,486,83,52);
      bas5.setBackground(Color.BLACK);
      bas5.setOpaque(false);
      bas5.setContentAreaFilled(false);
      bas5.setFocusable(false);
      bas5.setBorder(null);
      bas5.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas5.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
         }
      });
      frbasics.add(bas5);

      JButton bas6 = new JButton("6");
      bas6.setBounds(292,486,83,52);
      bas6.setBackground(Color.BLACK);
      bas6.setOpaque(false);
      bas6.setContentAreaFilled(false);
      bas6.setFocusable(false);
      bas6.setBorder(null);
      bas6.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas6.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
         }
      });
      frbasics.add(bas6);

      JButton bas7 = new JButton("7");
      bas7.setBounds(73,544,83,52);
      bas7.setBackground(Color.BLACK);
      bas7.setOpaque(false);
      bas7.setContentAreaFilled(false);
      bas7.setFocusable(false);
      bas7.setBorder(null);
      bas7.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas7.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
         }
      });
      frbasics.add(bas7);

      JButton bas8 = new JButton("8");
      bas8.setBounds(182,544,83,52);
      bas8.setBackground(Color.BLACK);
      bas8.setOpaque(false);
      bas8.setContentAreaFilled(false);
      bas8.setFocusable(false);
      bas8.setBorder(null);
      bas8.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas8.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
         }
      });
      frbasics.add(bas8);

      JButton bas9 = new JButton("9");
      bas9.setBounds(292,544,83,52);
      bas9.setBackground(Color.BLACK);
      bas9.setOpaque(false);
      bas9.setContentAreaFilled(false);
      bas9.setFocusable(false);
      bas9.setBorder(null);
      bas9.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas9.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
         }
      });
      frbasics.add(bas9);

      JButton bas0 = new JButton("0");
      bas0.setBounds(182,602,83,52);
      bas0.setBackground(Color.BLACK);
      bas0.setOpaque(false);
      bas0.setContentAreaFilled(false);
      bas0.setFocusable(false);
      bas0.setBorder(null);
      bas0.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bas0.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = BAmount.getText();
               BAmount.setText(ct + bt);
         }
      });
      frbasics.add(bas0);

      JButton basok = new JButton("OK");
      basok.setForeground(Color.BLUE);
      basok.setBounds(292,602,83,52);
      basok.setBackground(Color.BLACK);
      basok.setOpaque(false);
      basok.setEnabled(true);
      basok.setBorder(null);
      basok.setFocusable(false);
      basok.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      basok.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            mainbasics.dispose();
            mainload.setVisible(true);
         }
      });
      frbasics.add(basok);

      JButton basclr = new JButton();
      basclr.setBounds(425,502,168,65);
      basclr.setBackground(Color.BLACK);
      basclr.setOpaque(false);
      basclr.setContentAreaFilled(false);
      basclr.setFocusable(false);
      basclr.setBorder(null);
      basclr.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      basclr.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            BAmount.setText(null);
         }
      });
      frbasics.add(basclr);
      
      JButton bascan = new JButton();
      bascan.setBounds(425,572,168,65);
      bascan.setBackground(Color.BLACK);
      bascan.setOpaque(false);
      bascan.setContentAreaFilled(false);
      bascan.setFocusable(false);
      bascan.setBorder(null);
      bascan.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      bascan.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int cancel = JOptionPane.showConfirmDialog(null,"Sure? You want to cancel?", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cancel == JOptionPane.YES_OPTION) 
            {
               mainoption.setVisible(true);
               mainbasics.dispose();
            }
            else if (cancel == JOptionPane.NO_OPTION) 
            {
                  
            }
         }
      });
      frbasics.add(bascan);

// END BANK KEY PAD --------------------------------------------------------------------------------------------------//





// ONLINE PAYMENT KEY PAD -----------------------------------------------------------------------------------------------//

      JButton bil1 = new JButton("1");
      bil1.setBounds(73,428,83,52);
      bil1.setBackground(Color.BLACK);
      bil1.setOpaque(false);
      bil1.setContentAreaFilled(false);
      bil1.setFocusable(false);
      bil1.setBorder(null);
      bil1.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil1.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil1);

      JButton bil2 = new JButton("2");
      bil2.setBounds(182,428,83,52);
      bil2.setBackground(Color.BLACK);
      bil2.setOpaque(false);
      bil2.setContentAreaFilled(false);
      bil2.setFocusable(false);
      bil2.setBorder(null);
      bil2.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil2);

      JButton bil3 = new JButton("3");
      bil3.setBounds(292,428,83,52);
      bil3.setBackground(Color.BLACK);
      bil3.setOpaque(false);
      bil3.setContentAreaFilled(false);
      bil3.setFocusable(false);
      bil3.setBorder(null);
      bil3.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil3.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil3);

      JButton bil4 = new JButton("4");
      bil4.setBounds(73,486,83,52);
      bil4.setBackground(Color.BLACK);
      bil4.setOpaque(false);
      bil4.setContentAreaFilled(false);
      bil4.setFocusable(false);
      bil4.setBorder(null);
      bil4.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil4.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil4);

      JButton bil5 = new JButton("5");
      bil5.setBounds(182,486,83,52);
      bil5.setBackground(Color.BLACK);
      bil5.setOpaque(false);
      bil5.setContentAreaFilled(false);
      bil5.setFocusable(false);
      bil5.setBorder(null);
      bil5.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil5.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil5);

      JButton bil6 = new JButton("6");
      bil6.setBounds(292,486,83,52);
      bil6.setBackground(Color.BLACK);
      bil6.setOpaque(false);
      bil6.setContentAreaFilled(false);
      bil6.setFocusable(false);
      bil6.setBorder(null);
      bil6.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil6.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil6);

      JButton bil7 = new JButton("7");
      bil7.setBounds(73,544,83,52);
      bil7.setBackground(Color.BLACK);
      bil7.setOpaque(false);
      bil7.setContentAreaFilled(false);
      bil7.setFocusable(false);
      bil7.setBorder(null);
      bil7.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil7.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil7);

      JButton bil8 = new JButton("8");
      bil8.setBounds(182,544,83,52);
      bil8.setBackground(Color.BLACK);
      bil8.setOpaque(false);
      bil8.setContentAreaFilled(false);
      bil8.setFocusable(false);
      bil8.setBorder(null);
      bil8.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil8.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil8);

      JButton bil9 = new JButton("9");
      bil9.setBounds(292,544,83,52);
      bil9.setBackground(Color.BLACK);
      bil9.setOpaque(false);
      bil9.setContentAreaFilled(false);
      bil9.setFocusable(false);
      bil9.setBorder(null);
      bil9.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil9.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil9);

      JButton bil0 = new JButton("0");
      bil0.setBounds(182,602,83,52);
      bil0.setBackground(Color.BLACK);
      bil0.setOpaque(false);
      bil0.setContentAreaFilled(false);
      bil0.setFocusable(false);
      bil0.setBorder(null);
      bil0.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bil0.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            String bt = ((JButton)e.getSource()).getText();
               String ct = OPAmount.getText();
               OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bil0);

      JButton bildec= new JButton(".");
      bildec.setContentAreaFilled(false);
      bildec.setBounds(73,602,83,52);
      bildec.setBackground(Color.BLACK);
      bildec.setOpaque(false);
      bildec.setBorder(null);
      bildec.setFocusable(false);
      bildec.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bildec.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String bt = ((JButton)e.getSource()).getText();
            String ct = OPAmount.getText();
            OPAmount.setText(ct + bt);
         }
      });
      frbills.add(bildec);

      JButton bilok = new JButton("OK");
      bilok.setForeground(Color.BLUE);
      bilok.setBounds(292,602,83,52);
      bilok.setBackground(Color.BLACK);
      bilok.setOpaque(false);
      bilok.setEnabled(true);
      bilok.setBorder(null);
      bilok.setFocusable(false);
      bilok.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));
      bilok.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            mainbills.dispose();
            mainpin.setVisible(true);
         }
      });
      frbills.add(bilok);

      JButton bilclr = new JButton();
      bilclr.setBounds(425,502,168,65);
      bilclr.setBackground(Color.BLACK);
      bilclr.setOpaque(false);
      bilclr.setContentAreaFilled(false);
      bilclr.setFocusable(false);
      bilclr.setBorder(null);
      bilclr.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      bilclr.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         OPAmount.setText(null);
         anum.setText(null);
         anam.setText(null);
      }
   });
   frbills.add(bilclr);

      JButton bilent = new JButton();
      bilent.setBounds(425,430,168,65);
      bilent.setBackground(Color.BLACK);
      bilent.setOpaque(true);
      bilent.setContentAreaFilled(false);
      bilent.setFocusable(false);
      bilent.setBorder(null);
      bilent.setFont(new Font("ARIAL BOLD",Font.BOLD, 0));

      JButton bircan = new JButton();
      bircan.setBounds(425,572,168,65);
      bircan.setBackground(Color.BLACK);
      bircan.setOpaque(false);
      bircan.setContentAreaFilled(false);
      bircan.setFocusable(false);
      bircan.setBorder(null);
      bircan.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      bircan.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int cancel = JOptionPane.showConfirmDialog(null,"Sure? You want to cancel?", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cancel == JOptionPane.YES_OPTION) 
            {
               mainoption.setVisible(true);
               mainbiller.dispose();
            }
            else if (cancel == JOptionPane.NO_OPTION) 
            {
               
            }
         }
      });
      frbiller.add(bircan);

      JButton bilcan = new JButton();
      bilcan.setBounds(425,572,168,65);
      bilcan.setBackground(Color.BLACK);
      bilcan.setOpaque(false);
      bilcan.setContentAreaFilled(false);
      bilcan.setFocusable(false);
      bilcan.setBorder(null);
      bilcan.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      bilcan.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int cancel = JOptionPane.showConfirmDialog(null,"Sure? You want to cancel?", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cancel == JOptionPane.YES_OPTION) 
            {
               mainoption.setVisible(true);
               mainbasics.dispose();
            }
            else if (cancel == JOptionPane.NO_OPTION) 
            {
               
            }
         }
      });
      frbills.add(bilcan);

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

      JButton bpinent = new JButton();//bank enter button
      bpinent.setBounds(425,430,168,65);
      bpinent.setBackground(Color.BLACK);
      bpinent.setOpaque(false);
      bpinent.setContentAreaFilled(false);
      bpinent.setFocusable(false);
      bpinent.setVisible(false);
      bpinent.setBorder(null);
      bpinent.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      bpinent.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int correct = Integer.parseInt(bepin.getText());
            if (correct != 123456) {
               JOptionPane.showMessageDialog(null,"Access denied!");
               mainbasics.dispose();
               mainbpin.dispose();
               mainload.setVisible(true);
               click.setEnabled(false);
            } else {
               anum.setText(null);
               anam.setText(null);
               OPAmount.setText(null);
               mainbpin.dispose();
               mainbasics.setVisible(true);
            }
         }
      });
      frbpin.add(bpinent);

      JButton bpinent1 = new JButton();//loan enter button
      bpinent1.setBounds(425,430,168,65);
      bpinent1.setBackground(Color.BLACK);
      bpinent1.setOpaque(false);
      bpinent1.setContentAreaFilled(false);
      bpinent1.setFocusable(false);
      bpinent1.setVisible(false);
      bpinent1.setBorder(null);
      bpinent1.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      bpinent1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int correct = Integer.parseInt(bepin.getText());
            if (correct != 123456) {
               JOptionPane.showMessageDialog(null,"Access denied!");
               mainbills.dispose();
               mainbpin.dispose();
               mainload.setVisible(true);
               click.setEnabled(false);
            } else {
               anum.setText(null);
               anam.setText(null);
               OPAmount.setText(null);
               mainbpin.dispose();
               mainbills.setVisible(true);
            }
         }
      });
      frbpin.add(bpinent1);

      JButton bpinent2 = new JButton();//online payment enter button
      bpinent2.setBounds(425,430,168,65);
      bpinent2.setBackground(Color.BLACK);
      bpinent2.setOpaque(false);
      bpinent2.setContentAreaFilled(false);
      bpinent2.setFocusable(false);
      bpinent2.setVisible(false);
      bpinent2.setBorder(null);
      bpinent2.setFont(new Font("ARIAL BOLD",Font.BOLD, 17));
      bpinent2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int correct = Integer.parseInt(bepin.getText());
            if (correct != 123456) {
               JOptionPane.showMessageDialog(null,"Access denied!");
               mainborrow.dispose();
               mainbpin.dispose();
               mainload.setVisible(true);
               click.setEnabled(false);
            } else {
               JOptionPane.showMessageDialog(null, "Loan is accepted.");
               anum.setText(null);
               anam.setText(null);
               OPAmount.setText(null);
               mainbpin.dispose();
               mainborrow.setVisible(true);

            }
         }
      });
      frbpin.add(bpinent2);

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
// SCREEN FUNCTIONS -------------------------------------------------------------------------------------------------//

   ActionListener bmpin  = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         mainpin.setVisible(true);
         mainload.dispose();
         main.dispose();
         new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                     Thread.sleep(5000);
                  } catch (InterruptedException ex) {
                     ex.printStackTrace();
                  }
               scan.setIndeterminate(false);
               scan.setString("Done!");
               mainbio.dispose();
            }
         }).stop();
      }
   };
   mpin.addActionListener(bmpin);
   login.add(mpin);

   ActionListener bconv = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         mainoption.dispose();
         maincconv.setVisible(true);
         insert.setText(null);
         peso.setText(null);
      }
   };
   convert.addActionListener(bconv);
   option.add(convert);

   ActionListener bbor = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         mainoption.dispose();
         mainborrow.setVisible(true);
         LAmount.setText(null);
      }
   };
   loan.addActionListener(bbor);
   option.add(loan);

   ActionListener bbas = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         mainoption.dispose();
         mainbasics.setVisible(true);
         BAmount.setText(null);
      }
   };
   bank.addActionListener(bbas);
   option.add(bank);

   withdraw.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e)
      {
         double amount = Double.parseDouble(BAmount.getText());
         int result = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "", JOptionPane.YES_NO_OPTION);
         BAmount.setText(null);
         if (result == JOptionPane.YES_OPTION) {
            mainbpin.setVisible(true);
            mainbasics.setVisible(false);
            bpinent.setVisible(true);
            main.dispose();
               if (amount % 50 == 0) {
                  if (bal >= amount) {
                     bal -= amount;
                     bepin.setText(null);
                     btrans.setText("WITHDRAW");
                     bankreceipt.setVisible(true);
                     String amt = Double.toString(amount);
                     bamnt.setText(amt);
                     bbal.setText("₱ "+(bal*100)/100);
                  } 
                  else {
                     JOptionPane.showMessageDialog(null,"Insufficient funds");
                  }
               }
               else {
                  bepin.setText(null);
                  mainbpin.setVisible(false);
                  BAmount.setText(null);
                  mainbasics.setVisible(true);
                  JOptionPane.showMessageDialog(null, "Invalid Amount");
               }   
         } 
         else if (result == JOptionPane.NO_OPTION) {

         } 
      }
   });
   basics.add(withdraw);

   deposit.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e)
      {
         double amount = Double.parseDouble(BAmount.getText());
         int result = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
            mainbpin.setVisible(true);
            mainbasics.setVisible(false);
            bpinent.setVisible(true);
            if (amount % 50 == 0) {
               bal += amount;
               bepin.setText(null);
               BAmount.setText(null);
               bankreceipt.setVisible(true);
               btrans.setText("DEPOSIT");
               String amt = Double.toString(amount);
               bamnt.setText(amt);
               bbal.setText("₱ "+(bal*100)/100);
            }
            else {
               BAmount.setText(null);
               bepin.setText(null);
               mainbpin.setVisible(false);
               mainbasics.setVisible(true);
               JOptionPane.showMessageDialog(null, "Invalid Amount");
            }
         }
         else if (result == JOptionPane.NO_OPTION) {

         }
      }
   });
   basics.add(deposit);

   borent.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) 
      {
         double amount = Double.parseDouble(LAmount.getText());
         int result = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
            mainbpin.setVisible(true);
            mainborrow.setVisible(false);
            bpinent2.setVisible(true);
            bepin.setText(null);

               if (amount <= 5000) {
                  while (maxvalue > 0) {
                     bepin.setText(null);
                     LAmount.setText(null);
                     loanreceipt.setVisible(true);
                     ltrans.setText("LOAN");
                     String amt = Double.toString(amount);
                     lamnt.setText(amt);
                     lbal.setText("₱ "+(bal*100)/100);
                     if (amount > maxvalue) {
                        mainbpin.setVisible(false);
                        mainborrow.setVisible(true);
                        JOptionPane.showMessageDialog(null, "You've reached 5000!");
                        break;
                     }
                     else {
                        value += amount;
                        bal += amount;
                        maxvalue -= amount;
                        lbal.setText("₱ "+(bal*100)/100);


                     }
                     break;
                  }
               }
               else {
                  LAmount.setText(null);
                  bepin.setText(null);
                  mainbpin.setVisible(false);
                  mainborrow.setVisible(true);
                  JOptionPane.showMessageDialog(null, "Invalid Amount");
               }
         }
         else if (result == JOptionPane.NO_OPTION) {
          

         }
      }
   });
   frborrow.add(borent);

   bilent.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         double amount = Double.parseDouble(OPAmount.getText());
         int number = Integer.parseInt(anum.getText());
         int result = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.YES_OPTION) {
            mainbpin.setVisible(true);
            mainbills.setVisible(false);
            bpinent1.setVisible(true);
            if (bal >= amount) {
               bal -= amount;
               bepin.setText(null);
               opnam.setText(anam.getText());
               optype.setText("BILLS");
               olreceipt.setVisible(true);
               String amt = Double.toString(amount);
               opamnt.setText("₱ "+amt);
               String num = Integer.toString(number);
               opnum.setText(num);
               opbal.setText("₱ "+(bal*100)/100);
            } 
         }
         else if (result == JOptionPane.NO_OPTION) {
            bepin.setText(null);
            anum.setText(null);
            anam.setText(null);
            OPAmount.setText(null);

         }
         }  
   });
   frbills.add(bilent);

   ActionListener bbil = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         mainoption.dispose();
         mainbiller.setVisible(true);
      }
   };
   online.addActionListener(bbil);
   option.add(online);

   ActionListener bbio = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mainload.setVisible(false);
        mainbio.setVisible(true);
        main.dispose();
        new Thread(new Runnable() {
         @Override
         public void run() {
            try {
                  Thread.sleep(5000);
               } catch (InterruptedException ex) {
                  ex.printStackTrace();
               }
            scan.setIndeterminate(false);
            scan.setString("Done!");
            mainbio.dispose();
            mainoption.setVisible(true);
         }
      }).start();
      }
   };
   biometric.addActionListener(bbio);
   login.add(biometric);
   
   click.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          mainload.dispose();
          main.setVisible(true);
      }
   });
   frload.add(click);



// RECEIPT ----------------------------------------------------------------------------------------------------------//

    

    mainload.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainload.setVisible(true);
   } 
}
