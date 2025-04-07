package com.minpay.Comiqueria.mapper;

public interface IMapper<I, O> {
    public O map(I in);
    public O map(I in, O out);
}
