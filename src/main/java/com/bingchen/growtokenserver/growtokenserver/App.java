package com.bingchen.growtokenserver.growtokenserver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 DBTimer dbTimer = null;
//       dbTimer = new DBTimer(3);
       if(args[0] .equals("start")){
	       System.out.println("timer begin....");
	       dbTimer = new DBTimer(3);
       }
       
       if(( args[0] .equals( "stop") ) && (dbTimer != null)){
       	System.out.println("---timer stop ---");
       	dbTimer.stopTimer();
       }
    }
}
