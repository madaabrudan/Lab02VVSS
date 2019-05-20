
package biblioteca.repository.repo;

        import biblioteca.model.Carte;
        import biblioteca.repository.repoInterfaces.CartiRepoInterface;
        import org.junit.Assert;
        import org.junit.Test;

        import java.util.List;

public class TopDownTest {
    static Carte carte;
    static CartiRepoInterface crRepo = new CartiRepo();

    CartiRepoTest cartiRepoTest = new CartiRepoTest();
    AfisareDupaAnTest afisareDupaAnTest = new AfisareDupaAnTest();


    @Test
    public void TopDown() {
        cartiRepoTest.creazaCarte();
        cartiRepoTest.adaugaCarteRepo();

        AfisareDupaAnTest.carte = new Carte();
        AfisareDupaAnTest.carte.setAnAparitie(CartiRepoTest.carte.getAnAparitie());
        afisareDupaAnTest.afisareCarteValida();

    }
}

