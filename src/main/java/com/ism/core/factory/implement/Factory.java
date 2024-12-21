package com.ism.core.factory.implement;

import com.ism.core.factory.IFactory;
import com.ism.core.factory.IFactoryRepository;
import com.ism.core.factory.IFactoryService;
import com.ism.core.factory.IFactoryView;

public class Factory implements IFactory {
    private static Factory instance;
    private IFactoryRepository factoryRepository;
    private IFactoryService factoryService;
    private IFactoryView factoryView;

    private Factory() {
        this.factoryRepository = new FactoryRepository();
        this.factoryService = new FactoryService(this.factoryRepository);
        this.factoryView = new FactoryView(this.factoryService);
    }

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    @Override
    public IFactoryRepository getFactoryRepository() {
        return this.factoryRepository;
    }

    @Override
    public IFactoryService getFactoryService() {
        return this.factoryService;
    }

    @Override
    public IFactoryView getFactoryView() {
        return this.factoryView;
    }
}