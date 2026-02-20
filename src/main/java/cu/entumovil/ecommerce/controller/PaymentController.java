package cu.entumovil.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@CrossOrigin(origins = {"http://localhost:3000/"}, allowCredentials = "true")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping("/newPay")
	public PaymentResponse createPaymentLink(@RequestBody Payment payment) throws UnirestException{
		PaymentResponse paymentResponse = new PaymentResponse();
		try {
			logger.info("* Iniciando intento de pago.");
			paymentResponse = paymentService.newPayment(payment);
			paymentService.save(payment);
		} catch (Exception e) {
			logger.error("* Error al procesar intento de pago en el servicio Checkout. {}", e.getMessage());
		}	
		return paymentResponse;
	}

	
	
}
