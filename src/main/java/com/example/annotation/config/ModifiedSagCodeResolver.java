package com.example.annotation.config;

import com.example.annotation.annotation.SagRequestParam;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class ModifiedSagCodeResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(SagRequestParam.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        SagRequestParam annotation = parameter.getParameterAnnotation(SagRequestParam.class);
        String name = (annotation != null && StringUtils.hasLength(annotation.name())) ? annotation.name() : parameter.getParameterName();
        String sagCode = webRequest.getParameter(name);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object i = authentication.getPrincipal();

        return (StringUtils.hasLength(sagCode) && "AWS_AL".equals("AWS_AL")) ? SagModifierUtil.getUpdatedSubjectCode(sagCode) : sagCode;
    }
}