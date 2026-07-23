package com.fse.logging;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
public class PaymentProcessor { private static final Logger log = LoggerFactory.getLogger(PaymentProcessor.class); public boolean process(String id, double amount) { if (amount <= 0) { log.warn("Rejected payment {} because amount {} is invalid", id, amount); return false; } try { if (amount > 100000) throw new IllegalStateException("approval required"); log.info("Processed payment {}", id); return true; } catch (RuntimeException exception) { log.error("Payment {} failed", id, exception); return false; } } }
