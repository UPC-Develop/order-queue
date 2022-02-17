package pe.edu.upc.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.order.entity.ProductOrderCompositeEntity;
import pe.edu.upc.order.entity.ProductOrderEntity;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, ProductOrderCompositeEntity> {

}
