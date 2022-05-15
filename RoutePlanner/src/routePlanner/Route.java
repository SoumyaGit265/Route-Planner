package routePlanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Route implements Comparable<Route>{
	
	private String from;
	private String to;
	private String distance;
	private String travelTime;
	private String airfare;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getAirfare() {
		return airfare;
	}
	public void setAirfare(String airfare) {
		this.airfare = airfare;
	}
	
	Route() {
		
		
		
	}
	
	Route(String from, String to, String distance, String travelTime, String airfare) {
		
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.travelTime = travelTime;
		this.airfare = airfare;
		
	}
	
	public String toString() {
		
		return from + " " + to + " " + " " + distance + " " + travelTime + " " + airfare;
		
	}
	
	void showDirectFlights(ArrayList<Route> routeInfo, String city) {
		
		Iterator<Route> it = routeInfo.iterator();
		int count = 0;
		ArrayList<Route> list2 = new ArrayList<>();
		while(it.hasNext()) {
			
			Route r = it.next();
			if(r.from.equals(city)) {
				
				list2.add(r);
				count ++;
				
			} 
			
		}
		
		sortDirectFlightsRouteInfo(list2);
		for(Route r1 : list2) {
			
			System.out.println(r1);
			
		}
		
		if(count == 0) {
							
			System.out.println("We are sorry at this point of time, we do not have information on flights originating from " + city);
							
		}
		
	}
	
	void sortDirectFlightsRouteInfo(ArrayList<Route> list) {
		
		Collections.sort(list);
		
	}
	
	@Override
	public int compareTo(Route other) {
		
		int compareResult = this.to.compareTo(other.to);
		return compareResult;
		
	}
	
	void showAllConnections(ArrayList<Route> list, String sourceCity, String destinationCity) {
		
//		for(Route r : list) {		
//			
//			if(r.from.equals(sourceCity) && r.to.equals(destinationCity)) {
//				
//				System.out.println(r);
//				
//			} 
//			
//		}
		
		int count = 0;
		for(Route r : list) {
			
			if(r.to.equals(destinationCity)) {
				
				if(r.from.equals(sourceCity)) {
					
					System.out.println(r);
					count ++;
					
				} else {
					
					String source = r.from;
					for(Route g : list) {
						
						if(source.equals(g.to)) {
							
							System.out.println(g);
							System.out.println(r);
							count ++;
						}
						
					}
					
				}
				
			}
			
		}
		
		if(count == 0) {
			
			System.out.println("Sorry there is no direct flight or indirect flight at this moment");
			
		}
		
		
	}

}
