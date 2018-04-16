import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import org.apache.pdfbox.exceptions.COSVisitorException
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType0Font
import org.apache.pdfbox.pdmodel.font.PDType1Font
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage

public class Main {
	
	public static void main(String[] args) {
		
		println "Creating simple PDF File"
		
		String FileName = "textPDF.pdf"
		String imageTest = "test.jpg"
		String imageTest2 = "test2.jpg"
		
		try {
		
			PDDocument doc = new PDDocument()
			PDPage page = new PDPage()
			
			doc.addPage(page)
			
			PDXObjectImage testObject = new PDJpeg(doc, new FileInputStream(imageTest))
			PDXObjectImage test2Object = new PDJpeg(doc, new FileInputStream(imageTest2))
			
			PDPageContentStream content = new PDPageContentStream(doc, page)
			content.drawXObject(testObject, 1, 490, 300, 490)
			content.drawXObject(test2Object, 1, 1, 300, 490)
			
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