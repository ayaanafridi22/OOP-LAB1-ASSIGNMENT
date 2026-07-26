public class car {
 
    private enum Steering { CENTER, LEFT, RIGHT }
 
    private String model;
    private String paintColor;
    private int velocity;
    private boolean ignition;
    private double fuelPercent;
    private int currentGear;
    private boolean lightsOn;
    private Steering steering;
 
    public car() {
        model = "Unnamed";
        paintColor = "Grey";
        velocity = 0;
        ignition = false;
        fuelPercent = 100.0;
        currentGear = 0;
        lightsOn = false;
        steering = Steering.CENTER;
    }
 
    public void configure(String model, String paintColor) {
        this.model = model;
        this.paintColor = paintColor;
    }
 
    public void ignite() {
        if (fuelPercent <= 0) {
            System.out.println(model + ": ignition failed, no fuel.");
            return;
        }
        ignition = true;
        System.out.println(model + " is now running.");
    }
 
    public void shutdown() {
        ignition = false;
        velocity = 0;
        currentGear = 0;
        System.out.println(model + " has shut down.");
    }
 
    // Centralised rule check used by every "move" behaviour.
    private boolean readyToMove() {
        return ignition && fuelPercent > 0;
    }
 
    public void accelerate() {
        if (!readyToMove()) {
            System.out.println(model + ": can't move, check ignition/fuel.");
            return;
        }
        currentGear = Math.max(currentGear, 1);
        velocity += 10;
        fuelPercent = Math.max(0, fuelPercent - 2);
        System.out.println(model + " moving at " + velocity + " km/h, gear " + currentGear);
    }
 
    public void sprint() {
        if (!readyToMove()) {
            System.out.println(model + ": can't sprint, check ignition/fuel.");
            return;
        }
        currentGear = Math.min(currentGear + 1, 5);
        velocity += 25;
        fuelPercent = Math.max(0, fuelPercent - 4);
        System.out.println(model + " sprinting at " + velocity + " km/h, gear " + currentGear);
    }
 
    public void decelerate() {
        velocity = Math.max(0, velocity - 15);
        if (velocity < 40 && currentGear > 1) {
            currentGear--;
        }
        System.out.println(model + " slowing to " + velocity + " km/h");
    }
 
    public void steerLeft() {
        steering = Steering.LEFT;
        System.out.println(model + " steering left.");
    }
 
    public void steerRight() {
        steering = Steering.RIGHT;
        System.out.println(model + " steering right.");
    }
 
    public void nitroBoost() {
        if (!ignition) {
            System.out.println(model + ": nitro refused, engine off.");
            return;
        }
        if (fuelPercent < 15) {
            System.out.println(model + ": nitro refused, need at least 15% fuel.");
            return;
        }
        currentGear = 5;
        velocity += 60;
        fuelPercent -= 12;
        System.out.println(model + " NITRO BOOST -> " + velocity + " km/h!");
    }
 
    public void honkHorn() {
        System.out.println(model + ": Honk! Honk!");
    }
 
    public void switchLights() {
        lightsOn = !lightsOn;
        System.out.println(model + " lights " + (lightsOn ? "switched on." : "switched off."));
    }
 
    public void showStatus() {
        System.out.println("Model     : " + model);
        System.out.println("Color     : " + paintColor);
        System.out.println("Velocity  : " + velocity + " km/h");
        System.out.println("Gear      : " + currentGear);
        System.out.println("Ignition  : " + ignition);
        System.out.println("Fuel      : " + fuelPercent + "%");
        System.out.println("Lights    : " + lightsOn);
        System.out.println("Steering  : " + steering);
        System.out.println();
    }
}