import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class Sports extends JFrame implements ActionListener {
    JLabel question, user, serial;
    JButton previous, next, submit;
    JRadioButton jrb[] = new JRadioButton[5];
    ButtonGroup bg;
    int[] indexes = new int[10], opt_index = new int[4], m = new int[10];
    int current = 0, actual_option_index, result_count = 0, rows = 100, cols = 2, count_flag = 0;
    String Name,fileName;

    Sports(String name, String topic){
        super(topic);
        //setBackground(Color.GREEN);
        setResizable(false);
        setIconImage(new ImageIcon(Quiz.class.getResource("Images\\my_mini_logo.png")).getImage());
        fileName = "Files//Sports.csv";
        Name = name;
        user = new JLabel();
        user.setBackground(Color.blue);
        serial = new JLabel();
        add(serial);
        add(user);
        user.setFont(new Font("sanserif", Font.BOLD, 12));
        bg = new ButtonGroup();
        for(int i=0;i<5;i++){
            jrb[i] = new JRadioButton();
            jrb[i].setFont(user.getFont());
            add(jrb[i]);
            //jrb[i].setBackground(new Color(225,198,153));
            bg.add(jrb[i]);
        }

        previous = new JButton("Previous");
        next = new JButton("Next");
        submit = new JButton("Submit");
        previous.addActionListener(this);
        next.addActionListener(this);
        submit.addActionListener(this);
        add(previous);
        add(next);
        add(submit);
        indexes = new Utility().get_random_ques();
        display();
        serial.setBounds(55, 38, 20, 20);
        user.setBounds(65,38,450,20);
        jrb[0].setBounds(50,90,100,20);
        jrb[1].setBounds(50,125,100,20);
        jrb[2].setBounds(300,90,100,20);
        jrb[3].setBounds(300,125,100,20);
        previous.setBounds(80,195, 100,30);
        next.setBounds(220,195,100,30);
        submit.setBounds(360,195,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(595,295);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == next){
            if(new Utility().check(jrb[actual_option_index]))
                result_count += 1;
            current++;
            display();
            if(current == 9)//JOptionPane.showMessageDialog(this, "This is the last question");
                next.setEnabled(false);
        }
        if (e.getSource() == previous){
            current--;
            if(current != 9)
                next.setEnabled(true);
            display();
        }
        if (e.getSource() == submit){
            if(new Utility().check(jrb[actual_option_index]))
                result_count += 1;
            current++;
            new Utility().store(fileName, Name, result_count);
            Return_file sorted_data_ret = new Utility().sort_data(fileName);
            String[][] sorted_data = sorted_data_ret.records;
            count_flag = sorted_data_ret.flag;// this var is to get the count of number of lines in the file
            new Utility().change_file(fileName, sorted_data, count_flag);
            JOptionPane.showMessageDialog(this, Name + " You Scored : " + result_count);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Leaderboard("Sports");
                }
            });
            dispose();
        }

    }

    public void display(){
        jrb[4].setSelected(true);// this will set the fifth radio button as true for evry frme of question that appears so that when next is clicked fifth option is automatically selected.... as in radiobuttons and this type of code one click would be constant if question changes aswell
        opt_index = new Utility().get_random_opts();// this will make sure that random options are created and randomness of options doesnt even change even if we go next or even previous.
        if(indexes[current] == 0){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  Which sports event becomes the world's first major sports event to resume after COVID-19 lockdown?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else if(indexes[current] == 1){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  Who becomes 1st Indian to win ITF's Fed Cup Heart Award for Asia/Oceania zone through online voting by fans?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else if(indexes[current] == 2){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  Which are the official mascots of 19th Asian Games?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else if(indexes[current] == 3){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  Which Indian cricketer has been appointed as the new brand ambassador of Chinese smartphone brand iQOO?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else if(indexes[current] == 4){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  Who among the following players is known as the Sachin Tendulkar of domestic cricket?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else if(indexes[current] == 5){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText(" Who won the BBC Indian Sportswoman of the Year 2019?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else if(indexes[current] == 6){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  Who recently won World Boxing Council heavyweight title?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else if(indexes[current] == 7){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  Who became the first cricketer to play 100 matches in all three formats of the game - Test, ODI & T20?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else if(indexes[current] == 8){
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  Which of the following is to host the final of FIFA U-17 Women's World Cup?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }
        else {
            serial.setText(Integer.toString(current+1) + ".");
            user.setText("  How many NBA titles does Michael Jordan have?");
            String[] test = rand_opt();
            for(int i=0;i<4;i++)
                jrb[i].setText(test[i]);
        }

    }

    public String[] rand_opt(){
        if(indexes[current] == 0){
            String[] str = {"Copa America", "PL", "Bundesliga", "FIFA WC", "Bundesliga"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else if(indexes[current] == 1) {
            String[] str = {"Leander Paes", "Sania Mirza", "Ankiya Raina", "Sumit Nagal", "Sania Mirza"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else if(indexes[current] == 2){
            String[] str = {"Chenchen", "Congcong", "Lianlian", "All of the above", "All of the above"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else if(indexes[current] == 3){
            String[] str = {"Virat Kohli", "Sachin", "Suresh Raina", "M S Dhoni", "Virat Kohli"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else if(indexes[current] == 4){
            String[] str = {"Ravi Shasrti", "Virat Kohli", "Wasim Jaffer", "Suresh Raina", "Wasim Jaffer"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else if(indexes[current] == 5){
            String[] str = {"Saina Nehwal", "Sania mirza", "P V Sindhu", "Marry Kom", "P V Sindhu"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else if(indexes[current] == 6){
            String[] str = {"Tyson Fury", "David Haye", "Andy Ruiz Jr", "Manuel Charr", "Tyson Fury"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else if(indexes[current] == 7){
            String[] str = {"Virat Kohli", "Ross Taylor", "Rahul Dravid", "Brain Lara", "Ross Taylor"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else if(indexes[current] == 8){
            String[] str = {"Hyderabad", "New Delhi", "Mumbai", "Kolkata", "Mumbai"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
        else{
            String[] str = {"5", "6", "7", "8", "6"};
            Return_opt opt = new Utility().rand_gen(str, opt_index);// return opt is used as return type for collecting data .
            actual_option_index = opt.actual_index;
            return opt.str;
        }
    }
}
