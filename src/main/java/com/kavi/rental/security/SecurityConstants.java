package com.kavi.rental.security;

// @TODO: move to properties
public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 600_000; // 10 min , 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";

    // jwt header attribute keys
    public static final String JWT_ATTR_REPO_URL = "AppUrl";
    public static final String JWT_ATTR_EMAIL = "email";
    public static final String JWT_ATTR_USERTYPE = "UserType";
    public static final String JWT_ATTR_ = "Authorization";

    // public urls
    public static final String[] PUBLIC_URLS = new String[]{
            SIGN_UP_URL,
            "/vehicle",
            "/vehicle/{id}",
            "/vehicle/car/",
            "/vehicle/car/{id}",
            "/vehicle/lorry",
            "/vehicle/lorry/{id}"
    };
}
