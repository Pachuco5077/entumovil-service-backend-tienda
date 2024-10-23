package cu.entumovil.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.entumovil.ecommerce.entity.PaymentEntity;

public interface PaymentRepository  extends JpaRepository<PaymentEntity, Long> {	
	
}
