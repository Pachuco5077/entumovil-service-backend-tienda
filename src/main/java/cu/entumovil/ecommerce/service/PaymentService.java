package cu.entumovil.ecommerce.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import cu.entumovil.ecommerce.dto.PaymentResponse;
import cu.entumovil.ecommerce.entity.PaymentEntity;
import cu.entumovil.ecommerce.model.Payment;
import cu.entumovil.ecommerce.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public PaymentResponse newPayment(Payment payment) throws UnirestException {
		Map<String, Object> paymentMap = new HashMap<>();
		paymentMap.put("idusuario", payment.getIdusuario());
		paymentMap.put("nombreusuario", payment.getNombreusuario());
		paymentMap.put("pagado", payment.getPagado());
		paymentMap.put("reference", payment.getReference());
		paymentMap.put("concept", payment.getConcept());
		paymentMap.put("description", payment.getDescription());
		paymentMap.put("amount", payment.getAmount());
		paymentMap.put("currency", payment.getCurrency());
		paymentMap.put("expirationDays", payment.getExpirationDays());
		paymentMap.put("runway", payment.getRunway());
		paymentMap.put("confirmationRute", payment.getConfirmationRute());
		paymentMap.put("merchant", payment.getMerchant());
		paymentMap.put("successUrl", payment.getSuccessUrl());
		paymentMap.put("urlretorno", payment.getUrlretorno());
		paymentMap.put("errorUrl", payment.getErrorUrl());

		
		String url = "http://localhost:8091/checkout/newPay";
		//String authHeader = "Bearer " + token;
		//HttpHeaders headers = new HttpHeaders();
		//headers.set("Authorization", authHeader);
		//headers.set("Accept", "application/json");

		HttpResponse<String> response = Unirest.post(url)
				//.header("Authorization", authHeader)
				.header("Content-Type", "application/json")
				//.header("Accept", "application/json")
				.body(new Gson().toJson(paymentMap))
				.asString();

		System.out.println(" ......response: " + response.getBody().toString());

		PaymentResponse conv = new Gson().fromJson(response.getBody(), PaymentResponse.class);
		//ResponseEntity.status(HttpStatus.FOUND).location(URI.create( conv.getShortUrl())).build();
		return conv;
	}


	public PaymentEntity save(Payment payment) {
		PaymentEntity paymentEntity = new PaymentEntity();
		try {
			paymentEntity.setIdusuario(payment.getIdusuario());
			paymentEntity.setNombreusuario(payment.getNombreusuario());
			paymentEntity.setPagado(payment.getPagado());
			paymentEntity.setReference(payment.getReference());
			paymentEntity.setConcept(payment.getConcept());
			paymentEntity.setDescription(payment.getDescription());
			paymentEntity.setAmount(payment.getAmount());
			paymentEntity.setCurrency(payment.getCurrency());
			paymentEntity.setExpirationDays(payment.getExpirationDays());
			paymentEntity.setRunway(payment.getRunway());
			paymentEntity.setConfirmationRute(payment.getConfirmationRute());
			paymentEntity.setMerchant(payment.getMerchant());
			paymentEntity.setSuccessUrl(payment.getSuccessUrl());
			paymentEntity.setUrlretorno(payment.getUrlretorno());
			paymentEntity.setErrorUrl(payment.getErrorUrl());
		}
		catch (Exception e) {
			System.out.println("Error al guardar en DB: " + e.getMessage());
		}
		return paymentRepository.save(paymentEntity);
	}
}
