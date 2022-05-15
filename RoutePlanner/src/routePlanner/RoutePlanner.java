package routePlanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RoutePlanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "E:\\\\output1.csv";
		ArrayList<Route> list = new ArrayList<>();
		String line = "";
		int counter = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				
				if(counter != 0) {
					
					String arr[] = line.split(",");
					list.add(new Route(arr[0].replace("\"", ""), arr[1].replace("\"", ""), arr[2].replace("\"", ""), 
							arr[3].replace("\"", ""), arr[4].replace("\"", "")));
					
				}
				counter ++;
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Route>  it=list.iterator();
		
		System.out.println("From To Distance Travel Time Airfare");
		while(it.hasNext())
		{
			
			Route r = it.next();
			System.out.println(r);			
			
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Provide the airport name : ");
		String fromCity = sc.next();
		Route r1 = new Route();
		r1.showDirectFlights(list, fromCity);
		
		System.out.println("Enter the FROM destinations");
		String fromCity1 = sc.next();
		System.out.println("Enter the TO destinations");
		String toCity1 = sc.next();
		r1.showAllConnections(list, fromCity1, toCity1);
		
		
	}

}
