package com.feeapp.feenotifier.domain.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {
    private T data;
    private Error error;

    public Response(T data, Error e) {
        this.data = data;
        this.error = e;
    }
}
