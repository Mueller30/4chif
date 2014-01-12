package xml_muellerK;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Jaxbxmlformat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 try {
			 
				File filexml = new File("D:\\xmlProdukt.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Produkt.class);
		 
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				Produkt p = (Produkt) unmarshaller.unmarshal(filexml);
				System.out.println(p);
		 
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
	}

}
