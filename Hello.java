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
import java.rmi.server.*;
import java.rmi.*;
public class Hello extends UnicastRemoteObject implements MyInterface {

	private String message;
        private String courseNum;
        private String courseTime;
        private String desc;
        private String credit;
         public Hello() throws RemoteException
         {
             
         }
        public void setCourse(String courseNum,String courseTime,String desc,String credit) throws RemoteException
        {
            this.courseNum = courseNum;
            this.courseTime = courseTime;
            this.desc = desc;
            this.credit = credit;
           // return courseNum+" "+courseTime+" "+desc+" "+credit;
                     
        }
        public String getCourse() throws RemoteException
        {
            
            return courseNum+" "+courseTime+" "+desc+" "+credit;
                     
        }
	
	public Hello(String msg) throws RemoteException
	{
		message = msg;
	}
	public String say() throws RemoteException
	{
		return message;
	}

    
        
       
        
}
