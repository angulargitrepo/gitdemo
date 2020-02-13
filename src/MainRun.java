package com.streamlinity.ct.bst;

import com.streamlinity.ct.bst.solution.Bst;

import java.util.List;

public class MainRun {
    public static void main(String[] args) {
        Bst tree = new Bst();
      //  int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7,8};
      //  int arr[] = new int[]{0, 13, 11, 5, 24, 33, 44, 22};
        int arr[] = {5, 5,5};

        tree.init(arr);
        List<Integer> list = tree.getBstValues();
        System.out.println("In order "+list);
        list = tree.getBstValuesInOrder();
        System.out.println("Pre order "+list);

       List matchIndex = tree.search(15);//4
        System.out.println(matchIndex);

    }

}
