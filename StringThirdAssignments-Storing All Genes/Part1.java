import edu.duke.StorageResource;
/**
 * Part 1
This assignment is to write the code from the lesson to use a StorageResource 
to store the genes you find instead of printing them out. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public StorageResource getAllGenes(String dna)
    {
        String dnaUP = dna.toUpperCase();
        int startIndex = dnaUP.indexOf("ATG");
        StorageResource geneList = new StorageResource();
        
        while(true)
        {
            if(startIndex == -1)
            {
               break;
            }
            String gene = findGene (dna, startIndex);
            if(gene.isEmpty()){
                break;
            }         
            geneList.add(gene);
            
            startIndex = dna.indexOf("ATG",startIndex+gene.length());
            
        }
        return geneList;
    }
    
    public void testSimpleGene()
    {
        //DNA with no “ATG”,
        String dna = "ATAATTG";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        StorageResource geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        //DNA with no “TAA”,
        dna = "ATGATTGAA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        // DNA with ATG, TAA and the substring between them is not multiple of 3 (a gene)
        dna = "TGATGATTAA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TGATGATGTAATGTAG";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene) in lower case
        dna = "tgatgatgtaa";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        // DNA with ATG, TAG and the substring between them is a multiple of 3
        dna = "TGATGATGTTAATGTAG";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        // DNA with ATG, TGA
        dna = "TGATGTTATATGTAATGTGA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        // DNA with ATG, TGA
        dna = "TGATGTTATAGTAATGATGA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        // DNA with ATG, TGA
        dna = "TGATGTTATAGTAATGATGATGATGTAA";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
        
        // DNA with ATG, TGA
        dna = "ATGTAAATGTAGATGGT";
        System.out.println("Printing all genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        for(String gene : geneList.data())
        {
            System.out.println(gene);
        }
    }
}
