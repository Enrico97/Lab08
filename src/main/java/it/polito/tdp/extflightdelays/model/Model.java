package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Graph<Airport, DefaultWeightedEdge> graph;
	private List<Airport> aereoporti;
	private Map<Integer, Airport> idMap;
	ExtFlightDelaysDAO dao;
	List <CoppieAereoporti> coppie;
	public Model () {
		idMap = new HashMap<>();
		dao = new ExtFlightDelaysDAO();
	}

	/**
	 * @return the graph
	 */
	public Graph<Airport, DefaultWeightedEdge> getGraph(int distanza) {
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		coppie = dao.getCoppie(idMap, distanza);

		this.aereoporti = dao.loadAllAirports();
		
		Graphs.addAllVertices(graph, aereoporti);
		idMap = new HashMap<>();
		for (Airport a : aereoporti)
			idMap.put(a.getId(), a);
		for (CoppieAereoporti c : dao.getCoppie(idMap, distanza))
			Graphs.addEdge(graph, c.getA1(), c.getA2(), c.getAvg());
		return graph;
	}
	
}
