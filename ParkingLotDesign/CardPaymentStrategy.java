package ParkingLotDesign;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override 
    public void processPayment(double amount){
        System.out.println("Payment made by card of amount: "+amount);
    }
}
