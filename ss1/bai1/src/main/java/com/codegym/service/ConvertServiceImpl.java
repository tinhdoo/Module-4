package com.codegym.service;

import com.codegym.exception.ConvertException;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    private final double rate = 25000;

    @Override
    public double convert(double usd) {
        if (usd < 0) {
            throw new ConvertException("Số tiền USD không được âm!");
        }
        if (Double.isNaN(usd) || Double.isInfinite(usd)) {
            throw new ConvertException("Giá trị nhập vào không hợp lệ!");
        }
        return usd * rate;
    }
}

