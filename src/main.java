
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        int option;

        do{
            menu();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> newClient(clients);                           //New client

                case 2 -> searchClient(clients);                        //Search client

                case 3 -> newProduct(products);                         //New product

                case 4 -> searchProduct(products);                      //Search product

                case 5 -> {
                    System.out.println("Case 5");                       //New sale
                    for(Client clientOfArray: clients){                 //Printing list of clients
                        System.out.println("Name: " + clientOfArray.name);
                        System.out.println("Address: " + clientOfArray.address);
                        System.out.println("Phone: " + clientOfArray.phone);
                        System.out.println("-------------------");
                    }
                    System.out.print("Select one of the clients above: ");
                    String clientSelected = sc.nextLine();

                    for(Product productOfArray: products){              //Printing list of products
                        System.out.println("Name: " + productOfArray.name);
                        System.out.println("Price: " + productOfArray.price);
                        System.out.println("Stock: " + productOfArray.quantity);
                        System.out.println("-------------------");
                    }
                    System.out.print("Select one of the products above: ");
                    String productSelected = sc.nextLine();
                    System.out.print("How many items? ");
                    int amountSelected = sc.nextInt();

                    for(Product productOfArray: products){          //Decrease the amount of products in stock
                        if(productSelected.equals(productOfArray.name)){
                            productOfArray.quantity = productOfArray.quantity - amountSelected;
                        }
                    }
//                    newSale(clients, products);
                }

                case 6 -> inventory(products);                          //Inventory

                case 7 -> System.out.println("Thank you! Come back later!");  //Leave

                default -> {
                    System.out.println("Invalid option!! Try again!!"); //Invalid option
                    option = sc.nextInt();
                }
            }
        }while(option != 7);
    }

    static void menu(){                                     //Menu function
        System.out.println("|------------------------|");
        System.out.println("| 1 - New client         |");
        System.out.println("| 2 - Search client      |");
        System.out.println("| 3 - New product        |");
        System.out.println("| 4 - Search product     |");
        System.out.println("| 5 - New sale           |");
        System.out.println("| 6 - Show inventory     |");
        System.out.println("| 7 - Leave              |");
        System.out.println("|------------------------|");
        System.out.print("Choose one of the above: ");
    }

    static void newClient(@NotNull ArrayList<Client> clients) {
        Scanner sc = new Scanner(System.in);
        Client client = new Client();                     //New client
        System.out.print("Client's name: ");
        client.name = sc.nextLine();

        System.out.print("Client's address: ");
        client.address = sc.nextLine();

        System.out.print("Client's phone: ");
        client.phone = sc.nextLine();
        clients.add(client);

        for (Client clientOfArray : clients) {
            System.out.println(clientOfArray.name);
            System.out.println(clientOfArray.address);
            System.out.println(clientOfArray.phone);
        }
    }

    static void newProduct(@NotNull ArrayList<Product> products){
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        System.out.print("Product: ");
        product.name = sc.nextLine();
        System.out.print("Product's description: ");
        product.description = sc.nextLine();
        System.out.print("Price: ");
        product.price = sc.nextDouble();
        System.out.print("Profit: ");
        product.profit = sc.nextDouble();
        System.out.print("How many products do you have in stock? ");
        product.quantity = sc.nextInt();
        products.add(product);
    }

    static void searchClient(@NotNull ArrayList<Client> clients){
        String searchName;
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        searchName = sc.nextLine();
        for (Client arrayOfClients : clients) {
            if (arrayOfClients.name.equals(searchName)) {
                System.out.println("Found!!");
                System.out.println("Name: " + arrayOfClients.name);
                System.out.println("Address: " + arrayOfClients.address);
                System.out.println("Phone: " + arrayOfClients.phone);
                System.out.print("Would you like to make some changes? ");
                String answer = sc.nextLine();
                if ((answer.equalsIgnoreCase("y"))) {
                    System.out.print("New name: ");
                    String newName = sc.nextLine();
                    System.out.print("Old name: " + arrayOfClients.name + "\nNew name: " + newName);
                    arrayOfClients.name = newName;
                    System.out.println("New name!!! " + arrayOfClients.name);

                    System.out.print("New address: ");
                    String newAddress = sc.nextLine();
                    System.out.print("Old address: " + arrayOfClients.address + "\nNew address: " + newAddress);
                    arrayOfClients.address = newAddress;
                    System.out.println("New address!!! " + arrayOfClients.address);

                    System.out.print("New phone: ");
                    String newPhone = sc.nextLine();
                    System.out.print("Old phone: " + arrayOfClients.phone + "\nNew phone: " + newPhone);
                    arrayOfClients.phone = newPhone;
                    System.out.println("New phone!!! " + arrayOfClients.phone);
                }
            } else {
                System.out.println("Client not found!!");
            }
        }
    }

    static void searchProduct(@NotNull ArrayList<Product> products){
        Scanner sc = new Scanner(System.in);
        String searchProduct;
        System.out.print("Name: ");
        searchProduct = sc.nextLine();
        for (Product arrayOfProducts : products) {
            if (arrayOfProducts.name.equals(searchProduct)) {
                System.out.println("Found!!");
                System.out.println("Product's name: " + arrayOfProducts.name);
                System.out.println("Product's description: " + arrayOfProducts.description);
                System.out.println("Product's profit: " + arrayOfProducts.profit);
                System.out.println("Product's price: " + arrayOfProducts.price);
                System.out.print("Would you like to make some changes? ");
                String answer = sc.nextLine();
                if ((answer.equalsIgnoreCase("y"))) {
                    System.out.print("New name: ");
                    String newName = sc.nextLine();
                    System.out.print("Old name: " + arrayOfProducts.name + "\nNew name: " + newName);
                    arrayOfProducts.name = newName;
                    System.out.println("New name!!! " + arrayOfProducts.name);

                    System.out.print("New description: ");
                    String newDescription = sc.nextLine();
                    System.out.print("Old description: " + arrayOfProducts.description + "\nNew address: " + newDescription);
                    arrayOfProducts.description = newDescription;
                    System.out.println("New description!!! " + arrayOfProducts.description);

                    System.out.print("New profit: ");
                    double newProfit = sc.nextDouble();
                    System.out.print("Old profit: " + arrayOfProducts.profit + "\nNew profit: " + newProfit);
                    arrayOfProducts.profit = newProfit;
                    System.out.println("New phone!!! " + arrayOfProducts.profit);

                    System.out.print("New price: ");
                    double newPrice = sc.nextDouble();
                    System.out.print("Old price: " + arrayOfProducts.price + "\nNew price: " + newPrice);
                    arrayOfProducts.price = newPrice;
                    System.out.println("New price!!! " + arrayOfProducts.price);

                    System.out.print("New amount: ");
                    int newQuantity = sc.nextInt();
                    System.out.print("Old amount: " + arrayOfProducts.quantity + "\nNew amount: " + newQuantity);
                    arrayOfProducts.quantity = newQuantity;
                    System.out.println("New amount!!! " + arrayOfProducts.quantity);
                }
            } else {
                System.out.println("Product not found!!");
            }
        }
    }

