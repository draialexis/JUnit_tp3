package com.alexisdrai.tictactoe;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class gameFinishArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(Arguments.of((Object) new char[][]{{'o', 'x', 'o'}, {'o', 'x', 'x'}, {'x', 'o', 'x'}}),
                         // stalemate
                         Arguments.of((Object) new char[][]{{'x', 'o', '_'}, {'x', 'o', 'x'}, {'_', 'o', '_'}}),
                         // vertical w
                         Arguments.of((Object) new char[][]{{'_', 'o', 'o'}, {'_', '_', 'o'}, {'x', 'x', 'x'}}),
                         // horizontal w
                         Arguments.of((Object) new char[][]{{'x', '_', '_'}, {'_', 'x', 'o'}, {'o', '_', 'x'}}),
                         // diag top w
                         Arguments.of((Object) new char[][]{{'_', '_', 'o'}, {'_', 'o', 'x'}, {'o', 'x', 'x'}})
                         // diag bottom w
        );
    }
}
