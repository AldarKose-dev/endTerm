package com.company.view;

import com.company.controllers.OrderController;
import com.company.controllers.ProductController;
import com.company.model.entities.Order;
import com.company.model.repositories.order.IOrderRepository;
import com.company.model.repositories.product.IProductRepository;

import java.util.*;

public class Application {
    private OrderController orderController; //private field orderController
    private ProductController productController; //create private field productController
    private Scanner scanner = new Scanner(System.in).useDelimiter("\\n"); //create object of scanner
    public int counter = 0;  //counter for ID of order

    public Application(IOrderRepository orderRepository, IProductRepository productRepository) {  //constructor for application
        orderController = new OrderController(orderRepository);
        productController = new ProductController(productRepository);
    }

    public void start() {      //start running the program
        int choice;  //variable for choice in loop
        do {     //start loop
            System.out.println("1 – Show clothes");
            System.out.println("2 – Sort clothes");
            System.out.println("3 – Order");
            System.out.println("4 – Exit");
            choice = scanner.nextInt();
            if (choice == 1) {
                productController.displayProducts();   //calling method that output all data from table "product"
            } else if (choice == 2) { //sorting
                String sql;   //create variable sql that will send statement based on what type of sorting was chosen
                System.out.println("Choose type of a sorting: \n" +
                        "1)Sort by price\n" +"2)Sort by gender\n" +"3)Sort by color\n" + "4)Sort by brand\n" + "5)Sort by category\n" + "6)Sort by size\n");
                int choose = scanner.nextInt();  //scan the choice
                switch (choose) {
                    case 1:   //sorting py price
                        System.out.println("Input minimal price");
                        String price = scanner.next();
                        sql = "select * from products where price>" + price + "order by product_id";// concatinate sql statement with price that was inputed
                        productController.displaySortedProducts(sql);  //send sql to method display sorted products
                        break;
                    case 2:  //sorting by gender
                        System.out.println("Input your gender(M for male, F for female)");
                        String gender = scanner.next();
                        sql = "select * from products where gender='" + gender + "' order by product_id";
                        productController.displaySortedProducts(sql);
                        break;
                    case 3:   //sorting by color
                        System.out.println("Input your color(blue,beige,black,camel,yellow,purple)");
                        String color = scanner.next();
                        sql = "select * from products where color='" + color + "' order by product_id";
                        productController.displaySortedProducts(sql);
                        break;
                    case 4:  //sorting by brand
                        System.out.println("Input your brand(ZARA,ASOS,Bershka,The North Face)");
                        String brand = scanner.next();
                        sql = "select * from products where brand='" + brand + "' order by product_id";
                        productController.displaySortedProducts(sql);
                        break;
                    case 5: //sorting by category
                        System.out.println("Input your category(trousers,outerwear,dresses,tops,skirts)");
                        String category = scanner.next();
                        sql = "select * from products where category='" + category + "' order by product_id";
                        productController.displaySortedProducts(sql);
                        break;
                    case 6:  //sorting by size
                        System.out.println("Input your size(XS,S,M,L,XL)");
                        String size = scanner.next();
                        sql = "select * from products where size='" + size + "' order by product_id";
                        productController.displaySortedProducts(sql);
                        break;
                }
            }
            else if(choice == 3){  //making an order
                purchaseProducts();  //calling method to purchase

            }
        }
        while (choice != 4); //condition of exiting the loop
    }
    private void purchaseProducts() {
        System.out.println("Select id of product you want to purchase");
        int productName = scanner.nextInt();
        System.out.println("Enter your phone:");
        String phone = scanner.next();
        System.out.println("Enter your address:");
        String adress = scanner.next();
        System.out.println("Enter your name");
        String name = scanner.next();
        orderController.createOrder(productName, adress, phone, name); //calling method createOrder with passing data about order
        counter++;
        seeOrder(counter);
    }

    private void seeOrder(int id){
        List<Order> order =orderController.getOrder(id); //method getOrder will return the value of created order with id
        for (Order orders:order) {
            System.out.println("Your order " + orders + "is recieved. Thanks for using our store!");
        }
    }
}
