package com.telusko.ecom_proj.service;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product getProductById(int productId) {
        return repo.findById(productId).orElseThrow();
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {

        Product existingProduct = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Update normal fields
        existingProduct.setName(product.getName());
        existingProduct.setDesc(product.getDesc());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setReleaseDate(product.getReleaseDate());
        existingProduct.setAvailable(product.getAvailable());
        existingProduct.setQuantity(product.getQuantity());

        // Update image ONLY if new image uploaded
        if (imageFile != null && !imageFile.isEmpty()) {
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setImageType(imageFile.getContentType());
            existingProduct.setImageData(imageFile.getBytes());
        }

        return repo.save(existingProduct);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {

        return repo.searchProducts(keyword);
    }
}
