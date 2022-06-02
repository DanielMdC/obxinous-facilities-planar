package es.urjc.etsii.grafo.ObxinousFacilitiesPlanar.model;

import es.urjc.etsii.grafo.io.Instance;

public class ObxinousFacilitiesPlanarInstance extends Instance {
    private int n;
    private int m;
    private int p;
    private double[][] table;
    public ObxinousFacilitiesPlanarInstance(String name , int n, int m, int p, double [][] table){
        super(name);
        // TODO Add all required fields and parameters
        this.n = n;
        this.m = m;
        this.p = p;
        this.table = table;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public double[][] getTable() {
        return table;
    }

    public void setTable(double[][] table) {
        this.table = table;
    }

    // compareTo may be overriden to specify a custom instance solving order (default ordering by instance file name)

    @Override
    public int compareTo(Instance o) {
        return super.compareTo(o);
    }
}
