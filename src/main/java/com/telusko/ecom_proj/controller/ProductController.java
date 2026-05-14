package com.telusko.ecom_proj.controller;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello World";
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile) {
        try {
            System.out.println(product);
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);

        } catch (Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {

        Product product = service.getProductById(productId);

        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }


    @PutMapping("/product/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @RequestPart("product") Product product,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile
    ) throws IOException {

        return service.updateProduct(id, product, imageFile);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){

        Product product = service.getProductById(id);
        if (product != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<Product>> searchProducts(String keyword){

        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

}
