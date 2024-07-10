
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String findSimpleGene(String dna, int startCodon, int stopCodon)
    {
        String gene = "";
        String dnaUP = dna.toUpperCase();
        startCodon = dnaUP.indexOf("ATG");
        if(startCodon == -1)
            return "";
        
        stopCodon = dnaUP.indexOf("TAA", startCodon+3);
        if(stopCodon == -1)
            return "";
        
        gene = dna.substring(startCodon, stopCodon+3);
        if(gene.length() % 3 != 0)
            return "";
        
        return gene;
    }
    
    public void testSimpleGene()
    {
        //DNA with no “ATG”,
        String dna = "ATAATTG";
        System.out.println("DNA is: "+dna);
        String gene = findSimpleGene(dna,0,0);
        System.out.println("Gene is: "+gene);
        
        //DNA with no “TAA”,
        dna = "ATGATTGAA";
        System.out.println("DNA is: "+dna);
        gene = findSimpleGene(dna,0,0);
        System.out.println("Gene is: "+gene);
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TGATGATTTAA";
        System.out.println("DNA is: "+dna);
        gene = findSimpleGene(dna,0,0);
        System.out.println("Gene is: "+gene);
        
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        dna = "TGATGATGTTAA";
        System.out.println("DNA is: "+dna);
        gene = findSimpleGene(dna,0,0);
        System.out.println("Gene is: "+gene);
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene) in lower case
        dna = "tgatgatgtaa";
        System.out.println("DNA is: "+dna);
        gene = findSimpleGene(dna,0,0);
        System.out.println("Gene is: "+gene);
    }
}
