package pojos;

public class BookingDatesPojo {
    //1) tum keyler icin private variable'lar oluşturuyoruz
    private String checkin;
    private String checkout;

    //2) tum parmetrelerle ve parametresiz cons. olusturuyoruz
    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    //3) Public getter ve setter methodlarını olusturuyoruz
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //4) ToString methodunu olusturuyoruz
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

}
