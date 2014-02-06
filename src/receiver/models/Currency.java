package receiver.models;

/**
 * Created by 1 on 06.02.14.
 */
public class Currency {
    private String code;
    private String value;

    public Currency(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;

        if (code != null ? !code.equals(currency.code) : currency.code != null) return false;
        if (value != null ? !value.equals(currency.value) : currency.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
