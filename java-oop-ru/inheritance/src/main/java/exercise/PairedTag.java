package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String tag;
    private Map<String, String> attributes;
    private String body;
    private List<Tag> children;

    PairedTag(String tag, Map<String, String> attributes, String body, List<Tag> children) {
        super(tag, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String attributes = super.toString();
        String value = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(""));

        return String.format("<%s%s>%s%s</%s>", getTag(), attributes, body, value, getTag());
    }
}
// END
