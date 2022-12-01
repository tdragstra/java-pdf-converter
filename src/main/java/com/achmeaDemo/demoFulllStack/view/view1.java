package com.achmeaDemo.demoFulllStack.view;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;




import org.springframework.beans.factory.annotation.Autowired;

import com.achmeaDemo.demoFulllStack.persist.polisService;
import com.achmeaDemo.demoFulllStack.rest.Polis;
import  com.aspose.cells.Workbook;     


@SpringBootApplication
@RestController


public class view1 {
	@Autowired
	polisService ps;
	
		@GetMapping("/landingpage")
		public String dafuq() throws Exception {
			Polis p = new Polis();
			p.setVerzekeraar("Interpolis");
			p.setKosten(20);
			System.out.println("Dit is een test object van database model" + p.getVerzekeraar());
			/* We zouden hier iets met een database kunnen doen, geen idee wat. */
			Workbook workbook = new Workbook("C:\\Users\\tdrag\\Downloads\\demoFulllStack\\demoFulllStack\\src\\main\\resources\\static\\test.json");
			/* input is nu uit json bestand in static folder, kan je zelf testen, json bestand in git */
			workbook.save("output.pdf");
			/* Simpele pdf converter van json naar pdf, maakt er een tabel van. Even kijken hoe we dit "mooier" maken */
			return "PDF gedownload!" + p.getVerzekeraar();	    
	}
		
		@RequestMapping(path = "/download", method = RequestMethod.GET)
		public ResponseEntity<Resource> download(String paramfile) throws IOException {
			/* Dit is de download endpoint voor het bestand wat is aangemaakt met converter. Dat is dus maar 1 bestand. Hij overwrite met de save */
			
			File pdf = new File("C:\\Users\\tdrag\\Downloads\\demoFulllStack\\demoFulllStack\\output.pdf");

		    HttpHeaders headers = new HttpHeaders();
	        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=output.pdf");
	        headers.add("Pragma", "no-cache");
	        headers.add("Expires", "0");
	        
	        /* Code is bij elkaar gegoogled, ik snap maar weinig van wat hier gebeurd, but it works */
	        
	        Path path = Paths.get(pdf.getAbsolutePath());
		    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		    MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
		    return ResponseEntity.ok()
		            .headers(headers)
		            .contentLength(pdf.length())
		            .contentType(mediaType)
		            .body(resource);
		}		
}
