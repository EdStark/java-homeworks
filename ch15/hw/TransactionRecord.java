package ch15.hw;

/**
 * Created by ikirilov on 05/05/15.
 */
public class TransactionRecord {
    private int accountNumber;
    private double amount;

    public TransactionRecord(){};

    public TransactionRecord(int accountNumber, double amount){
        this.accountNumber=accountNumber;
        this.amount=amount;
    }

    public void setAccountNumber(int accountNumber){
       this.accountNumber=accountNumber;
    }
    public int getAccountNumber(){
        return accountNumber;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }
    public double getAmount(){
        return amount;
    }
}
