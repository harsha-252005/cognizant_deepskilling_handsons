package com.fse.tdd;
public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) { this.repository = repository; }
    public boolean create(String reference) {
        if (reference == null || reference.isBlank() || repository.existsByReference(reference)) return false;
        repository.save(reference); return true;
    }
}
