package model;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public double[][] getData() { return data; }

    public void setValue(int row, int col, double value) {
        data[row][col] = value;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f", data[i][j]);
            }
            System.out.println();
        }
    }

    // Cộng ma trận
    public Matrix additionMatrix(Matrix m2) {
        if (rows != m2.rows || cols != m2.cols) {
            throw new IllegalArgumentException("Two matrices must have the same size for addition!");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.data[i][j] + m2.data[i][j]);
            }
        }
        return result;
    }

    // Trừ ma trận
    public Matrix subtractionMatrix(Matrix m2) {
        if (rows != m2.rows || cols != m2.cols) {
            throw new IllegalArgumentException("Two matrices must have the same size for subtraction!");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.data[i][j] - m2.data[i][j]);
            }
        }
        return result;
    }

    // Nhân ma trận
    public Matrix multiplicationMatrix(Matrix m2) {
        if (this.cols != m2.rows) {
            throw new IllegalArgumentException("Number of columns of first matrix must equal number of rows of second matrix!");
        }
        Matrix result = new Matrix(this.rows, m2.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m2.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * m2.data[k][j];
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }
}
