/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hi;

/**
 *
 * @author jaimin
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import java.util.Scanner;
import java.awt.List;

public class HelloServer {
    
    
	public static void main(String[] args)
	{
		try
		{ 
                    Registry r = java.rmi.registry.LocateRegistry.createRegistry(9999);//1099 is the port number
                    Hello h = new Hello();
                    List list = new List();
                    File file = new File("C:\\Users\\jaimin\\Documents\\NetBeansProjects\\Hi\\src\\hi\\courseDetails.txt");
                   
                    String line = null;
//                      System.setSecurityManager(new java.rmi.RMISecurityManager());
                     // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(file);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                
                System.out.println(line);
                list.add(line);
            }   
            String fileData = null;
            fileData = list.getItem(0);
            String[] a = fileData.split("\\s");
            String c = a[0];
           
            h.setCourse(a[0], a[1], a[2], a[3]);
            r.rebind(c,h);
            
            //course 1
            fileData = list.getItem(1);
            a = fileData.split("\\s");
            c = a[0];
            h.setCourse(a[0], a[1], a[2], a[3]);
            r.rebind(c,h);
            if(Integer.parseInt(a[3]) == 0)
            {
                r.unbind(c);
            }
            
            //course 2
             fileData = list.getItem(2);
            a = fileData.split("\\s");
            c = a[0];
            h.setCourse(a[0], a[1], a[2], a[3]);
            r.rebind(c,h);
            if(Integer.parseInt(a[3]) == 0)
            {
                r.unbind(c);
            }
            
            
            

            // Always close files.
            bufferedReader.close();         

                     // Registry r = java.rmi.registry.LocateRegistry.cr("localhost", 9899);//1099 is the port number
   
                    r.rebind("Krunal", new Hello("i am Krunal"));
                        System.out.println("Server is connected and ready for operation.");
                } catch (Exception e) {
                        System.out.println("Server not connected: " + e);
                }
	}
}
