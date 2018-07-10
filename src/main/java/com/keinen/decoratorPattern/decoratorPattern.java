package com.keinen.decoratorPattern;

// the window interface
interface Window {
    public void draw(); // draw the window
    public String getDescription();
}

// implementation of a simple window without any scrollbars
class SimpleWindow implements Window {
    public void draw() {
    }

    public String getDescription() {
        return "simple window";
    }
}

// abstract decorator class
abstract class WindowDecorator implements Window {
    protected Window decorateWindow; // the window being decorated
    public WindowDecorator(Window decorateWindow) {
        this.decorateWindow = decorateWindow;
    }
}

// the first concrete decorator which adds vertical scrollbar functionality
class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator(Window decorateWindow) {
        super(decorateWindow);
    }

    public void draw() {
        drawVerticalScrollBar();
        decorateWindow.draw();
    }

    private void drawVerticalScrollBar() {
    }

    public String getDescription() {
        return decorateWindow.getDescription() + ", includingn vertical scrollbars";
    }
}

class HorizontalScrollBarDecorator extends WindowDecorator {
    public HorizontalScrollBarDecorator(Window decorateWindow) {
        super(decorateWindow);
    }

    public void draw() {
        drawHorizontalScrollBar();
        decorateWindow.draw();
    }

    private void drawHorizontalScrollBar() {

    }

    public  String getDescription() {
        return decorateWindow.getDescription() + ", including horizontal scrollbars";
    }
}

public class decoratorPattern {
    public static void main(String[] args) {
        Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));

        // print the window's description
        System.out.println(decoratedWindow.getDescription());
    }
}
