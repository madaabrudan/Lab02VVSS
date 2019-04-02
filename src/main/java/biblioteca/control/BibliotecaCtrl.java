package biblioteca.control;


import biblioteca.model.Carte;
import biblioteca.repository.repoInterfaces.CartiRepoInterface;
import biblioteca.util.Validator;

import java.util.List;

import static biblioteca.util.Validator.validateAnAparitie;

public class BibliotecaCtrl {

    private CartiRepoInterface cr;

    public BibliotecaCtrl(CartiRepoInterface cr) {
        this.cr = cr;
    }

    public void adaugaCarte(Carte c) throws Exception {
        Validator.validateCarte(c);
        cr.adaugaCarte(c);
    }


    public List<Carte> cautaCarte(String autor) throws Exception {
        Validator.isStringOK(autor);
        return cr.cautaCarte(autor);
    }

    public List<Carte> getCarti() throws Exception {
        return cr.getCarti();
    }

    public List<Carte> getCartiOrdonateDinAnul(Integer an) throws Exception {
        validateAnAparitie(an);
        return cr.getCartiOrdonateDinAnul(an);
    }


}
