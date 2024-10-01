package com.recipesns.core.security.encoder;

public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String password, String encodedPassword);
}
