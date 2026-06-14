package lk.jiat.rmi;

import lk.jiat.rmi.client.UserService;
import lk.jiat.rmi.model.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            //Can use LocateRegistry
            
//            Registry registry = LocateRegistry.getRegistry("localhost", 6666);
//            String[] list = registry.list();
//            for (String s : list) System.out.println(s);

            //Can use LocateRegistry

            //can use Naming

            //  UserService userService = (UserService) Naming.lookup("rmi://127.0.0.1:6666/user_service");

            //can use Naming


            //can use InitialContext

            Properties prop = new Properties();
            prop.put(Context.PROVIDER_URL, "rmi://localhost:6666");
            prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");

            InitialContext initialContext = new InitialContext(prop);
            UserService userService = (UserService) initialContext.lookup("user_service");

            //can use InitialContext

//            Message message = (Message) registry.lookup("message_service");
//            String msg = message.hello();
//            System.out.println(msg);
//            Integer total = 1000;
//            System.out.println("Hi " + message.getData().getName() + "Welcome");
//            System.out.println("=================== Your Account Details ==============");
//            System.out.println("Your account total: " + total);
//            System.out.print("Enter your amount to withdraw: ");
//            Integer amount = scanner.nextInt();
//            if (amount < 0) {
//                amount = 0;
//                System.out.println(" ");
//                System.out.println("Please enter a valid number");
//                System.out.print("Enter your amount to withdraw again: ");
//                amount = scanner.nextInt();
//            } else if (amount > total) {
//                amount = 0;
//                System.out.println(" ");
//                System.out.println("Amount exceeded than total. Please enter a valid amount");
//                System.out.print("Enter your amount to withdraw again: ");
//                amount = scanner.nextInt();
//            }
//            Integer result = message.getResult(total, amount);
//            System.out.println(" ");
//            System.out.println(" ");
//            System.out.println("=========== Transaction Successful ============");
//            System.out.println("Current Balance: " + result.toString());
//
//            System.out.println("********* Thank you for using us for your transaction *********");

//            UserService userService = (UserService) registry.lookup("user_service");
            userService.addUser(1,
                    new User(1, "Norlan", "Chilaw", "Norlan@gmail.com"));
            userService.getAllUsers().forEach(user -> {
                System.out.println(user.getName());
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
