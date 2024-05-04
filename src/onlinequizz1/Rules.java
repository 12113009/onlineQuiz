
package onlinequizz1;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;



public class Rules extends JFrame implements ActionListener{
    
    String name;
    JButton start,back;
    Rules(String name){
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Rules of the Exam");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("italic", Font.BOLD,30));
        heading.setForeground(new Color(30,144,254));
        add(heading);
        
        JLabel rules=new JLabel();
        rules.setBounds(20,90,700,350);
        rules.setFont(new Font("Tahoma", 0, 16));
        rules.setText("<html>1. You are trained to be a programmer and not a story teller, answer point to point<br><br>"
                + "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer<br><br>"
                + "3. You may have lot of options in life but here all the questions are compulsory<br><br>"
                + "4. Crying is allowed but please do so quietly.<br><br>"
                + "5. Only a fool asks and a wise answers (Be wise, not otherwise)<br><br>6"
                + ". Do not get nervous if your friend is answering more questions<br><br>"
                + "7. Brace yourself, this paper is not for the faint hearted<br><br>"
                + "8. May you know more than what John Snow knows, Good Luck<br><br><html>");
        this.add(rules);
        this.back = new JButton("Back");
        this.back.setBounds(250, 500, 100, 30);
        this.back.setBackground(new Color(30, 144, 254));
        this.back.setForeground(Color.WHITE);
        this.back.addActionListener(this);
        this.add(this.back);
        this.start = new JButton("Start");
        this.start.setBounds(400, 500, 100, 30);
        this.start.setBackground(new Color(30, 144, 254));
        this.start.setForeground(Color.WHITE);
        this.start.addActionListener(this);
        this.add(this.start);
        
        setSize(800,600);
        setLocation(350,100);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.start) {
            this.setVisible(false);
            new Quizzquestions(name);
            
        } else {
            this.setVisible(false);
            new LoginPage1();
        }

    }
    public static void main(String[] args){
        new Rules("user");
    }
    
    
}
