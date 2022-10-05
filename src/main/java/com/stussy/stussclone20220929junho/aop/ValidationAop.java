package com.stussy.stussclone20220929junho.aop;

import com.stussy.stussclone20220929junho.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ValidationAop {

    @Pointcut("@annotation(com.stussy.stussclone20220929junho.aop.annotation.ValidAspect)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null;

        for (Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult == null) {
            return joinPoint.proceed();
        }

        if(bindingResult.hasErrors()) {
            log.error("유효성 검사 오류 발생");
            Map<String, String> errorMap = new HashMap<String, String>();

            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });

            return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMap));
        }
        return joinPoint.proceed();
    }
}
