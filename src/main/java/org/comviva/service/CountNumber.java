package org.comviva.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.comviva.interfaces.ParseFile;

public class CountNumber implements ParseFile {
	
	private final Logger logger = LoggerFactory.getLogger(CountNumber.class);

	@Override
	public void countNumber() {

		double countNUmber =0;
		String desplegar ="";
		try {
			StreamTokenizer st = new StreamTokenizer(new FileReader("..\\examen\\src\\main\\resources\\ejemplo.txt"));
			
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				if (st.ttype == StreamTokenizer.TT_NUMBER) {
					
					
					desplegar = desplegar.concat((String.valueOf(st.nval)).concat(" + "));
					countNUmber = countNUmber + st.nval;
				}
			}
			desplegar = desplegar.substring(0, desplegar.length() -2);
			desplegar = desplegar.concat("=");
			logger.info("Los numeros hallados son: {} {}",desplegar,countNUmber);
		} catch (IOException e) {
			logger.error("Se ha producido un error: CountNumber::countNumber {}",CountNumber.class,e);
			
		}
		

	}

}

 