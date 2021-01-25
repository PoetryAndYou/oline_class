package com.yantumeijing.oline_class;

import com.yantumeijing.oline_class.model.entity.User;
import com.yantumeijing.oline_class.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class OlineClassApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGeneJwt() {
        User user = new User();
        user.setId(66);
        user.setName("下斗");
        user.setHeadImg("PNG");
        String token = JWTUtils.geneJsonWebToken(user);
        System.out.println(token);
        Claims claims = JWTUtils.checkJWT(token);
        System.out.println(claims.get("name"));
    }

//    private static checkJw
}
