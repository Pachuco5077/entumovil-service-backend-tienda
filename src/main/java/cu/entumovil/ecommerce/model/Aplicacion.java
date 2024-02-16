package cu.entumovil.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data @Getter @Setter
public class Aplicacion {

	private long id;
	private String nombre;
	private String descripcion;
	private long precio;
	private long tamanno;
	
}