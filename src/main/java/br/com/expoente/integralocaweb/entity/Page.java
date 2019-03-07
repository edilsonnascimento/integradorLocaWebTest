package br.com.expoente.integralocaweb.entity;

/**
 *
 * @author ednascimento
 */
public class Page {

    private Integer current;
    private Integer total;

    public Page() {
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Page{" + "current=" + current + ", total=" + total + '}';
    }
}
