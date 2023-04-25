package edu.school21.printer;

import edu.school21.preprocessor.PreProcessor;
import edu.school21.preprocessor.PreProcessorToUpperImpl;
import edu.school21.renderer.Renderer;
import edu.school21.renderer.RendererStandardImpl;

public class PrinterWithPrefixImpl implements Printer {

    private Renderer renderer;

    private String prefix;
    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void print(String input) {
        renderer.render(prefix  + " " + input);
    }

}
