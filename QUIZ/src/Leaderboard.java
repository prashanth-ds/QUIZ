import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Leaderboard extends JFrame {
    String[] s = {"Name", "Score"};
    private int rows = 100, cols = 2;
    Object[][] data = new String[rows][cols];
    JTable table;
    JScrollPane jsp;
    String Topic;
    Leaderboard(String topic){
        super(topic);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(Quiz.class.getResource("Images\\my_mini_logo.png")).getImage());
        setSize(330,250);
        if(topic.equals("GK"))
            Topic = "Files//GK.csv";
        else if(topic.equals("Entertainment"))
            Topic = "Files//Entertainment.csv";
        else if(topic.equals("Sports"))
            Topic = "Files//Sports.csv";
        else
            Topic = "Files//Literature.csv";
        put_data();
        table = new JTable(data, s);
        jsp = new JScrollPane(table);
        add(jsp);
        setLocationRelativeTo(null);// this will keep the window in centre
        setVisible(true);
    }

    public void put_data(){
        String buffer;
        int flag = 0, i = 0;
        //System.out.println(989);
        try {
            BufferedReader scr = new BufferedReader(new FileReader(Topic));
            while (scr.readLine() != null)
                flag++;
        }catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println("hello" + flag);
        try {
            BufferedReader sc = new BufferedReader(new FileReader(Topic));
                while ((buffer = sc.readLine()) != null) {
                    //System.out.println("has");
                    String[] line = buffer.trim().split(",");
                    for (int j = 0; j < line.length; j++)
                        data[i][j] = line[j];
                    i++;
                }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
