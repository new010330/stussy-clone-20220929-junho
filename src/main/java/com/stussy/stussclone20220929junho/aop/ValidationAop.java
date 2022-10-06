package com.stussy.stussclone20220929junho.aop;

import com.stussy.stussclone20220929junho.exception.CustomValidationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ValidationAop {

    @Pointcut("@annotation(com.stussy.stussclone20220929junho.aop.annotation.ValidAspect)")
    private void pointCut() {}

    @Before("pointCut()")
    public void around(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null;

        for (Object arg : args) {
            if (arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if (bindingResult.hasErrors()) {
            log.error("유효성 검사 오류 발생");
            Map<String, String> errorMap = new HashMap<String, String>();

            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });

            throw new CustomValidationException("Validation failed", errorMap);
//            return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMap));
        }
    }
    @AfterReturning(value = "pointCut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        log.info("Validation success: {}", returnObj);
    }
}
