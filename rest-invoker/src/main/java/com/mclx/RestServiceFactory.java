package com.mclx;


import com.google.common.collect.Maps;
import com.google.common.reflect.Reflection;
import com.mclx.annotation.RestUrl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

public class RestServiceFactory<T> {
    private static Map<Class, Map<Method, Object>> cache;

    public static <T> T newInstance(Class<T> type) {
        if (cache == null) {
            cache = Maps.newHashMap();
        }
        Map<Method, Object> methodInfo = cache.get(type);

        if (methodInfo == null) {

            methodInfo = Maps.newHashMap();

            for (Method method : type.getMethods()) {

                // method


            }


        }


        // TODO 先解析出来类的地址信息,缓存起来
        return Reflection.newProxy(type, (proxy, method, args) -> {
            for (Annotation declaredAnnotation : method.getDeclaredAnnotations()) {
                System.out.println(declaredAnnotation);
            }

            for (Parameter parameter : method.getParameters()) {


                System.out.println(parameter.getAnnotations()[0]);
            }


            return method.invoke(args);
        });
    }

    public static void main(String[] args) {
        RestService restService = newInstance(RestService.class);

        Map<String, Object> map = Maps.newHashMap();
        map.put("test", "luxin");
        String body = "{\"key\":\"improve\"}";
        restService.invoke(map, body);
    }

    private static class RestServiceResolver {
        private static Map<Class, Map<Method, Map<String, Object>>> cache;

        private static Map<Class, String> baseUrlCache;


        public static String getBaseUrl(Class type) {
            return baseUrlCache.get(type);
        }


        public static void resolve(Class type) {
            if (cache.get(type) == null || baseUrlCache.get(type) == null) {

                if (baseUrlCache == null) {
                    baseUrlCache = Maps.newHashMap();

                    String baseUrl = null;
                    for (Annotation declaredAnnotation : type.getDeclaredAnnotations()) {
                        if (declaredAnnotation instanceof RestUrl) {
                            baseUrl = ((RestUrl) declaredAnnotation).url();
                        }
                    }

                    if (baseUrl == null) {
                        throw new RuntimeException(type.getName() + " 必须有RestUrl注解!");
                    }


                }

            }


        }
    }


}
