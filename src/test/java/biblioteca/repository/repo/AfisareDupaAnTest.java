package biblioteca.repository.repo;

import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AfisareDupaAnTest {
    static Carte carte;

    static CartiRepoInterface crRepo = new CartiRepo();

    @Test
    public void afisareCarteValida() {
        if (carte == null) {
            carte = new Carte();
            carte.setAnAparitie(1970);
        }

        List<Carte> carteList = crRepo.getCartiOrdonateDinAnul(carte.getAnAparitie());

        for (Carte carteCurenta : carteList) {
            int an = carteCurenta.getAnAparitie();
            Assert.assertEquals((int) carte.getAnAparitie(), an);
        }
    }

    //non-valid
    @Test
    public void afisareCarteInvalida() {
        if (carte == null) {
            carte = new Carte();
            carte.setAnAparitie(2035);
        }
        List<Carte> carteList = crRepo.getCartiOrdonateDinAnul(carte.getAnAparitie());

        Assert.assertTrue(carteList.isEmpty());
    }

    @Test
    public void afisareCarteIntrodusa() {
        int anAles = 2035;
        List<Carte> carteList = crRepo.getCartiOrdonateDinAnul(anAles);

        Assert.assertTrue(carteList.isEmpty());
    }
}
