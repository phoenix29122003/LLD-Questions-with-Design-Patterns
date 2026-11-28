package PaymentGatewayLLD;

import java.util.HashMap;
import java.util.Map;

public class PaymentGateway {
    public Map<String,Payment>payments;

    public PaymentGateway(){
        this.payments=new HashMap<>();
    }

    public Payment createPayment(Integer amount, PaymentMethod paymentMethod){
        if(paymentMethod==null){
            System.out.println("Give valid payment method");
            return null;
        }
        if(amount<=0){
            System.out.println("We cannot create payment for negative amount");
            return null;
        }
        Payment payment=new Payment(amount, paymentMethod);
        this.payments.put(payment.id, payment);
        System.out.println("Payment created with id: "+payment.id);
        return payment;
    }

    public void processPayment(String paymentId){
        Payment payment=payments.get(paymentId);
        if(payment==null){
            System.out.println("Payment id in invalid");
            return;
        }
        if(!payment.status.equals(PaymentStatus.CREATED)){
            System.out.println("Cannot process payment");
            return;
        }
        payment.status=PaymentStatus.SUCCESS;

        System.out.println("Payment with id: "+payment.id + " is succeeded.");
    }

    public void refundPayment(String paymentId){
        Payment payment=payments.get(paymentId);
        if(payment==null){
            System.out.println("Payment id in invalid");
            return;
        }
        if(!payment.status.equals(PaymentStatus.SUCCESS)){
            System.out.println("Cannot refund payment");
            return;
        }

        payment.status=PaymentStatus.REFUNDED;
        System.out.println("Payment with id: "+payment.id + " is refunded");
    }

    public void showPaymentDetail(String paymentId){
        Payment payment=payments.get(paymentId);
        if(payment==null){
            System.out.println("Payment id in invalid");
            return;
        }

        System.out.println("Here is the payment detail");
        System.out.println("Payment id: "+payment.id);
        System.out.println("Amount: "+payment.amount);
        System.out.println("Status: "+payment.status.toString());
        System.out.println("Payment method: "+payment.paymentMethod.toString());
    }

    public void failPayment(String paymentId){
        Payment payment=payments.get(paymentId);
        if(payment==null){
            System.out.println("Payment id in invalid");
            return;
        }

        if(!payment.status.equals(PaymentStatus.CREATED)){
            System.out.println("Cannot process payment");
            return;
        }
        payment.status=PaymentStatus.FAILED;

        System.out.println("Payment with id: "+payment.id + " is failed.");
    }

    public void showPaymentHistory(){
        if(payments.size()==0){
            System.out.println("No payments to show");
        }
        for(Payment payment:payments.values()){
            System.out.println("Payment id: "+payment.id + " Status: "+payment.status + " Amount: "+payment.amount + " Method: "+payment.paymentMethod);
        }
    }
}
