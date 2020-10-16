package com.tankinfo.auth.mapper;

import com.tankinfo.auth.domain.ResourceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/16 5:54 下午
 * @Description: Please Write notes scientifically
 */

@Mapper
public interface ResourceEntityMapper {

    @Select({
        "SELECT",
            "re.content AS url,",
            "rs.sign_type,",
            "rs.sign_key,",
            "rs.valid_time,",
            "GROUP_CONCAT( r.role_code ) AS role_codes",
        "FROM",
            "resource re",
            "LEFT JOIN role_resource ur ON ur.resource_id = re.resource_id",
           " LEFT JOIN role r ON r.role_id = ur.role_id",
            "LEFT JOIN resource_sign rs ON rs.resource_id = re.resource_id",
        "WHERE",
            "re.resource_type = 'api'",
        "GROUP BY",
            "re.content"
    })
    List<ResourceEntity> resourceEnties();
}
