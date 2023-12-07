package edu.br.pucgoias.relatorio.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.pucgoias.relatorio.service.VisualizaRelatorioService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/relatorio")
public class VisualizarRelatorioController {

	   @Autowired
	   private VisualizaRelatorioService viewService;
	 
	   @GetMapping("/pdf")
	   public void gerarRelatório(HttpServletResponse response) throws JRException, IOException {
		   
	       JasperPrint jasperPrint = viewService.exportaRelatorio();
	       
	       // Exporta o relatório para PDF
	       JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	       
	       // Define o tipo de conteúdo da resposta
	       response.setContentType("application/pdf");
	       response.setHeader("Content-Disposition", "inline; filename=habitantes.pdf");
	   }
}
