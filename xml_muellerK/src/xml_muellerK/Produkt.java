package xml_muellerK;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Produkt {

	private String ursprungsdatum;
	private String bezeichnung;
	private String herkunft;
	private String preis;
	private String amaguetesiegel;
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	@XmlElement
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public String getHerkunft() {
		return herkunft;
	}
	@XmlElement
	public void setHerkunft(String herkunft) {
		this.herkunft = herkunft;
	}
	public String getPreis() {
		return preis;
	}
	@XmlElement
	public void setPreis(String preis) {
		this.preis = preis;
	}
	public String isAmaguetesiegel() {
		return amaguetesiegel;
	}
	@XmlElement
	public void setAmaguetesiegel(String amaguetesiegel) {
		this.amaguetesiegel = amaguetesiegel;
	}
	
	public String getUrsprungsdatum() {
		return ursprungsdatum;
	}
	@XmlAttribute
	public void setUrsprungsdatum(String ursprungsdatum) {
		this.ursprungsdatum = ursprungsdatum;
	}
}
