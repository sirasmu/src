package WIP.data.utility;
 /**
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe Rasmussen)
 * @version 2.0
 * date 19-05-2016
 */
public class IllegalDateException extends RuntimeException
{
   public IllegalDateException()
   {
      super("Invalid date");
   }
   
   public IllegalDateException( String msg)
   {
      super("Invalid date: "+msg);
   }

}
