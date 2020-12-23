package com.demo.recommend.dto;

import com.demo.recommend.domain.ContactEntity;
import com.demo.recommend.domain.ProductEntity;

public class ProductDto {

    private ContactEntity contact;
    private ProductEntity product;
    private double score;

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "contact=" + contact +
                ", product=" + product +
                ", score=" + score +
                '}';
    }
}
