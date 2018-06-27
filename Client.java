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
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
public class Client {

	public static void main(String[] argv) {
                try { 
                ArrayList enrolled = new ArrayList();
                ArrayList dropped = new ArrayList();
                    Registry r = java.rmi.registry.LocateRegistry.getRegistry(9999);//1099 is the port number
                    File file = new File("C:\\Users\\jaimin\\Documents\\NetBeansProjects\\Hi\\src\\hi\\courseDetails.txt");
                    File file1 = new File("C:\\Users\\jaimin\\Documents\\NetBeansProjects\\Hi\\src\\hi\\offered.txt");
                    List list = new List();
                    String line = null;
                    while(true)
                     {
                    Scanner sc = new Scanner(System.in);
                     System.out.println("------------Enter your choice--------------");
                     System.out.println("1. View course details.");
                     System.out.println("2. Enroll course.");
                     System.out.println("3. Drop a course");
                     System.out.println("4. Exit");
                     System.out.println("------------------------------");
                    
                     
                       int choice =   sc.nextInt();
                       if (choice == 1)
                       {
                    System.out.println("Courses offered are:");
                         
//                      System.setSecurityManager(new java.rmi.RMISecurityManager());
                     // FileReader reads text files in the default encoding.
            Path file2 = Paths.get("C:\\Users\\jaimin\\Documents\\NetBeansProjects\\Hi\\src\\hi\\offered.txt");
                                            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(file2, StandardCharsets.UTF_8));
                                            for (int j = 0; j < fileContent.size(); j++) {
                                                System.out.println(fileContent.get(j));
                                               
                                    }
                       }
                       else if (choice == 2)
                       {
                       
                           System.out.println("your have choosen option to enroll");
                           System.out.println("Enter course number to enroll");
                           String course = sc.next();
                           if (enrolled.contains(course))
                           {
                              System.out.println("You have already enrolled for this course");
                                break;
                           }
                           
                           else
                           {
                               enrolled.add(course);
                           }
                            MyInterface hello1 = (MyInterface) r.lookup(course);
                            // System.out.println(hello1.getCourse());
                             
                             FileReader fileReader =  new FileReader(file1);

            // Always wrap FileReader in BufferedReader.
                             BufferedReader bufferedReader =  new BufferedReader(fileReader);

                             while((line = bufferedReader.readLine()) != null) {
                
                //System.out.println(line);
                                 list.add(line);
                                 }   
            for(int i= 0;i<list.getRows()-1;i++)
				{
					
					String fileData = list.getItem(i);
                                        // System.out.println(fileData);
                                         if(fileData.contains(course) )
					{
                                           String[]  a = fileData.split("\\s");
                                            System.out.println("Course found courseNum is:"+a[0]);
                                            System.out.println("courseCapacity is:"+a[3]);
                                            int capacity = Integer.parseInt(a[3]) ;
                                            if ( capacity == 0)
                                            {
                                                System.out.println("Course not available");
                                            }
                                            else {
                                                
                                            
                                            int changedCapacity = capacity -1;
                                            String old = a[0]+" "+a[1]+" "+a[2]+" "+a[3];
                                            String updatedCourse = a[0]+" "+a[1]+" "+a[2]+" "+changedCapacity;
                                            
                                            Path file2 = Paths.get("C:\\Users\\jaimin\\Documents\\NetBeansProjects\\Hi\\src\\hi\\offered.txt");
                                            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(file2, StandardCharsets.UTF_8));
                                            for (int j = 0; j < fileContent.size(); j++) {
 							    if (fileContent.get(j).equals(old)) {
                                                               System.out.println(fileContent.get(j));
 							    	System.out.println("found");
 							        fileContent.set(i, updatedCourse);
                                                                System.out.println("i"+fileContent.get(j));
                                                               System.out.println("j"+fileContent.get(i));
                                                                Files.write(file2, fileContent, StandardCharsets.UTF_8);
                                                                  enrolled.add(a[0]);
                                                                System.out.println("File content changed");
 							        break;
 							    }
                                                             							}
                                            }
                                            
					}
					
                                }
            
            
                             
                       }
                       
                       else if (choice == 3)
                       {
                           System.out.println("You have choosen to drop the course");
                           System.out.println("Please enter course");
                           String toDrop = sc.next();
                           if(!enrolled.contains(toDrop))
                           {
                               System.out.println("You have not enrolled for this course");
                               System.out.println("Please enter valid course number");
                           }
                           else
                           {
                                                 File file3 = new File("C:\\Users\\jaimin\\Documents\\NetBeansProjects\\Hi\\src\\hi\\offered.txt");

                           FileReader fileReader = 
                 new FileReader(file3);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                
                //System.out.println(line);
                list.add(line);
            }   
            for(int i= 0;i<list.getRows()-1;i++)
				{
					
					String fileData = list.getItem(i);
                                        // System.out.println(fileData);
                                         if(fileData.contains(toDrop) )
					{
                                           String[]  a = fileData.split("\\s");
                                            System.out.println("Course found courseNum is:"+a[0]);
                                            System.out.println("courseCapacity is:"+a[3]);
                                            int oldC = Integer.parseInt(a[3]) - 1;
                                            int capacity = Integer.parseInt(a[3]) ;
                                            String old = a[0]+" "+a[1]+" "+a[2]+" "+oldC;
                                            String updatedCourse = a[0]+" "+a[1]+" "+a[2]+" "+capacity;
                                            
 				Path file2 = Paths.get("C:\\Users\\jaimin\\Documents\\NetBeansProjects\\Hi\\src\\hi\\offered.txt");
                                            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(file2, StandardCharsets.UTF_8));
                                            for (int j = 0; j < fileContent.size(); j++) {
                                                System.out.println(fileContent.get(j));
                                                System.out.println("Old data"+old);
 							    if (fileContent.get(j).equals(old)) {
                                                               System.out.println(fileContent.get(j));
 							    	System.out.println("found");
 							        fileContent.set(i, updatedCourse);
                                                                System.out.println("i"+fileContent.get(j));
                                                               System.out.println("j"+fileContent.get(i));
                                                                Files.write(file2, fileContent, StandardCharsets.UTF_8);

                                                                System.out.println("File content changed");
 							        break;
 							    }
                                                             							}
                                            
                                            
					}
                                	
                                }
                           }
                           
                       }
                       else if (choice == 4)
                       {
                           System.out.println("Thanks");
                           break;
                       }
                       else
                       {
                           System.out.println("Please enter valid choice");
                       }
                        
                     }
                } catch (Exception e) {
                        System.out.println("HelloClient exception: " + e);
                }
        }
}

