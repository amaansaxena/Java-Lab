public class Vector {
    private double[] v;

    public Vector(double[] input) throws VectorException {
        if (input.length != 2 && input.length != 3) {
            throw new VectorException("Vector must be either 2D or 3D.");
        }
        this.v = input;
    }

    public int getDimension() {
        return v.length;
    }

    private void validateDimensions(Vector v2) throws VectorException {
        if (this.getDimension() != v2.getDimension()) {
            throw new VectorException("Dimensions must be the same for this operation.");
        }
    }

    public Vector add(Vector v2) throws VectorException {
        validateDimensions(v2);
        double[] result = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            result[i] = this.v[i] + v2.v[i];
        }
        return new Vector(result);
    }

    public Vector subtract(Vector v2) throws VectorException {
        validateDimensions(v2);
        double[] result = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            result[i] = this.v[i] - v2.v[i];
        }
        return new Vector(result);
    }

    public double dotProduct(Vector v2) throws VectorException {
        validateDimensions(v2);
        double product = 0;
        for (int i = 0; i < v.length; i++) {
            product += this.v[i] * v2.v[i];
        }
        return product;
    }

    public void display(String label) {
        System.out.print(label + ": (");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + (i < v.length - 1 ? ", " : ""));
        }
        System.out.println(")");
    }
}