package com.mariazinchyn.myshop.service;

        import com.mariazinchyn.myshop.dto.request.ProductRequest;
        import com.mariazinchyn.myshop.dto.response.ProductResponse;
        import com.mariazinchyn.myshop.entity.Product;
        import com.mariazinchyn.myshop.exception.NoMatchesException;
        import com.mariazinchyn.myshop.repository.ProductRepository;
        import com.mariazinchyn.myshop.repository.SubcategoryRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class ProductService{
        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private SubcategoryService subcategoryService;

        public void save(ProductRequest request){
                productRepository.save(productRequestToProduct(null, request));
        }

        public void update(ProductRequest request, Long id){
            productRepository.save(productRequestToProduct(findOne(id), request));
        }


           public Product findOne(Long id) {
              return    productRepository.findById(id).orElseThrow(()-> new NoMatchesException("with id " + id + " not exist."));

        }

        private Product productRequestToProduct(Product product,ProductRequest request){
                if(product == null) {
                        product = new Product();
                }
                        product.setName(request.getName());
                        product.setSize(request.getSize());
                        product.setImage(request.getImage());
                        product.setSubcategory(subcategoryService.findOne(request.getSubcategoryId()));
                        return product;
                }
        }







