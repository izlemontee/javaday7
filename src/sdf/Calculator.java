package sdf;

import java.io.*;
import java.util.*;

public class Calculator {
    public float stacks(String[] tokens){

        Stack<String> stack = new Stack<String>();
        float x,y;
        String result = "";
        float get = 0f;
        String choice;
        float value = 0f;
        String p = "";
        
        for(int i = 0;i < tokens.length; i++){
            if(tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" &&tokens[i] != "/"){
                stack.push(tokens[i]);
                continue;
            }
            else{
                choice = tokens[i];
            }

            switch(choice){
                case "+":
                    x = Float.parseFloat(stack.pop());
                    y = Float.parseFloat(stack.pop()); //Removes the object at the top of this stack and returns that object as the value of this function.
                    value = x+y;
                    result = p+value;
                    stack.push(result);//pushes the item to the top of the stack
                break;

                case "-":
                    x = Float.parseFloat(stack.pop());
                    y = Float.parseFloat(stack.pop()); //Removes the object at the top of this stack and returns that object as the value of this function.
                    value = y-x;
                    result = p+value;
                    stack.push(result);//pushes the item to the top of the stack
                break;

                case "*":
                    x = Float.parseFloat(stack.pop());
                    y = Float.parseFloat(stack.pop()); //Removes the object at the top of this stack and returns that object as the value of this function.
                    value = x*y;
                    result = p+value;
                    stack.push(result);//pushes the item to the top of the stack
                break;

                case "/":
                    x = Float.parseFloat(stack.pop());
                    y = Float.parseFloat(stack.pop()); //Removes the object at the top of this stack and returns that object as the value of this function.
                    value = y/x;
                    result = p+value;
                    stack.push(result);//pushes the item to the top of the stack
                break;

                default:
                continue;
            }
        }
        //Removes the object at the top of this stack and returns that object as the value of this function.
        return Float.parseFloat(stack.pop());
    }
    
}
