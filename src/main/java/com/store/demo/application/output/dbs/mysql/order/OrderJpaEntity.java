package com.store.demo.application.output.dbs.mysql.order;

import com.store.demo.application.output.dbs.mysql.client.ClientJpaEntity;
import com.store.demo.application.output.dbs.mysql.product.ProductJpaEntity;
import com.store.demo.domain.entities.Order;
import com.store.demo.domain.status.OrderStatus;
import com.store.demo.domain.status.PaymentMethod;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "orders")
public class OrderJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime orderDate;
    @Column
    private BigDecimal totalPrice;
    @Column
    private OrderStatus status;
    @Column
    private PaymentMethod paymentMethod;
    @Column
    private String shippingAddress;
    @ManyToOne(cascade = CascadeType.ALL)
    private ClientJpaEntity client;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<ProductJpaEntity> products;

    public OrderJpaEntity() {
    }

    public OrderJpaEntity(Long id,
                          LocalDateTime orderDate,
                          BigDecimal totalPrice,
                          OrderStatus status,
                          PaymentMethod paymentMethod,
                          String shippingAddress,
                          ClientJpaEntity client,
                          List<ProductJpaEntity> products) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.shippingAddress = shippingAddress;
        this.client = client;
        this.products = products;
    }

    public static OrderJpaEntity from (Order order){
        var orderJpaEntity = new OrderJpaEntity();
        orderJpaEntity.id = order.getId();
        orderJpaEntity.orderDate = order.getOrderDate();
        orderJpaEntity.totalPrice = order.getTotalPrice();
        orderJpaEntity.status = order.getStatus();
        orderJpaEntity.paymentMethod = order.getPaymentMethod();
        orderJpaEntity.client = ClientJpaEntity.from(order.getClient());
        orderJpaEntity.products = ProductJpaEntity.from(order.getProducts());
            return orderJpaEntity;
    }
    public static List<OrderJpaEntity> from(List<Order> orders) {
        var orderJpaEntities = new ArrayList<OrderJpaEntity>();
        for (var order : orders) {
            var orderJpaEntity = new OrderJpaEntity(
                    order.getId(),
                    order.getOrderDate(),
                    order.getTotalPrice(),
                    order.getStatus(),
                    order.getPaymentMethod(),
                    order.getShippingAddress(),
                    ClientJpaEntity.from(order.getClient()),
                    ProductJpaEntity.from(order.getProducts())
            );
            orderJpaEntities.add(orderJpaEntity);
        }
        return orderJpaEntities;
    }
}
