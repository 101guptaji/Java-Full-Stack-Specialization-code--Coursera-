import edu.duke.*;
/**
 * Part 3 
Write the void method processGenes that has one parameter sr, which is a StorageResource of strings. This method processes all the strings in sr to find out information about them. Specifically, it should: 

print all the Strings in sr that are longer than 60 characters

print the number of Strings in sr that are longer than 60 characters

print the Strings in sr whose C-G-ratio is higher than 0.35

print the number of strings in sr whose C-G-ratio is higher than 0.35

print the length of the longest gene in sr

 * Download the file brca1line.fa from the DukeLearnToProgram Project Resources page. Make sure you save it in your BlueJ project so that your code can access it. 
 * You can use a FileResource to open the file and the FileResource method asString to convert the contents of the file to a single string so that you can use it like the other DNA strings you have been using.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

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
    
    public double cgRatio(String dna)
    {
        double sum = 0.0;
        String dnaUP = dna.toUpperCase();
        for(int i = 0;i<dna.length();i++)
        {
            if(dnaUP.charAt(i) == 'C' || dnaUP.charAt(i) == 'G')
            {
                sum++;
            }
        }
        
        return sum/dna.length();
    }
    
    public void processGenes(StorageResource sr)
    {
        int nineCnt = 0;
        int cgCnt = 0;
        int longGene = 0;
        for(String gene : sr.data())
        {
            if(gene.length() > 60){
                System.out.println("gene with length > 60 is: "+gene);
                nineCnt++;
            }
            double ratio = cgRatio(gene);
            if(ratio > 0.35)
            {
                System.out.println("Gene with cg ratio > 0.35 is: "+gene);
                cgCnt++;
            }
            if(longGene < gene.length())
            {
                longGene = gene.length();
            }
        }
        System.out.println("No. of gene with more than 60 characters= "+nineCnt);
        System.out.println("No. of gene with cg ratio more than 0.35=  "+cgCnt);
        System.out.println("length of longest gene= "+longGene);
    }
    
    public void testSimpleGene()
    {
        FileResource fr;
        String dna;
        StorageResource geneList;
        //DNA with no “ATG”,
        /*FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        System.out.println("Printing genes for DNA : '"+dna+"'");
        StorageResource geneList = getAllGenes(dna);
        processGenes(geneList);
        /*for(String gene : geneList.data())
        {
            System.out.println(gene);
        }*/
        
        fr = new FileResource("GRch38dnapart.fa");
        dna = fr.asString();
        System.out.println("Printing genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        //System.out.println(geneList.size());
        processGenes(geneList);
        
        /*
        fr = new FileResource("Axl2p.fa");
        dna = fr.asString();
        System.out.println("Printing genes for DNA : '"+dna+"'");
        geneList = getAllGenes(dna);
        processGenes(geneList);*/
    }
}
