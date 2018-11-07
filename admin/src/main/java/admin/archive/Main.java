package admin.archive;

import dto.Country;
import dto.Manager;
import ejb.CountryEJB;
import ejb.ManagerEJB;
import ejb.UserEJB;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
/*
    @EJB
    private static ManagerEJB managerEJB;
    @EJB
    private static UserEJB userEJB;
    @EJB
    private static CountryEJB countryEJB;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try{
            System.out.println("Administrator Console\n");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void menu(){

        int option = -1;
        do{
            System.out.println();
            System.out.println("0- Exit");
            System.out.println("1- Populate (First Step)");
            System.out.println("2- List Managers");
            System.out.println("3- Add Manager");
            System.out.println("4- Delete Manager");
            System.out.println("5- List Users");
            System.out.println("6- Set subscription on");
            System.out.println("7- Set subscription off");
            System.out.print("> ");

            option = scanner.nextInt();

            switch (option){
                case 1:
                    populate();
                    break;
                case 2:
                    listManagers();
                    break;
                case 3:
                    addManager();
                    break;
                case 4:
                    deleteManager();
                    break;
                case 5:
                    listUsers();
                    break;
                case 6:
                    setSubscriptionOn();
                    break;
                case 7:
                    setSubscriptionOff();
                    break;
            }

        }while(option == 0);

    }

    public static void populate(){
        try{
            countryEJB.addAllCountry("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void listManagers(){
        try{
            List<dto.Manager> managers = managerEJB.getAllManagers("");

            for(dto.Manager manager : managers){
                System.out.println("[Id: " + manager.getId() +
                        " Name: " + manager.getName() +
                        " Email: " + manager.getEmail() +
                        " Phone Number:" + manager.getPhoneNumber() +
                        " BirthDate: " + manager.getBirthDate().toString() +
                        " Country: " + manager.getCountry() +
                        " Address: " + manager.getAddress() +
                        " Created Date: " + manager.getCreateDate().toString() + "]"
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void addManager(){
        String email, password, name, phoneNumber, birthDate, country, address;
        Date birthInDateFormat = null;
        Country countryFormat;
        do{
            System.out.println("Insert Email:");
            System.out.print("> ");
            email = scanner.nextLine();
        }while(email.length() == 0);

        do{
            System.out.println("Insert Password:");
            System.out.print("> ");
            password = scanner.nextLine();
        }while(password.length() == 0);

        do{
            System.out.println("Insert Name:");
            System.out.print("> ");
            name = scanner.nextLine();
        }while(name.length() == 0);

        do{
            System.out.println("Insert Phone Number:");
            System.out.print("> ");
            phoneNumber = scanner.nextLine();
        }while(phoneNumber.length() == 0);

        do {
            System.out.print("Insert BirthDate (dd/MM/yyyy): ");
            System.out.print("> ");
            birthDate = scanner.nextLine();

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            try
            {
                birthInDateFormat = df.parse(birthDate);
            }
            catch (ParseException e)
            {
                birthDate = "";
            }

        } while (birthDate.length() == 0);

        country = "Portugal";

        do{
            System.out.print("Insert Address: ");
            System.out.print("> ");
            address = scanner.nextLine();
        }while(address.length() == 0);




        try{
            countryFormat = countryEJB.getCountryByName("",country);
            dto.Manager manager = new Manager( -1,email,password,name,birthInDateFormat,
                    address,phoneNumber,null,null,countryFormat);

            managerEJB.addManager(manager);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteManager(){
        System.out.println("Insert the Manager's ID to delete: ");
        System.out.println("> ");
        long id = scanner.nextLong();

        try{
            managerEJB.deleteManager("",id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void listUsers(){
        try{
            List<dto.User> users = userEJB.adminOnlyListAllUsers();

            for(dto.User user : users){
                System.out.println("[Id: " + user.getId() +
                        " Name: " + user.getName() +
                        " Email: " + user.getEmail() +
                        " Phone Number:" + user.getPhoneNumber() +
                        " BirthDate: " + user.getBirthDate().toString() +
                        " Country: " + user.getCountry() +
                        " Address: " + user.getAddress() +
                        " Created Date: " + user.getCreateDate().toString() +
                        " Credit Card: " + user.getCreditCardNumber() +
                        " Is Subscribed: " + user.getHasSubscriptionUpToDate() + "]"
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void setSubscriptionOn(){
        System.out.println("Insert the User's ID to set Subscription On: ");
        System.out.println("> ");
        long id = scanner.nextLong();

        try{
            userEJB.adminOnlyUpdateUserSubscription(id,true);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void setSubscriptionOff(){
        System.out.println("Insert the User's ID to set Subscription Off: ");
        System.out.println("> ");
        long id = scanner.nextLong();

        try{
            userEJB.adminOnlyUpdateUserSubscription(id,false);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    */
}
