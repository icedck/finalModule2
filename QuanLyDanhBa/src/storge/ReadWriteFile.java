package storge;

import java.util.List;

public interface ReadWriteFile<E> {
    void writeToFIle();
    List<E> readFromFIle();
}
