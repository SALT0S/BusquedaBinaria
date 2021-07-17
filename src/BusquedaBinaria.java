import java.util.Arrays;

public class BusquedaBinaria {
    public static void main(String[] args) throws Exception {
        int[] array = new int[1000];
        llenarArreglo(array);
        seleccion(array);
        if (binarySearch(array, 1)) {
            System.out.println("Se ha encontrado el valor.");
        } else {
            System.out.println("Valor no se encuentra en el arreglo");
        }
    }

    public static boolean binarySearch(int[] numbers, int numberToSearch) {
        int size = numbers.length;
        int middle = size / 2;

        System.out.println("Size: " + size);
        System.out.println("Middle: " + middle);
        System.out.println("Array: " + Arrays.toString(numbers));
        if (numbers[middle] == numberToSearch)
            return true;
        else if (size == 1)
            return false;
        else if (numbers[middle] > numberToSearch)
            return binarySearch(Arrays.copyOfRange(numbers, 0, middle), numberToSearch);
        else
            return binarySearch(Arrays.copyOfRange(numbers, middle + 1, size), numberToSearch);
    }

    public static void seleccion(int A[]) {
        int i, j, menor, pos, tmp, cont = 0;
        for (i = 0; i < A.length - 1; i += 1) {
            menor = A[i];
            pos = i;
            for (j = i + 1; j < A.length; j += 1) {
                if (A[j] < menor) {
                    menor = A[j];
                    pos = j;
                }
            }
            if (pos != i) {
                tmp = A[i];
                A[i] = A[pos];
                A[pos] = tmp;
                cont += 1;
            }
        }
        System.out.println("\nNumero de iteraciones: " + cont);
    }

    private static void llenarArreglo(int[] array) {
        for (int a = 0; a < array.length; a += 1) {
            array[a] = (int) (Math.random() * 2000) + 1;
        }
    }
}
