package de.uulm.sp.pvs.pnbk.main;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Airport {
	private Set<Airport> accessibleAirports = new TreeSet<Airport>();
	private String name;

	public Airport(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return name of the airport
	 */
	public final String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param destinations List of destinations to add.
	 */
	public final void addDestinations(Airport ...destinations) {
		if (null == destinations) {
			return;
		}
		for (final Airport airport : destinations) {
			accessibleAirports.add(airport);
		}
	}

	/**
	 * 
	 * @param destination the name of the destination airport
	 * @return returns true if the airport is accessible
	 */
	public final boolean hasDestination(final String destination) {
		for (final Airport airport : accessibleAirports) {
			if (null != airport && Objects.equals(airport.getName(), destination)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * lighter method to check accessible airports
	 * @param destination
	 * @return
	 */
	public final boolean hasDestination(Airport destination) {
		for (final Airport airport : accessibleAirports) {
			if (destination == airport) {
				return true;
			}
		}
		return false;
	}
	
	public final static List<FlightRoute> getAllRoutes(String startingAirportName, String destinationAirportName, int maxHops) {
		//TODO
		return null;
	}

}
