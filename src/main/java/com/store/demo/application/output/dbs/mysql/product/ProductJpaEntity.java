package com.store.demo.application.output.dbs.mysql.product;

import com.store.demo.application.output.dbs.mysql.order.OrderJpaEntity;
import com.store.demo.domain.entities.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "product")
public class ProductJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private int stockQuantity;
    @Column
    private String category;
    @ManyToMany
    private List<OrderJpaEntity> orders;

    public ProductJpaEntity() {
    }

    public ProductJpaEntity(Long id, String name, BigDecimal price, int stockQuantity, String category, List<OrderJpaEntity> orders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.orders = orders;
    }

    public static ProductJpaEntity from(Product product){
        var productJpaEntity = new ProductJpaEntity();
        productJpaEntity.id = product.getId();
        productJpaEntity.name = product.getName();
        productJpaEntity.price = product.getPrice();
        productJpaEntity.stockQuantity = product.getStockQuantity();
        productJpaEntity.category = product.getCategory();
        OrderJpaEntity.from(product.getOrder());
        return productJpaEntity;
    }

    public static List<ProductJpaEntity> from(List<Product> products) {
        var productsJpaEntities =  new ArrayList<ProductJpaEntity>();
        for (var product : products)
             {
                 var productJpaEntity = new ProductJpaEntity(
                         product.getId(),
                         product.getName(),
                         product.getPrice(),
                         product.getStockQuantity(),
                         product.getCategory(),
                         OrderJpaEntity.from(product.getOrder())
                 );
             }
            return productsJpaEntities;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<OrderJpaEntity> getOrder() {
        return orders;
    }

    public void setOrder(List<OrderJpaEntity> order) {
        this.orders = order;
    }
}