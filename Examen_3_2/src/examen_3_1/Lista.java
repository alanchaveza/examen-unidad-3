/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_3_1;


import java.util.Scanner;

/**
 *
 * @author Alán
 */
public class Lista {
    Nodo ini = null;
    static class Nodo 
    {
        int val;
        Nodo next;
        public Nodo(int val) 
        {
            this.val = val;
        }
    }
    Nodo sortedMerge(Nodo a, Nodo b) 
    {
        Nodo result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.val <= b.val) 
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        } 
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
 
    }
 
    Nodo mergeSort(Nodo in) 
    {
        // Base case : if head is null
        if (in == null || in.next == null)
        {
            return in;
        }
        Nodo medio = Medio(in);
        Nodo sig = medio.next;
        medio.next = null;
        Nodo izq = mergeSort(in);
        Nodo der = mergeSort(sig);
        Nodo listaJunta = sortedMerge(izq, der);
        return listaJunta;
    }
    Nodo Medio(Nodo in) 
    {
        if (in == null)
            return in;
        Nodo aux = in.next;
        Nodo med = in;
        while (aux != null)
        {
            aux = aux.next;
            if(aux!=null)
            {
                med = med.next;
                aux=aux.next;
            }
        }
        return med;
    }
 
    void push(int valor){
    Nodo x = new Nodo(valor);
        x.next = ini;
        ini = x;
    }
 
    // Utility function to print the linked list
    void printList(Nodo nod) 
    {
        while (nod != null) 
        {
            System.out.print(nod.val + " ");
            nod = nod.next;
        }
    }
     
    public static void main(String[] args) 
    {
 
        Lista li = new Lista();
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Dime la cantidad de numeros");
        num=sc.nextInt();
        for (int i = 0; i < num; i++) {
            li.push((int)(Math.random()*100)+1);
        }
        System.out.println("Lista normal:");
        li.printList(li.ini);
 
        // Apply merge Sort
        li.ini = li.mergeSort(li.ini);
        System.out.print("\nLa lista en orden es: \n");
        li.printList(li.ini);
    }
}
