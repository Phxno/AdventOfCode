package Day3;

public class Content {

    private final String type;
    private final int value;
    private final int row_index;
    private final int last_index;
    private final int start_index;

    Content(String type, int value, int row_index, int start_index, int end_index){
        this.type = type;
        this.start_index = start_index;
        this.last_index = end_index;
        this.row_index = row_index;
        this.value = value;
    }

    public int getLast_index() {
        return last_index;
    }

    public String getType() {
        return type;
    }

    public int getStart_index() {
        return start_index;
    }
    public int get_Row(){
        return row_index;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (this.type.compareTo("char") == 0) {
            return "Content{" +
                    "type='" + type + '\'' +
                    ", row_index=" + row_index +
                    ", start_index=" + start_index +
                    ", last_index= " + last_index +
                    '}';
        } else{
            return "Content{" +
                    "type='" + type + '\'' +
                    "value='" + value + '\'' +
                    ", row_index=" + row_index +
                    ", start_index=" + start_index +
                    ", last_index= " + last_index +
                    '}';
        }
    }
}
