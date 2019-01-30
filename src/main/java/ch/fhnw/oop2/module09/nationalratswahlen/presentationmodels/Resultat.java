package ch.fhnw.oop2.module09.nationalratswahlen.presentationmodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Dieter Holz
 */
public class Resultat {
	private final StringProperty  gemeindeNr      = new SimpleStringProperty();
	private final StringProperty  gemeindeNamen   = new SimpleStringProperty();
	private final StringProperty  kanton          = new SimpleStringProperty();
	private final StringProperty  FDP             = new SimpleStringProperty();
	private final StringProperty  CVP             = new SimpleStringProperty();
	private final StringProperty  SPS             = new SimpleStringProperty();
	private final StringProperty  SVP             = new SimpleStringProperty();
	private final StringProperty  LPS             = new SimpleStringProperty();
	private final StringProperty  EVP             = new SimpleStringProperty();
	private final StringProperty  CSP             = new SimpleStringProperty();
	private final StringProperty  GLP             = new SimpleStringProperty();
	private final StringProperty  PdA             = new SimpleStringProperty();
	private final StringProperty  Sol             = new SimpleStringProperty();
	private final StringProperty  FGA             = new SimpleStringProperty();
	private final StringProperty  GPS             = new SimpleStringProperty();
	private final StringProperty  SD              = new SimpleStringProperty();
	private final StringProperty  EDU             = new SimpleStringProperty();
	private final StringProperty  FPS             = new SimpleStringProperty();
	private final StringProperty  Lega            = new SimpleStringProperty();
	private final StringProperty  uebrige         = new SimpleStringProperty();
	private final IntegerProperty wahlberechtigte = new SimpleIntegerProperty();
	private final IntegerProperty waehlende       = new SimpleIntegerProperty();

	public Resultat(String[] line) {
		setGemeindeNr(line[0]);
		setGemeindeNamen(line[1]);
		setKanton(line[2]);
		setFDP(line[3]);
		setCVP(line[4]);
		setSPS(line[5]);
		setSVP(line[6]);
		setLPS(line[7]);
		setEVP(line[8]);
		setCSP(line[9]);
		setGLP(line[10]);
		setPdA(line[11]);
		setSol(line[12]);
		setFGA(line[13]);
		setGPS(line[14]);
		setSD(line[15]);
		setEDU(line[16]);
		setFPS(line[17]);
		setLega(line[18]);
		setUebrige(line[19]);
		setWahlberechtigte(Integer.valueOf(line[20]));
		setWaehlende(Integer.valueOf(line[21]));
	}


	public String infoAsLine(String delimiter) {
		return String.join(delimiter,
		                   getGemeindeNr(),
		                   getGemeindeNamen(),
		                   getKanton(),
		                   getFDP(),
		                   getCVP(),
		                   getSPS(),
		                   getSVP(),
		                   getLPS(),
		                   getEVP(),
		                   getCSP(),
		                   getGLP(),
		                   getPdA(),
		                   getSol(),
		                   getFGA(),
		                   getGPS(),
		                   getSD(),
		                   getEDU(),
		                   getFPS(),
		                   getLega(),
		                   getUebrige(),
		                   Integer.toString(getWahlberechtigte()),
		                   Integer.toString(getWaehlende())
		                   );
	}

	//getters and setters

	public String getGemeindeNr() {
		return gemeindeNr.get();
	}

	public StringProperty gemeindeNrProperty() {
		return gemeindeNr;
	}

	public void setGemeindeNr(String gemeindeNr) {
		this.gemeindeNr.set(gemeindeNr);
	}

	public String getGemeindeNamen() {
		return gemeindeNamen.get();
	}

	public StringProperty gemeindeNamenProperty() {
		return gemeindeNamen;
	}

	public void setGemeindeNamen(String gemeindeNamen) {
		this.gemeindeNamen.set(gemeindeNamen);
	}

	public String getKanton() {
		return kanton.get();
	}

	public StringProperty kantonProperty() {
		return kanton;
	}

