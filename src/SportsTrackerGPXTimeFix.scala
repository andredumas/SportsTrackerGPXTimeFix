



import java.text.SimpleDateFormat
import java.util.TimeZone

import scala.io.Source
import scala.util.matching.Regex.Match

import javax.xml.bind.DatatypeConverter

object SportsTrackerGPXTimeFix {
  val Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
  val TimeLine = """(\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{1,3})""".r
  
  def convert(date: String) : String = {
	  val calendar = DatatypeConverter.parseDateTime(date) 
	  calendar.setTimeZone(TimeZone.getTimeZone("UTC"))
	  
	  val timezeonConvertedDate = Format.format(calendar.getTime())
	  return timezeonConvertedDate
  }
  
  def convertTimeLine(timeLine: String): String = {
    TimeLine.replaceAllIn(timeLine, (m: Match) => 
      convert(m.group(1)) + "Z"
    )
   }
  
  def main(args: Array[String]) {
	  if(args.length < 1)
	    throw new IllegalArgumentException("Need to specify the file to process as an argument")
	  
	  Source.fromInputStream(this.getClass().getResourceAsStream(args(0))).getLines().foreach { line: String =>
	    println(convertTimeLine(line))
	  }
  }
}