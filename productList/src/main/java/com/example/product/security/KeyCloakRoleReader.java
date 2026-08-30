package com.example.product.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeyCloakRoleReader implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {

        Map<String,Object> realmeAccess = (Map<String, Object>) source.getClaims().get("realm_access");
        if (realmeAccess==null){
            return List.of();
//            return List.of((GrantedAuthority) ()->"ROLE_"+ realmeAccess.get("roles"));
        }

        Collection<GrantedAuthority> returnValue= ((List<String>) realmeAccess.get("roles")).stream()
                        .map(role->"ROLE_"+role)
                                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());

          return returnValue;

    }
}
