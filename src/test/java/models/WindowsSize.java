package models;

public class WindowsSize {

    private String screenSize;
    private String elementClass;
    private String postButton;

    public WindowsSize(String screenSize, String elementClass, String postButton) {
        this.screenSize = screenSize;
        this.elementClass = elementClass;
        this.postButton = postButton;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public String getElementClass() {
        return elementClass;
    }

    public String getPostButton() {
        return postButton;
    }
}
