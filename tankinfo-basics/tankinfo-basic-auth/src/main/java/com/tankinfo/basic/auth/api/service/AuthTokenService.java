package com.tankinfo.basic.auth.api.service;

import com.tankinfo.basic.auth.api.AuthApi;
import com.tankinfo.basic.auth.domain.TokenDTO;
import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/24 10:31 上午
 * @Description: Please Write notes scientifically
 */

@RestController
public class AuthTokenService extends BaseApiService<TokenDTO> implements AuthApi {

    @Autowired
    private TokenEndpoint tokenEndpoint;


    @Override
    public BaseResponse<TokenDTO> accessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        TokenDTO oauth2TokenDto = TokenDTO.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead("Bearer ").build();
        return setResultSuccess(oauth2TokenDto);
    }
}
