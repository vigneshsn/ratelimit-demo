//package com.example.demo;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ProductService {
//
//    private OrderService orderService;
//   public List<Product> getProductsForCustomerID(String customerId, LocalDate startDate, LocalDate endDate) {
//
//       List<Order> orders = orderService.getAllOrders(); //database call or service
//
//       List<Product> products = orders.stream()
//               .filter(order -> customerId.equals( order.customer.id ))
//               .filter(order -> filterOrderByDate(startDate, endDate, order))
//               .flatMap(order -> order.products.stream())
//               .collect(Collectors.toList());
//       return products;
//   }
//
//    private boolean filterOrderByDate(LocalDate startDate, LocalDate endDate, Order order) {
//        return order.orderDate.isAfter(startDate) && order.orderDate.isBefore(endDate);
//    }
//}
//
//class Product {
//    String id;
//    String name;
//}
//
//class Order{
//    String id;
//    List<Product> products;
//    LocalDate orderDate;
//    Customer customer;
//}
//
//class Customer {
//    String id;
//    String name;
//}
