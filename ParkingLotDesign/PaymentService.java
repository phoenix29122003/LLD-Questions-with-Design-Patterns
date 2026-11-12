package ParkingLotDesign;

public class PaymentService {
    public PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public void processPayment(double amount){
        paymentStrategy.processPayment(amount);
    }
}
