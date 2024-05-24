package edu.austral.ingsis.math;

import java.util.Map;

//TODO: could make it receive any power
public class Power implements BinaryOperation {
    final private Symbol first;
    final private Symbol second;

    public Power(Symbol first, Symbol second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Double computeWithValues(Map<String, Double> values) {
        return Math.pow(
                first.computeWithValues(values),
                second.computeWithValues(values)
        );
    }

    @Override
    public Symbol getFirst() {
        return first;
    }

    @Override
    public Symbol getSecond() {
        return second;
    }
}
