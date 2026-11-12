package ParkingLotDesign;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override 
    public void processPayment(double amount){
        System.out.println("Payment made by upi of amount: "+amount);
    }
}
