package cl.alreduxy.security.repositories;

import cl.alreduxy.security.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
