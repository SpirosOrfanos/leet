package y2021.mediumtasks;

import java.util.*;
import java.util.stream.Collectors;

public class Combinations {
    public static void main(String... args) {
        Combinations combinations = new Combinations();
        //combinations.combinations(new int[] {1, 2, 3, 4}).forEach(i -> System.out.println((List<Integer>)i));
        combinations.subsets(new int[] {1, 2, 3, 4}).forEach(i -> System.out.println(i));
    }

    public List<List<Integer>> combinations(int[] arr) {
        List<List<Integer>> list  = new ArrayList<>();
        combinations(arr, 0, list);
        return list;
    }

    public List<Integer> subsets(int[] arr) {
        List<List<Integer>> list  = new ArrayList<>();
        subsets(arr, 0, list, new ArrayList<>());
        List<Integer> p = list.stream().map( v -> v.stream().reduce(0, (a,b) -> a+b)).collect(Collectors.toList());
        p.sort((a, b) -> a>b ? 1 : a==b ? 0 : -1);
        return p;
    }

    public void subsets(int[] arr, int index, List<List<Integer>> list, List<Integer> l) {
        if (index<=arr.length) {
            list.add(new ArrayList<>(l));
        }

        if (index>=arr.length) return;

        for (int i = index; i<arr.length; i++) {
            l.add(arr[i]);
            subsets(arr, i+1, list, l);
            l.remove(l.size()-1);
        }
    }
    public void combinations(int[] arr, int index, List<List<Integer>> list) {
        if (index>=arr.length) {
            List<Integer> l = new ArrayList<>();
            for (int i:arr) {
                l.add(i);
            }
            list.add(l);
            return;
        }

        for (int i = index; i<arr.length; i++) {
            swap(arr, i, index);
            combinations(arr, index+1, list);
            swap(arr, i, index);
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
