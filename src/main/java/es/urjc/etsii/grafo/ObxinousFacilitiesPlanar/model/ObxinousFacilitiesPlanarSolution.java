package es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.model;

import es.urjc.etsii.grafo.solution.Solution;
import es.urjc.etsii.grafo.util.random.RandomManager;

import java.util.Arrays;

public class ObxinousFacilitiesPlanarSolution extends Solution<ObxinousFacilitiesPlanarSolution, ObxinousFacilitiesPlanarInstance> {

    private int[] selectedfactories;
    private int[] nonSelectedFactories;

    private double[] distClosestFacility;
    private int[] closestFacility;
    private double[][] table;
    private double score;
    /**
     * Initialize solution from instance
     *
     * @param ins
     */
    public ObxinousFacilitiesPlanarSolution(ObxinousFacilitiesPlanarInstance ins) {
        super(ins);
        // TODO Initialize data structures if necessary
        this.selectedfactories = new int[ins.getP()];
        this.nonSelectedFactories = new int[ins.getM()- ins.getP()];
        this.closestFacility = new int[ins.getN()];
        this.distClosestFacility = new double[ins.getN()];
        this.table = ins.getTable();
        Arrays.fill(selectedfactories, -1);
        Arrays.fill(nonSelectedFactories, -1);
        Arrays.fill(closestFacility, -1);
        Arrays.fill(distClosestFacility, Double.MAX_VALUE);
    }

    /**
     * Clone constructor
     *
     * @param s Solution to clone
     */
    public ObxinousFacilitiesPlanarSolution(ObxinousFacilitiesPlanarSolution s) {
        super(s);
        // TODO Copy ALL solution data, we are cloning a solution
        this.selectedfactories = s.selectedfactories.clone();
        this.nonSelectedFactories = s.nonSelectedFactories.clone();
        this.closestFacility = s.closestFacility.clone();
        this.distClosestFacility = s.distClosestFacility.clone();
        this.table = s.table.clone();
//        throw new UnsupportedOperationException("ObxinousFacilitiesPlanarSolution() in ObxinousFacilitiesPlanar not implemented yet");
    }


    @Override
    public ObxinousFacilitiesPlanarSolution cloneSolution() {
        // You do not need to modify this method
        // Call clone constructor
        return new ObxinousFacilitiesPlanarSolution(this);
    }

    @Override
    protected boolean _isBetterThan(ObxinousFacilitiesPlanarSolution other) {
        // TODO given two solutions, is the current solution STRICTLY better than the other?
        throw new UnsupportedOperationException("isBetterThan() in ObxinousFacilitiesPlanar not implemented yet");
    }

    /**
     * Get the current solution score.
     * The difference between this method and recalculateScore is that
     * this result can be a property of the solution, or cached,
     * it does not have to be calculated each time this method is called
     *
     * @return current solution score as double
     */
    @Override
    public double getScore() {
        // TODO: Implement efficient score calculation.
        // Can be as simple as a score property that gets updated when the solution changes
        // Example: return this.score;
        // Another ok start implementation can be: return recalculateScore();
//        throw new UnsupportedOperationException("getScore() in ObxinousFacilitiesPlanar not implemented yet");

        return recalculateScore();
    }

    /**
     * Recalculate solution score and validate current solution state
     * You must check that no constraints are broken, and that all costs are valid
     * The difference between this method and getScore is that we must recalculate the score from scratch,
     * without using any cache/shortcuts.
     * DO NOT UPDATE CACHES / MAKE SURE THIS METHOD DOES NOT HAVE SIDE EFFECTS
     *
     * @return current solution score as double
     */
    @Override
    public double recalculateScore() {
        // TODO calculate solution score from scratch, without using caches
        //  and without modifying the current solution. Careful with side effects.
//        throw new UnsupportedOperationException("recalculateScore() in ObxinousFacilitiesPlanar not implemented yet");
        double score = 0.0;
        for (int i = 0; i < this.selectedfactories.length; i++) {
            Double minDistance = Double.MAX_VALUE;
            for (int j = 0; j < this.closestFacility.length; j++) {
                if (this.closestFacility[j] == this.selectedfactories[i] && this.distClosestFacility[j] < minDistance) {
                    minDistance = this.distClosestFacility[j];
                }
            }
            score += minDistance;
        }
        return score;
    }
    public void selectRandomFacilities(){
        for (int i = 0; i< this.selectedfactories.length; i++){
            int factory = RandomManager.getRandom().nextInt(0, this.table.length);
            while (alreadySelected(factory)){
                factory = RandomManager.getRandom().nextInt(0, this.table.length);
            }
            this.selectedfactories[i] = factory;
        }
    }

    private boolean alreadySelected(int factory) {
        boolean selected = false;
            for (int i = 0; i < this.selectedfactories.length && !selected; i++){
                if (this.selectedfactories[i] == factory){
                    selected = true;
                }
            }
        return selected;
    }

    public void assingClosestFacility(){
        for (int i = 0; i<this.closestFacility.length; i++){
            Double minDistance = Double.MAX_VALUE;
            int factory = 0;
            for (int j = 0; j<this.nonSelectedFactories.length+this.selectedfactories.length; j++){
                if (this.table[i][j] < minDistance){
                    minDistance = this.table[i][j];
                    factory = j;
                }
            }
            this.closestFacility[i] = factory;
            this.distClosestFacility[i] = minDistance;
        }
    }
    @Override
    public String toString() {
        return "ObxinousFacilitiesPlanarSolution{" +
                "selectedfactories=" + Arrays.toString(selectedfactories) +
//                ", nonSelectedFactories=" + Arrays.toString(nonSelectedFactories) +
                ", closestFacility=" + Arrays.toString(closestFacility) +
                ", distClosestFacility=" + Arrays.toString(distClosestFacility) +
                ", table=" + Arrays.toString(table) +
                ", score=" + score +
                '}';
    }

    public int[] getSelectedfactories() {
        return selectedfactories;
    }

    public void setSelectedfactories(int[] selectedfactories) {
        this.selectedfactories = selectedfactories;
    }

    public double[][] getTable() {
        return table;
    }

    public void setTable(double[][] table) {
        this.table = table;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int[] getNonSelectedFactories() {
        return nonSelectedFactories;
    }

    public void setNonSelectedFactories(int[] nonSelectedFactories) {
        this.nonSelectedFactories = nonSelectedFactories;
    }

    public double[] getDistClosestFacility() {
        return distClosestFacility;
    }

    public void setDistClosestFacility(double[] distClosestFacility) {
        this.distClosestFacility = distClosestFacility;
    }

    public int[] getClosestFacility() {
        return closestFacility;
    }

    public void setClosestFacility(int[] closestFacility) {
        this.closestFacility = closestFacility;
    }
}
