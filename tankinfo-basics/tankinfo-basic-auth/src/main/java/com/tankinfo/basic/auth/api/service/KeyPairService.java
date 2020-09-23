package com.tankinfo.basic.auth.api.service;

import com.tankinfo.basic.auth.api.KeyPairApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



import java.util.Map;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/23 5:58 下午
 * @Description: Please Write notes scientifically
 */

@RestController
public class KeyPairService implements KeyPairApi {
    @Override
    public Map<String, Object> key() {
        return null;
    }

    /*@Autowired
    private KeyPair keyPair;
    @Override
    public Map<String, Object> key() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }*/
}
