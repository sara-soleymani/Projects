package eecs1022.lab7.bank.model;

public class Transaction {
    private String trans ;
    private double amount ;



    public Transaction(String trans , double amount) {
        this.amount = amount ;
        this.trans = trans ;
    }

    public String getStatus() {
        String newamount = String.format("%.2f", this.amount) ;
        return "Transaction " + this.trans +": $" + newamount ;

    }



}
