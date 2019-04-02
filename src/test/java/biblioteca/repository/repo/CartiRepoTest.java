package biblioteca.repository.repo;

import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import biblioteca.repository.repoMock.CartiRepoMock;
import biblioteca.util.Validator;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class CartiRepoTest {
    static Carte carte;
    static CartiRepoInterface crRepo = new CartiRepo();


    @Before
    public void creazaCarte() {
        carte = new Carte();
    }

    @After
    public void reinitializareCarte() {
        carte = new Carte();
    }

//ECP_valid


    @Test
    public void adaugaCarteRepo() {
        int sizeBeforeAdding = crRepo.getCarti().size();
        carte.adaugaReferent("Marin Preda");
        carte.adaugaReferent("Ion Creanga");
        carte.setTitlu("Morometii");
        carte.setAnAparitie(1980);
        carte.setEditura("Corint");
        carte.adaugaCuvantCheie("pamant");
        carte.adaugaCuvantCheie("salcam");

        try {
            crRepo.adaugaCarte(carte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int sizeAfterAdding = crRepo.getCarti().size();

        Assert.assertEquals(sizeBeforeAdding + 1, sizeAfterAdding);
    }


    @Test
    public void adaugaCarteRepo1() {
        int itemsBefore = 0;
        int itemsAfter = 0;
        carte.adaugaReferent("Mihai Eminescu");
        carte.setTitlu("Luceafrul");
        carte.setAnAparitie(1970);
        carte.setEditura("Luceafarul");
        carte.adaugaCuvantCheie("luceafar");

        for(Carte carteDinLista : crRepo.getCarti()){
            if(carteDinLista.equals(carte)){
                itemsBefore++;
            }
        }

        try {
            crRepo.adaugaCarte(carte);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Carte carteDinLista : crRepo.getCarti()){
            if(carteDinLista.equals(carte)){
                itemsAfter++;
            }
        }

        Assert.assertEquals(itemsBefore + 1, itemsAfter);
    }
//BVA_VALID
    @Test
    public void adaugaCarteRepoEdituraCuOLitera() {
        int itemsBefore = 0;
        int itemsAfter = 0;
        carte.adaugaReferent("Mihai Eminescu");
        carte.setTitlu("Luceafrul");
        carte.setAnAparitie(1970);
        carte.setEditura("L");
        carte.adaugaCuvantCheie("luceafar");

        for(Carte carteDinLista : crRepo.getCarti()){
            if(carteDinLista.equals(carte)){
                itemsBefore++;
            }
        }

        try {
            crRepo.adaugaCarte(carte);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Carte carteDinLista : crRepo.getCarti()){
            if(carteDinLista.equals(carte)){
                itemsAfter++;
            }
        }

        Assert.assertEquals(itemsBefore + 1, itemsAfter);
    }

    @Test
    public void adaugaCarteRepoTitluCuOLitera() {
        int itemsBefore = 0;
        int itemsAfter = 0;
        carte.adaugaReferent("Mihai Eminescu");
        carte.setTitlu("L");
        carte.setAnAparitie(1970);
        carte.setEditura("Luceafarul");
        carte.adaugaCuvantCheie("luceafar");

        for(Carte carteDinLista : crRepo.getCarti()){
            if(carteDinLista.equals(carte)){
                itemsBefore++;
            }
        }

        try {
            crRepo.adaugaCarte(carte);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Carte carteDinLista : crRepo.getCarti()){
            if(carteDinLista.equals(carte)){
                itemsAfter++;
            }
        }

        Assert.assertEquals(itemsBefore + 1, itemsAfter);
    }

//ECP_NONVALID
    @Test(expected = Exception.class)
    public void  validateCarteRepoReferentNonValid() throws Exception {
        carte.adaugaReferent("5");
        carte.setTitlu("Luceafrul");
        carte.setAnAparitie(1970);
        carte.setEditura("Luceafarul");
        carte.adaugaCuvantCheie("luceafar");

        Validator.validateCarte(carte);
    }

    @Test(expected = Exception.class)
    public void  validateCarteRepoAnAparritieNonValid() throws Exception {
        carte.adaugaReferent("Mihai");
        carte.setTitlu("Luceafrul");
        carte.setAnAparitie(1600);
        carte.setEditura("Luceafarul");
        carte.adaugaCuvantCheie("luceafar");

        Validator.validateAnAparitie(carte.getAnAparitie());
    }
//BVA_NONVALID
    @Test(expected = Exception.class)
    public void  validateCarteRepoTitluNonValid() throws Exception {
        carte.adaugaReferent("Mihai");
        carte.setTitlu(null);
        carte.setAnAparitie(1910);
        carte.setEditura("Luceafarul");
        carte.adaugaCuvantCheie("luceafar");

        Validator.validateCarte(carte);
    }

    @Test(expected = Exception.class)
    public void validateCarteRepoEdituraNonValid() throws Exception {
        carte.adaugaReferent("Mihai");
        carte.setTitlu("Luceafrul");
        carte.setAnAparitie(1900);
        carte.setEditura(null);
        carte.adaugaCuvantCheie("luceafar");

        Validator.validateCarte(carte);
    }







}