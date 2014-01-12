package xml_muellerK;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Jaxbxml {
	public static void main(String[] args) {
		Produkt p = new Produkt();
		p.setAmaguetesiegel("ja");
		p.setBezeichnung("kuchen");
		p.setHerkunft("Austria");
		p.setPreis("2");
		p.setUrsprungsdatum("November 2013");
		
		try {
			 
			File file = new File("D:\\xmlProdukt.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Produkt.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			marshaller.marshal(p,file);
			marshaller.marshal(p, System.out);
	 
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	 
		}
		
	}

