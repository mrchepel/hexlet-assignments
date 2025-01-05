package exercise;


// BEGIN
class ReversedSequence implements CharSequence {
    String text;

    public ReversedSequence(String text) {
        this.text = new StringBuilder(text).reverse().toString();
    }

    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public char charAt(int index) {
        return this.text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.text.subSequence(start, end);
    }

    @Override
    public String toString() {
        return text;
    }
}
// END
