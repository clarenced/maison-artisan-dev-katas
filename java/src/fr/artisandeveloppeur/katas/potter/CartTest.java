package fr.artisandeveloppeur.katas.potter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart cart;

    @BeforeEach
    void setup(){
        cart = new Cart();
    }

    @Test
    @DisplayName("Aucune réduction  appliquée pour achat de 1 livre")
    void aucuneReductionAppliqueePourAchat1Livre(){
        cart.addBook("Harry Potter à l'école des sorciers");

        assertEquals(800, cart.getPrice("Clarence"));
    }

    @Test
    @DisplayName("Réduction de 5% pour achat de 2 livres différents")
    void reductionDe5PourAchat2Livres(){
        cart.addBook("Harry Potter à l'école des sorciers");
        cart.addBook("Harry Potter et la Chambre des secrets ");

        assertEquals(1520, cart.getPrice("Clarence"));
    }

    @Test
    @DisplayName("Reduction de 10% pour achat de 3 livres différents")
    void reductionDe10PourAchatDe3Livres(){
        cart.addBook("Harry Potter à l'école des sorciers");
        cart.addBook("Harry Potter et la Chambre des secrets ");
        cart.addBook("Harry Potter et le Prisonnier d'Azkaban");

        assertEquals(2160, cart.getPrice("Clarence"));
    }

    @Test
    @DisplayName("Reduction  de 15 pour achat de 4 livres différents")
    void reductionDe15PourAchatDe4Livres(){
        cart.addBook("Harry Potter à l'école des sorciers");
        cart.addBook("Harry Potter et la Chambre des secrets ");
        cart.addBook("Harry Potter et le Prisonnier d'Azkaban");
        cart.addBook("Harry Potter et la Coupe de feu");

        assertEquals(2720, cart.getPrice("Clarence"));

    }

    @Test
    @DisplayName("Reduction de 20% pour achat de 5 livres différents")
    void reductionDe20PourAchatDe5livres(){
        cart.addBook("Harry Potter à l'école des sorciers");
        cart.addBook("Harry Potter et la Chambre des secrets ");
        cart.addBook("Harry Potter et le Prisonnier d'Azkaban");
        cart.addBook("Harry Potter et la Coupe de feu");
        cart.addBook("Harry Potter et l'Ordre du Phénix");

        assertEquals(3200, cart.getPrice("Clarence"));
    }

    @Test
    @DisplayName("Reduction de 25% pour achat de 6 livres différents")
    void reductionDe25PourAchatDe6livres(){
        cart.addBook("Harry Potter à l'école des sorciers");
        cart.addBook("Harry Potter et la Chambre des secrets ");
        cart.addBook("Harry Potter et le Prisonnier d'Azkaban");
        cart.addBook("Harry Potter et la Coupe de feu");
        cart.addBook("Harry Potter et l'Ordre du Phénix");
        cart.addBook("Harry Potter et le Prince de sang-mêlé");

        assertEquals(3600, cart.getPrice("Clarence"));
    }

    @Test
    @DisplayName("Reduction de 30% pour achat de 7 livres différents")
    void reductionDe30PourAchatDe7Livres(){
        cart.addBook("Harry Potter à l'école des sorciers");
        cart.addBook("Harry Potter et la Chambre des secrets ");
        cart.addBook("Harry Potter et le Prisonnier d'Azkaban");
        cart.addBook("Harry Potter et la Coupe de feu");
        cart.addBook("Harry Potter et l'Ordre du Phénix");
        cart.addBook("Harry Potter et le Prince de sang-mêlé");
        cart.addBook("Harry Potter et le Prince de sang-mêlé");

        assertEquals(3920, cart.getPrice("Clarence"));
    }

    @Test
    @DisplayName("Aucune reduction pour achat de 2 livres similaires")
    void aucuneReductionPourAchat2LivresSimilaires(){
        cart.addBook("Harry Potter à l'école des sorciers");
        cart.addBook("Harry Potter à l'école des sorciers");

        assertEquals(1600, cart.getPrice("Clarence"));
    }

}