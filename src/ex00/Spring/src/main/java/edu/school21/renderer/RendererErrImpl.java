package edu.school21.renderer;

import edu.school21.preprocessor.PreProcessor;
import edu.school21.preprocessor.PreProcessorToLowerImpl;

public class RendererErrImpl implements Renderer {
    private PreProcessor preProcessor;
    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }
    public void render (String input) {
        System.err.println(preProcessor.preProcess(input));
    }

}
