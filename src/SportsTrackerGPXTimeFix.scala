



import java.text.DateFormat
import javax.xml.bind.DatatypeConverter
import java.util.Calendar

object SportsTrackerGPXTimeFix extends App {
	println("Hello World")
	
	// Find file list, process each file
//		x match {
//	  case regex.matches => // Convert timezone and pass through
//	  case _ => // pass through all lines
//	}
//	println(DateFormat.getInstance().parse("2012-04-02T08:12:15.14"))
	println(DatatypeConverter.parseDateTime("2012-04-02T08:12:15.14").getTime())
	println(DatatypeConverter.parseDateTime("2012-03-31T08:12:15.14").getTime())
	val calendar = DatatypeConverter.parseDateTime("2012-03-31T08:12:15.14") 
}