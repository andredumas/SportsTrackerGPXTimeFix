import java.text.SimpleDateFormat
import java.util.TimeZone

import scala.io.Source
import scala.util.matching.Regex.Match

import javax.xml.bind.DatatypeConverter

object SportsTrackerGPXTimeFix {
  val timeRegex = """(\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}(.\d{1,3})?)""".r
  val iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
  // Always normalising to UTC
  iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"))
  
  def convertToUTC(date: String) : String = {
	  val calendar = DatatypeConverter.parseDateTime(date) 
	  return iso8601Format.format(calendar.getTime())
  }
  
  def convertTimeLine(timeLine: String): String = timeRegex.replaceAllIn(timeLine, (m: Match) => convertToUTC(m.group(1)) + "Z")
  
  def main(args: Array[String]) {
	  if(args.length < 1) {
	    println("Need to specify the file to process as an argument")
	    return
	  }
	  
	  Source.fromFile(args(0)).getLines().foreach { line: String =>
	    println(convertTimeLine(line))
	  }
  }
}