package com.alexisdrai;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

class pythNegArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of(0, 4, 5),
                         Arguments.of(3, 0, 4),
                         Arguments.of(4, 3, 0),
                         Arguments.of(-1, 5, 3),
                         Arguments.of(5, -1, 4),
                         Arguments.of(5, 4, -1));
    }
}
