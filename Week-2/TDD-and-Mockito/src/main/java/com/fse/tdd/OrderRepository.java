package com.fse.tdd;
public interface OrderRepository { boolean existsByReference(String reference); void save(String reference); }
