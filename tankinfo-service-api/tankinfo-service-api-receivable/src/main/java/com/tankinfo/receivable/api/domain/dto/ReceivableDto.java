package com.tankinfo.receivable.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 4:04 下午
 * @Description: Please Write notes scientifically
 */

@Data
@AllArgsConstructor
public class ReceivableDto {

    private String projectNo;

    private String chargeName;

    private Double total;

    private Double paid;

    private Double due;
}
