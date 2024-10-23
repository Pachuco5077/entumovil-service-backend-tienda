package cu.entumovil.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.entumovil.ecommerce.entity.AplicationEntity;
import cu.entumovil.ecommerce.exception.ResourceNotFoundException;
import cu.entumovil.ecommerce.model.Aplicacion;
import cu.entumovil.ecommerce.repository.AplicacionRepository;

@RestController
//@RefreshScope
@RequestMapping("/ecommerce")
@CrossOrigin("http://localhost:2999/")
public class AplicacionController {
	@Autowired 
	private AplicacionRepository aplicacionRepository;

	@GetMapping("/all")
	public List<AplicationEntity> listarAplicaciones(){
		return aplicacionRepository.findAll();
	}
	
	@PostMapping("/save")
	public AplicationEntity guardarAplicacion(@RequestBody AplicationEntity aplicacion) {
		return aplicacionRepository.save(aplicacion);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AplicationEntity> listarAppPorId(@PathVariable Long id){
		Optional<AplicationEntity> aplicationEntity = null; 
		try {
			aplicationEntity = aplicacionRepository.findById(id);
		} catch (Exception e) {
			new ResourceNotFoundException("La app con ese ID no existe: " + id);
		}
		return ResponseEntity.ok(aplicationEntity.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AplicationEntity> actualizarAplicacion(@PathVariable Long id, @RequestBody AplicationEntity aplicacionRequest){
		Optional<AplicationEntity> aplicationEntity = null; 
		try {
			aplicationEntity = aplicacionRepository.findById(id);
		} catch (Exception e) {
			new ResourceNotFoundException("La app con ese ID no existe: " + id);
		}
		aplicationEntity.get().setNombre(aplicacionRequest.getNombre());
		aplicationEntity.get().setDescripcion(aplicacionRequest.getDescripcion());
		aplicationEntity.get().setPrecio(aplicacionRequest.getPrecio());
		aplicationEntity.get().setTamanno(aplicacionRequest.getTamanno());
		AplicationEntity appActualizado = aplicacionRepository.save(aplicationEntity.get());
		
		return ResponseEntity.ok(appActualizado);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarAplicacion(@PathVariable Long id){
		Optional<AplicationEntity> aplicacion = null; 
		try {
			aplicacion = aplicacionRepository.findById(id);
		} catch (Exception e) {
			new ResourceNotFoundException("La app con ese ID no existe: " + id);
		}
		aplicacionRepository.delete(aplicacion.get());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
