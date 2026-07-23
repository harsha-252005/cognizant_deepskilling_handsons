package com.fse.tdd;
public class Calculator {
    public int add(int left, int right) { return left + right; }
    public int divide(int left, int right) {
        if (right == 0) throw new IllegalArgumentException("divisor must not be zero");
        return left / right;
    }
}
