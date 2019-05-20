package biblioteca.repository.repo;

import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import biblioteca.repository.repoMock.CartiRepoMock;
import biblioteca.util.Validator;
import org.junit.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartiRepoTest {
    public static Carte carte;
    public static CartiRepoInterface crRepo = new CartiRepo();


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
        int sizeBeforeAdding = 0;
        try {
            sizeBeforeAdding = crRepo.getCarti().size();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        int sizeAfterAdding = 0;
        try {
            sizeAfterAdding = crRepo.getCarti().size();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        try {
            for(Carte carteDinLista : crRepo.getCarti()){
                if(carteDinLista.equals(carte)){
                    itemsBefore++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            crRepo.adaugaCarte(carte);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for(Carte carteDinLista : crRepo.getCarti()){
                if(carteDinLista.equals(carte)){
                    itemsAfter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

        try {
            for(Carte carteDinLista : crRepo.getCarti()){
                if(carteDinLista.equals(carte)){
                    itemsBefore++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            crRepo.adaugaCarte(carte);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for(Carte carteDinLista : crRepo.getCarti()){
                if(carteDinLista.equals(carte)){
                    itemsAfter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

        try {
            for(Carte carteDinLista : crRepo.getCarti()){
                if(carteDinLista.equals(carte)){
                    itemsBefore++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            crRepo.adaugaCarte(carte);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for(Carte carteDinLista : crRepo.getCarti()){
                if(carteDinLista.equals(carte)){
                    itemsAfter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
