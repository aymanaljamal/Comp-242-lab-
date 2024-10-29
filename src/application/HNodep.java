package application;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class HNodep<A> {
    private SimpleObjectProperty<A> data;
    private SimpleStringProperty flag;

    public HNodep(A data) {
        this.data = new SimpleObjectProperty<>(data);
        this.flag = new SimpleStringProperty("E");  // 'E' for Empty, 'F' for Filled
    }

    public A getData() {
        return data.get();
    }

    public void setData(A data) {
        this.data.set(data);
    }

    public SimpleObjectProperty<A> dataProperty() {
        return data;
    }

    public String getFlag() {
        return flag.get();
    }

    public void setFlag(String flag) {
        this.flag.set(flag);
    }

    public SimpleStringProperty flagProperty() {
        return flag;
    }
}
