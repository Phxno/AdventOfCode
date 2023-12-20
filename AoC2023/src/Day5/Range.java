package Day5;

public class Range{
    private double src;
    private double dest;
    private double range;
    public Range(double destination, double source, double range){
        this.src = source;
        this.dest = destination;
        this.range = range;
    }

    public double getSource(){
        return this.src;
    }
    public double getDestination(){
        return this.dest;
    }
    public double getRange(){
        return this.range;
    }
    public double getRangeDest(){
        return (this.dest + this.range);
    }
    public double getRangeSrc(){
        return (this.src + this.range);
    }

    @Override
    public String toString() {
        return "Range{" +
                "src=" + src +
                ", dest=" + dest +
                ", range=" + range +
                '}';
    }
}
