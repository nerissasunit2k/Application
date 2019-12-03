/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import application.Interfaces.Login;
import application.Interfaces.Register;
import application.Medicines.*;
import application.users.ListOfUser;
import application.users.Admin;
import application.users.Admin_Pharmacist;
import application.users.Customer;
import application.users.Customer_User;
import application.users.User;

/**
 *
 * @author 2ndyrGroupC
 */
public class Interfaces {

    private Register regis = new Register();
    private Admin admin = new Admin();
    private Customer custom = new Customer();
    private Scanner write = new Scanner(System.in);
    private ListOfUser useList = new ListOfUser();
    private Login log = new Login();
    private Admin_Pharmacist adminAccess = new Admin_Pharmacist();
    private Customer_User customerAccess = new Customer_User();
    private ListOfMedicine medList = new ListOfMedicine();

    public void Interface() {
        //instantiates the accountlist for admin and medicinelist
            useList.addItem(new Admin("nerissa", "sunit", 19,"admin","admin"));
           // useList.addItem(new Customer("gabrielle", "mendez", 20,"cs","cs"));
            medList.addMedicineList(new Allergies("semprex-d","acrivastine", "semprex-d", 200, 12));
            medList.addMedicineList(new Allergies("zyrtec","cetirizine", "zyrtec", 30, 10));
            medList.addMedicineList(new Allergies("tavist","clemastine", "tavist", 100, 11));
            medList.addMedicineList(new Headache("advil","ibuprofen", "advil", 200, 9));
            medList.addMedicineList(new Headache("aleve,","naproxen", "aleve,", 310, 8));
            medList.addMedicineList(new Headache("relpax","eletriptan", "relpax", 2500, 10));
            medList.addMedicineList(new Cough("vicks","dextromethorphan", "vicks", 100, 10));
            medList.addMedicineList(new Cough("delsym","extromethorphan", "delsym", 300, 10));
            medList.addMedicineList(new Cough("tessalon","benzonatate", "tessalon", 300, 10));
            medList.addMedicineList(new BodyPain("conzip","tramadol", "conzip", 300, 10));
            medList.addMedicineList(new BodyPain("motrin,","ibuprofen", "motrin,", 300, 10));
            medList.addMedicineList(new BodyPain("amitriptyline","amitriptyline", "amitriptylines", 300, 10));
        boolean end = true;
//all transaction
        while (end) {
            
            useList.displayAcc();
            //medList.viewList();
            int select = 0;
            System.out.println("press 1 to register\npress 2 to log in\npress 3 quit");
            try {
                select = write.nextInt();
            } catch (InputMismatchException e) {
                write.next();
                System.out.println("WRONG INPUT GIVEN!");
                continue;
            }
            switch (select) {
                //register
                case 1:
                    System.out.println("*REGISTER*");

                    boolean endRegis = true;
                    int selectRegister = 0;
                    while (endRegis) {
                        System.out.println("press 1 to register as admin\tpress 2 for customer");
                        try {
                            selectRegister = write.nextInt();
                            endRegis = false;
                        } catch (InputMismatchException e) {
                            System.out.println("WRONG INPUT GIVEN!");
                            write.next();

                        }
                    }

                    //register as admin or customer
                    regis.register(write);
                    if (selectRegister == 1) {
                        System.out.println("registered as admin");
                        admin = new Admin(regis.getFirstname(), regis.getLastname(), regis.getAge(), regis.getAccname(), regis.getPassword());
                        useList.addItem(admin);

                    } else {
                        System.out.println("registered as cutomer");
                        custom = new Customer(regis.getFirstname(), regis.getLastname(), regis.getAge(), regis.getAccname(), regis.getPassword());
                        useList.addItem(custom);
                    }
                    break;
                case 2:
                    //log In
                    adminAccess.setMedList(medList);
                    customerAccess.setMedList(medList);
                    System.out.println("LOG IN");
                    log.logIn(write);
                    String acc = log.getAccname();
                    String pass = log.getPassword();
                    if (useList.isVerified(acc, pass)) {
                        if (useList.isInstanceOfAdmin(acc)) {
                            
                            System.out.println("PHARMACIST");
                            adminAccess.AdminPrivilege(write);
                            medList.setMedicineList(adminAccess.getMedList().getMedicineList());
                        } else {
                            int age=useList.getAge(acc);
                            System.out.println("CUSTOMER");
                            System.out.println("Welcome to our pharmacy");
                            System.out.println("the customer has the age of "+age);
                            customerAccess.setAge(age);
                            customerAccess.CustomerPrivilege(write);
                            medList.setMedicineList(customerAccess.getMedList().getMedicineList());
                        }
                    } else {
                        System.out.println("INVALID USERNAME OR PASSWORD!");
                    }
                    break;
                case 3:
                    System.out.println("exiting app");
                    end = false;
                    break;
                default:
                    System.out.println("Please check your input!");
                    break;
            }

        }

    }

}
