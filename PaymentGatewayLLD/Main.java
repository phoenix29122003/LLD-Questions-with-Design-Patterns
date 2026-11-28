package PaymentGatewayLLD;

public class Main {
    public static void main(String args[]){
        PaymentGateway gateway=new PaymentGateway();

        Payment payment1=gateway.createPayment(1000, PaymentMethod.UPI);
        System.out.println();

        gateway.processPayment(payment1.id);
        System.out.println();

        gateway.refundPayment(payment1.id);
        System.out.println();

        gateway.showPaymentDetail(payment1.id);
        System.out.println();

        gateway.refundPayment(payment1.id);
        System.out.println();

        Payment payment2=gateway.createPayment(2000, PaymentMethod.NET_BANKING);
        System.out.println();

        gateway.failPayment(payment2.id);
        System.out.println();

        gateway.showPaymentHistory();
    }
}
