import java.util.*;
import edu.duke.*;
/**
 * Assignment 1: Codon Count
    Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames. A strand of DNA is made up of the symbols C, G, T, and A. 
    A codon is three consecutive symbols in a strand of DNA such as ATT or TCC. A reading frame is a way of dividing a strand of DNA into consecutive codons. 
    
    Consider the following strand of DNA = “CGTTCAAGTTCAA”.
    
    There are three reading frames. 
    The first reading frame starts at position 0 and has the codons: “CGT”, “TCA”, “AGT” and “TCA”. Here TCA occurs twice and the others each occur once.
    The second reading frame starts at position 1 (ignoring the first C character) and has the codons: “GTT”, “CAA”, “GTT”, “CAA”. Here both GTT and CAA occur twice.
    The third reading frame starts at position 2 (ignoring the first two characters CG) and has the codons: “TTC”, “AAG”, “TTC”. Here TTC occurs twice and AAG occurs once. 
* 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CodonCount {
    HashMap <String, Integer> codonMap;
    
    public CodonCount()
    {
        codonMap = new HashMap <String, Integer> ();
    }
    
    private void buildCodonMap(String dna, int start)
    {
        codonMap.clear();
        for(int i =start;i<dna.length()-3;i+=3)
        {
            String codon = dna.substring(i,i+3);
            if(codonMap.containsKey(codon))
            {
                codonMap.put(codon, codonMap.get(codon)+1);
            }
            else
            {
                codonMap.put(codon, 1);
            }
        }
    }
    
    private String getMostCommonCodon()
    {
        String commonCodon = null;
        for(String key : codonMap.keySet())
        {
            if(commonCodon == null)
            {
                commonCodon = key;
            }
            else
            {
                if(codonMap.get(key) > codonMap.get(commonCodon))
                {
                    commonCodon = key;
                }
            }
        }
        return commonCodon;
    }
    
    private void printCodonCounts(int start, int end)
    {
        for(String key : codonMap.keySet())
        {
            if(codonMap.get(key) >= start && codonMap.get(key) <= end)
            {
                System.out.println(key+"\t"+codonMap.get(key));
            }
        }
    }
    
    public void tester()
    {
        FileResource fr = new FileResource();
        String dna = fr.asString().trim().toUpperCase();
        for(int i=0;i<3;i++)
        {
            buildCodonMap(dna, i);
            System.out.println("Reading frame starting with "+i+" results in "+codonMap.size() +" unique codons");
            
            String common = getMostCommonCodon();
            System.out.println("and most common codon is "+common+" with count "+codonMap.get(common));
            
            int start = 1, end =7;
            System.out.println("Counts of codons between "+start+" and "+end+" inclusive are: ");
            printCodonCounts(start, end);
            
            System.out.println();
        }
    }
}



















