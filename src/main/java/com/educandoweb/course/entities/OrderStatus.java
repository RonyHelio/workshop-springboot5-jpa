package com.educandoweb.course.entities;

public enum OrderStatus {
    Waiting_Payment(1),
    Paid(2),
    Shipped(3),
    Delivered(4),
    Cancelled(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        switch (code) {
            case 1:
                return Waiting_Payment;
                case 2:
                    return Paid;
                    case 3:
                        return Shipped;
                        case 4:
                            return Delivered;
                            case 5:
                                return Cancelled;
                                default:
                                    throw new IllegalArgumentException("Invalid order status");
        }
    }

}
