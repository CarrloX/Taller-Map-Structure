package com.riwi.workshop.infraestructure.abstract_services.basic_abstract_services;

public interface UpdateService<RS, RUQ, ID> {
    public RS update(RUQ request, ID id);
}
