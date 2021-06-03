import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

class Flock {
    List<Boid> boids;
 
    Flock() {
        boids = new ArrayList<>();
    }
 
    void run(Graphics2D g,  int w, int h) {
        for (Boid b : boids) {
            b.run(g, boids, w, h);
        }
    }
 
    boolean hasLeftTheBuilding(int w) {
        int count = 0;
        for (Boid b : boids) {
            if (b.location.x + Boid.size > w)
                count++;
        }
        return boids.size() == count;
    }
 
    void addBoid(Boid b) {
        boids.add(b);
    }
 
    static Flock spawn(double w, double h, int numBoids) {
        Flock flock = new Flock();
        for (int i = 0; i < numBoids; i++)
            flock.addBoid(new Boid(w, h));
        return flock;
    }
}