class ForeignCustomer extends Customer {
    private String nationality;

    public ForeignCustomer(String id, String name, String date, String type, double quantity, double unitPrice, String nationality) {
        super(id, name, date, type, quantity, unitPrice);
        this.nationality = nationality;
    }
}
