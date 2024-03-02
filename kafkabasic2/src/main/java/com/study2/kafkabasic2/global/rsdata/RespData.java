package com.study2.kafkabasic2.global.rsdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study2.kafkabasic2.global.standard.base.EmptyClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PRIVATE)
@Getter
public class RespData<T> {
    public static final RespData<EmptyClass> OK = of("200-1", "성공", new EmptyClass());
    @NonNull
    String resultCode;
    @NonNull
    int statusCode;
    @NonNull
    String msg;
    @NonNull
    T data;

    public static RespData<EmptyClass> of(String msg) {
        return of("200-1", msg, new EmptyClass());
    }

    public static <T> RespData<T> of(T data) {
        return of("200-1", "성공", data);
    }

    public static <T> RespData<T> of(String msg, T data) {
        return of("200-1", msg, data);
    }

    public static <T> RespData<T> of(String resultCode, String msg) {
        return of(resultCode, msg, (T) new EmptyClass());
    }

    public static <T> RespData<T> of(String resultCode, String msg, T data) {
        int statusCode = Integer.parseInt(resultCode.split("-", 2)[0]);

        RespData<T> tRsData = new RespData<>(resultCode, statusCode, msg, data);

        return tRsData;
    }

    @NonNull
    @JsonIgnore
    public boolean isSuccess() {
        return getStatusCode() >= 200 && getStatusCode() < 400;
    }

    @NonNull
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }

    public <T> RespData<T> newDataOf(T data) {
        return new RespData<>(resultCode, statusCode, msg, data);
    }
}
