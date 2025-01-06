package com.aruizmontana.literatura.domain.response;


public record Result<R, E>(R success, E error) {

    public static <R, E> Result<R, E> success(R result) {
        return new Result<>(result, null);
    }

    public static <R, E> Result<R, E> error(E error) {
        return new Result<>(null, error);
    }

    public boolean isSuccess() {
        return this.error == null;
    }

    @Override
    public R success() {
        if (!isSuccess()) {
            throw new IllegalStateException("No success value present");
        }
        return success;
    }

    @Override
    public E error() {
        if (isSuccess()) {
            throw new IllegalStateException("No error value present");
        }
        return error;
    }
}



