package com.mini.coffzag.entity;

import com.mini.coffzag.dto.OrderRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "COFFEE_ID", nullable = false)
    private Long coffeeId;

    @Column(name = "ORDER_CNT", nullable = false)
    private Long orderCnt;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public Order(Long coffeeId, Long orderCnt, Cart cart) {
        this.coffeeId = coffeeId;
        this.orderCnt = orderCnt;
        this.cart = cart;
    }

    public void update(OrderRequestDto orderRequestDto) {
        this.orderCnt = orderRequestDto.getOrderCnt();
    }

}
