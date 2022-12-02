package com.adyen.checkout;

import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.model.Amount;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionResponse;
import com.adyen.service.Checkout;
import com.adyen.service.exception.ApiException;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, ApiException {

        Client client = new Client("AQEqhmfxJ4rMYxVGw0m/n3Q5qf3Ve4RZBZZIQXakQjKOUwqkt7plCWMlR7zoEMFdWw2+5HzctViMSCJMYAc=-iQZaq9A/OSCksF5ukdULZRnH5JUQCQM3p8HbMtKItBk=-TyQc_RC:JZ[9YY=y", Environment.LIVE, "1aa91d85f667dbfe-Sothebys");

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.setIdempotencyKey("UNIQUE-ID-dad126b9-d7b3-4d8d-adf0-7c6e324");

        Checkout checkout;
        checkout = new Checkout(client);


        CreateCheckoutSessionRequest checkoutSessionRequest = new CreateCheckoutSessionRequest();

        Amount amount = new Amount();
        amount.setCurrency("CNY");
        amount.setValue(10L);


        checkoutSessionRequest.setAmount(amount);
        checkoutSessionRequest.setMerchantAccount("SothebysCN-Marketplace");
        checkoutSessionRequest.setReturnUrl("http://5db9-14-136-214-22.ap.ngrok.io/redirect?orderRef=da301901-076b-4632-a2be-886b890cf22d");
        checkoutSessionRequest.setReference("2cac3158-5bb2-488e-869b-638c91d2e133");
        CreateCheckoutSessionResponse checkoutSessionResponse = checkout.sessions(checkoutSessionRequest);
        System.out.println(checkoutSessionResponse);

    }
}
