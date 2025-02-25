package exercise;


// BEGIN
public class LabelTag implements TagInterface{

    private String type;
    private TagInterface value;

    public LabelTag(String type, TagInterface value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String render() {
        return "<label>" + type  + value.render() + "</label>";
    }
}
// END
