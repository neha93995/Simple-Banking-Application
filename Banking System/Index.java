// Write a simple Banking System program by using OOPs concept where you can get account Holder name balance etc?

import java.util.*;


class Data{
    Scanner sc = new Scanner(System.in);
    
    protected ArrayList<String[]> userList = new ArrayList<>();
    private String list[][] =
    {
        {"id","account n0.","account type","Name","balance","number","pin"},
        {"1","1001","saving","Neha","4564563","929932","1010"},
        {"2","1002","saving","abhay","3455345","929932","1010"},
        {"3","1003","current","uday","453454","929932","1010"},
        {"4","1004","current","ambika","343342","929932","1010"},
        {"5","1005","saving","shivam","5645645","929932","1010"},
        {"6","1006","saving","ranjeet","76867","929932","1010"},
        {"7","1007","current","tanu","345745","929932","1010"},
    };
    
    // ------constructor for adding details array to Arraylist------------
    Data()
    {
        for(int i=0; i<list.length; i++)
        {
            userList.add(list[i]);
        }

    }


    
}



class Account extends Data{

    
    // -------------- open new account-----------------------

    public void addNewAccount(){
        
        System.out.println("Open New Account.....\n");
        String s[] = new String[userList.get(1).length];
        
        s[0]= ""+userList.size();
        s[1]=""+(userList.size()+1000);
        
        // take account details from user

        System.out.println("Account no. : "+s[1]);

        for(int i=2; i<s.length; i++)
        {
            System.out.print("enter "+userList.get(0)[i]+" : ");
            s[i] = sc.nextLine();
        }

        // add account to the acount list
        userList.add(s);
        System.out.println("\nNew Acount created Successfully ..... ");

        // print();
    }



    // -------deposite amount ----------

    public void depositeAmount(){

        System.out.println("Deposite Amount.....\n");
        
        System.out.print("Enter Account Number  :  ");
        int accNo = sc.nextInt();
        
        // search account 
        
        int id = accNo-1000;
        int balance = Integer.parseInt(userList.get(id)[4]);
        
        // take amount by user
        System.out.print("Enter amount to deposite  : ");
        int deposite = sc.nextInt();
        
        
        // add deposite amount to bank 
        
        userList.get(id)[4]=(balance+deposite)+"";
        System.out.println("\nAmount deposite Successful.....\n");
        // print();

    }
    

    // --------Withdraw amount -----------

    public void withdrawAmount()
    {
        System.out.println("\nWithdraw Amount.....\n");

        // take details for transection

        System.out.print("Enter Account Number  : ");
        int accNo = sc.nextInt();

        System.out.print("Enter amount for withdraw  : ");
        int withdraw = sc.nextInt();

        // check account and pin of user

        System.out.print("Enter Pin for checking!  :  ");
        int pin = sc.nextInt();

        int id = accNo-1000;

        if(pin==Integer.parseInt(userList.get(id)[6]))
        {
            // add new amount after transection 
            int remainingBalance = Integer.parseInt(userList.get(id)[4])-withdraw;
            if(remainingBalance<0)
            {
                System.out.println("\nsorry! you don't have enought amount.....!");
            }
            else{
                userList.get(id)[4] = remainingBalance+"";
                System.out.println("\nAmount Transection Successful.....\n");
            }

        }
        else
        {
            System.out.println("\nPin is not match.....!");
        }

        // print();

    }


    // -----------check balance----------

    public void checkBalanceAndDetails()
    {
        System.out.println("\nCheck Your Balance.....\n");

        // take account number for details

        System.out.print("Enter Account no :  ");
        int accNo  = sc.nextInt();

        int id = accNo-1000;

        // print details of account holder

        for(int i=1; i<userList.get(id).length; i++)
        {
            String format = " %1$-14s";
                String title = userList.get(0)[i];
                String value = userList.get(id)[i];
                System.out.println(title.format(format, title)+"  :  "+value.format(format, value));
        }

        // print();
  
    }


    // ----------list all account-----------

    public void listOfAccount()
    {
        System.out.println("\nList of Accounts .....\n");

        Iterator<String[]> itr = userList.iterator();

        //make table of all accounts

        while(itr.hasNext())
        {
            String s[] = (String[]) itr.next();
            for(int i=0;i<s.length-1; i++)
            {
                String format = "| %1$-14s";
                String str = s[i];
                String st = str.format(format, str);

                System.out.print(st);
            }
            System.out.println();
            
        }
    }


    public void print()
    {
        for(int i=0; i<userList.size(); i++)
        {
            System.out.println(Arrays.toString(userList.get(i)));
        }
    }

}





public class Index{

    public static void main(String[] args) {
        
        System.out.println("\n\n________________________________________Welcome To Bank Application________________________________________________\n\n");
        
        
        boolean isContinue =true;
        Account acc = new Account();
        
        // ------------------------repeating program until user don't want to exit---------
        
        while(isContinue)
        {
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------\n");
            
            System.out.println("What do you want to do \n ");
            System.out.print("  1. new Account  ");
            System.out.print("  2. Deposite Amount  ");
            System.out.print("  3. Withdraw Amount  ");
            System.out.print("  4. Check balance & details   ");
            System.out.print("  5. List all Account ");
            System.out.println("  6. Exit \n");
            
            
            System.out.print("Enter Operation : ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------\n\n");
            
           

            switch (option) 
            {
                case 1:
                {
                    acc.addNewAccount();
                    break;
                }
                case 2:
                {
                    acc.depositeAmount();
                    break;
                }
                case 3:
                {
                    acc.withdrawAmount();
                    break;
                }
                case 4:
                {
                    acc.checkBalanceAndDetails();
                    break;
                }
                case 5:
                {
                    acc.listOfAccount();
                    break;
                }
                case 6:
                {
                    System.out.println("\n\n____________________________________________________Thank You ____________________________________________________\n\n");
                    isContinue=false;
                    break;
                }
                default :
                {
                    System.out.println("Wrong input type! Enter number between 1 to 6");
                }
            
        }
        
    }
    
}

}