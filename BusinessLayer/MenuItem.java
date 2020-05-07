package BusinessLayer;

public abstract class MenuItem{
    public int computePrice() {throw new UnsupportedOperationException("cannot compute price");};
    public void addItem(MenuItem item){};
    public String getName(){throw new UnsupportedOperationException("cannot get item name");};
    public void setName(String name){};
    public void setPrice(int i){};
}
