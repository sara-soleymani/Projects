package eecs1022.lab7.bank.model;

public class Client {
    private String name ;
    private double balance ;
    String[] statmnt ;
    int maxnumoftrans = 10 ;
    int nos ;

    public Client(String name , double balance) {
        statmnt = new String[maxnumoftrans] ;
        nos = 0 ;
        this.name = name ;
        this.balance = balance ;
    }

    public String getname() {
        return this.name ;
    }

    public double getbalance() {
        return this.balance ;
    }


    public String getStatus() {
        String statement = this.name + ": $" + String.format("%.2f", this.balance) ;
        statmnt[0] = statement ;
        if(nos == 0) {
            nos++ ;
        }
        return statement ;
    }

    public String[] getStatement() {

        String[] sts = new String[nos] ;
        for(int i = 0 ; i < nos ; i++) {
            sts[i] = statmnt[i] ;
        }
        return sts ;
    }

    public void deposit(double amount) {
        this.balance += amount ;
        String newmount = String.format("%.2f", amount) ;
        statmnt[nos] = "Transaction DEPOSIT: $" + newmount ;
        nos++ ;
    }

    public void withdraw(double amount) {
        this.balance -= amount ;
        String newmount = String.format("%.2f", amount) ;
        statmnt[nos] = "Transaction WITHDRAW: $" + newmount ;
        nos++ ;
    }




}


