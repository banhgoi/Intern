/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package strategypatterndemo;
import java.util.*;
/**
 *
 * @author user
 */
interface SortStrategy
{
    <T> void sort(Set<T> items);
}
class QuickSort implements SortStrategy
{
    @Override
    public <T> void sort(Set<T> items)
    {
        System.out.println("Quick sort");
    }
}
class MergeSort implements SortStrategy
{
    @Override
    public <T> void sort(Set<T> items)
    {
        System.out.println("Merge sort");
    }
}
class SortedSet
{
    private SortStrategy strategy;
    private Set<String> items = new HashSet<>();
    public void setSortStratagy(SortStrategy strategy)
    {
        this.strategy = strategy;
    }
    public void add(String name)
    {
        items.add(name);
    }
    public void sort()
    {
        strategy.sort(items);
    }
}
public class StrategyPatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SortedSet sortedSet = new SortedSet();
        sortedSet.add("Ngo");
        sortedSet.add("Hoang");
        sortedSet.add("Minh");
        sortedSet.setSortStratagy(new QuickSort());
        sortedSet.sort();
        sortedSet.setSortStratagy(new MergeSort());
        sortedSet.sort();
    }
    
}
