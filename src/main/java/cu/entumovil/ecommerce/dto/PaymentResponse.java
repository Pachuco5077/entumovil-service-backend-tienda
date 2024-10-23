package cu.entumovil.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Data @Getter @Setter
public class PaymentResponse {
	private String id;
	private String reference;
	private String concept;
	private String description;
	private int amount;
	private String currency;
	private boolean singleUse;
	private int reasonId;
	private int	state;
	private String updatedAt;
	private String createdAt;
	private String qrImage;
	private String shortUrl;
	private String paymentUrl;
	private boolean	hasClient;
	private String serviceDate;
	private String expirationDate;
	private String urlNotification;
	private String urlFailed;
	private String urlSuccess;
	private String lang;
	private String userId;
	private Integer expirationDays;	
}
