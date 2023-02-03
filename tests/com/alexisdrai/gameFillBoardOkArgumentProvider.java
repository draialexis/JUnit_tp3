package com.alexisdrai;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class gameFillBoardOkArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(Arguments.of(new char[][]{     //start
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 0, 0, """
                                  x _ _\s
                                  _ _ _\s
                                  _ _ _\s"""),          //end
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 0, 1, """
                                  _ x _\s
                                  _ _ _\s
                                  _ _ _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 0, 2, """
                                  _ _ x\s
                                  _ _ _\s
                                  _ _ _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 1, 0, """
                                  _ _ _\s
                                  x _ _\s
                                  _ _ _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 1, 1, """
                                  _ _ _\s
                                  _ x _\s
                                  _ _ _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 1, 2, """
                                  _ _ _\s
                                  _ _ x\s
                                  _ _ _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 2, 0, """
                                  _ _ _\s
                                  _ _ _\s
                                  x _ _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 2, 1, """
                                  _ _ _\s
                                  _ _ _\s
                                  _ x _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', '_', '_'},
                                 {'_', '_', '_'}
                         }, 2, 2, """
                                  _ _ _\s
                                  _ _ _\s
                                  _ _ x\s"""),


                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', 'x', '_'},
                                 {'_', '_', '_'}
                         }, 1, 2, """
                                  _ _ _\s
                                  _ x o\s
                                  _ _ _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', '_'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', '_'}
                         }, 0, 2, """
                                  _ _ x\s
                                  _ x o\s
                                  _ _ _\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', 'x'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', '_'}
                         }, 2, 2, """
                                  _ _ x\s
                                  _ x o\s
                                  _ _ o\s"""),
                         Arguments.of(new char[][]{
                                 {'_', '_', 'x'},
                                 {'_', 'x', 'o'},
                                 {'_', '_', 'o'}
                         }, 2, 0, """
                                  _ _ x\s
                                  _ x o\s
                                  x _ o\s""")
        );
    }
}

