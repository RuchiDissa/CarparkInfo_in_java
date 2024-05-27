import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Search extends JFrame implements ActionListener {

    private JLabel b,g,m,y,ms,c;
    private JTextField tb,tg,tm,ty,tms,tc;
    private JButton bs1,bs2;
    private File f2 = new File("D:\\Car Info.txt");
    private BufferedReader br;
    private FileReader fr;
    Scanner myReader;
    String brand,gearbox,model,color;
    int year,speed;
    private ArrayList<Car> cars = new ArrayList<>();

    Search(String title){
        setTitle(title);
        setLayout(new FlowLayout());
        setSize(760,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        b = new JLabel("Brand");
        b.setForeground(Color.BLACK);
        b.setFont(new Font("verdana",Font.BOLD,12));
        b.setBounds(40,20,100,20);

        tb = new JTextField();
        tb.setForeground(Color.BLACK);
        tb.setFont(new Font("verdana",Font.BOLD,12));
        tb.setBounds(10,60,100,20);

        g = new JLabel("GearBox");
        g.setForeground(Color.BLACK);
        g.setFont(new Font("verdana",Font.BOLD,12));
        g.setBounds(150,20,100,20);

        tg = new JTextField();
        tg.setForeground(Color.BLACK);
        tg.setFont(new Font("verdana",Font.BOLD,12));
        tg.setBounds(130,60,100,20);

        m = new JLabel("Model");
        m.setForeground(Color.BLACK);
        m.setFont(new Font("verdana",Font.BOLD,12));
        m.setBounds(280,20,100,20);

        tm = new JTextField();
        tm.setForeground(Color.BLACK);
        tm.setFont(new Font("verdana",Font.BOLD,12));
        tm.setBounds(250,60,100,20);

        y = new JLabel("Year");
        y.setForeground(Color.BLACK);
        y.setFont(new Font("verdana",Font.BOLD,12));
        y.setBounds(400,20,100,20);

        ty = new JTextField();
        ty.setForeground(Color.BLACK);
        ty.setFont(new Font("verdana",Font.BOLD,12));
        ty.setBounds(370,60,100,20);

        ms = new JLabel("Max Speed");
        ms.setForeground(Color.BLACK);
        ms.setFont(new Font("verdana",Font.BOLD,12));
        ms.setBounds(510,20,100,20);

        tms = new JTextField();
        tms.setForeground(Color.BLACK);
        tms.setFont(new Font("verdana",Font.BOLD,12));
        tms.setBounds(500,60,100,20);

        c = new JLabel("Color");
        c.setForeground(Color.BLACK);
        c.setFont(new Font("verdana",Font.BOLD,12));
        c.setBounds(660,20,100,20);

        tc = new JTextField();
        tc.setForeground(Color.BLACK);
        tc.setFont(new Font("verdana",Font.BOLD,12));
        tc.setBounds(630,60,100,20);

        bs1 = new JButton("Find the fastest car");
        bs1.setForeground(Color.BLACK);
        bs1.setBackground(Color.WHITE);
        bs1.setFont(new Font("verdana",Font.BOLD,12));
        bs1.setBounds(40,100,500,40);

        bs2 = new JButton("Clear");
        bs2.setForeground(Color.BLACK);
        bs2.setBackground(Color.WHITE);
        bs2.setFont(new Font("verdana",Font.BOLD,12));
        bs2.setBounds(560,100,150,40);

        add(b);
        add(g);
        add(m);
        add(y);
        add(ms);
        add(c);
        add(tb);
        add(tg);
        add(tm);
        add(ty);
        add(tms);
        add(tc);
        add(bs1);
        add(bs2);

        tb.setEnabled(false);
        tg.setEnabled(false);
        tm.setEnabled(false);
        ty.setEnabled(false);
        tms.setEnabled(false);
        tms.setText("0.00 kph");
        tc.setEnabled(false);

        bs1.addActionListener(this);
        bs2.addActionListener(this);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==bs1)
        {
            try {


                Scanner myReader = new Scanner(f2);
                while (myReader.hasNextLine()) {

                    do{
                        brand = myReader.next();
                        gearbox = myReader.next();
                        model = myReader.next();
                        year = Integer.parseInt(myReader.next());
                        speed = Integer.parseInt(myReader.next());
                        color = myReader.next();
                        cars.add(new Car(brand, gearbox, model, color, year, speed));
                    }while (myReader.hasNext());
                    Car maxSpeedCar = cars.stream().max(Comparator.comparing(Car::getSpeed)).orElse(null);
                    tb.setText(maxSpeedCar.getBrand());
                    tg.setText(maxSpeedCar.getGearbox());
                    tm.setText(maxSpeedCar.getModel());
                    ty.setText(String.valueOf(maxSpeedCar.getYear()));
                    tms.setText(String.valueOf(maxSpeedCar.getSpeed()+" kph"));
                    tc.setText(maxSpeedCar.getColor());
                }
                myReader.close();
            } catch (FileNotFoundException xe) {
                System.out.println("An error occurred.");
                xe.printStackTrace();
            }
        }
        else if (e.getSource()==bs2) {

            tb.setText("");
            tg.setText("");
            tm.setText("");
            ty.setText("");
            tms.setText("");
            tc.setText("");
        }
        }

}

