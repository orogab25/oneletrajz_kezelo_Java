package main.data;

public class Tanulmany {

	private
		int id,tulajId;
		String tanulmanyNev,tanulmanyKezdet,tanulmanyVeg,eredmeny;
		
		public Tanulmany() {}
		public Tanulmany(int id, String tanulmanyNev, String tanulmanyKezdet, String tanulmanyVeg, String eredmeny,int tulajId) {
			super();
			this.id=id;
			this.tanulmanyNev = tanulmanyNev;
			this.tanulmanyKezdet = tanulmanyKezdet;
			this.tanulmanyVeg = tanulmanyVeg;
			this.eredmeny = eredmeny;
			this.tulajId=tulajId;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getTanulmanyNev() {
			return tanulmanyNev;
		}
		
		public void setTanulmanyNev(String tanulmanyNev) {
			this.tanulmanyNev = tanulmanyNev;
		}
		
		public String getTanulmanyKezdet() {
			return tanulmanyKezdet;
		}
		
		public void setTanulmanyKezdet(String tanulmanyKezdet) {
			this.tanulmanyKezdet = tanulmanyKezdet;
		}
		
		public String getTanulmanyVeg() {
			return tanulmanyVeg;
		}
		
		public void setTanulmanyVeg(String tanulmanyVeg) {
			this.tanulmanyVeg = tanulmanyVeg;
		}
		
		public String getEredmeny() {
			return eredmeny;
		}
		
		public void setEredmeny(String eredmeny) {
			this.eredmeny = eredmeny;
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
			return id+" "+tanulmanyNev+" "+tanulmanyKezdet+" "+tanulmanyVeg+" "+eredmeny+" "+tulajId;
		}
}
