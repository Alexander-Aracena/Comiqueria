package com.minpay.Comiqueria.dto.request;

public record ResetPasswordRequestDTO(
    String token,
    String newPassword
) {}
