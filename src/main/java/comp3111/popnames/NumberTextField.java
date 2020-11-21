package comp3111.popnames;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

    public NumberTextField() {
        super();
    }

    public NumberTextField(String init) {
        super(init);
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String replacement) {
        if (validate(replacement)) {
            super.replaceSelection(replacement);
        }
    }

    /**
     * Validates that the text field either contains an {@link Integer} or is blank.
     *
     * @param text Text to check.
     * @return True if the text either contains an Integer or is blank.
     */
    private boolean validate(String text) {
        //TODO ok
        return (text.matches("[0-9]+") || text.isEmpty());
    }

    /**
     * @return Integer value represented by the text in the {@link TextField}.
     * @throws NumberFormatException If {@link NumberTextField#getCharacters()} cannot be parsed into an integer.
     */
    public int getValue() {
        return Integer.parseInt(this.getCharacters().toString());
    }
}
