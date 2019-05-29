package main.ctrl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.data.Munka;
import main.data.Oneletrajz;
import main.data.Tanulmany;

public class ViewController implements Initializable{
	
	//lista létrehozása a datak-hoz
	private ObservableList<Oneletrajz> dataOneletrajz;
	private ObservableList<Tanulmany> dataTanulmany;
	private ObservableList<Munka> dataMunka;
	
	//kapcsolódunk az adatbázishoz
	public static Connection connection;
	
	//kiválasztottságot jelző változók
	boolean isSelected=false,isSelected1=false,isSelected2=false;
	
	//kiválasztott rekordok
	Munka munkaSelected;
	Tanulmany tanulmanySelected;
	Oneletrajz oneletrajzSelected;
	
	//FXML elemek
	@FXML
	private AnchorPane apOneletrajz;
	@FXML
	private TableView<Oneletrajz> tableOneletrajz;
	@FXML
	private TableColumn<Oneletrajz,String> colId;
	@FXML
	private TableColumn<Oneletrajz,String> colNev;
	@FXML
	private TableColumn<Oneletrajz,String> colSzulHely;
	@FXML
	private TableColumn<Oneletrajz,String> colSzulIdo;
	@FXML
	private TableColumn<Oneletrajz,String> colAllam;
	@FXML
	private TableColumn<Oneletrajz,String> colEmail;
	@FXML
	private TableColumn<Oneletrajz,String> colTelefon;
	@FXML
	private TableColumn<Oneletrajz,String> colLetrehozas;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtNev;
	@FXML
	private TextField txtSzulHely;
	@FXML
	private TextField txtSzulIdo;
	@FXML
	private TextField txtAllam;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtTelefon;
	@FXML
	private TextField txtLetrehozas;
	@FXML
	private Button btnSave;
	@FXML
	private Button btnNew;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnTanulmanyok;
	@FXML
	private Button btnMunkak;
	@FXML
	private AnchorPane apTanulmany;
	@FXML
	private TableView<Tanulmany> tableTanulmany;
	@FXML
	private TableColumn<Tanulmany,String> colId1;
	@FXML
	private TableColumn<Tanulmany,String> colTulaj1;
	@FXML
	private TableColumn<Tanulmany,String> colTanulmanyNev;
	@FXML
	private TableColumn<Tanulmany,String> colTanulmanyKezdet;
	@FXML
	private TableColumn<Tanulmany,String> colTanulmanyVeg;
	@FXML
	private TableColumn<Tanulmany,String> colEredmeny;
	@FXML
	private TextField txtId1;
	@FXML
	private TextField txtTulaj1;
	@FXML
	private TextField txtTanulmanyNev;
	@FXML
	private TextField txtTanulmanyKezdet;
	@FXML
	private TextField txtTanulmanyVeg;
	@FXML
	private TextField txtEredmeny;
	@FXML
	private Button btnSave1;
	@FXML
	private Button btnNew1;
	@FXML
	private Button btnDelete1;
	@FXML
	private Label lblTulaj1;
	@FXML
	private Button btnBezaras1;
	@FXML
	private AnchorPane apMunka;
	@FXML
	private TableView<Munka> tableMunka;
	@FXML
	private TableColumn<Munka,String> colId2;
	@FXML
	private TableColumn<Munka,String> colTulaj2;
	@FXML
	private TableColumn<Munka,String> colMunkaNev;
	@FXML
	private TableColumn<Munka,String> colMunkaKezdet;
	@FXML
	private TableColumn<Munka,String> colMunkaVeg;
	@FXML
	private TableColumn<Munka,String> colBeosztas;
	@FXML
	private TableColumn<Munka,String> colFeladatok;
	@FXML
	private TextField txtId2;
	@FXML
	private TextField txtTulaj2;
	@FXML
	private TextField txtMunkaNev;
	@FXML
	private TextField txtMunkaKezdet;
	@FXML
	private TextField txtMunkaVeg;
	@FXML
	private TextField txtBeosztas;
	@FXML
	private TextField txtFeladatok;
	@FXML
	private Button btnSave2;
	@FXML
	private Button btnNew2;
	@FXML
	private Button btnDelete2;
	@FXML
	private Label lblTulaj2;
	@FXML
	private Button btnBezaras2;
	
