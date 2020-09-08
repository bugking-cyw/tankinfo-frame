package com.tankinfo.sentinel.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/8 1:55 下午
 * @Description: Please Write notes scientifically
 * 网关限流 降级策略
 */
public class SentinelFallBackHandler implements BlockRequestHandler {

    private static final String DEFAULT_BLOCK_MSG = "操作过于频繁 请稍后重试";

    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
        return ServerResponse.status(200).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(buildErrorResult(throwable)));
    }

    private ErrorResult buildErrorResult(Throwable ex) {
        return new ErrorResult(200, DEFAULT_BLOCK_MSG);
    }



    private static class ErrorResult {
        private final int code;
        private final String message;

        ErrorResult(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

}
