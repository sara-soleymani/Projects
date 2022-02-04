package eecs1022.lab7.bank.model;

public class Bank
{
    private Client[] client;
    private int maxnumofclients = 6;
    private int noc;
    private String stat;
    private boolean haserror = false;


    public Bank()
    {

        client = new Client[maxnumofclients];
        noc = 0;
    }

    public String getStatus()
    {

        if (haserror == false)
        {

            stat = getStringStatus();

        }

        return stat;

    }

    public String getStringStatus()
    {

        this.stat = "Accounts: {";

        for (int i = 0; i < this.noc; i++)
        {

            if (i < this.noc)
            {

                if (i != 0)
                {
                    this.stat += ", " + client[i].getStatus();
                } else
                {
                    this.stat += client[i].getStatus();
                }

            }
        }

        return this.stat += "}";

    }

    public boolean isclient(String name)
    {
        boolean iscl = false;

        for (int i = 0; i < noc && !iscl; i++)
        {

            iscl = client[i].getname().equals(name);


        }
        return iscl;
    }

    public Client getclient(String name)
    {
        boolean iscl = false;
        Client result = null;
        for (int i = 0; i < this.noc && !iscl; i++)
        {
            if (client[i].getname().equals(name))
            {
                iscl = true;
                result = client[i];
            }


        }
        return result;
    }


    public String[] getStatement(String name)
    {

        String[] sts = null;

        if (isclient(name) == false)
        {
            stat = "Error: From-Account " + name + " does not exist";
            haserror = true;

        } else
        {

            sts = getclient(name).getStatement();

        }
        return sts;

    }

    public String getstatementstring(String name) {

        String sttmntstring = "";
        if (isclient(name) == true && getStatement(name) != null)
        {
            for (int i = 0; i < getclient(name).getStatement().length; i++)
            {
                sttmntstring += getclient(name).getStatement()[i];
                if(i < getclient(name).getStatement().length - 1){
                    sttmntstring += ", " ;
                }
            }
        }else{

            sttmntstring = "Error: From-Account " + name + " does not exist";

        }
        return sttmntstring;


}



    public void deposit(String name, double amount) {
        if(isclient(name) == false ) {
            stat = "Error: To-Account "+ name +" does not exist" ;
            haserror = true ;
        }
        else if (amount <= 0) {
            stat =  "Error: Non-Positive Amount" ;
            haserror = true ;
        }else {
            getclient(name).deposit(amount);
            stat = getStringStatus() ;
        }
    }

    public void withdraw(String name, double amount) {
        if(isclient(name) == false) {
            stat = "Error: From-Account " + name + " does not exist" ;
            haserror = true ;
        }
        else if (amount <= 0) {
            stat =  "Error: Non-Positive Amount" ;
            haserror = true ;
        } else if( amount > getclient(name).getbalance() ) {
            stat = "Error: Amount too large to withdraw" ;
        }
        else {
            getclient(name).withdraw(amount);
            stat = getStringStatus() ;
        }
    }

    public void transfer(String fromname, String toname, double transamount) {

        if(isclient(fromname) == false) {
            stat = "Error: From-Account " + fromname + " does not exist" ;
            haserror = true ;
        }
        else if(isclient(toname) == false) {
            stat = "Error: To-Account " + toname + " does not exist" ;
            haserror = true ;
        }
        else if (transamount <= 0) {
            stat =  "Error: Non-Positive Amount" ;
            haserror = true ;
        } else if( transamount > getclient(fromname).getbalance() ) {
            stat = "Error: Amount too large to transfer" ;
            haserror = true ;
        }
        else {

            withdraw(fromname, transamount);
            stat = getStringStatus() ;
            deposit(toname, transamount);
            stat = getStringStatus() ;

        }
    }



    public void addClient(String newname, double initbalance) {

        if(noc >= maxnumofclients) {
            this.stat =  "Error: Maximum Number of Accounts Reached" ;
            haserror = true ;

        }
//
        else if(isclient(newname) == true) {
            this.stat = "Error: Client " + newname +" already exists" ;
            haserror = true ;

        }

        else if(initbalance <= 0) {
            this.stat = "Error: Non-Positive Initial Balance" ;
            haserror = true ;
        }
        else  {
            this.client[noc] = new Client(newname, initbalance) ;
            noc++ ;
            stat = getStringStatus() ;


        }

    }
}
