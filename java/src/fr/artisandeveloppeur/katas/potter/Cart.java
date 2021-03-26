package fr.artisandeveloppeur.katas.potter;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private int nbItems;
    private final int PRIX_LIVRE = 8;
    private final Map<String, Integer> livresCount = new HashMap<>();

    //ajoute un livre au panier
    public void addBook(String title){
        if(livresCount.containsKey(title)){
            livresCount.put(title, livresCount.get(title) + 1);
        } else {
            livresCount.put(title, 1);
        }
        nbItems = livresCount.values().stream().reduce(0, Integer::sum);
    }

    private boolean hasDuplicates(){
        return this.livresCount.entrySet().stream()
                .anyMatch(entry -> entry.getValue() > 1);
    }

    // calcule le prix du panier en centimes
    public int getPrice(String firstName){
        double reductionToApply = hasDuplicates() ? 0 : computeReductionToApply();
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

