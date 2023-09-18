package communication;

import java.io.Serializable;

public enum Operation implements Serializable {
    LOGIN,
    GET,
    CREATE,
    SAVE,
    DELETE
}
