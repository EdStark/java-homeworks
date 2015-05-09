package ch12;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

/**
 * Created by ikirilov on 03/05/15.
 */
public class Tokenizer {
    /*
    Dates are printed in several common formats. Lets take European and US date formats:
    EU:  25.04.2015   US:  04/25/2015
    Write an application that reads a date in the first format and prints it in the second format.
    */
    public static List<String> printNewFormat(String fileName) {
        FileInputStream fis;
        DataInputStream dis;
        BufferedReader br=null;
        String newDate;
        List<String> newDateFormatList = new ArrayList<String>();
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line = null;  //My all-time favourite line
            String day, month, year;  //Vars to hold date elements

            while((line = br.readLine()) != null){   //Start reading the input line by line
                String[] tokens = line.split("\\."); //Split the original input line into an array of 3 elements
                day=tokens[0]; //Assign the first array element to the day
                month=tokens[1]; //Assign the second array element to the month
                year=tokens[2];  //Assign the last array element to the year
                newDate = month + "/" + day + "/" + year;//Construct the new format here
                newDateFormatList.add(newDate); //Add the newly constructed date to the list
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
               if(br != null) br.close(); //Best practise is always to try closing the reader
            }catch(Exception e){
               e.printStackTrace();
            }
        }
        return newDateFormatList;//Return the list with the new date format
    }

    public static void main(String[] args) {
        List<String> dateList = printNewFormat("/Users/ikirilov/Documents/my_java_code/dietel_dietel/src/ch12/input.txt");

        //Loop through all list entries and print them one-by one
        for(String str:dateList){
            System.out.println(str + "  ");
        }
    }
}
