package com.mclx;

import org.springframework.beans.factory.FactoryBean;

public class RestServiceFactoryBean<T> implements FactoryBean<T> {

    private Class<T> type;
    private RestServiceFactory factory;


    @Override
    public T getObject() throws Exception {
        return null;
    }

    @Override
    public Class<T> getObjectType() {
        return type;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
