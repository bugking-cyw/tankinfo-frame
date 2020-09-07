package com.tankinfo.receivable.imp.feign;

import com.tankinfo.auth.api.service.AuthService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("tankinfo-auth")
public interface AuthServiceFeign extends AuthService {
}
