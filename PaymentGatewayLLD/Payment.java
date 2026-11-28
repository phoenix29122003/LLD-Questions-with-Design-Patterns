package PaymentGatewayLLD;

import java.util.UUID;

public class Payment {
    public String id;
    public Integer amount;
    public PaymentMethod paymentMethod;
    public PaymentStatus status;

    public Payment(Integer amount, PaymentMethod paymentMethod){
        this.id=UUID.randomUUID().toString();
        this.amount=amount;
        this.paymentMethod=paymentMethod;
        this.status=PaymentStatus.CREATED;
    }
}
