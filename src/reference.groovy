import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import org.apache.pdfbox.exceptions.COSVisitorException
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType1Font
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage

public class Reference {
	
	public static void referenceWriter(String[] args) {
		
		println "Creating simple PDF File"
		
		String FileName = "textPDF.pdf"
		
		try {
			
			PDDocument doc = new PDDocument()
			PDPage page = new PDPage()
			
			doc.addPage(page)
			
			PDPageContentStream content = new PDPageContentStream(doc, page)
			
			content.beginText()
			content.setFont(PDType1Font.HELVETICA, 26)
			content.moveTextPositionByAmount(600, 780)
			content.drawString("A Value")
			content.endText()
			
			content.close()
			doc.save(FileName)
			doc.close()
			
			println "Your file was created in : " + System.getProperty("user.dir")			
		}
		catch(COSVisitorException e) {
			System.out.println(e.getMessage())
		}
		
	}
	
	public static void referenceImage(String[] args) {
		println "Creating simple image PDf file"
		
		String FileName = "ImagePDf.pdf"
		String image = "imageName.jpg"
		
		try {
			
			PDDocument doc = new PDDocument()
			PDPage page = new PDPage()
			
			doc.addPage(page)
			
			PDXObjectImage imageObject = new PDJpeg(doc, new FileInputStream(image))
			
			PDPageContentStream content = new PDPageContentStream(doc, page)
			content.drawImage(image, 100, 100)
			
			content.close()
			doc.save(FileName)
			doc.close()
			
			println "Your file was created in : " + System.getProperty("user.dir")
		}
		catch(COSVisitorException e) {
			System.out.println(e.getMessage())
		}
	}
}