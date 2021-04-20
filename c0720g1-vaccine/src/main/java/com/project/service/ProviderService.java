package com.project.service;

import com.project.entity.Provider;

public interface ProviderService {

    /**
     * TinVT
     * create Provider
     * @return
     */
    void createProvider(String name);

    /**
     * TinVT
     * find by name Provider
     * @return
     */
    Provider searchNameProvider(String name);
}

