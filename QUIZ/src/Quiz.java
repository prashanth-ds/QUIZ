import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    private ImageIcon image;
    private JLabel for_icon, nameLabel, desc;
    private JTextField textField;
    private String name, options[] = {"GK", "Entertainment", "Sports", "Literature"}, topic;
    private JButton jb, lb;
    private JComboBox jcb;

    Quiz(){
        super("Quiz (prashanth258)");
        setLayout(new FlowLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(530, 178);
        setResizable(false);// this will not allow user to resize thee window
        setIconImage(new ImageIcon(Quiz.class.getResource("Images\\my_mini_logo.png")).getImage());

        image = new ImageIcon(Quiz.class.getResource("Images\\my_logo.png"));
        for_icon = new JLabel("", image, JLabel.CENTER);
        add(for_icon);// this is coz we directly cannot pass image object to add we always have to pass a label so is it.

        nameLabel = new JLabel("Name :");
        add(nameLabel);

        textField = new JTextField("Enter Your Name",20);
        //textField.
        add(textField);
        textField.addActionListener(this);

        // this block will be for combobox to list the diffrent quiz sub-topics.
        jcb = new JComboBox(options);
        add(jcb);

        // this block will be for submit button
        jb = new JButton("Submit");
        jb.addActionListener(this);
        add(jb);

        lb = new JButton("Leaderboards");
        lb.addActionListener(this);
        add(lb);

        setLocationRelativeTo(null);// note this should always be placed before setVisible..... as it has to pack all of the things in the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            name = textField.getText();
            if (name.equals("Enter Your Name") || name.equals(""))
                JOptionPane.showMessageDialog(this, "Please Enter Your Name");
            else {
                topic = (String) jcb.getSelectedItem();
                System.out.println(name + "   " + topic);
                //dispose();// this is like destroying that particular frame if it is literally of no use
                if (topic.equals("GK")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new GK(name, topic);
                        }
                    });
                }
                if (topic.equals("Entertainment")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new Entertainment(name, topic);
                        }
                    });
                }
                if(topic.equals("Sports")){
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new Sports(name, topic);
                        }
                    });
                }
                if(topic.equals("Literature")){
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new Literature(name, topic);
                        }
                    });
                }
            }

        }
        if(e.getSource() == lb){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AllLeaderboards();
                }
            });
        }
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Quiz();
            }
        });
    }
}