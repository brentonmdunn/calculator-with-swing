import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class MyFrame extends JFrame implements ActionListener {
    
    JButton clear;
    JButton blank1;
    JButton blank2;
    JButton blank3;

    
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonEquals;
    
    JLabel output;

    String s = "";
    String fullNumber = "";
    double temp = 0;
    int total = 0;
    int num1 = 0;
    boolean minus = false;
    boolean plus = false;
    boolean first = true;

    ArrayList<Integer> shown = new ArrayList<Integer>();

    public void buttonAction(int value) {
        enableAllButtons();

        temp = 0;

        if (plus) {
            //total += value;
            //temp += value;
            total = num1 + value;
        }
        else if (minus) {
            //total -= value;
            //temp -= value;
            System.out.println("Num1: " + num1);
            System.out.println("Array: " + value);
            total = num1 - value;
        } 
        /*if (first) {
            total += value;
            temp += value;
            first = false;
        }*/

        minus = false;
        plus = false;
        output.setText(s.valueOf(total));
    }

    private void enableAllButtons() {
        buttonMinus.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonEquals.setEnabled(true);
    }

    private void disableAllButtons() {
        buttonPlus.setEnabled(false);
        buttonMinus.setEnabled(false);
        //buttonEquals.setEnabled(false);
    }

    private String arrayListToString() {
        fullNumber = "";
        for (int e : shown) {
            fullNumber += e;
        }
        return fullNumber;
    }

    private int arrayListToInt() {
        boolean firstElement = true;
        int number = 0;
        //int length = shown.size();
        for (int e : shown) {
            if (firstElement) {
                number += e;
                firstElement = false;
            } else {
                number *= 10;
                number += e;
            }
        }
        return number;
    }

    MyFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.green);
        buttons.setLayout(new GridLayout(4,3));
        buttons.setPreferredSize(new Dimension(500,350));
        frame.add(buttons,BorderLayout.SOUTH);
        

        clear = new JButton("clear");
        blank1 = new JButton("blank1");
        blank2 = new JButton("blank2");
        blank3 = new JButton("blank3");

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonEquals = new JButton("="); 

        clear.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonEquals.addActionListener(this);

        buttons.add(clear);
        buttons.add(blank1);
        buttons.add(blank2);
        buttons.add(blank3);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(buttonPlus);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(buttonMinus);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(buttonEquals);

        output = new JLabel();
        output.setText("TYPE SOMETHING");
        output.setFont(new Font("Times New Roman",Font.PLAIN,40));
        output.setHorizontalAlignment(JLabel.RIGHT);

        frame.add(output);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear) {
            shown.clear();
            num1 = 0;
            output.setText("");
        }if(e.getSource()==button1) {
            shown.add(1);
            output.setText(arrayListToString());
        }
        if(e.getSource()==button2) {
            shown.add(2);
            output.setText(arrayListToString());
        }
        if(e.getSource()==button3) {
            shown.add(3);
            output.setText(arrayListToString());
        }
        if(e.getSource()==button4) {
            shown.add(4);
            output.setText(arrayListToString());
        }
        if(e.getSource()==button5) {
            shown.add(5);
            output.setText(arrayListToString());
        }
        if(e.getSource()==button6) {
            shown.add(6);
            output.setText(arrayListToString());
        }
        if(e.getSource()==button7) {
            shown.add(7);
            output.setText(arrayListToString());
        }
        if(e.getSource()==button8) {
            shown.add(8);
            output.setText(arrayListToString());
        }
        if(e.getSource()==button9) {
            shown.add(9);
            output.setText(arrayListToString());
        }
        if(e.getSource()==buttonPlus) {
            plus = true;
            num1 = arrayListToInt();
            shown.clear();
            disableAllButtons();
        }
        if(e.getSource()==buttonMinus) {
            minus = true;
            num1 = arrayListToInt();
            shown.clear();
            disableAllButtons();
        }
        if(e.getSource()==buttonEquals) {
            buttonAction(arrayListToInt());
        }
    }
}
