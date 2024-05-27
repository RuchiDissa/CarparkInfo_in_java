import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main extends JFrame implements ActionListener {

    private JLabel l1,l2,l3,l4,l5,l6,l7;
    private JComboBox c1;
    private JRadioButton manual,auto;
    private ButtonGroup Bg;
    private JTextField t1,t2,t3,t4;
    private JButton add,search,clear;
    private File f1 = new File("D:\\Car Info.txt");
    private  FileWriter w;
    private  BufferedWriter bw;
    Search s1;

    Main(String title){

        setTitle(title);
        setLayout(new FlowLayout());
        setSize(400,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        //label : Enter the car's information
        l1 = new JLabel("Enter the car's Information");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("verdana",Font.BOLD,15));
        l1.setBounds(80,10,250,20);

        //label : Choose the brand
        l2 = new JLabel("Choose the Brand : ");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("verdana",Font.BOLD,12));
        l2.setBounds(10,60,250,20);

        //ComboBox : choose the brand
        c1 = new JComboBox();
        c1.setForeground(Color.BLACK);
        c1.setFont(new Font("verdana",Font.BOLD,12));
        c1.setBounds(170,60,170,20);
        c1.addItem("Choose one");
        c1.addItem("Mercedes");
        c1.addItem("BMW");
        c1.addItem("HONDA");
        c1.addItem("Mazda");
        c1.addItem("Suzuki");
        c1.addItem("Hyundai");
        c1.addItem("Toyota");

        //label : Choose hte GearBox
        l3 = new JLabel("Choose the GearBox : ");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("verdana",Font.BOLD,12));
        l3.setBounds(10,100,250,20);

        //RadioButton : Select manual gear
        manual = new JRadioButton("Manual");
        manual.setForeground(Color.BLACK);
        manual.setBackground(Color.lightGray);
        manual.setFont(new Font("verdana",Font.BOLD,12));
        manual.setBounds(170,100,80,20);

        //RadioButton : Select Automatic gear
        auto = new JRadioButton("Automatic");
        auto.setForeground(Color.BLACK);
        auto.setBackground(Color.lightGray);
        auto.setFont(new Font("verdana",Font.BOLD,12));
        auto.setBounds(260,100,95,20);

        //Group all RadioButton
        Bg= new ButtonGroup();
        Bg.add(manual);
        Bg.add(auto);

        //label : Enter the model
        l4 = new JLabel("Enter the Model : ");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("verdana",Font.BOLD,12));
        l4.setBounds(10,140,250,20);

        //TextField : Enter the model
        t1 = new JTextField();
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("verdana",Font.BOLD,12));
        t1.setBounds(170,140,170,20);

        //label : Enter the year
        l5 = new JLabel("Enter the Year : ");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("verdana",Font.BOLD,12));
        l5.setBounds(10,180,250,20);

        //TextField : Enter the year
        t2 = new JTextField();
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("verdana",Font.BOLD,12));
        t2.setBounds(170,180,170,20);

        //label : Enter the MaxSpeed
        l6 = new JLabel("Enter the Max Speed : ");
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("verdana",Font.BOLD,12));
        l6.setBounds(10,220,250,20);

        //TextField : Enter the MaxSpeed
        t3 = new JTextField();
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("verdana",Font.BOLD,12));
        t3.setBounds(170,220,170,20);

        //label : Enter the color
        l7 = new JLabel("Enter the Color : ");
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("verdana",Font.BOLD,12));
        l7.setBounds(10,260,250,20);

        //TextField : Enter the color
        t4 = new JTextField();
        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("verdana",Font.BOLD,12));
        t4.setBounds(170,260,170,20);

        //Button : Add car to the files
        add = new JButton("Add Car to the Files");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setFont(new Font("verdana",Font.BOLD,15));
        add.setBounds(75,300,250,30);

        //Button : Open the search form
        search = new JButton("Open the search form");
        search.setForeground(Color.BLACK);
        search.setBackground(Color.WHITE);
        search.setFont(new Font("verdana",Font.BOLD,15));
        search.setBounds(75,340,250,30);

        //Button : Clear the textfields
        clear = new JButton("Clear");
        clear.setForeground(Color.BLACK);
        clear.setBackground(Color.WHITE);
        clear.setFont(new Font("verdana",Font.BOLD,15));
        clear.setBounds(75,380,250,30);

        add(l1);
        add(l2);
        add(c1);
        add(l3);
        add(manual);
        add(auto);
        add(l4);
        add(t1);
        add(l5);
        add(t2);
        add(l6);
        add(t3);
        add(l7);
        add(t4);
        add(add);
        add(search);
        add(clear);
        add.addActionListener(this);
        search.addActionListener(this);
        clear.addActionListener(this);
        setVisible(true);
    }
    public static void main(String[] args) {

        Main m1 = new Main("Car Info");

    }


    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){

            try {

            w = new FileWriter(f1,true);
            bw = new BufferedWriter(w);

            String brand = c1.getSelectedItem().toString();
            String model = t1.getText();
            int year = Integer.parseInt(t2.getText());
            int speed = Integer.parseInt(t3.getText());
            String color = t4.getText();

                   if (manual.isSelected() == true) {
                        bw.write(brand+"\t"+"Manual"+"\t" +model+ "\t" +year+ "\t" +speed+ " " +color);
                        bw.newLine();
                        bw.close();

                   } else if (auto.isSelected() == true) {
                            bw.write(brand+"\t"+"Automatic"+"\t" +model+ "\t" +year+ "\t" +speed+ " " +color);
                            bw.newLine();
                            bw.close();
                   }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"An error occurred.","ERROR",JOptionPane.ERROR_MESSAGE);
            }

        }
        else if(e.getSource()==search){

            Search s1 = new Search("Search Form");
            dispose();

        } else if (e.getSource()==clear) {
            Bg.clearSelection();
            c1.setSelectedItem("Choose one");
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
    }
}