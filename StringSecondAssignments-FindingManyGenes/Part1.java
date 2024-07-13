import java.util.Scanner;

/**
 * Part 1: Finding many Genes 

A. Find a gene in a strand of DNA where the stop codon could be any of the three stop codons “TAA”, “TAG”, or “TGA”.

B. Find all the genes (where the stop codon could be any of the three stop codons) in a strand of DNA.
 * 
 * @author HimanshuGupta
 * @version 1.0
 */
public class Part1 {

    public int findStopCodon(String dna, int startIndex, String codon)
    {
        String dnaUP = dna.toUpperCase();
        int stopIndex = dnaUP.indexOf(codon, startIndex+3);
        while(stopIndex != -1)
        {
            if((stopIndex-startIndex) % 3 == 0)
            {
                return stopIndex;
            }
            else{
                stopIndex = dnaUP.indexOf(codon, stopIndex+1);
            }
        }
        return -1;
    }
    
    public String findGene (String dna, int startIndex)
    {
        if(startIndex == -1)
            return "";
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = -1;
        if((taaIndex == -1) || (tagIndex != -1 && tagIndex < taaIndex))
        {
            minIndex = tagIndex;
        }
        else
        {
            minIndex = taaIndex;
        }
        if((minIndex == -1) || (tgaIndex != -1 && tgaIndex < minIndex))
        {
            minIndex = tgaIndex;
        }
        if(minIndex == -1)
            return "";
        
        return dna.substring(startIndex, minIndex+3);
    }
    
    public void printAllGenes(String dna)
    {
        String dnaUP = dna.toUpperCase();
        int startIndex = dnaUP.indexOf("ATG");
        
        while(true)
        {
            if(startIndex == -1)
            {
               break;
            }
            String gene = findGene (dna, startIndex);
            if(!gene.isEmpty())
                System.out.println(gene);
            startIndex = dnaUP.indexOf("ATG",startIndex+gene.length()+1);
            
        }
    }
    
    public void testSimpleGene()
    {
        //DNA with no “ATG”,
        String dna = "ATAATTG";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        //DNA with no “TAA”,
        dna = "ATGATTGAA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        // DNA with ATG, TAA and the substring between them is not multiple of 3 (a gene)
        dna = "TGATGATTAA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TGATGATGTAATGTAG";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene) in lower case
        dna = "tgatgatgtaa";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        // DNA with ATG, TAG and the substring between them is a multiple of 3
        dna = "TGATGATGTTAATGTAG";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        // DNA with ATG, TGA
        dna = "TGATGTTATATGTAATGTGA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        // DNA with ATG, TGA
        dna = "TGATGTTATAGTAATGATGA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        // DNA with ATG, TGA
        dna = "TGATGTTATAGTAATGATTAATGGTATTATGAATGTAA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        // DNA with ATG, TGA
        dna = "TGATGTTATAGTAATGATGATGATGTAA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
        
        dna = "AATGCTAACTAGCTGACTAAT";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        printAllGenes(dna);
    }
}
