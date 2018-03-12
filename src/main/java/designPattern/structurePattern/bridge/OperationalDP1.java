package designPattern.structurePattern.bridge;

public class OperationalDP1 extends DrawingProgramming {

    public OperationalDP1() {
    }

    @Override
    public void drawRetangle(int width, int height) {
        DP1.drawRetangle(width, height);
    }

    @Override
    public void drawTriangle(int rows) {
        DP1.drawTriangle(rows);
    }

}
