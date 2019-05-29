package main.data;

public class Munka {

	private
		int id,tulajId;
		String munkaNev,munkaKezdet,munkaVeg,beosztas,feladatok;
		
		public Munka() {}
		public Munka(int id, String munkaNev, String munkaKezdet, String munkaVeg, String beosztas, String feladatok,int tulajId) {
			super();
			this.id=id;
			this.munkaNev = munkaNev;
			this.munkaKezdet = munkaKezdet;
			this.munkaVeg = munkaVeg;
			this.beosztas = beosztas;
			this.feladatok = feladatok;
			this.tulajId=tulajId;
		}

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getMunkaNev() {
			return munkaNev;
		}
		
		public void setMunkaNev(String munkaNev) {
			this.munkaNev = munkaNev;
		}
		
		public String getMunkaKezdet() {
			return munkaKezdet;
		}
		
		public void setMunkaKezdet(String munkaKezdet) {
			this.munkaKezdet = munkaKezdet;
		}
		
		public String getMunkaVeg() {
			return munkaVeg;
		}
		
		public void setMunkaVeg(String munkaVeg) {
			this.munkaVeg = munkaVeg;
		}
		
		public String getBeosztas() {
			return beosztas;
		}
		
		public void setBeosztas(String beosztas) {
			this.beosztas = beosztas;
		}
		
		public String getFeladatok() {
			return feladatok;
		}
		
		public void setFeladatok(String feladatok) {
			this.feladatok = feladatok;
		}
		
		public int getTulajId() {
			return tulajId;
		}
		
		public void setTulajId(int tulajId) {
			this.tulajId = tulajId;
		}
			
		@Override
		public String toString()
		{
			return id+" "+munkaNev+" "+munkaKezdet+" "+munkaVeg+" "+beosztas+" "+feladatok+" "+tulajId;
		}
}
