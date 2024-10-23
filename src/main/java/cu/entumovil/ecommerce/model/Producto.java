package cu.entumovil.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data @Getter @Setter
public class Producto {
	
	private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantEnStock;
    private String imagen;
}
