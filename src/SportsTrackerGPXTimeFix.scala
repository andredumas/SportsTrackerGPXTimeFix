



import java.text.SimpleDateFormat
import java.util.TimeZone

import javax.xml.bind.DatatypeConverter

object SportsTrackerGPXTimeFix {
  val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S")
  
  def convert(date: String) : String = {
	  val calendar = DatatypeConverter.parseDateTime(date) 
	  calendar.setTimeZone(TimeZone.getTimeZone("UTC"))
	  
	  val timezeonConvertedDate = format.format(calendar.getTime())
	  println(date + " -> " + timezeonConvertedDate)
	  return timezeonConvertedDate
  }
  
  def main(args: Array[String]) {
	  // Find file list, process each file
//		x match {
//	  case regex.matches => // Convert timezone and pass through
//	  case _ => // pass through all lines
//	}
	  convert("2012-04-02T08:12:15.14")
	  convert("2012-03-31T08:12:15.14")
  }
}