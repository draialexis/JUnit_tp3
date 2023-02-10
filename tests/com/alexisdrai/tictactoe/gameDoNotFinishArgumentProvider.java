package com.alexisdrai.tictactoe;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class gameDoNotFinishArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(Arguments.of((Object) new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}}),
                         Arguments.of((Object) new char[][]{{'o', 'x', 'o'}, {'o', 'x', 'x'}, {'x', 'o', '_'}}),
                         Arguments.of((Object) new char[][]{{'_', '_', '_'}, {'_', 'x', '_'}, {'o', '_', '_'}}));
    }
}
