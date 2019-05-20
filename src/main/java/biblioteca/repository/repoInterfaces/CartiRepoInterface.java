package biblioteca.repository.repoInterfaces;


import biblioteca.model.Carte;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CartiRepoInterface {
	void adaugaCarte(Carte c) throws Exception;
	List<Carte> cautaCarte(String ref) throws IOException;
	List<Carte> getCarti() throws IOException;
	List<Carte> getCartiOrdonateDinAnul(Integer an);
}
