public class main {
     public static void main(String[] args) {
        car civic = new car();
        car mustang = new car();
 
        civic.configure("Honda Civic", "White");
        mustang.configure("Ford Mustang", "Yellow");
 
        System.out.println("=== Initial status ===");
        civic.showStatus();
        mustang.showStatus();
 
        System.out.println("=== Trying to move before ignition ===");
        civic.accelerate(); // must be refused
 
        System.out.println("\n=== Starting both cars ===");
        civic.ignite();
        mustang.ignite();
 
        civic.accelerate();
        civic.sprint();
        civic.steerLeft();
        civic.switchLights();
 
        mustang.accelerate();
        mustang.steerRight();
        mustang.honkHorn();
 
        System.out.println("\n=== Independent status check ===");
        civic.showStatus();
        mustang.showStatus();
 
        System.out.println("=== Nitro boost ===");
        civic.nitroBoost();
        mustang.nitroBoost();
 
        System.out.println("\n=== Slow down and shut down ===");
        civic.decelerate();
        civic.shutdown();
        civic.accelerate(); // must be refused again
 
        System.out.println("\n=== Final status ===");
        civic.showStatus();
        mustang.showStatus();
    }
    
}
