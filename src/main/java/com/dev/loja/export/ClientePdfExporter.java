package com.dev.loja.export;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dev.loja.model.Cliente;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ClientePdfExporter extends AbstractExporter {

	public void export(List<Cliente> listClientes, HttpServletResponse response) throws IOException {
		super.setResponseHeader(response, "application/pdf",".pdf");
		
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		

		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(new Color(105, 80, 223));
		
		
		
		Paragraph paragraph = new Paragraph("Lista de Clientes", font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
	
        document.add(paragraph);
        
		
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(10);
		
		writeTableHeader(table);
		writeTableData(table, listClientes);
		
		document.add(table);
		
		
		document.close();
		
	}

	private void writeTableData(PdfPTable table, List<Cliente> listClientes) {
		for (Cliente cliente : listClientes) {
			table.addCell(String.valueOf(cliente.getId()));
			table.addCell(cliente.getNome());
			table.addCell(cliente.getEmail());
			table.addCell(String.valueOf(cliente.getStatus()));
		}
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(new Color(105, 80, 223));
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("Cliente ID", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Nome", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("E-mail", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Status", font));
		table.addCell(cell);
		
	}

}
