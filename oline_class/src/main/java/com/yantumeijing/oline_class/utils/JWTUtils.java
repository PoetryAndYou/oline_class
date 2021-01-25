package com.yantumeijing.oline_class.utils;

import com.yantumeijing.oline_class.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT工具类
 * 1. toke,是可以base64进行解密铭文信息的
 * 2. base64进行解密出铭文信息，修改在进行编码， 则会失败
 * 3. 无法作废已颁布的token,除非改密钥
 */
public class JWTUtils {

    /*
     * 过期时间
     */
    private static final long EPIRE = 60000 * 60 * 24 * 7;
    /*
     * 加密秘钥
     */
    private static final String SECRET = "ytmj.cn";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "ytmj";

    /**
     * subject
     */
    private static final String SUBJECT = "ytmj";

    /**
     * 根据用户信息生成令牌
     *
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user) {
        String token = Jwts.builder().setSubject(SUBJECT)//主题
                .claim("head_img", user.getHeadImg()) //payload负载
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date())//下发时间
                .setExpiration(new Date(System.currentTimeMillis() + EPIRE))//过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}
