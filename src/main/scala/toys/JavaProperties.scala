package toys

import scala.collection.JavaConversions.propertiesAsScalaMap

/**
 * Print a table of all Java properties. 
 * You need to find the length of the longest key before you can print the table.
 *
 */
object JavaProperties extends App {
  val jprops: scala.collection.Map[String, String] = System.getProperties()
  var maxlen = 0
  // Get the length of longest key
  jprops.keys.foreach(k => maxlen = maxlen max k.length)
  for ((k, v) <- jprops) {
    println(k.padTo(maxlen, ' ') + " | " + v)
  }
}
