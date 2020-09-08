package com.tankinfo.sentinel.init;


import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;

import com.tankinfo.sentinel.handler.SentinelFallBackHandler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/8 12:36 下午
 * @Description: Please Write notes scientifically
 */
@Component
public abstract class SentinelSourceRegister implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        registerRollback();
        resisterApis();
    }

    public abstract void resisterApis();

    // 注册自定义分组
    /*public void resisterApis () {

        Set<ApiDefinition> definitions = new HashSet<>();
        ApiDefinition api1 = new ApiDefinition("cus-apis-receivable")
                .setPredicateItems(new HashSet<ApiPredicateItem>() {{
                    add(new ApiPathPredicateItem().setPattern("/takinfo-receivable/**").setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX));
                }});
        definitions.add(api1);
        //GatewayApiDefinitionManager.loadApiDefinitions(definitions);
        SentinelProperty<Set<ApiDefinition>> setSentinelProperty = new DynamicSentinelProperty(definitions);
        GatewayApiDefinitionManager.register2Property(setSentinelProperty);

    }*/

    public void registerRollback () {
        GatewayCallbackManager.setBlockHandler(new SentinelFallBackHandler());
    }


}
