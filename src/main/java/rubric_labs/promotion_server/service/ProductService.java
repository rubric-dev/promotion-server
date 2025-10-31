package rubric_labs.promotion_server.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rubric_labs.promotion_server.domain.promotion.Product;
import rubric_labs.promotion_server.domain.promotion.ProductRepository;
import rubric_labs.promotion_server.response.ProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long saveProduct(Long companyId, Long mallId, String name, String code) {
        Product product = Product.of(companyId, mallId, name, code);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    public ProductResponse.Detail getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));
        return ProductResponse.Detail.from(product);
    }

    public ProductResponse.ListResponse getProductsByCompanyId(Long companyId) {
        List<Product> products = productRepository.findByCompanyId(companyId);
        return ProductResponse.ListResponse.from(products);
    }

    public ProductResponse.ListResponse getProductsByMallId(Long mallId) {
        List<Product> products = productRepository.findByMallId(mallId);
        return ProductResponse.ListResponse.from(products);
    }

    public ProductResponse.ListResponse getProductsByCompanyIdAndMallId(Long companyId, Long mallId) {
        List<Product> products = productRepository.findByCompanyIdAndMallId(companyId, mallId);
        return ProductResponse.ListResponse.from(products);
    }
}
