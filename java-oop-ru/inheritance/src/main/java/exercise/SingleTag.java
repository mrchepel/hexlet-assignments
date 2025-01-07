package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    private String tag;
    private Map<String, String> attributes;

    SingleTag(String tag, Map<String, String> attributes) {
        super(tag, attributes);
    }

    @Override
    public String toString() {
        return String.format("<%s%s>", getTag(), super.toString());
    }
}
// END
