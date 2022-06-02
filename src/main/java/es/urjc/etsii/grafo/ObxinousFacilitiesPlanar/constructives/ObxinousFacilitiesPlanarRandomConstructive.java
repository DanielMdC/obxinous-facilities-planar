package es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.constructives;

import es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.model.ObxinousFacilitiesPlanarInstance;
import es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.model.ObxinousFacilitiesPlanarSolution;
import es.urjc.etsii.grafo.solver.create.Constructive;

public class ObxinousFacilitiesPlanarRandomConstructive extends Constructive<ObxinousFacilitiesPlanarSolution, ObxinousFacilitiesPlanarInstance> {

    @Override
    public ObxinousFacilitiesPlanarSolution construct(ObxinousFacilitiesPlanarSolution solution) {
        // IN --> Empty solution from solution(instance) constructor
        // OUT --> Feasible solution with an assigned score
        // TODO: Implement random constructive


        // Remember to call solution.updateLastModifiedTime() if the solution is modified without using moves!!
//        solution.updateLastModifiedTime();
//        solution.updateLastModifiedTime();
        solution.assingClosestFacility();
        solution.selectRandomFacilities();
        solution.updateLastModifiedTime();
        solution.setScore(solution.recalculateScore());
        return solution;
//        throw new UnsupportedOperationException("RandomConstructive not implemented yet");
    }
}
