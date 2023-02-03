package com.alexisdrai;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class gameFillBoardOkArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        char[][] empty = new char[][]{
                {'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}
        };

        return Stream.of(Arguments.of(empty, 0, 0, new char[][]{
                                 {'x', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }),

                         Arguments.of(empty, 0, 1, new char[][]{
                                 {'_', 'x', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }),

                         Arguments.of(empty, 0, 2, new char[][]{
                                 {'_', '_', 'x'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }),

                         Arguments.of(empty, 1, 0, new char[][]{
                                 {'_', '_', '_'},
                                 {'x', '_', '_'},
                                 {'_', '_', '_'}
                         }),

                         Arguments.of(empty, 1, 1, new char[][]{
                                 {'_', '_', '_'},
                                 {'_', 'x', '_'},
                                 {'_', '_', '_'}
                         }),

                         Arguments.of(empty, 1, 2, new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', 'x'},
                                 {'_', '_', '_'}
                         }),

                         Arguments.of(empty, 2, 0, new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'x', '_', '_'}
                         }),

                         Arguments.of(empty, 2, 1, new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', 'x', '_'}
                         }),

                         Arguments.of(empty, 2, 2, new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', 'x'}
                         }),

                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', 'x', '_'},
                                 {'_', '_', '_'}
                         }, 1, 2, new char[][]{
                                 {'_', '_', '_'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', '_'}
                         }),

                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', '_'}
                         }, 0, 2, new char[][]{
                                 {'_', '_', 'x'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', '_'}
                         }),

                         Arguments.of(new char[][]{
                                 {'_', '_', 'x'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', '_'}
                         }, 2, 2, new char[][]{
                                 {'_', '_', 'x'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', 'o'}
                         }),

                         Arguments.of(new char[][]{
                                 {'_', '_', 'x'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', 'o'}
                         }, 2, 0, new char[][]{
                                 {'_', '_', 'x'},
                                 {'_', 'x', 'o'},
                                 {'x', '_', 'o'}
                         }));
    }
}

