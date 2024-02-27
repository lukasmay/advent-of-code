


public class Valve {
    private int flowrate;
    private String name;
    private String[] valveConections;

    public Valve(int flowrate, String name, String[] valveConections) {
        this.flowrate = flowrate;
        this.name = name;
        this.valveConections = valveConections;
    }

    public Valve(){

    }

    @Override
    public String toString() {
        String holder = "";
        for (String v : this.valveConections){
            holder += v + " ";
        }
        return "Name: "+this.name+" FlowRate: "+this.flowrate+" ValveConnections: "+holder;
    }

    public int getFlowrate() {
        return this.flowrate;
    }

    public void setFlowrate(int flowrate) {
        this.flowrate = flowrate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getValveConections() {
        return this.valveConections;
    }

    public void setValveConections(String[] valveConections) {
        this.valveConections = valveConections;
    }
}
