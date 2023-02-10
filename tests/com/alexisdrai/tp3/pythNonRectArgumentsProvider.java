package com.alexisdrai.tp3;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

class pythNonRectArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE),
                         Arguments.of(1, 1, 1),
                         Arguments.of(5, 6, 10));
    }
}
