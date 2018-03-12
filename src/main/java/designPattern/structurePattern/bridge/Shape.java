package designPattern.structurePattern.bridge;

public abstract class Shape {

    public DrawingProgramming drawingProgramming;

    public Shape() {
    }

    public Shape(DrawingProgramming drawingProgramming) {
        this.drawingProgramming = drawingProgramming;
    }

    public abstract void draw();

    public DrawingProgramming getDrawingProgramming() {
        return drawingProgramming;
    }

    public void setDrawingProgramming(DrawingProgramming drawingProgramming) {
        this.drawingProgramming = drawingProgramming;
    }
}
