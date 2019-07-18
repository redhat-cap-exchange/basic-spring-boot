package com.example.springbootmanagementexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random ;

@RestController
public class LoadRestController {

	private Random r = new Random();
	
	static String fib(int n) 
	{ 
			// Declare an array to store Fibonacci numbers.
			int f[] = new int[n+2]; // 1 extra to handle case, n = 0 
			int i; 
					
			// 0th and 1st number of the series are 0 and 1
			f[0] = 0; 
			f[1] = 1; 
				
			for (i = 2; i <= n; i++) 
			{ 
					// Add the previous 2 numbers in the series and store it
					f[i] = f[i-1] + f[i-2]; 
			} 
					
			return f.toString() ;
	} 
      
  @GetMapping("/load")
	public String load() {
	    
	    int sleep = r.nextInt(2000) ;
	    
	    try { 
					System.out.println("Sleeping for " + sleep + "ms.") ;
					// sleep, then do some work ...
	        Thread.currentThread().sleep(sleep) ;      
	    } catch(Exception e) {
	    }
	    
	    return fib(sleep) ;
	}
}
