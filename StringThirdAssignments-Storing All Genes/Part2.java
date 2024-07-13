import edu.duke.*;
/**
 * Write the method cgRatio that has one String parameter dna, and returns the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA. For example if the String were “ATGCCATAG,” then cgRatio would return 4/9 or .4444444.
 * Write a method countCTG that has one String parameter dna, and returns the number of times the codon CTG appears in dna. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
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
    
    public int countCTG(String dna)
    {
        int cnt = 0;
        String dnaUp = dna.toUpperCase();
        int index = dnaUp.indexOf("CTG");
        while(index != -1)
        {
            cnt++;
            index = dnaUp.indexOf("CTG", index+3);
        }
        
        return cnt;
    }
    
    public void testCG()
    {
        String dna = "";
        double ratio = 0.0;
        int ctgCount = 0;
        /*dna = "ATGCCATAG";
        System.out.println("DNA Strand is: '"+dna+"'");
        ratio = cgRatio(dna);
        System.out.println("cg ratio is: "+ratio);
        ctgCount = countCTG(dna);
        System.out.println("CTG count is: "+ctgCount);*/
        
        FileResource fr;
        fr = new FileResource("GRch38dnapart.fa");
        dna = fr.asString();
        System.out.println("DNA Strand is: '"+dna+"'");
        ratio = cgRatio(dna);
        System.out.println("cg ratio is: "+ratio);
        ctgCount = countCTG(dna);
        System.out.println("CTG count is: "+ctgCount);
    }
}
