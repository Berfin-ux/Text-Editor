public class SingletonEditor {
    private static EdiText editor = new EdiText();     // creating an private object from EdiText class

    public static EdiText getEditor(){
        return editor;        // returns editor
    }
}

