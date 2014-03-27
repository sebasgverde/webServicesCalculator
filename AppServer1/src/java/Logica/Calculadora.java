package Logica;

public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        return a / b;
    }

    public int operacion(int p1, int p2, String op) {
        int result = 0;
        int a = p1;
        int b = p2;
        if (op.equals("+")) {
            result = sumar(a, b);
        } else if (op.equals("-")) {
            result = restar(a, b);
        } else if (op.equals("*")) {
            result = multiplicar(a, b);
        } else if (op.equals("+")) {
            result = dividir(a, b);
        }

        return result;
    }
}
