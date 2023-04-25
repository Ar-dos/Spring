package edu.school21.preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    public String preProcess(String input) {
        return input.toUpperCase();
    }
}
