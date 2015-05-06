/*************************************************************************
 *  Exercise 15.4 from Java How To Program (Early Objects) 10th edition
 *  a) Define class TransactionRecord. Objects of this class contain an account number and amount for the transaction.
 *  Provide methods to modify and retrieve these values.
 *
 *  b) Modify class Account in Fig. 15.9 to include method combine, which takes a TransactionRecord object
 *  and combines the balance of the Account object and the amount value of the TransactionRecord object.
 *
 * c) Write a program to create data for testing the program. Use the sample account data in Figs. 15.14 and 15.15.
 * Run the program to create the files trans.txt and oldmast.txt to be used by your file-matching program.
 *
 * d) Create class FileMatch to perform the file-matching functionality. The class should contain methods that read oldmast.txt and trans.txt.
 * When a match occurs (i.e., records with the same account number appear in both the master file and the transaction file),
 * add the dollar amount in the transaction record to the current balance in the master record, and write the "newmast.txt" record.
 * (Assume that purchases are indicated by positive amounts in the transaction file and payments by negative amounts.)
 * When there’s a master record for a particular account, but no corresponding transaction record, merely write the master record to "newmast.txt".
 * When there’s a transaction record, but no corresponding master record, print to a log file the message "Unmatched transaction record for account number..."
 * (fill in the account number from the transaction record). The log file should be a text file named "log.txt".”
  *************************************************************************/
package ch15.hw;
import java.io.*;

/**
 * @author ikirilov
 */
class CreateTestData {
    /**
     * Writes account test data to "oldmaster.txt" file
     * @throws IOException
     */
    public static void WriteToMaster() throws IOException {
        int account;
        String name;
        double balance;
        PrintWriter pw = new PrintWriter(new FileWriter("oldmaster.txt"), true);

        //Data for the following fields:
        //account number - firstname - lastname - balance
        //Can be modified
        Object[][] data = {
                {100, "Diego Maradona", 1000.00},
                {200, "Hristo Stoichkov", 2000.00},
                {300, "Zinedine Zidane", 3000.00}
        };

        System.out.println("Contents of oldmaster.txt:");
        for (Object datum[] : data) {
            account = (int) datum[0];
            name = (String) datum[1];
            balance = (double) datum[2];
            System.out.println(account + " " + name + " " + balance);
            pw.println(account + " " + name + " " + balance);
        }
    }

    /**
     * Writes transaction test data to "trans.txt"
     * @throws IOException
     */
    public static void WriteToTrans() throws IOException {
        int account;
        double balance;
        PrintWriter pw = new PrintWriter(new FileWriter("trans.txt"), true);

        //Data for the following fields:
        //account number   transaction
        //Can be modified
        Object[][] data = {
                {100, 10.00},
                {200, 20.00},
                {300, 30.00}
        };
        System.out.printf("%nContents of trans.txt:%n");
        for (Object datum[] : data) {
            account = (int) datum[0];
            balance = (double) datum[1];
            System.out.println(account + " " + balance);
            pw.println(account + " " + balance);
        }
    }
}

class ReadAndMatchTestData {
    /**
     * Reads data from "oldmaster.txt" and "trans.txt"
     * Matches the two files by their account numbers
     * If match is found, adds the transaction and prints to new file ("newmaster.txt")
     * @throws IOException
     */
    public static void Match() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("newmaster.txt"),true);
        BufferedReader transReader = new BufferedReader(new InputStreamReader(new FileInputStream("trans.txt")));
        BufferedReader accountReader = new BufferedReader(new InputStreamReader(new FileInputStream("oldmaster.txt")));
        Account account = new Account();
        TransactionRecord tr = new TransactionRecord();

        String accountLine;
        String firstName, lastName;
        while((accountLine=accountReader.readLine())!=null) {
            Object[] splitAccount = accountLine.split(" ");

            firstName = (String) splitAccount[1];
            lastName = (String) splitAccount[2];
            account.setAccount(Integer.parseInt((String) splitAccount[0]));
            account.setBalance(Double.parseDouble((String) splitAccount[3]));

            String trans_line;
            int accountNumber=0;
            while((trans_line=transReader.readLine())!=null){
                Object[] splitTransaction = trans_line.split(" ");
                //System.out.println(line);
                accountNumber = Integer.parseInt((String) splitTransaction[0]);
                double transaction = Double.parseDouble((String) splitTransaction[1]);
                tr.setAccountNumber(accountNumber);
                tr.setAmount(transaction);
                if(accountNumber==account.getAccount()) {
                    System.out.printf("%nMatch found! Account %d's balance has been increaded by %.2f.%n", accountNumber, transaction);
                    System.out.println("Now it is " + account.combine(tr));
                    System.out.println("Saving new data to 'newmaster.txt'");
                    pw.println(account.getAccount() + " " + firstName + " " + lastName + " " + account.combine(tr));
                    break;
                }
            }
        }
        pw.close();
        transReader.close();
        accountReader.close();

    }
}


public class Test {
    public static void main(String[] args) throws IOException {
        CreateTestData.WriteToMaster();
        CreateTestData.WriteToTrans();
        ReadAndMatchTestData.Match();
    }
}
