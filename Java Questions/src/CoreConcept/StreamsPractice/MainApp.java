package CoreConcept.StreamsPractice;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {

    public static class Product {
        private Long id;
        private String name;
        private String category;
        private Double price;

        public Product(Long id, String name, String category, Double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
        }

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        public Double getPrice() { return price; }
        public void setPrice(Double price) { this.price = price; }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", category='" + category + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static class Customer {
        private Long id;
        private String name;
        private Integer tier;

        public Customer(Long id, String name, Integer tier) {
            this.id = id;
            this.name = name;
            this.tier = tier;
        }

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public Integer getTier() { return tier; }
        public void setTier(Integer tier) { this.tier = tier; }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", tier=" + tier +
                    '}';
        }
    }

    public static class Order {
        private Long id;
        private String status;
        private LocalDate orderDate;
        private LocalDate deliveryDate;
        private List<Product> productsList;
        private Customer customer;

        public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate,
                     List<Product> productsList, Customer customer) {
            this.id = id;
            this.status = status;
            this.orderDate = orderDate;
            this.deliveryDate = deliveryDate;
            this.productsList = productsList;
            this.customer = customer;
        }

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public LocalDate getOrderDate() { return orderDate; }
        public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

        public LocalDate getDeliveryDate() { return deliveryDate; }
        public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }

        public List<Product> getProductsList() { return productsList; }
        public void setProductsList(List<Product> productsList) { this.productsList = productsList; }

        public Customer getCustomer() { return customer; }
        public void setCustomer(Customer customer) { this.customer = customer; }

        @Override
        public String toString() {
            return "Order{" +
                    "id=" + id +
                    ", status='" + status + '\'' +
                    ", orderDate=" + orderDate +
                    ", deliveryDate=" + deliveryDate +
                    ", productsList=" + productsList +
                    ", customer=" + customer +
                    '}';
        }
    }

    public static void main(String[] args) {

        Product p1 = new Product(1L, "baby", "Toys", 100.0);
        Product p2 = new Product(2L, "James Bond", "Books", 150.0);
        Product p3 = new Product(3L, "car1", "Baby", 106.0);
        Product p4 = new Product(4L, "carBook", "Books", 300.0);
        Product p5 = new Product(5L, "car2", "Baby", 200.0);

        List<Product> prodlist = Arrays.asList(p1, p2, p3, p4, p5);

        Customer c1 = new Customer(1L, "Mahesh", 1);
        Customer c2 = new Customer(2L, "Rajesh", 2);

        Order o1 = new Order(1L, "confirm", LocalDate.of(2021, 3, 15), LocalDate.now(), prodlist, c1);
        Order o2 = new Order(2L, "pending", LocalDate.of(2021, 2, 2), LocalDate.now(), prodlist, c2);
        Order o3 = new Order(3L, "pending", LocalDate.of(2021, 2, 4), LocalDate.now(), Arrays.asList(p1, p2), c1);

        List<Order> ordersList = Arrays.asList(o1, o2, o3);

        //Filter products with 'Books' category and price > 100
        prodlist.stream().filter(x -> x.price > 100 && x.category.equals("Books")).collect(Collectors.toList()).forEach(System.out::println);

        //List of orders with products belong to category 'Baby'
        ordersList.stream().filter(order -> order.getProductsList().stream().anyMatch(y -> y.category.equals("Baby"))).collect(Collectors.toList()).forEach(System.out::println);

        //List of products with category as 'Toys' and then apply 10% discount
        prodlist.stream().filter(x -> x.getCategory().equals("Toys")).map(x -> x.getPrice() - x.getPrice() * 0.1).collect(Collectors.toList()).forEach(System.out::println);

        //Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        ordersList.stream().filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().isAfter(LocalDate.parse("2021-02-01")) && order.getOrderDate().isBefore(LocalDate.parse("2021-04-01")))
                .map(Order::getProductsList).collect(Collectors.toList()).forEach(System.out::println);

        //Find Cheapest product for category = 'Books'
        System.out.print(prodlist.stream().filter(x-> x.getCategory().equals("Books")).min(Comparator.comparing(Product::getPrice)).get());

        //Get the 3 most recent placed order
        ordersList.stream().sorted(Comparator.comparing(Order::getOrderDate).reversed()).limit(3).collect(Collectors.toList()).forEach(System.out::println);

        //    Get list of orders which were ordered on 15 March-2021
        //    Log the order records to console and return its products list.
        List<Product> abc = ordersList.stream().filter(order -> order.getDeliveryDate().isEqual(LocalDate.parse("2021-03-15"))).peek(System.out::println)
                .flatMap(o -> o.getProductsList().stream()).collect(Collectors.toList());

        System.out.println(abc);

        //Calculate total lump sum of all orders placed in Feb 2021
        ordersList.stream().filter(order -> order.getOrderDate().isAfter(LocalDate.parse("2021-02-01")) && order.getOrderDate().isBefore(LocalDate.parse("2021-02-01")))
                .flatMap(Order-> Order.getProductsList().stream()).mapToDouble(Product::getPrice).sum();

        //Calculate order average payment placed on 15-Mar-2021
        ordersList.stream().filter(order -> order.getOrderDate().equals(LocalDate.parse("2021-03-15")))
                .flatMap(Order-> Order.getProductsList().stream()).mapToDouble(Product::getPrice).average().getAsDouble();


    }
}

