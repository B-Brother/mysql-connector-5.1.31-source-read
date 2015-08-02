package com.alibaba.tinker.trry;

import java.io.BufferedReader;
import java.io.BufferedWriter; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket; 

public class SocketTest {
	public static void main(String[] args) throws Exception {
		 Socket socket = null;  
	        BufferedReader br = null;  
	        PrintWriter pw = null;  
	        try {  
	            //客户端socket指定服务器的地址和端口号  
	            socket = new Socket("localhost", 3306); 
	            System.out.println(socket);
	            //同服务器原理一样  
	            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
	            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));   
	            
                pw.println(" fuckme " );  
                pw.flush();  
                
                String s = null;
                while((s = br.readLine()) != null){
                	System.out.println(s);
                }       
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                System.out.println("close......");  
	                br.close();  
	                pw.close();  
	                socket.close();  
	            } catch (IOException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        }  

	}
}
