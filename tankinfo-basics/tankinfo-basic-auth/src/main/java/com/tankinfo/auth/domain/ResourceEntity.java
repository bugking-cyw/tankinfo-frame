package com.tankinfo.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/16 5:51 下午
 * @Description: Please Write notes scientifically
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceEntity {
    private String url;

    private String signType;

    private String signKey;

    private Long validTime;

    private String roleCodes;
}
