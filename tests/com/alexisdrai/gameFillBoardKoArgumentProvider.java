package com.alexisdrai;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class gameFillBoardKoArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        char[][] empty = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};

        return Stream.of(Arguments.of(empty, -1, 0, empty),
                         Arguments.of(empty, 0, -1, empty),
                         Arguments.of(empty, 0, 3, empty),
                         Arguments.of(empty, 3, 0, empty),
                         Arguments.of(new char[][]{{'_', '_', '_'}, {'_', 'x', '_'}, {'_', '_', '_'}},
                                      1,
                                      1,
                                      new char[][]{{'_', '_', '_'}, {'_', 'x', '_'}, {'_', '_', '_'}}));
    }
}
