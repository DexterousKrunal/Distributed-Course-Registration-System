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
import java.rmi.*;

public interface MyInterface extends Remote {

public String say() throws RemoteException;


public String getCourse() throws RemoteException;
}