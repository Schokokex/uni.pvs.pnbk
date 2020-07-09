package de.uulm.sp.pvs.pnbk.main;

import java.util.LinkedList;

public class FlightRoute extends LinkedList<Airport> {
	private static final long serialVersionUID = 1L;
	private final int hops;
	
	public FlightRoute(Airport ...airportList)  {
		super();
		hops = airportList.length;
		for (Airport airport : airportList) {
			this.add(airport);
		}
	}

	public int getHops() {
		return hops;
	}
}
