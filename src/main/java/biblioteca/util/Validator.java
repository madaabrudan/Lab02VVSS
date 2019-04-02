package biblioteca.util;

import biblioteca.model.Carte;

public class Validator {
	
	public static boolean isStringOK(String s) throws Exception{
		boolean flag = s.matches("[a-zA-Z]+");
		if(flag == false)
			throw new Exception("String invalid");
		return flag;
	}
	
	public static void validateCarte(Carte c)throws Exception{
		if(c.getCuvinteCheie()==null){
			throw new Exception("Lista cuvinte cheie vida!");
		}
		if(c.getReferenti()==null){
			throw new Exception("Lista autori vida!");
		}
		if(!isOKString(c.getTitlu()))
			throw new Exception("Titlu invalid!");
		if(!isOKString(c.getEditura()))
			throw new Exception("Editura invalida!");
		for(String s:c.getReferenti()){
			if(!isOKString(s))
				throw new Exception("Autor invalid!");
		}
		for(String s:c.getCuvinteCheie()){
			if(!isOKString(s))
				throw new Exception("Cuvant cheie invalid!");
		}
		validateAnAparitie(c.getAnAparitie());
	}
	
	public static boolean isNumber(Integer s){
		//return s.matches("[0-9]+");
		return s > 0;
	}

	public static boolean isAnAparitieValid(Integer s){
		//return s.matches("[0-9]+");
		return s > 1899;
	}

	public static void validateAnAparitie(Integer s) throws Exception {
		if(!(s > 1899)){
			throw new Exception("An aparitie invalid!");
		}
	}
	
	public static boolean isOKString(String s){
		String []t = s.split(" ");
		if(t.length==2){
			boolean ok1 = t[0].matches("[a-zA-Z]+");
			boolean ok2 = t[1].matches("[a-zA-Z]+");
			if(ok1==ok2 && ok1==true){
				return true;
			}
			return false;
		}
		return s.matches("[a-zA-Z]+");
	}
	
}
