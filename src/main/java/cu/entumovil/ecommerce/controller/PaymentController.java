package cu.entumovil.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;

import cu.entumovil.ecommerce.dto.PaymentResponse;
import cu.entumovil.ecommerce.model.Payment;
import cu.entumovil.ecommerce.service.PaymentService;
import lombok.AllArgsConstructor;

@RestController
//@RefreshScope
@RequestMapping("/ecommerce")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:2999/"}, allowCredentials = "true")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/newPay")
	public PaymentResponse createPaymentLink(@RequestBody Payment payment) throws UnirestException{
		PaymentResponse paymentResponse = new PaymentResponse();
		try {
			paymentService.save(payment);
			paymentResponse = paymentService.newPayment(payment);
		} catch (Exception e) {
			System.out.println(" *-*-*-* Autenticando en la pasarela de pagos: " + e.getMessage());
		}	
		return paymentResponse;
	}

	
	
}
