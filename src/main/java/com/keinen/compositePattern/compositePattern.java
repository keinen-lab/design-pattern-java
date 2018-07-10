package com.keinen.compositePattern;

import java.util.ArrayList;
import java.util.List;

// component
interface Graphic {
    // prints the graphic
    public void print();
}

// composite
class CompositeGraphic implements Graphic {

    // collection of child graphics
    private List<Graphic> mChildGraphics = new ArrayList<Graphic>();

    // print the graphic
    public void print() {
        for (Graphic graphic : mChildGraphics) {
            graphic.print();
        }
    }

    // adds the graphic to the composition
    public void add(Graphic graphic) {
        mChildGraphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        mChildGraphics.remove(graphic);
    }
}

// leaf
class Ellipse implements Graphic {
    // print the graphic
    public void print() {
        System.out.println("Ellipse");
    }
}

// client
public class compositePattern {
    public static void main(String[] args) {
        // initailize four ellipses
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();

        // initalize three composte graphics
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();

        // Composes the graphics
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);

        graphic2.add(ellipse4);

        graphic.add(graphic1);
        graphic.add(graphic2);

        graphic.print();
    }
}
