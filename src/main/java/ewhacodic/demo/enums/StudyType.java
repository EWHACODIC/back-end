package ewhacodic.demo.enums;

import lombok.Getter;

@Getter
public enum StudyType {
    ONLINE("온라인"),
    OFFLINE("오프라인");

    String description;

    StudyType(String description) {
        this.description = description;
    }
}
