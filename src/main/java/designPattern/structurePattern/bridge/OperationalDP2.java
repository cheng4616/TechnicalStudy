package designPattern.structurePattern.bridge;

public class OperationalDP2 extends DrawingProgramming {

    public OperationalDP2() {

    }

    @Override
    public void drawRetangle(int width, int height) {
        DP2.drawRetangle(width, height);
    }

    @Override
    public void drawTriangle(int rows) {
        DP2.drawTriangle(rows);
    }

}
