package com.anaisrabary.insa;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculateurPrixMust extends TestCase {

    private final double montantArticle;
    private final double quantiteArticle;
    private final double montantHT ;

    public CalculateurPrixMust( final double montantArticle, final double quantiteArticle, final double montantHT){
        this.montantArticle = montantArticle ;
        this.quantiteArticle = quantiteArticle ;
        this.montantHT = montantHT ;
    }

    private static final Object[][] testparameters = new Object[][]
            {
                    {1,     1, 1.00 },
                    {1,     2, 2.00 },
                    {2,     1, 2.00 },
                    {1.5,   2, 3.00 },
            };

    @Parameterized.Parameters
    public static Collection<Object[]> parametre(){ return Arrays.asList(testparameters);}

    /*
    @Test
    public void Must_calculate_Montant_HT(){
    }
    */
}
