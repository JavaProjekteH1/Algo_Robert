package main.java.Praesenz.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Taschenrechner {
    private HashMap<String, Double> mapVars = new HashMap<>();

    private double eval(String exprUPN){
        Stack<Double> numbers = new Stack<>();

        String[] content = exprUPN.split(" +");

        for(String s : content){
            //operatoren
            if(s.equals("+")){
                double tmp = numbers.pop();
                numbers.push(numbers.pop() + tmp);
                continue;
            }else if(s.equals("-")){
                double tmp = numbers.pop();
                numbers.push(numbers.pop() - tmp);
                continue;
            }
            else if(s.equals("*")){
                double tmp = numbers.pop();
                numbers.push(numbers.pop() * tmp);
                continue;
            }
            else if(s.equals("/")){
                double tmp = numbers.pop();
                numbers.push(numbers.pop() / tmp);
                continue;
            }
            if(mapVars.containsKey(s)){
                numbers.push(mapVars.get(s));
                continue;
            }

            try{
                numbers.push(Double.parseDouble(s));
            }catch(NumberFormatException e){
                System.out.println("NAN: " + s);
            }
        }
        double res = 0;
        for(double n : numbers){
            res += n;
        }
        return res;
    }

    public String analyze(String expr){
        String res;
        int posOfEqual =expr.indexOf("=");
        if(posOfEqual != -1){
            double tmp = eval(expr.substring(posOfEqual+2));
            mapVars.put( expr.substring(0, posOfEqual - 1), tmp);
            res = ""+tmp;
        }else{
            res = ""+eval(expr);
        }
        return res;
    }

    public void reset(){
        mapVars.clear();
    }

}
