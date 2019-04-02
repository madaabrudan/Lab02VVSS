package biblioteca.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carte {

	private String titlu;
	private List<String> referenti;
	private Integer anAparitie;

	public String getEditura() {
		return editura;
	}

	private String editura;
	private List<String> cuvinteCheie;

	public Carte(){
		titlu = "";
		referenti = new ArrayList<String>();
		anAparitie = 0;
		cuvinteCheie = new ArrayList<String>();
		editura="";
	}

    public String getTitlu() {
        return titlu;
    }

	public void setEditura(String editura) {
        this.editura = editura;
    }

    public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public List<String> getReferenti() {
		return referenti;
	}

	public Integer getAnAparitie() {
        return anAparitie;
    }

	public void setAnAparitie(Integer anAparitie) {
		this.anAparitie = anAparitie;
	}

	public List<String> getCuvinteCheie() {
		return cuvinteCheie;
	}


	public void adaugaCuvantCheie(String cuvant){
		cuvinteCheie.add(cuvant);
	}

	public void adaugaReferent(String ref){
		referenti.add(ref);
	}

	@Override
	public String toString(){
		Collections.sort(referenti);
		String ref = "";
		String cuvCheie = "";

		for(int i=0;i<referenti.size();i++){
			if(i==referenti.size()-1)
				ref+=referenti.get(i);
			else
				ref+=referenti.get(i)+",";
		}

		for(int i=0;i<cuvinteCheie.size();i++){
			if(i==cuvinteCheie.size()-1)
				cuvCheie+=cuvinteCheie.get(i);
			else
				cuvCheie+=cuvinteCheie.get(i)+",";
		}

		return titlu+";"+ref+";"+anAparitie+";"+editura+";"+cuvCheie;
	}

	public static Carte getCarteFromString(String carte){
		Carte c = new Carte();
		String []atr = carte.split(";");
		String []referenti = atr[1].split(",");
		String []cuvCheie = atr[4].split(",");


        c.editura=atr[3];
		c.titlu=atr[0];
		for(String s:referenti){
			c.adaugaReferent(s);
		}

		c.anAparitie = Integer.parseInt(atr[2]);
		for(String s:cuvCheie){
			c.adaugaCuvantCheie(s);
		}

		return c;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!Carte.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Carte other = (Carte) obj;
        if ((this.referenti == null) ? (other.referenti != null) : !this.referenti.equals(other.referenti)) {
            return false;
        }

        if (!this.editura.equals(other.editura)) {
            return false;
        }

        if (!this.titlu.equals(other.titlu)) {
            return false;
        }

        if (!this.cuvinteCheie.equals(other.cuvinteCheie)) {
            return false;
        }

        if ((int)this.anAparitie != (int)other.anAparitie) {
            return false;
        }

        return true;
    }
}
