
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna)
    {
        String gene = "";
        
        int startCodon = dna.indexOf("ATG");
        if(startCodon == -1)
            return "";
        
        int endCodon = dna.indexOf("TAA", startCodon+3);
        if(endCodon == -1)
            return "";
        
        gene = dna.substring(startCodon, endCodon+3);
        if(gene.length() % 3 != 0)
            return "";
        
        return gene;
    }
    
    public void testSimpleGene()
    {
        //DNA with no “ATG”,
        String dna = "ATAATTG";
        System.out.println("DNA is: "+dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is: "+gene);
        
        //DNA with no “TAA”,
        dna = "ATGATTGAA";
        System.out.println("DNA is: "+dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: "+gene);
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TGATGATTTAA";
        System.out.println("DNA is: "+dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: "+gene);
        
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        dna = "TGATGATGTTAA";
        System.out.println("DNA is: "+dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: "+gene);
    }
}
