package fr.artisandeveloppeur.katas.potter;

public class Cart {

    private int nbItems;
    private final int PRIX_LIVRE = 8;

    //ajoute un livre au panier
    public void addBook(String title){
        nbItems++;
    }
    // calcule le prix du panier en centimes
    public int getPrice(String firstName){
        double reductionToApply = computeReductionToApply();
        return (int)((PRIX_LIVRE * nbItems - reductionToApply) * 100);
    }

    private double computeReductionToApply() {
        int reductions;
        switch (nbItems){
            case 2: reductions = 5; break;
            case 3: reductions = 10; break;
            case 4: reductions = 15; break;
            case 5: reductions = 20; break;
            case 6: reductions = 25; break;
            case 7: reductions = 30; break;
            default:reductions = 0;
        }
        return computeReductions(reductions);
    }

    private double computeReductions(int reductions) {
        return (PRIX_LIVRE * nbItems * reductions) / 100.0;
    }
}

