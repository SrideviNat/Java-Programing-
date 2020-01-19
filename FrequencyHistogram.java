//package COMP2120;
// Sridevi Nataraj

import java.util.*;

public class FrequencyHistogram
{
    /**
     * this fuction reads in line of input and calculates the frequecy of each words and then it
     * maps it with a frequency histogram. Also it maps the inverse of teh entered word and it
     * prints it on screen.
     * @param args
     * @return none
     */
    public static void main(String [] args)
    {
        TreeMap<String, Integer> freqhist = new TreeMap<String,Integer>();
        
        Scanner in = new Scanner(System.in);
        
        while(in.hasNext())
        {
            String word = in.next();
            Integer value = freqhist.get(word);
            
            if(value != null)
            {
                freqhist.put(word, value.intValue() + 1);
            }
            else
            {
                freqhist.put(word, 1);
            }
        }
        
        freqhist.forEach((key,value)->System.out.println(key + ": " + value));
        System.out.println("");
     
        AbstractMap<Integer,? extends AbstractSet<String>> invfreqhist = inverse(freqhist);
        
        invfreqhist.forEach((key, value)->{
            System.out.print(key + ":");
            
            value.forEach(v->{
                System.out.print(" " + v);
            });
            
            System.out.println("");
        });
    
    }

    /**
     * this method creates an inverse map of the frequenct histogram passed onto 
     * the inverse function.
     * @param <K> //INTEGER
     * @param <V> //STRING
     * @param m
     * @return <K,V>AbstractMap<V,? extends AbstractSet<K>>
     */
    public static <K,V>AbstractMap<V,? extends AbstractSet<K>> inverse(AbstractMap<K,V> m)
    {
        TreeMap<V,HashSet<K>> retval = new TreeMap<V,HashSet<K>>();
        
        Iterator it = m.entrySet().iterator();
        
        while(it.hasNext())
        {
            @SuppressWarnings("Unchecked")
            AbstractMap.Entry<K,V> pair = (AbstractMap.Entry<K,V>)it.next();
          
        
        
        HashSet<K> set = null;
        
        if(retval.containsKey(pair.getValue()))
        {
            set = retval.get(pair.getValue());
        }
        
        if(set == null)
        {
            set = new HashSet<K>();
        }
        
        set.add(pair.getKey());
        retval.put(pair.getValue(), set);
        
        }
        return retval;
    }
    



}
