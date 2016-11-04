package SEP1;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * A class representing the date in the format: day/month/year.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */

public class TheTime implements Serializable
{
   private int day;
   private int month;
   private int year;

   String[] months = { "January", "February", "March", "April", "May", "June",
         "July", "August", "September", "October", "November", "December" };

   /**
    * Three argument constructor
    * 
    * @param day
    *           the day
    * @param month
    *           the month
    * @param year
    *           the year
    */
   public TheTime(int day, int month, int year)
   {
      if (day < 1 || day > 31)
      {
         throw new IllegalDateException("invalid day");
      }

      if (month == 2 && (day == 31 || day == 30))
      {
         throw new IllegalDateException("february has fewer days");
      }
      this.day = day;

      if (month < 1 || month > 12)
      {
         throw new IllegalDateException("invalid month");
      }
      this.month = month;
      if (year < 0)
      {
         throw new IllegalDateException("invalid year");
      }
      this.year = year;

   }

   /**
    * Three argument constructor
    * 
    * @param dayStr
    *           the day
    * @param monthStr
    *           the month
    * @param yearStr
    *           the year
    */
   public TheTime(String dayStr, String monthStr, String yearStr)
   {
      int day = Integer.parseInt(dayStr);
      int month = 1;
      for (int i = 1; i < months.length + 1; i++)
      {
         if (monthStr.equals(months[i - 1]))
         {
            month = i;
            break;
         }
      }
      int year = Integer.parseInt(yearStr);

      if (day < 1 || day > 31)
      {
         throw new IllegalDateException("invalid day");
      }

      if (month == 2 && (day == 31 || day == 30))
      {
         throw new IllegalDateException("february has fewer days");
      }
      this.day = day;

      if (month < 1 || month > 12)
      {
         throw new IllegalDateException("invalid month");
      }
      this.month = month;
      if (year < 0)
      {
         throw new IllegalDateException("invalid year");
      }
      this.year = year;

   }

   /**
    * Sets the day
    * 
    * @param d
    *        the day that will be set to
    */
   public void setday(int d)
   {
      if (d < 1 || d > 31)
      {
         throw new IllegalDateException("invalid day");
      }

      if (this.month == 2 && (d == 31 || d == 30))
      {
         throw new IllegalDateException("february has fewer days");
      }
      day = d;
   }

   /**
    * Sets the month
    * 
    * @param m
    *       the month that will be set to
    */
   public void setmonth(int m)
   {
      if (m < 1 || m > 12)
      {
         throw new IllegalDateException("invalid month");
      }
      month = m;
   }

   /**
    * Sets the year
    * 
    * @param y
    *       the year that will be set to
    */
   public void setyear(int y)
   {
      if (y < 0)
      {
         throw new IllegalDateException("invalid year");
      }
      year = y;
   }

   /**
    * Gets the date's day
    * 
    * @return day
    *          the date's day
    */
   public int getDay()
   {
      return day;
   }

   /**
    * Gets the date's month
    * 
    * @return month
    *          the date's month
    */
   public int getMonth()
   {
      return month;
   }

   /**
    * Gets the date's year
    * 
    * @return year
    *          the date's year
    */
   public int getYear()
   {
      return year;
   }

   /**
    * Makes a copy of the date
    * 
    * @return a copy of the date
    */
   public TheTime copy()
   {
      return new TheTime(day, month, year);
   }

   /**
    * A method for showing the current date
    * 
    * @return myCurrentDate
    *             the current date
    */
   public static TheTime today()
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int currentDay = currentDate.get(GregorianCalendar.DATE);
      int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
      int currentYear = currentDate.get(GregorianCalendar.YEAR);
      TheTime myCurrentDate = new TheTime(currentDay, currentMonth, currentYear);
      return myCurrentDate;
   }

   /**
    * A method for showing the day of the week
    * 
    * @return dayofweek 
    *             the day of the week
    */
   public String dayOfWeek()
   {
      if (month == 1 || month == 2)
      {
         month += 12;
         year -= 1;
      }
      String dayofweek;
      int dayoftheweek = (day + ((13 * (month + 1)) / 5) + (year % 100)
            + ((year % 100) / 4) + ((year / 100) / 4) + 5 * (year / 100)) % 7;

      if ((int) dayoftheweek == 0)
         dayofweek = "Saturday";
      else if ((int) dayoftheweek == 1)
         dayofweek = "Sunday";
      else if ((int) dayoftheweek == 2)
         dayofweek = "Monday";
      else if ((int) dayoftheweek == 3)
         dayofweek = "Tuesday";
      else if ((int) dayoftheweek == 4)
         dayofweek = "Wednesday";
      else if ((int) dayoftheweek == 5)
         dayofweek = "Thursday";
      else if ((int) dayoftheweek == 6)
         dayofweek = "Friday";
      else
         dayofweek = "error";
      return dayofweek + " ";
   }

   /**
    * Returns a string representation of the date
    * 
    * @return a string representation of the date in the format: day/month/year
    */
   public String toString()
   {
      return day + "/" + month + "/" + year;
   }

   /**
    * Compares the day, month and year of 2 dates.
    * 
    * @param obj
    *           the object to compare with
    * @return true 
    *           if the given object is equal to this date
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof TheTime))
      {
         return false;
      }
      TheTime other = (TheTime) obj;
      return day == other.day && month == other.month && year == other.year;
   }

   /**
    * Converts a date of type String to a date of type TheTime
    * 
    * @param dateString
    *           what date to convert
    * @return convertedTime
    *           the date converted
    */
   public static TheTime convert(String dateString)
   {
      TheTime convertedTime;
      String[] splitArray = dateString.split("/");
      int day = Integer.parseInt(splitArray[0]);
      int month = Integer.parseInt(splitArray[1]);
      int year = Integer.parseInt(splitArray[2]);
      convertedTime = new TheTime(day, month, year);
      return convertedTime;
   }

   /**
    * A method checking if the date introduced is before the date in the date
    * that the method is called on
    * 
    * @param date2
    *           the date to check
    * @return true
    *           if the date is before and false if the date is after
    */
   public boolean isBefore(TheTime date2)
   {
      if (day <= date2.getDay() && month <= date2.getMonth()
            && year <= date2.getYear())
      {

         return true;
      }
      else if (month < date2.month && year < date2.getYear())
      {
         return true;
      }
      else if (year < date2.getYear())
         return true;
      else
         return false;
   }

   /**
    * A method for checking whether it is a leap year.
    * 
    * @return true 
    *           if it is a leap year
    */
   public boolean isLeapYear()
   {
      if (year % 4 == 0 && year % 100 != 0)
         return true;
      else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)
         return true;
      else
         return false;
   }

   /**
    * A method that changes the time to the day after. This method takes into
    * consideration whether it is the last day in the month or year.
    */
   public void nextDay()
   {

      day++;

      if (day > daysInMonth())
      {
         day = 1;
         month++;

         if (month > 12)
         {
            month = 1;
            year++;
         }
      }
   }

   /**
    * This method check what month it is and return the amount of days in that
    * month.
    * 
    * @return the amount of days in the month.
    */
   public int daysInMonth()
   {
      switch (month)
      {
         case 1:
         case 3:
         case 5:
         case 7:
         case 8:
         case 10:
         case 12:
            return 31;
         case 4:
         case 6:
         case 9:
         case 11:
            return 30;
         case 2:
            if (isLeapYear())
               return 29;
            else
               return 28;
         default:
            return -1;
      }

   }

}
