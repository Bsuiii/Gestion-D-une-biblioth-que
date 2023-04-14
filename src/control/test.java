package control;

import Entity.Emprunt;
import Entity.Exemplaire;
import Entity.Usager;
import Util.Exceprtions;

public class test {

	public static void main(String[] args) throws Exceprtions {
    /* OeuvreControl sec=new OeuvreControl();
     System.out.println(sec.getById(3));
     ExemplaireControl ex=new ExemplaireControl();
     System.out.println(ex.getByEtat("Neuf"));
     
     Emprunt emp=new Emprunt();
     Usager user=new Usager();
     user.setId(1);
     emp.setUsagerEmprunt(user);
     Exemplaire exc=new Exemplaire();
     exc.setId(2);
     emp.setExemplairesEmprunt(exc);
     System.out.println(new EmpruntControl().insert(emp));*/
     securityController scr=new securityController();
     System.out.println(scr.authenticate("bessi", "bessi"));
	}

}
