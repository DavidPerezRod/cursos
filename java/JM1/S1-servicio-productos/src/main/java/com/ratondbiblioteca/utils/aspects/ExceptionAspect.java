package com.ratondbiblioteca.utils.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class ExceptionAspect {
 
 @Pointcut("@annotation(com.ratondbiblioteca.utils.aspects.ExceptionControl)")
 public void exceptionControl() {}
 
 @Around("@annotation(com.ratondbiblioteca.utils.aspects.ExceptionControl)")
// @Around("execution(* *(..)) && @annotation(exceptionControl)")
 public Object catchException(ProceedingJoinPoint joinpoint) throws Throwable {
  Object exit = null;
  log.info("se entra en el aspecto");
  try {
   exit = joinpoint.proceed();
  } catch (Exception except) {
   log.info("Excepcion capturada en el advice: "+except.getMessage(), except);
   throw  new AlmJpaRepoException(except);
  }
  return exit;
 }
}