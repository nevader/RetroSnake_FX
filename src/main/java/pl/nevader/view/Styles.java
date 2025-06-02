package pl.s24825.view;

public enum Styles{
    SMALL,
    MEDIUM,
    BIG;

    public static String getCssPath(Styles style) {
        switch (style) {
            case SMALL:
                return "css/Small.css";
            case MEDIUM:
                return "css/Medium.css";
            case BIG:
                return "css/Big.css";
            default:
                return null;
        }
    }
}
