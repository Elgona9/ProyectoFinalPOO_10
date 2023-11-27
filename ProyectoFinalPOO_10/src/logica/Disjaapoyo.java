package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

public class Disjaapoyo {
    private int nodes, source, destination, i, j;

    // Constructor
    public Disjaapoyo(int nodes, int source, int destination) {
        this.nodes = nodes;
        this.source = source;
        this.destination = destination;
    }

    // Método para imprimir el camino más corto
    public String getShortestPath(Disja d) {
        // Calcular las distancias y padres utilizando el método calc de Disja
        d.calc(nodes, source);

        StringBuilder result = new StringBuilder();

        // Agregar la información al StringBuilder
       
        int current = destination;

        // Construir el camino en orden
        result.append(current);
        while (current != source) {
            current = d.parent[current];
            result.insert(0, " -> ").insert(0, current);
        }

        // Retornar la cadena
        return result.toString();
    }
    
    public List<String> getShortestPathSegments(Disja d) {
        // Calcular las distancias y padres utilizando el método calc de Disja
        d.calc(nodes, source);

        List<String> pathSegments = new ArrayList<>();

        int current = destination;

        // Construir el camino en orden
        StringBuilder currentSegment = new StringBuilder();
        currentSegment.append(current);

        while (current != source) {
            current = d.parent[current];
            currentSegment.insert(0, " -> ").insert(0, current);

            // Si alcanzamos el inicio de un nuevo segmento, agregar el segmento actual a la lista
            if (current == source) {
                pathSegments.add(currentSegment.toString());
                currentSegment = new StringBuilder();
                currentSegment.append(current);
            }
        }

        // Invertir la lista para que esté en el orden correcto
        Collections.reverse(pathSegments);

        return pathSegments;
    }

}