	public void setKanton(String kanton) {
		this.kanton.set(kanton);
	}

	public String getFDP() {
		return FDP.get();
	}

	public StringProperty FDPProperty() {
		return FDP;
	}

	public void setFDP(String FDP) {
		this.FDP.set(FDP);
	}

	public String getCVP() {
		return CVP.get();
	}

	public StringProperty CVPProperty() {
		return CVP;
	}

	public void setCVP(String CVP) {
		this.CVP.set(CVP);
	}

	public String getSPS() {
		return SPS.get();
	}

	public StringProperty SPSProperty() {
		return SPS;
	}

	public void setSPS(String SPS) {
		this.SPS.set(SPS);
	}

	public String getSVP() {
		return SVP.get();
	}

	public StringProperty SVPProperty() {
		return SVP;
	}

	public void setSVP(String SVP) {
		this.SVP.set(SVP);
	}

	public String getLPS() {
		return LPS.get();
	}

	public StringProperty LPSProperty() {
		return LPS;
	}

	public void setLPS(String LPS) {
		this.LPS.set(LPS);
	}

	public String getEVP() {
		return EVP.get();
	}

	public StringProperty EVPProperty() {
		return EVP;
	}

	public void setEVP(String EVP) {
		this.EVP.set(EVP);
	}

	public String getCSP() {
		return CSP.get();
	}

	public StringProperty CSPProperty() {
		return CSP;
	}

	public void setCSP(String CSP) {
		this.CSP.set(CSP);
	}

	public String getGLP() {
		return GLP.get();
	}

	public StringProperty GLPProperty() {
		return GLP;
	}

	public void setGLP(String GLP) {
		this.GLP.set(GLP);
	}

	public String getPdA() {
		return PdA.get();
	}

	public StringProperty pdAProperty() {
		return PdA;
	}

	public void setPdA(String pdA) {
		this.PdA.set(pdA);
	}

	public String getSol() {
		return Sol.get();
	}

	public StringProperty solProperty() {
		return Sol;
	}

	public void setSol(String sol) {
		this.Sol.set(sol);
	}

	public String getFGA() {
		return FGA.get();
	}

	public StringProperty FGAProperty() {
		return FGA;
	}

	public void setFGA(String FGA) {
		this.FGA.set(FGA);
	}

	public String getGPS() {
		return GPS.get();
	}

	public StringProperty GPSProperty() {
		return GPS;
	}

	public void setGPS(String GPS) {
		this.GPS.set(GPS);
	}

	public String getSD() {
		return SD.get();
	}

	public StringProperty SDProperty() {
		return SD;
	}

	public void setSD(String SD) {
		this.SD.set(SD);
	}

	public String getEDU() {
		return EDU.get();
	}

	public StringProperty EDUProperty() {
		return EDU;
	}

	public void setEDU(String EDU) {
		this.EDU.set(EDU);
	}

	public String getFPS() {
		return FPS.get();
	}

	public StringProperty FPSProperty() {
		return FPS;
	}

	public void setFPS(String FPS) {
		this.FPS.set(FPS);
	}

	public String getLega() {
		return Lega.get();
	}

	public StringProperty legaProperty() {
		return Lega;
	}

	public void setLega(String lega) {
		this.Lega.set(lega);
	}

	public String getUebrige() {
		return uebrige.get();
	}

	public StringProperty uebrigeProperty() {
		return uebrige;
	}

	public void setUebrige(String uebrige) {
		this.uebrige.set(uebrige);
	}

	public int getWahlberechtigte() {
		return wahlberechtigte.get();
	}

	public IntegerProperty wahlberechtigteProperty() {
		return wahlberechtigte;
	}

	public void setWahlberechtigte(int wahlberechtigte) {
		this.wahlberechtigte.set(wahlberechtigte);
	}

	public int getWaehlende() {
		return waehlende.get();
	}

	public IntegerProperty waehlendeProperty() {
		return waehlende;
	}

	public void setWaehlende(int waehlende) {
		this.waehlende.set(waehlende);
	}

}
