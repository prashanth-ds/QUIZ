import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllLeaderboards extends JFrame implements ActionListener {
    JButton gk, entertainment, sports, literature;

    AllLeaderboards(){
        super("Leaderboard Menu");
        setIconImage(new ImageIcon(Quiz.class.getResource("Images\\my_mini_logo.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,90);
        setResizable(false);
        gk = new JButton("GK");
        entertainment = new JButton("Entertainment");
        sports = new JButton("Sports");
        literature = new JButton("Literature");
        gk.addActionListener(this);
        entertainment.addActionListener(this);
        sports.addActionListener(this);
        literature.addActionListener(this);
        add(gk);
        add(entertainment);
        add(sports);
        add(literature);
        gk.setBounds(50,15,100, 20);
        entertainment.setBounds(170,15,120, 20);
        sports.setBounds(310,15,100, 20);
        literature.setBounds(430,15,100, 20);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == gk){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Leaderboard("GK");
                    dispose();// this will dispose only the current frame and not all the framees
                }
            });
        }
        if(e.getSource() == entertainment){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Leaderboard("Entertainment");
                    dispose();
                }
            });
        }
        if(e.getSource() == sports){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Leaderboard("Sports");
                    dispose();
                }
            });
        }
        if(e.getSource() == literature){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Leaderboard("Literature");
                    dispose();
                }
            });
        }
    }
}
