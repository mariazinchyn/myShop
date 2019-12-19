package com.mariazinchyn.myshop.service;

        import com.mariazinchyn.myshop.dto.request.ProductRequest;
        import com.mariazinchyn.myshop.dto.response.PageResponse;
        import com.mariazinchyn.myshop.dto.response.ProductResponse;
        import com.mariazinchyn.myshop.entity.Product;
        import com.mariazinchyn.myshop.exception.NoMatchesException;
        import com.mariazinchyn.myshop.repository.ProductRepository;
        import com.mariazinchyn.myshop.repository.SubcategoryRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Sort;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.CrossOrigin;

        import java.io.IOException;
        import java.util.List;
        import java.util.stream.Collectors;


@Service
public class ProductService{
        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private SubcategoryService subcategoryService;

        @Autowired
        private FileService fileService;




        public void save(ProductRequest request) throws IOException{
                productRepository.save(productRequestToProduct(null, request));
        }

        public PageResponse<ProductResponse> findPage(Integer page, Integer size, String fieldName, Sort.Direction direction) {
                Page<Product> data = productRepository.findAll(PageRequest.of(page, size, direction, fieldName));
                List<ProductResponse> collect = data.get().map(ProductResponse::new).collect(Collectors.toList());
                return new PageResponse<>(data.getTotalElements(),
                        data.getTotalPages(),
                        collect);
        }

        public void update(ProductRequest request, Long id) throws IOException{
            productRepository.save(productRequestToProduct(findOne(id), request));
        }


           public Product findOne(Long id) {
              return    productRepository.findById(id).orElseThrow(()-> new NoMatchesException("with id " + id + " not exist."));


        }

        private Product productRequestToProduct(Product product,ProductRequest request) throws IOException{
                if(product == null) {
                        product = new Product();
                }
                        product.setName(request.getName());
                        product.setSize(request.getSize());
                        product.setPhoto(request.getPhoto());
                        //product.getPhoto(request.getPhoto());
                        product.setSubcategory(subcategoryService.findOne(request.getSubcategoryId()));
                        return product;
                }

        public ProductResponse findOneResponse(Long id) {
               return new ProductResponse(findOne(id));

       }




        }







