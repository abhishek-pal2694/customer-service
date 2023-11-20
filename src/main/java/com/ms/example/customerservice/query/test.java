package com.ms.example.customerservice.query;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class test {

    public static void main(String[] args) {
        //List<String> names = Arrays.asList("Abhi","Jish");
        String name = "Abhishek";
        String output = "";
        Stack stack = new Stack();
        for (char word: name.toCharArray()) {
            stack.push(word);
        }

        while (!stack.isEmpty()){
            output += stack.pop();
        }

        System.out.println(output);
    }
}
