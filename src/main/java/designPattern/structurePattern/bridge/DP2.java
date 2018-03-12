package designPattern.structurePattern.bridge;

public class DP2 {
    
    public static void drawRetangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

    public static void drawTriangle(int Rows) {
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

}
