package com.tankinfo.admin.controller;

import com.tankinfo.admin.domain.Oauth2TokenDTO;
import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.security.Principal;
import java.util.Map;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/28 10:09 上午
 * @Description: Please Write notes scientifically
 */

@RestController
public class TokenController extends BaseApiService {

    @Resource
    private TokenEndpoint tokenEndpoint;


    @PostMapping("/oauth/token")
    BaseResponse<Oauth2TokenDTO> token(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDTO oauth2TokenDto = Oauth2TokenDTO.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead("Bearer ").build();
        return setResultSuccess(oauth2TokenDto);
    }
}
