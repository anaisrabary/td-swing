package com.anaisrabary.insa.calculateurprix;

public class CalculateurPrixPresenter {
    private final CalculateurPrixView calculateurPrixView;

    public CalculateurPrixPresenter(CalculateurPrixView calculateurPrixView) {
        this.calculateurPrixView = calculateurPrixView;
    }

    public void onComputeButtonClicked(String montantArticleAsText, String quantiteArticleText) {
        double montantArticleDouble = Double.parseDouble(montantArticleAsText);
        double quantiteAtricleDouble = Double.parseDouble(quantiteArticleText);

        calculateurPrixView.afficherResultat(montantArticleDouble*quantiteAtricleDouble);
        //calculateurPrixView.afficherErreur("Allez, au boulot ! :)");
    }
}
