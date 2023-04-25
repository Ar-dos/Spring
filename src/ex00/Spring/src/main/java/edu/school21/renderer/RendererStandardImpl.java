package edu.school21.renderer;

import edu.school21.preprocessor.PreProcessor;
import edu.school21.preprocessor.PreProcessorToLowerImpl;

public class RendererStandardImpl implements Renderer {
    private PreProcessor preProcessor;
    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }
    public void render (String input) {
        System.out.println(preProcessor.preProcess(input));
    }
}
