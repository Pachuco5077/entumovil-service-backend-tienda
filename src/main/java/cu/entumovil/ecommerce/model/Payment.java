package cu.entumovil.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data @Getter @Setter
public class Payment {

	private long id;
	private String idusuario;
	private String nombreusuario;
	private Boolean pagado = false;
	private String reference;
	private String concept;
	private String description;
	private long amount;
	private String currency;
	private int expirationDays;	
	private int runway;  //enzona=0, transf=1, tropipay=2
	private int confirmationRute; //0 para no confirmar, 1 por correo, 2 por sms
	private String merchant;   // aqui se pone el nombre del comercio q esta utilizando la PP
	private String successUrl;
	private String urlretorno;
	private String errorUrl;
	
}