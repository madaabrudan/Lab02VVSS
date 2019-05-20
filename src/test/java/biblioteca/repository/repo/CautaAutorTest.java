package biblioteca.repository.repo;

import biblioteca.control.BibliotecaCtrl;
import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import biblioteca.util.Validator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CautaAutorTest {
    CartiRepoInterface cr = new CartiRepo();
    BibliotecaCtrl bc = new BibliotecaCtrl(cr);
//cautare carte dupa un autor existent
    @Test
    public void cautareCarteValida() throws Exception{
       List<Carte> listaCarti =  bc.cautaCarte("Mihai");
       Assert.assertEquals(1, listaCarti.size());

       String numeAutor = listaCarti.get(0).getReferenti().get(0);
       boolean autorGasit = numeAutor.contains("Mihai");

       Assert.assertTrue(autorGasit);
    }

//cautare carte dupa autor inexistent
    @Test
    public void cautareCarteInvalida() throws Exception{
        List<Carte> listaCarti =  bc.cautaCarte("Christofer");
        Assert.assertEquals(0, listaCarti.size());
    }
//cauta 2 carti scrise de acelasi autor
    @Test
    public void cautareDouaCartiValide() throws Exception{
        List<Carte> listaCarti =  bc.cautaCarte("Ion Creanga");
        Assert.assertEquals(2, listaCarti.size());

        String numeAutor1 = listaCarti.get(0).getReferenti().get(0);
        String numeAutor2 = listaCarti.get(1).getReferenti().get(0);
        boolean autorGasit1 = numeAutor1.contains("Ion Creanga");
        boolean autorGasit2 = numeAutor2.contains("Ion Creanga");

        Assert.assertTrue(autorGasit1);
        Assert.assertTrue(autorGasit2);
    }

    //cauta toate cartile ale caror autori contin litera i
    @Test
    public void cautareCartiDupaAutorCareContinLiteraI() throws Exception{
        List<Carte> listaCarti =  bc.cautaCarte("i");
        Assert.assertEquals(4, listaCarti.size());

        String numeAutor1 = listaCarti.get(0).getReferenti().get(0);
        String numeAutor2 = listaCarti.get(1).getReferenti().get(0);
        String numeAutor3 = listaCarti.get(2).getReferenti().get(0);
        String numeAutor4 = listaCarti.get(3).getReferenti().get(0);

        boolean autorGasit1 = numeAutor1.toLowerCase().contains("i");
        boolean autorGasit2 = numeAutor2.toLowerCase().contains("i");
        boolean autorGasit3 = numeAutor3.toLowerCase().contains("i");
        boolean autorGasit4 = numeAutor4.toLowerCase().contains("i");

        Assert.assertTrue(autorGasit1);
        Assert.assertTrue(autorGasit2);
        Assert.assertTrue(autorGasit3);
        Assert.assertTrue(autorGasit4);
    }

    // cautare carte cu doi autori, dupa al doilea autor
    @Test
    public void cautareCarteCu2AutoriDupaAlDoileaAutor()  throws Exception{
        List<Carte> listaCarti =  bc.cautaCarte("Vasile Alecsandri");
        Assert.assertEquals(1, listaCarti.size());
        Assert.assertEquals(2, listaCarti.get(0).getReferenti().size());

        String numeAutor2 = listaCarti.get(0).getReferenti().get(1);
        boolean autorGasit = numeAutor2.equals("Vasile Alecsandri");

        Assert.assertTrue(autorGasit);
    }

    // cautare carte cu doi autori, dupa primul autor
    @Test
    public void cautareCarteCu2AutoriDupaprimulAutor() throws Exception{
        List<Carte> listaCarti =  bc.cautaCarte("Mircea Eliade");
        Assert.assertEquals(1, listaCarti.size());
        Assert.assertEquals(2, listaCarti.get(0).getReferenti().size());

        String numeAutor2 = listaCarti.get(0).getReferenti().get(0);
        boolean autorGasit = numeAutor2.equals("Mircea Eliade");

        Assert.assertTrue(autorGasit);
    }
    // cautare dupa string gol(invalid)

    @Test(expected = Exception.class)
    public void cautareCarteDupaStringGol() throws Exception {
       bc.cautaCarte(""); }
}