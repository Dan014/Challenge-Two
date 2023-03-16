/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challengetwo;

import java.util.Arrays;

/**
 *
 * @author DANIEL GARCIA
 */
public class ChallengeTwo {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 8, 10};
        //int[] nums = {-2, -1};
        //int[] nums = {-6, -5, 0, 5, 6};
        //int[] nums = {-10, 10};
        int[] result = squaredAndSorted(nums);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Esta metodo toma una matriz no vacía de enteros ordenados en orden
     * ascendente y devuelve una nueva matriz de la misma longitud con los
     * cuadrados de los enteros originales también ordenados en orden
     * ascendente. Si el número de salida está fuera del rango [0, 88], se
     * elimina de la matriz de salida.
     *
     * @param nums Una matriz no vacía de enteros ordenados en orden ascendente
     * @return Una nueva matriz con los cuadrados ordenados en orden ascendente y filtrada para eliminar los
     * números fuera del rango [0, 88].
     */
    public static int[] squaredAndSorted(int[] nums) {
        int[] result = new int[nums.length];//Se inizaliza una nueva matriz con el mismo tamaño que la matriz de entrada, esta alamcenara los cuadrados de los elementos de nums de forma ascendente
        int left = 0, right = nums.length - 1;//Se inicializa los indices que apuntan a los extremos derechos e izquierdo de la matriz num
        int index = nums.length - 1;//Se inicializa el indice que apunta al ultimo elemnto de la matriz result
        while (left <= right) {//Inicia el ciclo while que se ejecuta mientras left es menor o igual a right
            int leftSquared = nums[left] * nums[left];//Se calcula el cuadrado de left
            int rightSquared = nums[right] * nums[right];//Se calcula el cuadrado de right
            if (leftSquared > rightSquared) {//Si el cuadrado de left es mayor que right se alamacena en result en la posicion indicada por el index y se incrementa una posicion de left
                result[index] = leftSquared;
                left++;
            } else {//De lo contrario se agrega el valor de right en result en la posicion indicada por el index y se decrementa una posicion de right
                result[index] = rightSquared;
                right--;
            }
            index--;//Siempre se decrementa index para apuntar a la posicion siguiente de la matriz
        }
        //En esta parte se valida que la matriz final no sea mayor a 88
        int i = 0, j = 0;//Se inicialzia i y j en cero
        int[] filteredResult = new int[nums.length];//Se inicializa una nueva matriz filteredResult con el mismo tamaño que result. Esta matriz contendrá los elementos de result que estén en el rango [0, 88]
        //Recorre la matriz Result
        while (i < result.length) {
            //valida que los elementos de result se encuentren en el rango [0, 88]
            if (result[i] >= 0 && result[i] <= 88) {
                filteredResult[j] = result[i];
                j++;//indice para la nueva lista
            }
            i++;//Se incrementa para acceder al siguiente elmento de result
        }
        int[] trimmedResult = new int[j];//Se inicializa una nueva matriz trimmedResult con tamaño j que es la cantidad de elementos relevantes en
        for (i = 0; i < j; i++) {
            trimmedResult[i] = filteredResult[i];
        }
        return trimmedResult;
    }

}