	//Inicializációs folyamat
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		connection=Connect.dbConnector();
		loadOneletrajzok();
	}
	
	//Önéletrajzok betöltése adatbázisból
	public void loadOneletrajzok()
	{
		try {
			this.dataOneletrajz = FXCollections.observableArrayList();
			String query="SELECT * FROM Oneletrajz";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while (rs.next()) 
			{
		        this.dataOneletrajz.add(new Oneletrajz(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)));
		    }
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		colId.setCellValueFactory(new PropertyValueFactory<Oneletrajz, String>("Id"));
		colNev.setCellValueFactory(new PropertyValueFactory<Oneletrajz, String>("Nev"));
		colSzulHely.setCellValueFactory(new PropertyValueFactory<Oneletrajz, String>("SzulHely"));
		colSzulIdo.setCellValueFactory(new PropertyValueFactory<Oneletrajz, String>("SzulIdo"));
		colAllam.setCellValueFactory(new PropertyValueFactory<Oneletrajz, String>("Allam"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Oneletrajz, String>("Email"));
		colTelefon.setCellValueFactory(new PropertyValueFactory<Oneletrajz, String>("Telefon"));
		colLetrehozas.setCellValueFactory(new PropertyValueFactory<Oneletrajz, String>("Letrehozas"));
		
		this.tableOneletrajz.setItems(null);
		this.tableOneletrajz.setItems(this.dataOneletrajz);
	}
	
		//Tanulmányok betöltése adatbázisból
		public void loadTanulmanyok()
		{
			try {
				this.dataTanulmany = FXCollections.observableArrayList();
				String query="SELECT * FROM Tanulmany WHERE TulajId='"+txtId.getText()+"'";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while (rs.next()) 
				{
					this.dataTanulmany.add(new Tanulmany(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			colId1.setCellValueFactory(new PropertyValueFactory<Tanulmany, String>("Id1"));
			colTanulmanyNev.setCellValueFactory(new PropertyValueFactory<Tanulmany, String>("TanulmanyNev"));
			colTanulmanyKezdet.setCellValueFactory(new PropertyValueFactory<Tanulmany, String>("TanulmanyKezdet"));
			colTanulmanyVeg.setCellValueFactory(new PropertyValueFactory<Tanulmany, String>("TanulmanyVeg"));
			colEredmeny.setCellValueFactory(new PropertyValueFactory<Tanulmany, String>("Eredmeny"));
			colTulaj1.setCellValueFactory(new PropertyValueFactory<Tanulmany, String>("Tulaj1"));
			
			this.tableTanulmany.setItems(null);
			this.tableTanulmany.setItems(this.dataTanulmany);
		}
	
		//Munkák betöltése adatbázisból
		public void loadMunkak()
		{
			try {
				this.dataMunka = FXCollections.observableArrayList();
				String query="SELECT * FROM Munka WHERE TulajId='"+txtId.getText()+"'";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while (rs.next()) 
				{
					this.dataMunka.add(new Munka(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getInt(7)));
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			colId2.setCellValueFactory(new PropertyValueFactory<Munka, String>("Id2"));
			colMunkaNev.setCellValueFactory(new PropertyValueFactory<Munka, String>("MunkaNev"));
			colMunkaKezdet.setCellValueFactory(new PropertyValueFactory<Munka, String>("MunkaKezdet"));
			colMunkaVeg.setCellValueFactory(new PropertyValueFactory<Munka, String>("MunkaVeg"));
			colBeosztas.setCellValueFactory(new PropertyValueFactory<Munka, String>("Beosztas"));
			colFeladatok.setCellValueFactory(new PropertyValueFactory<Munka, String>("Feladatok"));
			colTulaj2.setCellValueFactory(new PropertyValueFactory<Munka, String>("Tulaj2"));
			
			this.tableMunka.setItems(null);
			this.tableMunka.setItems(this.dataMunka);
		}
	
	//Önéletrajz mezők feltöltése
	@FXML
	public void rowClicked(MouseEvent event) {
		
		oneletrajzSelected = tableOneletrajz.getSelectionModel().getSelectedItem();
		
		txtId.setText(oneletrajzSelected.getId()+"");
		txtNev.setText(oneletrajzSelected.getNev()+"");
		txtSzulHely.setText(oneletrajzSelected.getSzulHely()+"");
		txtSzulIdo.setText(oneletrajzSelected.getSzulIdo()+"");
		txtAllam.setText(oneletrajzSelected.getAllam()+"");
		txtEmail.setText(oneletrajzSelected.getEmail()+"");
		txtTelefon.setText(oneletrajzSelected.getTelefon()+"");
		txtLetrehozas.setText(oneletrajzSelected.getLetrehozas()+"");
		
		isSelected=true;
	}
	
		//Tanulmány mezők feltöltése
		@FXML
		public void rowClicked1(MouseEvent event) {
			
			tanulmanySelected = tableTanulmany.getSelectionModel().getSelectedItem();
			
			txtId1.setText(tanulmanySelected.getId()+"");
			txtTanulmanyNev.setText(tanulmanySelected.getTanulmanyNev()+"");
			txtTanulmanyKezdet.setText(tanulmanySelected.getTanulmanyKezdet()+"");
			txtTanulmanyVeg.setText(tanulmanySelected.getTanulmanyVeg()+"");
			txtEredmeny.setText(tanulmanySelected.getEredmeny()+"");
			txtTulaj1.setText(tanulmanySelected.getTulajId()+"");
			
			isSelected1=true;
		}
	
		//Munka mezők feltöltése
		@FXML
		public void rowClicked2(MouseEvent event) {
			
			munkaSelected = tableMunka.getSelectionModel().getSelectedItem();
			
			txtId2.setText(munkaSelected.getId()+"");
			txtMunkaNev.setText(munkaSelected.getMunkaNev()+"");
			txtMunkaKezdet.setText(munkaSelected.getMunkaKezdet()+"");
			txtMunkaVeg.setText(munkaSelected.getMunkaVeg()+"");
			txtBeosztas.setText(munkaSelected.getBeosztas()+"");
			txtFeladatok.setText(munkaSelected.getFeladatok()+"");
			txtTulaj2.setText(munkaSelected.getTulajId()+"");
			
			isSelected2=true;
		}
		
	//Önéletrajz mezők ürítése
	public void clearOneletrajz()
	{
		txtId.setText("");
		txtNev.setText("");
		txtSzulHely.setText("");
		txtSzulIdo.setText("");
		txtAllam.setText("");
		txtEmail.setText("");
		txtTelefon.setText("");
		txtLetrehozas.setText("");
	}
		
		//Tanulmány mezők ürítése
		public void clearTanulmany()
		{
			txtId1.setText("");
			txtTanulmanyNev.setText("");
			txtTanulmanyKezdet.setText("");
			txtTanulmanyVeg.setText("");
			txtEredmeny.setText("");
			txtTulaj1.setText("");
		}
			
		//Munka mezők ürítése
		public void clearMunka()
		{
			txtId2.setText("");
			txtMunkaNev.setText("");
			txtMunkaKezdet.setText("");
			txtMunkaVeg.setText("");
			txtBeosztas.setText("");
			txtFeladatok.setText("");
			txtTulaj2.setText("");
		}
	
		//Tanulmányok megnyitása
		@FXML
		public void doTanulmanyok(ActionEvent event) {
			
			if(isSelected == false)
			{
				Alert alert =Util.createAlert("Hiba", "Hibás kiválasztás", "Válasszon önéletrajzot!");
				alert.show();
			}
			else
			{
			apOneletrajz.setVisible(false);
			apTanulmany.setVisible(true);
			clearTanulmany();
			lblTulaj1.setText(txtNev.getText());
			loadTanulmanyok();
			txtTulaj1.setText(txtId.getText());
			}
		}
		
		//Munkák megnyitása
		@FXML
		public void doMunkak(ActionEvent event) {
			
			if(isSelected == false)
			{
				Alert alert =Util.createAlert("Hiba", "Hibás kiválasztás", "Válasszon önéletrajzot!");
				alert.show();
			}
			else
			{
			apOneletrajz.setVisible(false);
			apMunka.setVisible(true);
			clearMunka();
			lblTulaj2.setText(txtNev.getText());
			loadMunkak();
			txtTulaj2.setText(txtId.getText());
			}
		}
		
		//Tanulmányok bezárása
		@FXML
		public void doBezaras1(ActionEvent event) {
			apTanulmany.setVisible(false);
			apOneletrajz.setVisible(true);
		}
		
		//Munkák bezárása
		@FXML
		public void doBezaras2(ActionEvent event) {
			apMunka.setVisible(false);
			apOneletrajz.setVisible(true);
		}
	
	//Új önéletrajz létrehozása
	@FXML
	public void doNew(ActionEvent event) {
		
		if(txtId.getText().equals("") || txtNev.getText().equals("") || txtSzulHely.getText().equals("") || txtAllam.getText().equals("") || txtEmail.getText().equals("") || txtTelefon.getText().equals("") || txtLetrehozas.getText().equals(""))
		{
			Alert alert =Util.createAlert("Hiba", "Nincs kitöltve minden mező!");
			alert.show();
		}
		else
		{
			int i=0;
			
			for(i=0;i<tableOneletrajz.getItems().size();i++)
			{
				if(txtId.getText().equals(String.valueOf(colId.getCellData(i))))
				{
					Alert alert =Util.createAlert("Hiba", "Már létezik ilyen azonosító!");
					alert.show();
					break;
				}
			}
		
			if(i==tableOneletrajz.getItems().size())
			{
				try {
				String query="INSERT INTO Oneletrajz(Id,Nev,SzulHely,SzulIdo,Allam,Email,Telefon,Letrehozas)"
						+ "VALUES ('"+txtId.getText()+"','"+txtNev.getText()+"','"+txtSzulHely.getText()+"','"+txtSzulIdo.getText()+"','"+txtAllam.getText()+"','"+txtEmail.getText()+"','"+txtTelefon.getText()+"','"+txtLetrehozas.getText()+"')";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				
				loadOneletrajzok();
				
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
		//Új tanulmány létrehozása
		@FXML
		public void doNew1(ActionEvent event) throws SQLException {
			
			if(txtId1.getText().equals("") ||txtTulaj1.getText().equals("") || txtTanulmanyNev.getText().equals("") || txtTanulmanyKezdet.getText().equals("") || txtTanulmanyVeg.getText().equals("") || txtEredmeny.getText().equals(""))
			{
				Alert alert =Util.createAlert("Hiba", "Nincs kitöltve minden mező!");
				alert.show();
			}
			else
			{
				String queryId="SELECT * FROM Tanulmany";
				PreparedStatement pstId=connection.prepareStatement(queryId);
				ResultSet rs=pstId.executeQuery();
				
				int i=0,j=0;
				
				while (rs.next()) 
				{
					if(!txtId1.getText().equals(String.valueOf(rs.getInt(1))))
					{
						i++;
					}
					j++;
				}
				
				if(i==j)
				{
				try {
					
					String query="INSERT INTO Tanulmany(Id,Nev,Kezdet,Veg,Eredmeny,TulajId)"
							+ "VALUES ('"+txtId1.getText()+"','"+txtTanulmanyNev.getText()+"','"+txtTanulmanyKezdet.getText()+"','"+txtTanulmanyVeg.getText()+"','"+txtEredmeny.getText()+"','"+txtTulaj1.getText()+"')";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					
					loadTanulmanyok();
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				else
				{
					Alert alert =Util.createAlert("Hiba", "Már létezik ilyen azonosítójú tanulmány!");
					alert.show();
				}
			}
		}
		
		//Új munka létrehozása
		@FXML
		public void doNew2(ActionEvent event) throws SQLException {
			
			if(txtId2.getText().equals("") || txtTulaj2.getText().equals("") || txtMunkaNev.getText().equals("") || txtMunkaKezdet.getText().equals("") || txtMunkaVeg.getText().equals("") || txtBeosztas.getText().equals("") || txtFeladatok.getText().equals(""))
			{
				Alert alert =Util.createAlert("Hiba", "Nincs kitöltve minden mező!");
				alert.show();
			}
			else
			{
				String queryId="SELECT * FROM Munka";
				PreparedStatement pstId=connection.prepareStatement(queryId);
				ResultSet rs=pstId.executeQuery();
				
				int i=0,j=0;
				
				while (rs.next()) 
				{
					if(!txtId2.getText().equals(String.valueOf(rs.getInt(1))))
					{
						i++;
					}
					j++;
				}
				
				if(i==j)
				{
				try {
					String query="INSERT INTO Munka(Id,Nev,Kezdet,Veg,Beosztas,Feladatok,TulajId)"
							+ "VALUES ('"+txtId2.getText()+"','"+txtMunkaNev.getText()+"','"+txtMunkaKezdet.getText()+"','"+txtMunkaVeg.getText()+"','"+txtBeosztas.getText()+"','"+txtFeladatok.getText()+"','"+txtTulaj2.getText()+"')";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					
					loadMunkak();
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				else
				{
					Alert alert =Util.createAlert("Hiba", "Már létezik ilyen azonosítójú munka!");
					alert.show();
				}
			}
		}

	//Önéletrajz módosítása
	@FXML
	public void doSave(ActionEvent event) {
		
		if(txtId.getText().equals("") || txtNev.getText().equals("") || txtSzulHely.getText().equals("") || txtAllam.getText().equals("") || txtEmail.getText().equals("") || txtTelefon.getText().equals("") || txtLetrehozas.getText().equals(""))
		{
			Alert alert =Util.createAlert("Hiba", "Nincs kitöltve minden mező!");
			alert.show();
		}
		else
		{
			int i=0;
			
			for(i=0;i<tableOneletrajz.getItems().size();i++)
			{
				if(txtId.getText().equals(String.valueOf(colId.getCellData(i))))
				{
					break;
				}
			}
			
			if(i<tableOneletrajz.getItems().size())
			{
				try {
					String query="UPDATE Oneletrajz SET Nev ='"+txtNev.getText()+"', SzulHely ='"+txtSzulHely.getText()+"', SzulIdo ='"+txtSzulIdo.getText()+"', Allam ='"+txtAllam.getText()+"', Email ='"+txtEmail.getText()+"', Telefon ='"+txtTelefon.getText()+"', Letrehozas ='"+txtLetrehozas.getText()+"' WHERE Id='"+txtId.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					
					loadOneletrajzok();
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
			else
			{
				Alert alert =Util.createAlert("Hiba", "Nem létezik ilyen azonosítójú rekord!");
				alert.show();
			}
		}
	}
	
		//Tanulmány módosítása
		@FXML
		public void doSave1(ActionEvent event) throws SQLException {
			
			if(txtId1.getText().equals("") ||txtTulaj1.getText().equals("") || txtTanulmanyNev.getText().equals("") || txtTanulmanyKezdet.getText().equals("") || txtTanulmanyVeg.getText().equals("") || txtEredmeny.getText().equals(""))
			{
				Alert alert =Util.createAlert("Hiba", "Nincs kitöltve minden mező!");
				alert.show();
			}
			else
			{
				String queryId="SELECT * FROM Tanulmany";
				PreparedStatement pstId=connection.prepareStatement(queryId);
				ResultSet rs=pstId.executeQuery();
				
				int i=0,j=0;
				
				while (rs.next()) 
				{
					if(!txtId1.getText().equals(String.valueOf(rs.getInt(1))))
					{
						i++;
					}
					j++;
				}
				
				if(i<j)
				{
					try {
						String query="UPDATE Tanulmany SET Nev ='"+txtTanulmanyNev.getText()+"', Kezdet ='"+txtTanulmanyKezdet.getText()+"', Veg ='"+txtTanulmanyVeg.getText()+"', Eredmeny ='"+txtEredmeny.getText()+"' WHERE Id='"+txtId1.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
						
						loadTanulmanyok();
						
						} catch (Exception e2) {
							e2.printStackTrace();
						}
				}
				else
				{
					Alert alert =Util.createAlert("Hiba", "Nem létezik ilyen azonosítójú rekord!");
					alert.show();
				}
			}
		}
	
		//Munka módosítása
		@FXML
		public void doSave2(ActionEvent event) throws SQLException {
			
			if(txtId2.getText().equals("") ||txtTulaj2.getText().equals("") || txtMunkaNev.getText().equals("") || txtMunkaKezdet.getText().equals("") || txtMunkaVeg.getText().equals("") || txtBeosztas.getText().equals("") || txtFeladatok.getText().equals(""))
			{
				Alert alert =Util.createAlert("Hiba", "Nincs kitöltve minden mező!");
				alert.show();
			}
			else
			{
				String queryId="SELECT * FROM Munka";
				PreparedStatement pstId=connection.prepareStatement(queryId);
				ResultSet rs=pstId.executeQuery();
				
				int i=0,j=0;
				
				while (rs.next()) 
				{
					if(!txtId2.getText().equals(String.valueOf(rs.getInt(1))))
					{
						i++;
					}
					j++;
				}
				
				if(i<j)
				{
					try {
						String query="UPDATE Munka SET Nev ='"+txtMunkaNev.getText()+"', Kezdet ='"+txtMunkaKezdet.getText()+"', Veg ='"+txtMunkaVeg.getText()+"', Beosztas ='"+txtBeosztas.getText()+"', Feladatok ='"+txtFeladatok.getText()+"' WHERE Id='"+txtId2.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
						
						loadMunkak();
						
						} catch (Exception e2) {
							e2.printStackTrace();
						}
				}
				else
				{
					Alert alert =Util.createAlert("Hiba", "Nem létezik ilyen azonosítójú rekord!");
					alert.show();
				}
			}
		}
	
	//Önéletrajz törlése
	@FXML
	public void doDelete(ActionEvent event) {
		
		if(txtId.getText().equals(""))
		{
			Alert alert =Util.createAlert("Hiba", "Nincs kitöltve az ID mező!");
			alert.show();
		}
		else
		{
			int i=0;
				
			for(i=0;i<tableOneletrajz.getItems().size();i++)
			{
				if(txtId.getText().equals(String.valueOf(colId.getCellData(i))))
				{
					break;
				}
			}
			
			if(i<tableOneletrajz.getItems().size())
			{
				try {
					String query="DELETE FROM Oneletrajz WHERE Id='"+txtId.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					
					loadOneletrajzok();
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
			else
			{
				Alert alert =Util.createAlert("Hiba", "Nem létezik ilyen azonosítójú rekord!");
				alert.show();
			}
		}
	}
	
		//Tanulmány törlése
		@FXML
		public void doDelete1(ActionEvent event) throws SQLException {
			
			if(txtId1.getText().equals(""))
			{
				Alert alert =Util.createAlert("Hiba", "Nincs kitöltve az ID mező!");
				alert.show();
			}
			else
			{
				String queryId="SELECT * FROM Tanulmany";
				PreparedStatement pstId=connection.prepareStatement(queryId);
				ResultSet rs=pstId.executeQuery();
				
				int i=0,j=0;
				
				while (rs.next()) 
				{
					if(!txtId1.getText().equals(String.valueOf(rs.getInt(1))))
					{
						i++;
					}
					j++;
				}
				
				if(i<j)
				{
					try {
						String query="DELETE FROM Tanulmany WHERE Id='"+txtId1.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
						
						loadTanulmanyok();
						
						} catch (Exception e2) {
							e2.printStackTrace();
						}
				}
				else
				{
					Alert alert =Util.createAlert("Hiba", "Nem létezik ilyen azonosítójú rekord!");
					alert.show();
				}
			}
		}
	
		//Munka törlése
		@FXML
		public void doDelete2(ActionEvent event) throws SQLException {
			
			if(txtId2.getText().equals(""))
			{
				Alert alert =Util.createAlert("Hiba", "Nincs kitöltve az ID mező!");
				alert.show();
			}
			else
			{
				String queryId="SELECT * FROM Munka";
				PreparedStatement pstId=connection.prepareStatement(queryId);
				ResultSet rs=pstId.executeQuery();
				
				int i=0,j=0;
				
				while (rs.next()) 
				{
					if(!txtId2.getText().equals(String.valueOf(rs.getInt(1))))
					{
						i++;
					}
					j++;
				}
				
				if(i<j)
				{
					try {
						String query="DELETE FROM Munka WHERE Id='"+txtId2.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
						
						loadMunkak();
						
						} catch (Exception e2) {
							e2.printStackTrace();
						}
				}
				else
				{
					Alert alert =Util.createAlert("Hiba", "Nem létezik ilyen azonosítójú rekord!");
					alert.show();
				}
			}
		}
}
