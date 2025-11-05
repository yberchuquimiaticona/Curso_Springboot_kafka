package dev.ychuquimia.product_service.Service;

import dev.ychuquimia.product_service.dto.ProductRequest;
import dev.ychuquimia.product_service.dto.ProductResponse;
import dev.ychuquimia.product_service.dto.ProductSummaryResponse;
import dev.ychuquimia.product_service.exception.ResourceNotFoundException;
import dev.ychuquimia.product_service.mapper.ProductMapper;
import dev.ychuquimia.product_service.model.Product;
import dev.ychuquimia.product_service.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class ProductService {

  private final ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public List<ProductResponse> findAll(String name) {
    List<Product> products = (name == null || name.isBlank())
        ? repository.findAll()
        : repository.findByNameContainingIgnoreCase(name);
    return products.stream()
        .map(ProductMapper::toResponse)
        .toList();
  }

  public ProductResponse findById(Long id) {
    Product product = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Producto " + id + " no encontrado"));
    return ProductMapper.toResponse(product);
  }

  @Transactional
  public ProductResponse create(ProductRequest request) {
    Product product = new Product();
    Product saved = repository.save(ProductMapper.toEntity(request, product));
    return ProductMapper.toResponse(saved);
  }

  @Transactional
  public ProductResponse update(Long id, ProductRequest request) {
    Product product = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Producto " + id + " no encontrado"));
    Product updated = repository.save(ProductMapper.toEntity(request, product));
    return ProductMapper.toResponse(updated);
  }

  @Transactional
  public void delete(Long id) {
    Product product = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Producto " + id + " no encontrado"));
    repository.delete(product);
  }

  public List<ProductSummaryResponse> findAllAndSumary() {
    List<Product> products = repository.findAll();
    return products.stream()
        .map(ProductMapper::toSummaryResponse)
        .collect(Collectors.toList());
  }
}
