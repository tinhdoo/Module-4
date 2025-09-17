package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public double calculator(double numA, double numB, String calculator) throws ArithmeticException {
        switch (calculator) {
            case "add":
                return numA + numB;
            case "sub":
                return numA - numB;
            case "mul":
                return numA * numB;
            case "div":
                if (numB == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                return numA / numB;
        }

        return 0;
    }
}
