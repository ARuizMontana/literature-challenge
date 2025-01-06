package com.aruizmontana.literatura.domain.response;

import retrofit2.Call;

import java.util.function.Function;

public class ApiResponse {
    public static <R, E> Result<R, E> tryCatch(Call<R> action, Function<Exception, E> errorHandler) {
        try {
            var response = action.execute();
            if (response.errorBody() != null) {
                return switch (response.code()) {
                    case 400 -> Result.error(errorHandler.apply(new Exception("Bad request")));
                    case 404 -> Result.error(errorHandler.apply(new Exception("Not found")));
                    case 408 ->
                            Result.error(errorHandler.apply(new Exception("Presentamos mucho trafico en las solicitudes, intentelo nuevamente mas tarde.")));
                    default -> Result.error(errorHandler.apply(new Exception("Error en el servicio de Gutendex")));
                };
            } else {
                if (response.isSuccessful()) {
                    return Result.success(response.body());
                } else {
                    return Result.error(errorHandler.apply(new Exception("Uknown error")));
                }
            }
        } catch (Exception e) {
            return Result.error(errorHandler.apply(e));
        }
    }
}
