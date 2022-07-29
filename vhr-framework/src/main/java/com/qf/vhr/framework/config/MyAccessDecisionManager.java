package com.qf.vhr.framework.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Author 李小晖
 * @Date 2022/7/26 21:24
 * @Version IDEA 2022.1.1
 */

/**
 *   判断当前用户是否具备当前请求所需要的角色
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

     /**  核心的判断逻辑，如果当前用户权限不满足的话，那么直接抛出异常即可，如果这个方法
      *   整常执行完，那么就说明权限是满足的
      *
      * @param authentication 存放当前登录用户信息，这个里面就包含了当前登录用户的角色
      * @param object  这里面包含了当前请求
      * @param configAttributes  当前请求所需要的角色
      *
      * @throws AccessDeniedException
      * @throws InsufficientAuthenticationException
      */
     @Override
     public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
          // 1. 获取当前用户角色
          Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
          for (ConfigAttribute configAttribute : configAttributes) {
               // 2. 获取所需要的角色字符串
               String attribute = configAttribute.getAttribute();
               if ("ROLE_LOGIN".equals(attribute)){
                    // 说明当前请求登录之后，就可以访问，不需要做权限判断
                    if (authentication instanceof UsernamePasswordAuthenticationToken){
                         // 说明当前用户已经登录，则结束该判断角色方法
                         return;
                    }else {
                         // 说明当前用户没有登录
                         throw new AccessDeniedException("权限不足，请联系管理员获取权限");
                    }
               }
               // 遍历当前已经登录用户所具有的 角色
               for (GrantedAuthority authority : authorities) {
                    // 与当前请求所需要的角色去比对，看看是否相等
                    if (authority.getAuthority().equals(attribute)){
                         return;
                    }
               }
          }
          // 如果前面所有的 return 都没有执行，那么说明当前用户不具备当前请求所需要的权限
          throw new AccessDeniedException("权限不足，请联系管理员获取权限");
     }

     @Override
     public boolean supports(ConfigAttribute attribute) {
          return true;
     }

     @Override
     public boolean supports(Class<?> clazz) {
          return true;
     }
}
