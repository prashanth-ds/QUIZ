package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class DocToJSON {

    @SuppressWarnings("unchecked")
    private void change() {
        Scanner input = new Scanner(System.in);
        int type;
        System.out.println("Enter\n1:GK\n2:Entertainment\n3:Sports\n4:Literature");
        type = input.nextInt();
        input.nextLine();

        JSONArray all_gk = new JSONArray();
        for (int i = 0; i < 4; i++) {
            //JSONObject[] options = new JSONObject[4];
            JSONObject options = new JSONObject();
            JSONObject obj = new JSONObject();

            String question;
            System.out.println("Enter the question");
            question = input.nextLine();
            System.out.println("enter four options");
            options.put("question", question);
            options.put("option 1", input.nextLine());
            options.put("option 2", input.nextLine());
            options.put("option 3", input.nextLine());
            options.put("option 4", input.nextLine());
            obj.put("question", options);
            all_gk.add(obj);
        }

        if(type == 1) {
            try (FileWriter file = new FileWriter("GK.json")) {
                file.write(all_gk.toJSONString());
                file.flush();
                System.out.println("done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type == 2){
            try (FileWriter file = new FileWriter("Entertainment.json")) {
                file.write(all_gk.toJSONString());
                file.flush();
                System.out.println("done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type == 3){
            try (FileWriter file = new FileWriter("sports.json")) {
                file.write(all_gk.toJSONString());
                file.flush();
                System.out.println("done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try (FileWriter file = new FileWriter("literature.json")) {
                file.write(all_gk.toJSONString());
                file.flush();
                System.out.println("done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new DocToJSON().change();
    }
}
