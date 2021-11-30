//package br.com.grabriellpa.casesapi.v1.interceptors;
//
//import br.com.grabriellpa.casesapi.v1.enums.CasesEnum;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class AuditInterceptor {
//
//    @Around("execution(* br.com.grabriellpa.casesapi.v1.controller.CasesController.collectCasesData(..))")
//    public Object auditMethod(ProceedingJoinPoint jp) throws Throwable {
//        Object[] args = jp.getArgs();
//        String methodName = jp.getSignature().getName();
////        args[0] = CasesEnum.CONFIRMED;
//
//        System.out.println(methodName);
//
//        return jp.proceed(args);
//    }
//}
