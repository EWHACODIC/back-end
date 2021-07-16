package ewhacodic.demo.enums;

public enum Tag {
    REACT("리액트"),
    REDUX("리덕스");


    Tag(String description) {
        this.description = description;
    }

    private String description;
}
