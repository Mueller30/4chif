package xml_muellerK;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class ParserXML {
	
	static final String URSPRUNGSDATUM="ursprungsdatum";
	static final String PRODUKT="produkt";
	static final String BEZEICHNUNG= "bez";
	static final String HERKUNFT="";
	static final String PREIS="09";
	static final String AMAGUETESIEGEL="nein";
	
	
	public List<Produkt> configread(String configfile){
		List<Produkt> produkt = new ArrayList<Produkt>();
		try{
			XMLInputFactory inputF=XMLInputFactory.newInstance();
			InputStream instream = new FileInputStream(configfile);
			XMLEventReader reader= inputF.createXMLEventReader(instream);
			
			Produkt p= null;
			
			while(reader.hasNext()){
				XMLEvent event = reader.nextEvent();
				if(event.isStartElement()){
					StartElement startE = event.asStartElement();
					
					switch(startE.getName().getLocalPart()){
					case PRODUKT:
						p = new Produkt();
						@SuppressWarnings("unchecked")
						Iterator<Attribute> attributesofP = startE.getAttributes();
						while(attributesofP.hasNext()){
							Attribute a = attributesofP.next();
							if (a.getName().toString().equals(URSPRUNGSDATUM)) {
								p.setUrsprungsdatum(a.getValue());
							}
						}
						break;
					case BEZEICHNUNG:
						event= reader.nextEvent();
						System.out.println(event.asCharacters().getData());
						p.setBezeichnung(event.asCharacters().getData());
						break;
					case HERKUNFT:
						event= reader.nextEvent();
						p.setHerkunft(event.asCharacters().getData());
						break;
					case PREIS:
						event= reader.nextEvent();
						p.setPreis(event.asCharacters().getData());
						break;
					case AMAGUETESIEGEL: 
						event= reader.nextEvent();
						p.setAmaguetesiegel(event.asCharacters().getData());
						break;
						}
					
					}
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (PRODUKT)) {
						produkt.add(p);
					}
				}
				}
	
	} catch (FileNotFoundException e) {
		e.printStackTrace();} 
	catch (XMLStreamException e) {
		e.printStackTrace();
		}
		return produkt;
	}
	
}
