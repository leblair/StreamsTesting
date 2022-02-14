class Book {
    public String name;
    public int vol;
    public double price;

    public Book(String name, int vol, double price) {
        this.name = name;
        this.vol = vol;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", vol=" + vol +
                ", price=" + price +
                '}';
    }


}
