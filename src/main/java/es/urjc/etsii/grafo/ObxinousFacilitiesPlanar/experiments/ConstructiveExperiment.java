package es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.experiments;

import es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.constructives.ObxinousFacilitiesPlanarRandomConstructive;
import es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.constructives.grasp.ObxinousFacilitiesPlanarListManager;
import es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.model.ObxinousFacilitiesPlanarInstance;
import es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.model.ObxinousFacilitiesPlanarSolution;
import es.urjc.etsii.grafo.solver.SolverConfig;
import es.urjc.etsii.grafo.solver.algorithms.Algorithm;
import es.urjc.etsii.grafo.solver.algorithms.SimpleAlgorithm;
import es.urjc.etsii.grafo.solver.create.grasp.GreedyRandomGRASPConstructive;
import es.urjc.etsii.grafo.solver.create.grasp.RandomGreedyGRASPConstructive;
import es.urjc.etsii.grafo.solver.services.AbstractExperiment;

import java.util.ArrayList;
import java.util.List;

public class ConstructiveExperiment extends AbstractExperiment<ObxinousFacilitiesPlanarSolution, ObxinousFacilitiesPlanarInstance> {

    public ConstructiveExperiment(SolverConfig solverConfig) {
        super(solverConfig);
    }

    @Override
    public List<Algorithm<ObxinousFacilitiesPlanarSolution, ObxinousFacilitiesPlanarInstance>> getAlgorithms() {
        // In this experiment we will compare a random constructive with several GRASP constructive configurations
        // TODO: Using this experiment as an example, after first test define your own experiments.
        boolean maximizing = super.isMaximizing();
        var algorithms = new ArrayList<Algorithm<ObxinousFacilitiesPlanarSolution, ObxinousFacilitiesPlanarInstance>>();
        var graspListManager = new ObxinousFacilitiesPlanarListManager();
        double[] alphaValues = {0d, 0.25d, 0.5d, 0.75d, 1d};

        // Add random constructive to list of algorithms to test
        // SimpleAlgorithm executes the given constructive and the (optional) local search methods once.
        algorithms.add(new SimpleAlgorithm<>(new ObxinousFacilitiesPlanarRandomConstructive()));

        // Add GRASP constructive methods to experiment
        // if the alpha parameter is not given --> random alpha in range [0,1] for each construction
        algorithms.add(new SimpleAlgorithm<>(new GreedyRandomGRASPConstructive<>(graspListManager, maximizing)));
//        algorithms.add(new SimpleAlgorithm<>(new RandomGreedyGRASPConstructive<>(graspListManager, maximizing)));

        for (double alpha : alphaValues) {
//            algorithms.add(new SimpleAlgorithm<>(new GreedyRandomGRASPConstructive<>(graspListManager, alpha, maximizing)));
//            algorithms.add(new SimpleAlgorithm<>(new RandomGreedyGRASPConstructive<>(graspListManager, alpha, maximizing)));
        }

        return algorithms;
    }
}
