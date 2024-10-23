package cu.entumovil.ecommerce.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data @Getter @Setter
public class Combo {

	private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private List<Producto> productos;
    private String imagen;
    private String categoria;
	
}
