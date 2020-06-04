import javax.swing.*;
import java.io.*;
import java.util.Random;

public class Utility {

    public int[] get_random_ques(){
        Random rand = new Random();
        int[] indexes = new int[10];
        for(int i=0;i<10;i++){
            indexes[i] = rand.nextInt(10);
            for(int j=0;j<i;j++){
                if(indexes[i] == indexes[j]){
                    i--;
                    break;
                }
            }
        }
        for(int k : indexes)
            System.out.println(k);
        return indexes;
    }

    public int[] get_random_opts(){
        Random rand = new Random();
        int[] opt_index = new int[4];

        for(int i=0;i<4;i++){
            opt_index[i] = rand.nextInt(4);
            for(int j=0;j<i;j++){
                if(opt_index[i] == opt_index[j]){
                    i--;
                    break;
                }
            }
        }
        for(int k : opt_index)
            System.out.println(k);
        return opt_index;
    }

    public Return_opt rand_gen(String[] s, int[] opt_index){
        /*
         * here, we'll see that fifth element in string is integer which is a string so we convert the string to integer by the first method used below
         * Integer.parseInt.("200") is equal to 200(int).
         * */
        Random rand = new Random();
        //int [] opt_index = new int[4];
        int actual_option_index = 0;

        for(int i=0;i<4;i++){
            String temp = s[opt_index[i]];
            s[opt_index[i]] = s[i];
            s[i] = temp;
        }
        for(int i=0;i<4;i++)
            System.out.println(s[i]);
        // here we will be getting the index of randomized options so that it'll be easy to evaluate in check function.
        for(int i=0;i<4;i++){
            if(s[i].equals(s[4]))
                actual_option_index = i;
        }
        return new Return_opt(s, actual_option_index);
    }

    boolean check(JRadioButton jrb){
        return jrb.isSelected();
    }

    public void store(String topic, String name, int score){
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter(topic, true));// this object is used for performing CRUD in file
            file.append(name);
            file.append(",");
            file.append(Integer.toString(score));// this will parse integer to string
            file.append("\n");
            file.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Return_file sort_data(String topic){
        int i = 0, count_flag = 0;
        String buffer, name_data, score_data;
        String[][] data = new String[100][2];
        try{// here we actually collect each data in a 2d array
            BufferedReader file = new BufferedReader(new FileReader(topic));
            while ((buffer = file.readLine()) != null) {
                //System.out.println("has");
                String[] line = buffer.trim().split(",");
                for (int j = 0; j < line.length; j++)
                    data[i][j] = line[j];
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println("before");
        try {// here we get the count of num of lines
            BufferedReader scr = new BufferedReader(new FileReader(topic));
            while (scr.readLine() != null)
                count_flag++;
        }catch (IOException e){
            e.printStackTrace();
        }
        //Bubble sorting
        for(int k=0;k<count_flag;k++){
            for(int j=1;j<(count_flag-k);j++){
                if(Integer.parseInt(data[j][1]) > Integer.parseInt(data[j-1][1])){
                    name_data = data[j-1][0];//equals to temp = a[j-1]
                    score_data = data[j-1][1];
                    data[j-1][0] = data[j][0];// equals to a[j-1] = a[j]
                    data[j-1][1] = data[j][1];
                    data[j][0] = name_data;//equals to a[j] = temp
                    data[j][1] = score_data;
                }
            }
        }
        //System.out.println("after");
        //print_data(data);
        try{
            FileWriter change = new FileWriter(topic);
            PrintWriter flush = new PrintWriter(change);
            flush.flush();
            flush.close();
            change.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println("hedskn");
        //print_data(data);
        return new Return_file(data,count_flag);
    }

    public void change_file(String topic, String[][] data, int count_flag){
        try{
            BufferedWriter file = new BufferedWriter(new FileWriter(topic, true));
            for(int i=0;i<count_flag;i++){
                if(i == 0) {
                    file.write(data[i][0]);
                    file.write(",");
                    file.write(data[i][1]);
                    file.write("\n");
                }
                else {
                    file.append(data[i][0]);
                    file.append(",");
                    file.append(data[i][1]);
                    file.append("\n");
                }
            }
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
