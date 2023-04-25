package edu.school21.printer;

import edu.school21.preprocessor.PreProcessor;
import edu.school21.renderer.Renderer;

import java.time.LocalDateTime;
import java.time.Period;

public class PrinterWithDateTimeImpl implements Printer {

    private Renderer renderer;
    private String prefix;
    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String input) {
        renderer.render(LocalDateTime.now().toString() + " " + input);
    }
}
