package com.example.rest.api.ntt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationNtt implements Serializable {

    private String username;
    private String password;
}
