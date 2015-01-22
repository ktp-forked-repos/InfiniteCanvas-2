package net.itwister.infinitecanvas.canvas;

import android.graphics.PointF;

import net.itwister.infinitecanvas.RamerDouglasPeuckerOptimizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 1/21/2015.
 */
class Curve {

    List<PointF> points = new ArrayList<>();

    public void addPoint(float x, float y) {
        points.add(new PointF(x, y));
    }

    public void optimize() {
        RamerDouglasPeuckerOptimizer optimizer = new RamerDouglasPeuckerOptimizer();
        optimizer.setPoints(points);
        optimizer.setEpsilon(3);
        points = optimizer.compute();
    }

    public int getPointCount() {
        return points.size();
    }

    public Iterable<PointF> getPoints() {
        return points;
    }

    public boolean isValid() {
        return points.size() >= 2;
    }
}