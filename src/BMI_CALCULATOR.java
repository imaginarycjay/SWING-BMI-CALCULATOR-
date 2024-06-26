import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

public class BMI_CALCULATOR extends JFrame implements ActionListener, KeyListener {

   JLabel equalSign, heightLabel, weightLabel;
   JTextField result, height, weight;
   JButton calculate, clear;
   DecimalFormat df;

   BMI_CALCULATOR(){
      df = new DecimalFormat("#.##");
      setLayout(null);

      result = new JTextField();
      result.setBounds(30, 50, 268, 60);
      result.setEditable(false);
      result.setFocusable(false);
      result.setBorder(new LineBorder(Color.white, 0, true));
      result.setBackground(new Color(50, 50, 50));
      result.setForeground(Color.white);
      result.setFont(new Font("Arial", Font.BOLD, 24));
      result.setHorizontalAlignment(JTextField.CENTER);
      this.add(result);

      equalSign = new JLabel("=");
      equalSign.setFont(new Font("Arial", Font.PLAIN, 42));
      equalSign.setBounds(150,100, 100, 100);
      equalSign.setForeground(Color.white);
      this.add(equalSign);

      height = new JTextField();
      height.setBounds(87, 203, 150, 30);
      height.setBorder(new LineBorder(Color.white, 0, true));
      height.setBackground(new Color(50, 50, 50));
      height.setForeground(Color.white);
      height.setFont(new Font("Arial", Font.BOLD, 16));
      height.setHorizontalAlignment(JTextField.CENTER);
      height.addKeyListener(this);
      this.add(height);

      heightLabel = new JLabel("Enter height in CM");
      heightLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 12));
      heightLabel.setBounds(112,200, 500, 100);
      heightLabel.setForeground(Color.white);
      this.add(heightLabel);

      weight = new JTextField();
      weight.setBounds(87, 273, 150, 30);
      weight.setBorder(new LineBorder(Color.white, 0, true));
      weight.setBackground(new Color(50, 50, 50));
      weight.setForeground(Color.white);
      weight.setFont(new Font("Arial", Font.BOLD, 16));
      weight.setHorizontalAlignment(JTextField.CENTER);
      weight.addKeyListener(this);
      this.add(weight);

      weightLabel = new JLabel("Enter weight in KG");
      weightLabel.setFont(new Font("Arial", Font.PLAIN, 12));
      weightLabel.setBounds(112,270, 500, 100);
      weightLabel.setForeground(Color.white);
      this.add(weightLabel);

      calculate = new JButton("Calculate");
      calculate.setFont(new Font("Arial", Font.PLAIN, 10));
      calculate.setBounds(70, 350, 80, 20);
      calculate.setBackground(new Color(71, 177, 232));
      calculate.setBorder(new LineBorder(Color.white, 0, true));
      calculate.addActionListener(this);
      this.add(calculate);

      clear = new JButton("Clear");
      clear.setFont(new Font("Arial", Font.PLAIN, 10));
      clear.setBounds(175, 350, 80, 20);
      clear.setBackground(new Color(71, 177, 232));
      clear.setBorder(new LineBorder(Color.white, 0, true));
      clear.addActionListener(this);
      this.add(clear);


      this.setTitle("BMI Calculator v1");
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setVisible(true);
      this.setSize(345, 500);
      this.setResizable(false);
      this.getContentPane().setBackground(new Color(34, 33, 38));
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == calculate) {
         calculateBMI();
      } else if (e.getSource() == clear) {
         clearBMI();
      }
   }

   @Override
   public void keyTyped(KeyEvent e) {
   }

   @Override
   public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == 10) {
         calculateBMI();
      } else if (e.getKeyCode() == 27) {
         clearBMI();
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {

   }

   public void calculateBMI(){
      try{
         double weightValue = Double.parseDouble(weight.getText());
         double heightValue = Double.parseDouble(height.getText());
         double heightInMeters = heightValue / 100;
         double finalBMI = weightValue / (heightInMeters * heightInMeters);
         String formattedBMI = df.format(finalBMI); //formats and coverts double to string
         result.setText(formattedBMI + " BMI");

      } catch (NumberFormatException e) {
         result.setText("Invalid Input!");
      }
   }

   public void clearBMI(){
      result.setText("");
      weight.setText("");
      height.setText("");
   }

   public static void main(String[] args) {
      new BMI_CALCULATOR();
   }
}