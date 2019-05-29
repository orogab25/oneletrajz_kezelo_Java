package main.data;

public class Oneletrajz {

	private
		int id;
		String nev,szulHely,szulIdo,allam,email,telefon,letrehozas;
		
		public Oneletrajz() {}
		public Oneletrajz(int id, String nev, String szulHely, String szulIdo, String allam, String email, String telefon, String letrehozas) {
			super();
			this.id=id;
			this.nev = nev;
			this.szulHely = szulHely;
			this.szulIdo = szulIdo;
			this.allam = allam;
			this.email = email;
			this.telefon = telefon;
			this.letrehozas = letrehozas;
		}

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getNev() {
			return nev;
		}
		
		public void setNev(String nev) {
			this.nev = nev;
		}
		
		public String getSzulHely() {
			return szulHely;
		}
		
		public void setSzulHely(String szulHely) {
			this.szulHely = szulHely;
		}
		
		public String getSzulIdo() {
			return szulIdo;
		}
		
		public void setSzulIdo(String szulIdo) {
			this.szulIdo = szulIdo;
		}
		
		public String getAllam() {
			return allam;
		}
		
		public void setAllam(String allam) {
			this.allam = allam;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getTelefon() {
			return telefon;
		}
		
		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}
		
		public String getLetrehozas() {
			return letrehozas;
		}
		
		public void setLetrehozas(String letrehozas) {
			this.letrehozas = letrehozas;
		}
		
		@Override
		public String toString()
		{
			return id+" "+nev+" "+szulHely+" "+szulIdo+" "+allam+" "+email+" "+telefon+" "+letrehozas;
		}
}
