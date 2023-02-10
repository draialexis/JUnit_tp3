package com.alexisdrai.tp3;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

class pythBasicArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of(3, 4, 5),
                         Arguments.of(3, 5, 4),
                         Arguments.of(4, 3, 5),
                         Arguments.of(4, 5, 3),
                         Arguments.of(5, 3, 4),
                         Arguments.of(5, 4, 3));
    }

}
