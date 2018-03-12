package designPattern.structurePattern.bridge;

public class Triangle extends Shape {
    private int rows = 0;

    public Triangle(DrawingProgramming drawingProgramming, int rows) {
        super(drawingProgramming);
        this.rows = rows;
    }

    @Override
    public void draw() {
        this.driangleDraw(rows);
    }

    private void driangleDraw(int rows) {
        this.drawingProgramming.drawTriangle(rows);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
