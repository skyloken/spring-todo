package com.skyloken.todo.security;

import java.util.Map;

import com.skyloken.todo.model.MyUser;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.stereotype.Component;

@Component
public class ExtractPrincipal implements PrincipalExtractor {

    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        System.out.println(map);
        return new MyUser(map.get("name").toString());
    }

}

