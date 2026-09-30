package com.minpay.Comiqueria.service.interfaces;

import com.minpay.Comiqueria.dto.request.LoginRequestDTO;
import com.minpay.Comiqueria.dto.response.LoginResponseDTO;
import com.minpay.Comiqueria.dto.request.RegisterRequestDTO;
import com.minpay.Comiqueria.dto.response.UsuarioResponseDTO;

public interface IAuthService {
    LoginResponseDTO login(LoginRequestDTO request);
    UsuarioResponseDTO register(RegisterRequestDTO request);
    String forgotPassword(String email);
    UsuarioResponseDTO resetPassword(String token, String newPassword);
    LoginResponseDTO forceChangePassword(String nombreUsuario, String nuevaContrasenia);
}