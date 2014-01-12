package xml_muellerK;

import java.util.List;

public class ParserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParserXML px= new ParserXML();
		List<Produkt> l= px.configread("daten.xml");
		for(Produkt p:l){
			System.out.println(p);
		}
		
	}

}
