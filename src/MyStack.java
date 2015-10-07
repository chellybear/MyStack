/*
 * You need to write a Java class MyStack, that extends ArrayList.. ArrayList is
the non-thread safe version of Vector. Your MyStack will mimic the addition and
subtraction of a post fix adding machine. All data is in free format (white
space separated), keep reading until EOF. You should capture all exception,
print out just the exception message and continue reading until EOF
 */

/**
 *
 * @author rjachin0
 */
import java.util.*;
import java.lang.*;
import java.util.ArrayList;

public class MyStack{
    public static void main(String[] args){
    boolean validCommand = false;
    boolean tooLong = false;
    String i, input;
    String data = "";
    CharSequence dec = "\\d*\\.\\d+";
    int in;
    Stack stack = new Stack();
    Scanner inp = new Scanner(System.in);
    do{
   	data += inp.nextLine();
    }while(inp.hasNextLine());
    
    Scanner sc = new Scanner(data);

    do{
          i = sc.next();
          input = i.toUpperCase();

          try{
              in = Integer.parseInt(input);
          }
          catch(NumberFormatException ex){
              if(input.length() > 1){
              System.out.println("Exception: too long: " + i);
              tooLong = true;
              }
          }

        if(input.matches("-?\\d+")){
            stack.push(input);
            validCommand = true;
        }
                else if(input.matches("P")){
//            System.out.println("went thru print");
            stack.printStack(stack);
            System.out.println();
            validCommand = true;
        }
        else if(input.matches("\\+")){
            if(stack.getSize() < 2){
                System.out.println("Exception: Need two operands");
            }
            else{
            stack.popAndAdd();
            }
            validCommand = true;
        }
        else if(input.matches("\\-")){
            if(stack.getSize() < 2){
                System.out.println("Exception: Need two operands");
            }
            else{
            stack.popAndSub();
            }
            validCommand = true;
        }

        if(!validCommand && !tooLong){
            System.out.println("Exception: Unknown Command " + i);
        }

        validCommand = false;
        tooLong = false;
        }while(sc.hasNext());




    }


    }


 class Stack extends ArrayList{
 private ArrayList<Object> list = new ArrayList<>();

 @Override
 public boolean isEmpty() {
 return list.isEmpty();
 }

 public int getSize() {
 return list.size();
 }

 public Object peek() {
 return list.get(getSize() - 1);
 }

 public Object popAndAdd() {
 Object a, b, sumS;
 int aa, bb, sum;

 a = list.get(getSize() - 1);
 list.remove(getSize() - 1);
 aa = Integer.parseInt(a.toString());

 if(!isEmpty()){
 b = list.get(getSize() - 1);
 list.remove(getSize() - 1);
 bb = Integer.parseInt(b.toString());
 sum = bb + aa;
 }
 else{
     sum = Integer.parseInt(a.toString());
 }

 sumS = sum;
 push(sumS);
 return sumS;
 }

 public Object popAndSub() {
 Object a, b, sumS;
 int aa, bb, sum;
 a = list.get(getSize() - 1);
 list.remove(getSize() - 1);
 b = list.get(getSize() - 1);
 list.remove(getSize() - 1);

 aa = Integer.parseInt(a.toString());
 bb = Integer.parseInt(b.toString());
 sum = bb - aa;

 sumS = sum;
 push(sumS);
 return sumS;
 }

 public void push(Object o) {
 list.add(o);
 }

 public void printStack(Object o){
     ListIterator<Object> litr = null;
     litr = list.listIterator();
     while(litr.hasNext()){
         System.out.print(litr.next() + ", ");
     }
 }
// @Override
// public String toString() {
// return "stack: " + list.toString();
// }
 }

