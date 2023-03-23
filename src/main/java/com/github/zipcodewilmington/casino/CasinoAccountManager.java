package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CasinoAccountManager {
    char input1;
    Scanner input = new Scanner(System.in);
    private String userName2;
    private String password2;
    public static final String ANSI_RED = "\u001B[31m";

    private ArrayList<CasinoAccount> accountList = new ArrayList<CasinoAccount>();


    public void mainMenu() {



        CasinoAccount newAccount = new CasinoAccount();

        System.out.print("======================\n" +
                "=     Main Menu      =\n"
                + "======================\n"
                + "=      (L)ogin       =\n"
                + "=  (C)reate Account  =\n"
                + "=    (M)ore Info     =\n"
                + "======================\n");


        delay();


        System.out.println("Please input an option");

        while (true) {
            try {
                input1 = input.next().toLowerCase().charAt(0);
                switch (input1) {
                    case 'c':
                        newAccount = createAccount();
                        mainMenu();
                        break;
                    case 'm':
                        moreInfo();
                        break;
                    case 'l':
                        login();
                        break;

                    default:
                        System.out.println("Invalid Input");

                }


            } catch (InputMismatchException e) {
                System.out.print("Invalid number, Please input Number: ");
                input.nextLine();
            }
        }
    }


    public void moreInfo() {
        System.out.println(
                "=================================\n"
                        + "        Crystal Casino\n"
                        + "          Created by  \n"
                        + "Christa, Tim, Hiep, Andre, Jake\n"
                        + "\n"
                        + "    ZipCode Wilmington 9.4");

        //waits 1 second for next message

        delay();

        //asks user for input

        System.out.println("Press any key to continue");


        while (true) {
            input.next();
            break;
        }
        mainMenu();
    }

    public void login() {


        System.out.println("Welcome to Crystal Casino!");


        // while (true) {
        System.out.print(ANSI_RED + "Please enter your username:");
        userName2 = input.next();

        delay();

        System.out.print(ANSI_RED + "Please enter your password:");
        password2 = input.next();

        boolean loginCheck = false;
        int index = 0;

        for (int i = 0; i < accountList.size(); i++) {
            if (userName2.equals(accountList.get(i).getUserName())) {
                if (password2.equals(accountList.get(i).getPassword())) {
                    loginCheck = true;
                    index = i;
                    break;
                }
            }
        }

        if (loginCheck) {
            System.out.println("Login successful");
            delay();
            checkinLobby(accountList.get(index).getAccount());
        } else {
            System.out.println("Username or password is incorrect");
            mainMenu();
        }
    }


    public void checkinLobby(CasinoAccount account) {
        CasinoAccount z = account;
        System.out.print(
                "==============================\n"
                        + "=  Welcome to Check in Desk  =\n"
                        + "==============================\n"
                        + "= (E)nter Casino Game Lobby  =\n"
                        + "=       (G)et Balance        =\n"
                        + "=      (D)eposit Money       =\n"
                        + "=        (M)ain Menu         =\n"
                        + "=      (Q)uit and Save       =\n"
                        + "==============================\n");

        delay();

        // asks user for input

        System.out.println(ANSI_RED + "Please input an option");

        input1 = input.next().toLowerCase().charAt(0);
        switch (input1) {
            case 'm':
                mainMenu();
                break;

            case 'g':
                System.out.println("Your balance is: " + account.getBalance());
                delay();
                checkinLobby(z);
                break;

            case 'd':
                System.out.println(ANSI_RED + "How much do you want to deposit?");
                int deposit = input.nextInt();
                account.deposit(deposit);
                System.out.println("Your balance is: " + account.getBalance());
                update(account);
                System.out.println(accountList);
                delay();
                checkinLobby(z);
                break;

            case 'e':
                gameLobby(z);
                break;
            case 'q':

                quit();
                break;

            default:
                System.out.println("Invalid input");

        }


    }

    public void gameLobby(CasinoAccount account) {
        CasinoAccount z = account;
        System.out.println(z.getBalance());
        System.out.print(
                "=================================\n"
                        + "=     Welcome to Casino Lobby   =\n"
                        + "=================================\n"
                        + "=          (B)lack Jack         =\n"
                        + "=             (S)lots           =\n"
                        + "=          (C)huckALuck         =\n"
                        + "=           (R)oulette          =\n"
                        + "=           (K)londike          =\n"
                        + "=       (P)aperScissorRocks     =\n"
                        + "=        (M)ain Menu/Quit       =\n"
                        + "=================================\n");

        delay();

        // asks user for input

        System.err.println(ANSI_RED + "Please input an option");


        input1 = input.next().toLowerCase().charAt(0);
        switch (input1) {
            case 'm':
                mainMenu();
                break;

            case 'b':
                //blackjack()
                break;

            case 's':
                //slots();
                break;

            case 'c':
                //chuckaluck
                break;

            case 'r':
                //roulette
                break;

            case 'k':
                //klondike
                break;

            case 'p':
                //paperscissorrock
                break;

            default:
                System.out.println("Invalid Input");

        }
    }

    public static void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CasinoAccount createAccount() {

        CasinoAccount newAccount = null;

        System.out.println(ANSI_RED + "Please pick a username");
        String user = input.next();

        System.out.println(ANSI_RED + "Please input a password");
        String pass = input.next();

        boolean x = true;

        while (x) {
            int bal = getNumber(ANSI_RED + "How much do you want to deposit?"); // method asks how much a user wants to add

            if (bal > 0) {
                newAccount = new CasinoAccount(user, pass, bal);


                x = false;
            } else {
                System.out.println("Sorry you don't have enough money");
            }
        }




        System.out.println("Your account has been created");

        delay();

        System.out.println("Returning to Main Menu");

        delay();


        //console.mainMenu();


        accountList.add(newAccount);
        System.out.println(accountList);


        return newAccount;

    }

    int getNumber(String message) {
        while (true) {
            System.out.println(message);
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + input.next() + "\" isn't a number!\n");
            }
        }
    }

    public void quit() {
        try {
            File file = new File("hiep.txt");
            PrintStream writer = new PrintStream(file);
            for(CasinoAccount s : accountList){
                if(s != null) {
                    writer.println(s);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    public void update(CasinoAccount account) {
        for (int i = 0; i < accountList.size(); i++) {
            if (userName2.equals(accountList.get(i).getUserName())) {
                accountList.set(i, account);
            }
        }
    }

    public void read() throws FileNotFoundException {
        Scanner read = new Scanner(new File("hiep.txt"));
        String[] line;

        String username;
        String password;
        Integer balance = 0;

        while(read.hasNext()) {
            line = read.next().split(",");

            username = line[0];
            password = line[1];
            balance = Integer.parseInt(line[2]);
            CasinoAccount account = new CasinoAccount(username, password, balance);
            accountList.add(account);

        }

        System.out.println(accountList);
    }

}