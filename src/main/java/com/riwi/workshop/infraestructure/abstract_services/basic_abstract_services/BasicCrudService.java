package com.riwi.workshop.infraestructure.abstract_services.basic_abstract_services;

public interface BasicCrudService<RCQ, RUQ, RS, BRS, ID> extends
        CreateService<RCQ, BRS>,
        GetService<RS, ID>,
        UpdateService<RS, RUQ, ID>,
        DeleteService<ID> {
}