//       static void newSale(ArrayList<Client> clients, ArrayList<Product> products){
//           Scanner sc = new Scanner(System.in);
//
//           for(Client clientOfArray: clients){                      //Printing list of clients
//               System.out.println("Name: " + clientOfArray.name);
//               System.out.println("Address: " + clientOfArray.address);
//               System.out.println("Phone: " + clientOfArray.phone);
//               System.out.println("-------------------");
//           }
//           System.out.print("Select one of the clients above: ");
//           String clientSelected = sc.nextLine();
//
//           for(Product productOfArray: products){                   //Printing list of products
//               System.out.println("Name: " + productOfArray.name);
//               System.out.println("Price: " + productOfArray.price);
//               System.out.println("Stock: " + productOfArray.quantity);
//               System.out.println("-------------------");
//           }
//           System.out.print("Select one of the products above: ");
//           String productSelected = sc.nextLine();
//           System.out.print("How many items? ");
//           int amountSelected = sc.nextInt();
//           for(Product productOfArray: products){
//               if(productSelected.equals(productOfArray.name)){
//                   productOfArray.quantity = productOfArray.quantity - amountSelected;
//               }
//           }
//       }

    static void inventory(@NotNull ArrayList<Product> products){
        for(Product productOfArray: products){
            System.out.println("Name: " + productOfArray.name);
            System.out.println("Price: " + productOfArray.price);
            System.out.println("Stock: " + productOfArray.quantity);
            System.out.println("-------------------");
        }
    }
}
