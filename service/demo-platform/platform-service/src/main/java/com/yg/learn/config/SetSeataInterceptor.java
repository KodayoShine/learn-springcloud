package com.yg.learn.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnClass({RequestInterceptor.class, GlobalTransactional.class})
public class SetSeataInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String currentXid = RootContext.getXID();
        if (!StringUtils.isEmpty(currentXid)) {
            template.header(RootContext.KEY_XID, currentXid);
        }
    }
}
