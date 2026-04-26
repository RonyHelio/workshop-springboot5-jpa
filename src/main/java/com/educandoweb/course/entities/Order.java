package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity //anotação que afirma que irá se tornar uma tabela
@Table(name = "tb_order")

public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "cliente_id") //Cria a coluna da chave estrangeira no banco
    private User client; //um pedido tem um cliente

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order( ) {

    }

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) //As duas entidades tem o mesmo ID
    private Payment payment;

    public Order(Long id, Instant moment, User client, OrderStatus order_status) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setStatus(order_status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
