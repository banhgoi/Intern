/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interpreterpatterndemo;

/**
 *
 * @author user
 */
class InterpreterEngineContext
{
    private String[] interpret(String input)
    {
        String s = input.replaceAll("[^0-9]", " ");
        return s.replaceAll("( )+", " ").trim().split(" ");
    }
    public int add(String input)
    {
        String tokens[] = interpret(input);
        return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
    }
    public int subtract(String input)
    {
        String tokens[] = interpret(input);
        return Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[1]);
    }
}
interface Expression
{
    int interpret(InterpreterEngineContext context);
}
class AddExpression implements Expression
{
    private String expression;
    public AddExpression(String expression)
    {
        this.expression = expression;
    }
    @Override
    public int interpret(InterpreterEngineContext context)
    {
        return context.add(expression);
    }
}
class SubtractExpression implements Expression
{
    private String expression;
    public SubtractExpression(String expression)
    {
        this.expression = expression;
    }
    @Override
    public int interpret(InterpreterEngineContext context)
    {
        return context.subtract(expression);
    }
}
public class InterpreterPatternDemo {
    public static int interpret(String input) throws Exception
    {
        Expression expression = null;
        if (input.contains("plus")) expression = new AddExpression(input);
        else if (input.contains("minus")) expression = new SubtractExpression(input);
        else throw new Exception();
        return expression.interpret(new InterpreterEngineContext());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        System.out.println("5 plus 5 equals " + interpret("5 plus 5"));
        System.out.println("5 minus 5 equals " + interpret("5 minus 5"));
    }
    
}
