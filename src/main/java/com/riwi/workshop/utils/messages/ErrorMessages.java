package com.riwi.workshop.utils.messages;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ErrorMessages {
    public static String idNotFound(String entity) {
        final String message = "aqui no hay registros en la entidad %s con el id suministrado";
        return String.format(message, entity);
    }
}